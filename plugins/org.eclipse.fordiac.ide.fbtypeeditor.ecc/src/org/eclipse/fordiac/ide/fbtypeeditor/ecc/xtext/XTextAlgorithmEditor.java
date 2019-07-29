/*******************************************************************************
 * Copyright (c) 2014 - 2017 fortiss GmbH
 * 				 2019 Johannes Kepler University Linz
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alois Zoitl, Monika Wenger
 *     - initial API and implementation and/or initial documentation
 *   Alois Zoitl - added code for handling better appreance in dark theme
  *******************************************************************************/
package org.eclipse.fordiac.ide.fbtypeeditor.ecc.xtext;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.fordiac.ide.fbtypeeditor.ecc.Activator;
import org.eclipse.fordiac.ide.fbtypeeditor.ecc.IAlgorithmEditor;
import org.eclipse.fordiac.ide.model.libraryElement.Algorithm;
import org.eclipse.fordiac.ide.model.libraryElement.BaseFBType;
import org.eclipse.fordiac.ide.ui.providers.SourceViewerColorProvider;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.source.AbstractRulerColumn;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;

/**
 * XText based algorithm editor.
 * 
 * Can be used with any xtext based grammar using dependency injection.
 * 
 */
@SuppressWarnings("restriction")
public class XTextAlgorithmEditor implements IAlgorithmEditor {

	private EmbeddedEditor editor;

	private EmbeddedEditorModelAccess embeddedEditorModelAccess;

	private BaseFBType fbType;

	private final EContentAdapter adapter = new EContentAdapter() {

		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (Notification.REMOVING_ADAPTER != notification.getEventType()) {
				if (!(notification.getNotifier() instanceof Algorithm)) {
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							if ((null != editor.getViewer()) && (null != editor.getViewer().getControl())
									&& (!editor.getViewer().getControl().isDisposed())) {
								updatePrefix();
							}
						}
					});
				}
			}
		}
	};

	public XTextAlgorithmEditor(EmbeddedEditor editor, BaseFBType fbType) {
		this.editor = editor;
		this.fbType = fbType;
		embeddedEditorModelAccess = this.editor.createPartialEditor("", "", "", true); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		SourceViewerColorProvider.initializeSourceViewerColors(getViewer());

		getViewer().addVerticalRulerColumn(createLineNumberRulerColumn());

		AbstractRulerColumn column = new AbstractRulerColumn() {
		};
		getViewer().addVerticalRulerColumn(column); // Place holder for folding, also adds distance between line numbers
													// and alg text

		this.fbType.eAdapters().add(adapter);
		editor.getViewer().getControl().addDisposeListener(e -> getFBType().eAdapters().remove(adapter));

		updatePrefix();
	}

	private LineNumberRulerColumn createLineNumberRulerColumn() {
		LineNumberRulerColumn lnrc = new LineNumberRulerColumn() {
			@Override
			protected String createDisplayString(int line) {
				line -= prefixLineCount;
				return super.createDisplayString(line);
			}
		};

		lnrc.setForeground(getViewer().getTextWidget().getForeground());
		lnrc.setBackground(getViewer().getTextWidget().getBackground());
		return lnrc;
	}

	protected BaseFBType getFBType() {
		return fbType;
	}

	private XtextSourceViewer getViewer() {
		return this.editor.getViewer();
	}

	@Override
	public void addDocumentListener(IDocumentListener listener) {
		editor.getDocument().addDocumentListener(listener);
	}

	@Override
	public void removeDocumentListener(IDocumentListener listener) {
		editor.getDocument().removeDocumentListener(listener);
	}

	@Override
	public void setAlgorithmText(String text) {
		embeddedEditorModelAccess.updateModel(regeneratePrefix(), text, ""); //$NON-NLS-1$
	}

	@Override
	public String getAlgorithmText() {
		return embeddedEditorModelAccess.getEditablePart();
	}

	@Override
	public Control getControl() {
		return getViewer().getControl();
	}

	private int prefixLineCount = 0;

	private void updatePrefix() {
		documentValid = false;
		embeddedEditorModelAccess.updatePrefix(regeneratePrefix());

		try {
			prefixLineCount = getViewer().getDocument().getNumberOfLines(0,
					getViewer().getVisibleRegion().getOffset());
			prefixLineCount--; // the first line starts after the prefix
		} catch (BadLocationException e) {
			Activator.getDefault().logError(e.getMessage(), e);
		}

		documentValid = true;
	}

	/**
	 * Provide a prefix string to be used for algorithm parsing.
	 * 
	 * The prefix can be used to import stuff or to provide access to the inputs,
	 * outputs, and internal variables of the FB.
	 * 
	 * Per default we return an empty string.
	 * 
	 * @return the new prefix to be used for parsing the algorithm, must not be null
	 */
	protected String regeneratePrefix() {
		return ""; //$NON-NLS-1$
	}

	private boolean documentValid = true;

	@Override
	public boolean isDocumentValid() {
		return documentValid;
	}

}
