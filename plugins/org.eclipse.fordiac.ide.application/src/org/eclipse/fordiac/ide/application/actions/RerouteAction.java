/*******************************************************************************
 * Copyright (c) 2009, 2011, 2013 Profactor GmbH, TU Wien ACIN, fortiss GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class RerouteAction implements IObjectActionDelegate {

	private final List<Connection> connections = new ArrayList<>();

	@Override
	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {
		// currently nothing to be done here
	}

	@Override
	public void run(final IAction action) {
		for (final Connection conn : connections) {
			conn.revalidate();
		}

	}

	@Override
	public void selectionChanged(final IAction action, final ISelection selection) {
		connections.clear();
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			for (final Object obj : structuredSelection) {
				if (obj instanceof ConnectionEditPart) {
					connections.add((Connection) ((ConnectionEditPart) obj).getFigure());
				}
			}
		}
	}
}
