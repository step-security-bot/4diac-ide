/**
 * generated by Xtext 2.11.0
 */
package org.eclipse.fordiac.ide.model.structuredtext.structuredText.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;

import org.eclipse.fordiac.ide.model.structuredtext.structuredText.PrimaryVariable;
import org.eclipse.fordiac.ide.model.structuredtext.structuredText.StructuredTextPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Primary
 * Variable</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.fordiac.ide.model.structuredtext.structuredText.impl.PrimaryVariableImpl#getVar
 * <em>Var</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimaryVariableImpl extends VariableImpl implements PrimaryVariable {
	/**
	 * The cached value of the '{@link #getVar() <em>Var</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVar()
	 * @generated
	 * @ordered
	 */
	protected VarDeclaration var;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PrimaryVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredTextPackage.Literals.PRIMARY_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public VarDeclaration getVar() {
		if (var != null && var.eIsProxy()) {
			InternalEObject oldVar = (InternalEObject) var;
			var = (VarDeclaration) eResolveProxy(oldVar);
			if (var != oldVar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							StructuredTextPackage.PRIMARY_VARIABLE__VAR, oldVar, var));
			}
		}
		return var;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VarDeclaration basicGetVar() {
		return var;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setVar(VarDeclaration newVar) {
		VarDeclaration oldVar = var;
		var = newVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredTextPackage.PRIMARY_VARIABLE__VAR, oldVar,
					var));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case StructuredTextPackage.PRIMARY_VARIABLE__VAR:
			if (resolve)
				return getVar();
			return basicGetVar();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case StructuredTextPackage.PRIMARY_VARIABLE__VAR:
			setVar((VarDeclaration) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case StructuredTextPackage.PRIMARY_VARIABLE__VAR:
			setVar((VarDeclaration) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case StructuredTextPackage.PRIMARY_VARIABLE__VAR:
			return var != null;
		}
		return super.eIsSet(featureID);
	}

} // PrimaryVariableImpl
