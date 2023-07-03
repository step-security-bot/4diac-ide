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
package org.eclipse.fordiac.ide.fbtypeeditor.st;

import org.eclipse.fordiac.ide.structuredtextfunctioneditor.ui.STFunctionExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class StructuredTextFunctionFBTypeExecutableExtensionFactory extends STFunctionExecutableExtensionFactory {
	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(StructuredTextFunctionFBTypeExecutableExtensionFactory.class);
	}
}