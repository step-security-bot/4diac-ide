/*******************************************************************************
 * Copyright (c) 2022 Johannes Kepler University Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Felix Roithmayr
 *     - initial implementation
 *******************************************************************************/
package org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.CreateServiceSequenceCommand;
import org.eclipse.fordiac.ide.model.libraryElement.Service;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceSequence;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class NewServiceSequenceHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		final int i = selection.size() - 1;
		if (i < 0) {
			return IStatus.ERROR;
		}

		Object selected = selection.toList().get(i);
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		final CommandStack cmdstack = activeEditor.getAdapter(CommandStack.class);

		if (selected instanceof EditPart) {
			selected = ((EditPart) selected).getModel();
		}

		cmdstack.execute(getCommand(selected));
		return Status.OK_STATUS;
	}

	private Command getCommand(final Object selected) {
		if (selected instanceof Service) {
			return new CreateServiceSequenceCommand((Service) selected);
		}
		if (selected instanceof ServiceSequence) {
			final ServiceSequence refElement = (ServiceSequence) selected;
			return new CreateServiceSequenceCommand(refElement.getService(), refElement);
		}
		return null;
	}

}