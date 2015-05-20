/*******************************************************************************
 * Copyright (c) 2015 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *       Alexander Bergmayr (Vienna University of Technology) - initial API and implementation
 *  
 *       Initially developed in the context of ARTIST EU project www.artist-project.eu
 *******************************************************************************/
/**
 */
package eu.artist.migration.deployment.tosca.impl;

import eu.artist.migration.deployment.tosca.TRequirementType;
import eu.artist.migration.deployment.tosca.ToscaPackage;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TRequirement Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.impl.TRequirementTypeImpl#getRequiredCapabilityType <em>Required Capability Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TRequirementTypeImpl extends TEntityTypeImpl implements TRequirementType {
	/**
	 * The default value of the '{@link #getRequiredCapabilityType() <em>Required Capability Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredCapabilityType()
	 * @generated
	 * @ordered
	 */
	protected static final QName REQUIRED_CAPABILITY_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequiredCapabilityType() <em>Required Capability Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredCapabilityType()
	 * @generated
	 * @ordered
	 */
	protected QName requiredCapabilityType = REQUIRED_CAPABILITY_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TRequirementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToscaPackage.Literals.TREQUIREMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getRequiredCapabilityType() {
		return requiredCapabilityType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredCapabilityType(QName newRequiredCapabilityType) {
		QName oldRequiredCapabilityType = requiredCapabilityType;
		requiredCapabilityType = newRequiredCapabilityType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TREQUIREMENT_TYPE__REQUIRED_CAPABILITY_TYPE, oldRequiredCapabilityType, requiredCapabilityType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ToscaPackage.TREQUIREMENT_TYPE__REQUIRED_CAPABILITY_TYPE:
				return getRequiredCapabilityType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ToscaPackage.TREQUIREMENT_TYPE__REQUIRED_CAPABILITY_TYPE:
				setRequiredCapabilityType((QName)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ToscaPackage.TREQUIREMENT_TYPE__REQUIRED_CAPABILITY_TYPE:
				setRequiredCapabilityType(REQUIRED_CAPABILITY_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ToscaPackage.TREQUIREMENT_TYPE__REQUIRED_CAPABILITY_TYPE:
				return REQUIRED_CAPABILITY_TYPE_EDEFAULT == null ? requiredCapabilityType != null : !REQUIRED_CAPABILITY_TYPE_EDEFAULT.equals(requiredCapabilityType);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (requiredCapabilityType: ");
		result.append(requiredCapabilityType);
		result.append(')');
		return result.toString();
	}

} //TRequirementTypeImpl
