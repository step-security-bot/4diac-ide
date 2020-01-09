/*******************************************************************************
 * Copyright (c) 2009 Profactor GmbH
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Thomas Strasser
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.export.compare;

import org.eclipse.osgi.util.NLS;

/**
 * Messages class.
 * 
 * @author gebenh
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.fordiac.ide.export.compare.messages"; //$NON-NLS-1$

	/** The Default compare editor opener_ newl y_ exported. */
	public static String DefaultCompareEditorOpener_NEWLY_Exported;

	/** The Default compare editor opener_ origina l_ file. */
	public static String DefaultCompareEditorOpener_ORIGINAL_FILE;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
