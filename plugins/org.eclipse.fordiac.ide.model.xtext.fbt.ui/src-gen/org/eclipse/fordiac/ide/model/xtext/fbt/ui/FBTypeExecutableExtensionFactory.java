/*
 * generated by Xtext 2.11.0
 */
package org.eclipse.fordiac.ide.model.xtext.fbt.ui;

import com.google.inject.Injector;
import org.eclipse.fordiac.ide.model.xtext.fbt.ui.internal.FbtActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass.
 */
public class FBTypeExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FbtActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return FbtActivator.getInstance().getInjector(FbtActivator.ORG_ECLIPSE_FORDIAC_IDE_MODEL_XTEXT_FBT_FBTYPE);
	}

}
