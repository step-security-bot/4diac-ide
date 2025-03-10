/*******************************************************************************
 * Copyright (c) 2021 Primetals Technologies Austria GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.annotations;

import org.eclipse.fordiac.ide.model.helpers.FBNetworkHelper;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;

public final class SubAppAnnotations {

	public static FBNetwork loadSubAppNetwork(final SubApp subApp) {
		FBNetwork subAppNetwork = subApp.getSubAppNetwork();
		if ((null == subAppNetwork) && (subApp.isTyped())) {
			subAppNetwork = FBNetworkHelper.copyFBNetWork(subApp.getType().getFBNetwork(), subApp.getInterface());
			subApp.setSubAppNetwork(subAppNetwork);
		}
		return subAppNetwork;
	}

	private SubAppAnnotations() {
		throw new UnsupportedOperationException("The utility class SubAppAnnotations should not be instatiated"); //$NON-NLS-1$
	}

}
