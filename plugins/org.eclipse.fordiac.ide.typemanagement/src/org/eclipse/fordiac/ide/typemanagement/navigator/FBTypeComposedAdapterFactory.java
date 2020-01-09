/*******************************************************************************
 * Copyright (c) 2011, 2017 TU Wien ACIN, fortiss GmbH
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.typemanagement.navigator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.fordiac.ide.model.data.provider.DataItemProviderAdapterFactory;
import org.eclipse.fordiac.ide.model.libraryElement.provider.LibraryElementItemProviderAdapterFactory;

final class FBTypeComposedAdapterFactory {

	private static ComposedAdapterFactory fbTypeCompAdapterFactory;

	static ComposedAdapterFactory getAdapterFactory() {
		if (fbTypeCompAdapterFactory == null) {
			fbTypeCompAdapterFactory = new ComposedAdapterFactory(createFactoryList());
		}
		return fbTypeCompAdapterFactory;
	}

	private static List<AdapterFactory> createFactoryList() {
		ArrayList<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new LibraryElementItemProviderAdapterFactory());
		factories.add(new DataItemProviderAdapterFactory());
		return factories;
	}

	private FBTypeComposedAdapterFactory() {
		throw new UnsupportedOperationException(
				"Utility class FBTypecomposedAdapterFactory should not be insantiated!");
	}
}
