/*******************************************************************************
 * Copyright (c) 2015 fortiss GmbH
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Monika Wenger
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.fbtypeeditor.ecc.properties;

import org.eclipse.fordiac.ide.fbtypeeditor.ecc.editparts.ECTransitionEditPart;
import org.eclipse.fordiac.ide.model.libraryElement.ECTransition;
import org.eclipse.jface.viewers.IFilter;

public class ECTransitionFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		if (toTest instanceof ECTransitionEditPart) {
			return true;
		}
		if (toTest instanceof ECTransition) {
			return true;
		}
		return false;
	}

}
