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
package org.eclipse.fordiac.ide.gef.annotation;

import java.util.Map;

public abstract class GraphicalAnnotation {

	private static final String TYPE_PREFIX = GraphicalAnnotation.class.getPackageName();
	public static final String TYPE_UNKNOWN = TYPE_PREFIX + ".unknown"; //$NON-NLS-1$
	public static final String TYPE_ERROR = TYPE_PREFIX + ".error"; //$NON-NLS-1$
	public static final String TYPE_WARNING = TYPE_PREFIX + ".warning"; //$NON-NLS-1$
	public static final String TYPE_INFO = TYPE_PREFIX + ".info"; //$NON-NLS-1$

	private final String type;
	private final Object target;

	protected GraphicalAnnotation(final String type, final Object target) {
		this.type = type;
		this.target = target;
	}

	public abstract String getText();

	public abstract String getLocation();

	public abstract Object getAttribute(String attributeName);

	public abstract Map<String, Object> getAttributes();

	public final String getType() {
		return type;
	}

	public final Object getTarget() {
		return target;
	}

	@Override
	public String toString() {
		return String.format("%s [type=%s, target=%s, getText()=%s]", getClass().getName(), type, target, getText()); //$NON-NLS-1$
	}
}