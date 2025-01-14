/*******************************************************************************
 * Copyright (c) 2017 fortiss GmbH
 * 				 2020 Primetals Technologies Germany GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 3
 *
 * Contributors:
 *   Alois Zoitl - initial implementation and/or documentation
 *   Alexander Lumplecker
 *     - extraced getOppositeInterfaceelement and getConnectionOpposite
 *       to ConnectionsHelper
 *     - added getOppositeMappedIE
 *******************************************************************************/
package org.eclipse.fordiac.ide.resourceediting.handlers;

import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.util.EList;
import org.eclipse.fordiac.ide.model.helpers.ConnectionsHelper;
import org.eclipse.fordiac.ide.model.libraryElement.Connection;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.fordiac.ide.model.ui.actions.OpenListenerManager;
import org.eclipse.fordiac.ide.model.ui.editors.AdvancedScrollingGraphicalViewer;
import org.eclipse.fordiac.ide.resourceediting.editors.ResourceDiagramEditor;
import org.eclipse.fordiac.ide.resourceediting.editparts.VirtualInOutputEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class OpenConnectionOppositeResource extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			final Object first = ((IStructuredSelection) selection).getFirstElement();
			if (first instanceof VirtualInOutputEditPart) {
				final IInterfaceElement oppositeMappedIE = getOppositeMappedIE((VirtualInOutputEditPart) first);
				if (null != oppositeMappedIE) {
					openResource(oppositeMappedIE);
				}
			}
		}
		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		final IEvaluationContext ctx = (IEvaluationContext) evaluationContext;
		Object obj = ctx.getDefaultVariable();

		if (obj instanceof List) {
			final List<?> list = (List<?>) obj;
			if (!list.isEmpty()) {
				obj = list.get(0);
			}
		}
		if (obj instanceof VirtualInOutputEditPart) {
			setBaseEnabled(null != getOppositeMappedIE((VirtualInOutputEditPart) obj));
		} else {
			setBaseEnabled(false);
		}
	}

	private static IInterfaceElement getOppositeMappedIE(final VirtualInOutputEditPart vIOEditPart) {
		final IInterfaceElement ie = vIOEditPart.getModel().getReferencedInterfaceElement();
		final EList<Connection> ieConnections = ConnectionsHelper.getConnections(ie);
		if (!ieConnections.isEmpty()) {
			return ConnectionsHelper.getOppositeInterfaceElement(ie, ieConnections.get(0));
		}
		return null;
	}

	private static void openResource(final IInterfaceElement oppositeMappedIE) {
		final Resource res = oppositeMappedIE.getFBNetworkElement().getResource();

		if (null != res) {
			final IEditorPart editor = OpenListenerManager.openEditor(res);
			if (editor instanceof ResourceDiagramEditor) {
				final AdvancedScrollingGraphicalViewer viewer = ((ResourceDiagramEditor) editor).getViewer();
				if (viewer != null) {
					final Map<?, ?> map = viewer.getEditPartRegistry();
					final Object ieToSelect = map.get(oppositeMappedIE);
					if (ieToSelect instanceof EditPart) {
						viewer.selectAndRevealEditPart((EditPart) ieToSelect);
					}
				}
			}
		}
	}

}
