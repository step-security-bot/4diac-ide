/*******************************************************************************
 * Copyright (c) 2008, 2012 - 2018 Profactor GbmH, TU Wien ACIN, fortiss GmbH,
 * 								Johannes Kepler University	
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Alois Zoitl, Monika Wenger 
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.systemconfiguration.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.fordiac.ide.gef.DiagramEditorWithFlyoutPalette;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.SystemConfiguration;
import org.eclipse.fordiac.ide.model.libraryElement.TypedConfigureableObject;
import org.eclipse.fordiac.ide.systemconfiguration.editparts.SystemConfEditPartFactory;
import org.eclipse.fordiac.ide.systemmanagement.ISystemEditor;
import org.eclipse.fordiac.ide.systemmanagement.SystemManager;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

public class SystemConfigurationEditor extends DiagramEditorWithFlyoutPalette implements ISystemEditor {
	private SystemConfiguration sysConf;

	@Override
	protected EditPartFactory getEditPartFactory() {
		return new SystemConfEditPartFactory(this, getZoomManger());
	}

	@Override
	protected ContextMenuProvider getContextMenuProvider(final ScrollingGraphicalViewer viewer,
			final ZoomManager zoomManager) {
		return new SystemConfigurationContextMenueProvider(viewer, zoomManager, getActionRegistry());
	}

	@Override
	protected TransferDropTargetListener createTransferDropTargetListener() {
		return new SysConfTemplateTransferDropTargetListener(getViewer(), getSystem());
	}

	@Override
	public SystemConfiguration getModel() {
		return sysConf;
	}

	@Override
	protected void setModel(final IEditorInput input) {
		if (input instanceof SystemConfigurationEditorInput) {
			SystemConfigurationEditorInput sysConfInput = (SystemConfigurationEditorInput) input;
			sysConf = sysConfInput.getContent();
		}
		super.setModel(input);
	}

	@Override
	public AutomationSystem getSystem() {
		return (AutomationSystem) sysConf.eContainer();
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		// TODO __gebenh error handling if save fails!
		SystemManager.INSTANCE.saveSystem(getSystem());
		getCommandStack().markSaveLocation();
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	@Override
	protected FlyoutPreferences getPalettePreferences() {
		return SystemConfPaletteFactory.PALETTE_PREFERENCES;
	}

	@Override
	protected PaletteRoot getPaletteRoot() {

		if (getModel() != null && getSystem() != null) {
			return SystemConfPaletteFactory.createPalette(getSystem());
		}
		return new PaletteRoot();
	}

	public void selectElement(TypedConfigureableObject refElement) {
		Object obj = getViewer().getEditPartRegistry().get(refElement);
		if (obj instanceof EditPart) {
			getViewer().select((EditPart) obj);
			getViewer().reveal((EditPart) obj);
		}
	}

	@Override
	public void doSaveAs() {
		// empty
	}

}
