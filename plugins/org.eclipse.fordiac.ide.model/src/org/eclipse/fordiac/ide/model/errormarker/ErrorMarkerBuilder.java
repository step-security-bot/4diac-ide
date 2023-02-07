/*******************************************************************************
 * Copyright (c) 2021 Primetals Technologies Austria GmbH
 *               2023 Martin Erich Jobst
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Michael Oberlehner - initial API and implementation and/or initial documentation
 *   Martin Jobst - refactor marker handling
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.errormarker;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public final class ErrorMarkerBuilder {

	private String type = FordiacErrorMarker.IEC61499_MARKER;
	private int severity = IMarker.SEVERITY_ERROR;
	private int priority = IMarker.PRIORITY_HIGH;
	private int lineNumber = -1;
	private String message;
	private String location;
	private EObject target;

	protected ErrorMarkerBuilder() {
	}

	protected ErrorMarkerBuilder(final String message) {
		this.message = message;
	}

	public static ErrorMarkerBuilder createErrorMarkerBuilder(final String message) {
		return new ErrorMarkerBuilder(message);
	}

	public void createMarker(final IResource resource) throws CoreException {
		resource.createMarker(type, getAttributes(resource));
	}

	public Map<String, Object> getAttributes() {
		return getAttributes(null);
	}

	public Map<String, Object> getAttributes(final IResource resource) {
		final Map<String, Object> attributes = new HashMap<>();
		attributes.put(IMarker.SEVERITY, Integer.valueOf(severity));
		attributes.put(IMarker.PRIORITY, Integer.valueOf(priority));
		if (lineNumber >= 0) {
			attributes.put(IMarker.LINE_NUMBER, Integer.valueOf(lineNumber));
		}
		if (message != null) {
			attributes.put(IMarker.MESSAGE, message);
		}
		if (location != null) {
			attributes.put(IMarker.LOCATION, location);
		} else if (target != null) {
			attributes.put(IMarker.LOCATION, FordiacMarkerHelper.getLocation(target));
		}
		if (target != null) {
			attributes.put(FordiacErrorMarker.TARGET_URI,
					FordiacMarkerHelper.getTargetUri(resource, target).toString());
			attributes.put(FordiacErrorMarker.TARGET_TYPE, EcoreUtil.getURI(target.eClass()).toString());
		}
		return attributes;
	}

	public String getType() {
		return type;
	}

	public ErrorMarkerBuilder setType(final String type) {
		if (type != null) {
			this.type = type;
		} else {
			this.type = FordiacErrorMarker.IEC61499_MARKER;
		}
		return this;
	}

	public int getSeverity() {
		return severity;
	}

	public ErrorMarkerBuilder setSeverity(final int severity) {
		this.severity = severity;
		return this;
	}

	public int getPriority() {
		return priority;
	}

	public ErrorMarkerBuilder setPriority(final int priority) {
		this.priority = priority;
		return this;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public ErrorMarkerBuilder setLineNumber(final int lineNumber) {
		this.lineNumber = lineNumber;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ErrorMarkerBuilder setMessage(final String message) {
		this.message = message;
		return this;
	}

	public String getLocation() {
		return location;
	}

	public ErrorMarkerBuilder setLocation(final String location) {
		this.location = location;
		return this;
	}

	public EObject getTarget() {
		return target;
	}

	public ErrorMarkerBuilder setTarget(final EObject target) {
		this.target = target;
		return this;
	}

	@Override
	public String toString() {
		return String.format(
				"ErrorMarkerBuilder [type=%s, message=%s, location=%s, severity=%s, priority=%s, lineNumber=%s, target=%s]", //$NON-NLS-1$
				type, message, location, severity, priority, lineNumber, EcoreUtil.getURI(target));
	}
}
