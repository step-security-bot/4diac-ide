/*******************************************************************************
 * Copyright (c) 2023 Johannes Kepler University, Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Sebastian Hollersbacher - initial API and implementation and/or initial documentation
 ******************************************************************************/

package org.eclipse.fordiac.ide.model.dataexport;

import javax.xml.stream.XMLStreamException;

import org.eclipse.fordiac.ide.model.LibraryElementTags;
import org.eclipse.fordiac.ide.model.data.StructuredType;
import org.eclipse.fordiac.ide.model.libraryElement.AttributeDeclaration;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;

public class AttributeTypeExporter extends AbstractTypeExporter {

	public AttributeTypeExporter(final AttributeDeclaration type) {
		super(type);
	}

	@Override
	protected AttributeDeclaration getType() {
		return (AttributeDeclaration) super.getType();
	}

	@Override
	protected String getRootTag() {
		return LibraryElementTags.ATTRIBUTE_DECLARATION_ELEMENT;
	}

	@Override
	protected void createTypeSpecificXMLEntries() throws XMLStreamException {
		addCompilerInfo(getType().getCompilerInfo());

		if (getType().getType() instanceof final StructuredType struct) {
			createStructContent(struct);
		}

		if (!getType().getAttributes().isEmpty()) {
			addAttributes(getType().getAttributes());
		}
	}

	private void createStructContent(final StructuredType type) throws XMLStreamException {
		addStartElement(LibraryElementTags.STRUCTURED_TYPE_ELEMENT);
		for (final VarDeclaration varDecl : type.getMemberVariables()) {
			addVarDeclaration(varDecl);
		}
		addEndElement();
	}

}
