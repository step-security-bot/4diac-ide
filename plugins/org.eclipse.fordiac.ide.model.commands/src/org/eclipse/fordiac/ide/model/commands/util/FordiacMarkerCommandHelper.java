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
package org.eclipse.fordiac.ide.model.commands.util;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.fordiac.ide.model.errormarker.ErrorMarkerBuilder;
import org.eclipse.fordiac.ide.model.errormarker.FordiacMarkerHelper;
import org.eclipse.fordiac.ide.ui.FordiacLogHelper;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.ui.ide.undo.CreateMarkersOperation;
import org.eclipse.ui.ide.undo.DeleteMarkersOperation;

public final class FordiacMarkerCommandHelper {

	public static Command newCreateMarkersCommand(final ErrorMarkerBuilder builder) {
		final IResource resource = FordiacMarkerHelper.getResource(builder.getTarget());
		if (resource == null) {
			FordiacLogHelper
					.logWarning("Cannot determine resource for " + builder + " (target may be null or dangling)"); //$NON-NLS-1$ //$NON-NLS-2$
			return new CompoundCommand();
		}
		return new OperationCommand(new CreateMarkersOperation(builder.getType(), builder.getAttributes(), resource,
				"Create error marker for " + builder.toString()), false); //$NON-NLS-1$
	}

	public static Command newDeleteMarkersCommand(final List<IMarker> markers) {
		return new OperationCommand(
				new DeleteMarkersOperation(markers.toArray(new IMarker[markers.size()]), "Delete error markers"), //$NON-NLS-1$
				false);
	}

	private FordiacMarkerCommandHelper() {
		throw new UnsupportedOperationException();
	}
}
