/*******************************************************************************
 * Copyright (c) 2023 Primetals Technologies Austria GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Mario Kastner
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.properties;

import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.fordiac.ide.ui.FordiacMessages;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class SubAppPropertySection extends InstancePropertySection {

	private Text heightText;
	private Text widthText;
	private Button lockCheckbox;

	private static final int TEXT_INPUT_MAX_LENGTH = 5;
	private static final int WIDTH_OF_TEXT_HINT = 150;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		createFBSizeGroup(rightComposite);
	}

	@Override
	protected void createSubsectionLayout(final Composite parent) {
		createSingleRowLayout(parent);
		createDoubleColumnLayout(upperComposite);
		createFBInfoGroup(leftComposite);
		createTableSection(lowerComposite);
	}

	private void createLockSizeCheckbox(final Composite parent) {
		lockCheckbox = getWidgetFactory().createButton(parent, null, SWT.CHECK);
		lockCheckbox.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			if (getType() != null) {
				removeContentAdapter();
				// executeCommand(new ChangeGroupSizeLockCommand(getType(),
				// lockCheckbox.getSelection()));
				addContentAdapter();
			}
		}));
	}

	private void createFBSizeGroup(final Composite parent) {
		final Composite fbSizeContainer = getWidgetFactory().createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(fbSizeContainer);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(fbSizeContainer);

		getWidgetFactory().createCLabel(fbSizeContainer, FordiacMessages.Height + ":"); //$NON-NLS-1$
		heightText = createGroupText(fbSizeContainer, true);
		heightText.setTextLimit(TEXT_INPUT_MAX_LENGTH);

		getWidgetFactory().createCLabel(fbSizeContainer, FordiacMessages.Width + ":"); //$NON-NLS-1$
		widthText = createGroupText(fbSizeContainer, true);
		widthText.setTextLimit(TEXT_INPUT_MAX_LENGTH);

		getWidgetFactory().createCLabel(fbSizeContainer, FordiacMessages.Subapp_Size_DisableAutoResize + ":"); //$NON-NLS-1$
		createLockSizeCheckbox(fbSizeContainer);
	}

	@Override
	protected SubApp getType() {
		if (type instanceof final SubApp subApp) {
			return subApp;
		}
		return null;
	}

	@Override
	protected Object getInputType(final Object input) {
		return SubappPropertySectionFilter.getFBNetworkElementFromSelectedElement(input);
	}

}