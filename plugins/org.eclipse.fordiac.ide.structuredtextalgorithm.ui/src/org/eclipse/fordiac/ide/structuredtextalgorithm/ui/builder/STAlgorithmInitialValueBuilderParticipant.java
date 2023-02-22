/*******************************************************************************
 * Copyright (c) 2023 Martin Erich Jobst
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Martin Jobst - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.structuredtextalgorithm.ui.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.fordiac.ide.model.errormarker.ErrorMarkerBuilder;
import org.eclipse.fordiac.ide.model.errormarker.FordiacErrorMarker;
import org.eclipse.fordiac.ide.model.errormarker.FordiacMarkerHelper;
import org.eclipse.fordiac.ide.model.libraryElement.ErrorMarkerRef;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElement;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;
import org.eclipse.fordiac.ide.model.libraryElement.Value;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.fordiac.ide.model.typelibrary.TypeEntry;
import org.eclipse.fordiac.ide.model.typelibrary.TypeLibraryManager;
import org.eclipse.fordiac.ide.structuredtextalgorithm.util.StructuredTextParseUtil;
import org.eclipse.fordiac.ide.structuredtextcore.stcore.util.STCoreUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.validation.Issue;

public class STAlgorithmInitialValueBuilderParticipant implements IXtextBuilderParticipant {

	@Override
	public void build(final IBuildContext context, final IProgressMonitor monitor) throws CoreException {
		final List<IResourceDescription.Delta> deltas = getRelevantDeltas(context);
		for (final var delta : deltas) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			if (delta.getOld() != null) {
				doClean(delta);
			}
			if (delta.getNew() != null) {
				doBuild(delta, context, monitor);
			}
		}
	}

	protected void doBuild(final IResourceDescription.Delta delta, final IBuildContext context,
			final IProgressMonitor monitor) throws CoreException {
		try {
			final Iterable<IEObjectDescription> varDeclarationDescriptions = delta.getNew()
					.getExportedObjectsByType(LibraryElementPackage.eINSTANCE.getVarDeclaration());
			for (final var varDeclarationDescription : varDeclarationDescriptions) {
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				final EObject target = context.getResourceSet().getEObject(varDeclarationDescription.getEObjectURI(),
						true);
				if (target instanceof VarDeclaration) {
					validateValue((VarDeclaration) target, delta, monitor);
				}
			}
		} catch (final RuntimeException e) {
			throw new CoreException(Status.error("Exception processing build delta " + delta.getUri().toString(), e)); //$NON-NLS-1$
		}
	}

	@SuppressWarnings("static-method")
	protected void doClean(final IResourceDescription.Delta delta) throws CoreException {
		final IFile file = getFile(delta.getOld().getURI());
		if (file != null && file.exists()) {
			file.deleteMarkers(FordiacErrorMarker.INITIAL_VALUE_MARKER, true, IResource.DEPTH_INFINITE);
		}
	}

	protected void validateValue(final VarDeclaration varDeclaration, final IResourceDescription.Delta delta,
			final IProgressMonitor monitor) throws CoreException {
		final String value = getValue(varDeclaration);
		final List<Issue> issues = StructuredTextParseUtil.validate(value, delta.getUri(),
				STCoreUtil.getFeatureType(varDeclaration), null, null);
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		final Value canonicalValue = getCanonicalObject(varDeclaration.getValue());
		if (canonicalValue != null) {
			updateErrorMessage(canonicalValue, issues);
			final IFile file = getFile(delta.getUri());
			if (file != null && file.exists()) {
				updateMarkers(file, canonicalValue, issues, monitor);
			}
		}
	}

	@SuppressWarnings("static-method")
	protected void updateErrorMessage(final ErrorMarkerRef object, final List<Issue> issues) {
		final String errorMessage = issues.stream().filter(issue -> issue.getSeverity() == Severity.ERROR)
				.map(Issue::getMessage).collect(Collectors.joining(", ")); //$NON-NLS-1$
		final Display display = PlatformUI.getWorkbench().getDisplay();
		if (display != null && !display.isDisposed()) {
			display.asyncExec(() -> object.setErrorMessage(errorMessage));
		} else {
			object.setErrorMessage(errorMessage);
		}
	}

	protected void updateMarkers(final IFile file, final EObject object, final List<Issue> issues,
			final IProgressMonitor monitor) throws CoreException {
		deleteMarkers(file, object);
		for (final Issue issue : issues) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			createMarker(file, object, issue);
		}
	}

	@SuppressWarnings("static-method")
	protected void createMarker(final IFile file, final EObject object, final Issue issue) throws CoreException {
		ErrorMarkerBuilder.createErrorMarkerBuilder(issue.getMessage()).setType(FordiacErrorMarker.INITIAL_VALUE_MARKER)
		.setTarget(object).createMarker(file);
	}

	@SuppressWarnings("static-method")
	protected void deleteMarkers(final IFile file, final EObject object) throws CoreException {
		for (final IMarker marker : FordiacMarkerHelper.findMarkers(file, object,
				FordiacErrorMarker.INITIAL_VALUE_MARKER)) {
			marker.delete();
		}
	}

	@SuppressWarnings("unchecked")
	protected static <T extends EObject> T getCanonicalObject(final T object) {
		final EObject root = EcoreUtil.getRootContainer(object);
		if (root instanceof LibraryElement) {
			final TypeEntry typeEntry = ((LibraryElement) root).getTypeEntry();
			if (typeEntry != null) {
				final LibraryElement typeEditable = typeEntry.getTypeEditable();
				if (typeEditable != null) {
					final String fragment = EcoreUtil.getRelativeURIFragmentPath(root, object);
					return (T) EcoreUtil.getEObject(typeEditable, fragment);
				}
			}
			// do not return target unless it could be resolved to typeEditable
			// if it is a LibraryElement
			return null;
		}
		return object;
	}

	protected static int getMarkerSeverity(final Issue issue) {
		switch (issue.getSeverity()) {
		case ERROR:
			return IMarker.SEVERITY_ERROR;
		case WARNING:
			return IMarker.SEVERITY_WARNING;
		case INFO:
			return IMarker.SEVERITY_INFO;
		default:
			throw new IllegalArgumentException(String.valueOf(issue.getSeverity()));
		}
	}

	protected static String getValue(final VarDeclaration varDeclaration) {
		if (varDeclaration.getValue() != null && varDeclaration.getValue().getValue() != null) {
			return varDeclaration.getValue().getValue();
		}
		return ""; //$NON-NLS-1$
	}

	protected List<IResourceDescription.Delta> getRelevantDeltas(final IBuildContext context) {
		return context.getDeltas().stream().filter(this::isRelevantDelta).collect(Collectors.toList());
	}

	protected boolean isRelevantDelta(final IResourceDescription.Delta delta) {
		final IFile file = getFile(delta.getUri());
		return file != null && TypeLibraryManager.INSTANCE.getTypeEntryForFile(file) != null;
	}

	protected static IFile getFile(final URI uri) {
		if (uri.isPlatformResource()) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		return null;
	}
}