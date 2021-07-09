/*******************************************************************************
 * Copyright (c) 2017 fortiss GmbH
 * 				 2020 Andrea Zoitl
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Monika Wenger
 *       - initial API and implementation and/or initial documentation
 *   Andrea Zoitl
 *       - externalized translatable strings
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.commands;

import org.eclipse.osgi.util.NLS;

@SuppressWarnings("squid:S3008")  // tell sonar the java naming convention does not make sense for this class
public final class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.fordiac.ide.model.commands.messages"; //$NON-NLS-1$
	public static String AdapterConnectionNotAllowed;
	public static String ChangeBackgroundcolorCommand_LABEL_ChangeColor;
	public static String ChangeValueCommand_LABEL_ChangeValue;
	public static String ChangeValueCommand_ConstantValuesNoAllowedOnAny;
	public static String CreateSubAppInstanceCommand_CreateSubapplicationInstance;
	public static String DeleteConnectionCommand_DeleteConnection;
	public static String DeleteFBNetworkElement;
	public static String DeleteFBNetworkElementCommand_DeleteFBOrSubapplication;
	public static String FBCreateCommand_LABLE_CreateFunctionBlock;
	public static String LinkConstraints_ClassLinconstraintsShouldNotBeCreated;
	public static String LinkConstraints_ERROR_NotConnectedToAnEventByAWithConstruct;
	public static String LinkConstraints_STATUSMessage_hasAlreadyInputConnection;
	public static String LinkConstraints_STATUSMessage_hasAlreadyOutputConnection;
	public static String LinkConstraints_STATUSMessage_IN_IN_OUT_OUT_notAllowed;
	public static String LinkConstraints_STATUSMessage_NotCompatible;
	public static String MapToCommand_STATUSMessage_AlreadyMapped;
	public static String MapToCommand_STATUSMessage_TypeNotSupported;
	public static String ViewSetPositionCommand_LABEL_Move;
	public static String WithExists;
	public static String ConnectingIncompatibleInterfaceTypes;
	public static String UntypeSubappCommand_Label;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		// empty private constructor
	}
}
