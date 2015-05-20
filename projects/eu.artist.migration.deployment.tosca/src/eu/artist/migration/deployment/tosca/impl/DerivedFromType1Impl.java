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

import eu.artist.migration.deployment.tosca.DerivedFromType1;
import eu.artist.migration.deployment.tosca.ToscaPackage;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derived From Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.impl.DerivedFromType1Impl#getNodeTypeImplementationRef <em>Node Type Implementation Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DerivedFromType1Impl extends MinimalEObjectImpl.Container implements DerivedFromType1 {
	/**
	 * The default value of the '{@link #getNodeTypeImplementationRef() <em>Node Type Implementation Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeTypeImplementationRef()
	 * @generated
	 * @ordered
	 */
	protected static final QName NODE_TYPE_IMPLEMENTATION_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeTypeImplementationRef() <em>Node Type Implementation Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeTypeImplementationRef()
	 * @generated
	 * @ordered
	 */
	protected QName nodeTypeImplementationRef = NODE_TYPE_IMPLEMENTATION_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DerivedFromType1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToscaPackage.Literals.DERIVED_FROM_TYPE1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getNodeTypeImplementationRef() {
		return nodeTypeImplementationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeTypeImplementationRef(QName newNodeTypeImplementationRef) {
		QName oldNodeTypeImplementationRef = nodeTypeImplementationRef;
		nodeTypeImplementationRef = newNodeTypeImplementationRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.DERIVED_FROM_TYPE1__NODE_TYPE_IMPLEMENTATION_REF, oldNodeTypeImplementationRef, nodeTypeImplementationRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ToscaPackage.DERIVED_FROM_TYPE1__NODE_TYPE_IMPLEMENTATION_REF:
				return getNodeTypeImplementationRef();
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
			case ToscaPackage.DERIVED_FROM_TYPE1__NODE_TYPE_IMPLEMENTATION_REF:
				setNodeTypeImplementationRef((QName)newValue);
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
			case ToscaPackage.DERIVED_FROM_TYPE1__NODE_TYPE_IMPLEMENTATION_REF:
				setNodeTypeImplementationRef(NODE_TYPE_IMPLEMENTATION_REF_EDEFAULT);
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
			case ToscaPackage.DERIVED_FROM_TYPE1__NODE_TYPE_IMPLEMENTATION_REF:
				return NODE_TYPE_IMPLEMENTATION_REF_EDEFAULT == null ? nodeTypeImplementationRef != null : !NODE_TYPE_IMPLEMENTATION_REF_EDEFAULT.equals(nodeTypeImplementationRef);
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
		result.append(" (nodeTypeImplementationRef: ");
		result.append(nodeTypeImplementationRef);
		result.append(')');
		return result.toString();
	}

} //DerivedFromType1Impl
