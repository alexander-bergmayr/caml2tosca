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

import eu.artist.migration.deployment.tosca.PropertyMappingsType;
import eu.artist.migration.deployment.tosca.TPropertyMapping;
import eu.artist.migration.deployment.tosca.ToscaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Mappings Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.impl.PropertyMappingsTypeImpl#getPropertyMapping <em>Property Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyMappingsTypeImpl extends MinimalEObjectImpl.Container implements PropertyMappingsType {
	/**
	 * The cached value of the '{@link #getPropertyMapping() <em>Property Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<TPropertyMapping> propertyMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyMappingsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToscaPackage.Literals.PROPERTY_MAPPINGS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TPropertyMapping> getPropertyMapping() {
		if (propertyMapping == null) {
			propertyMapping = new EObjectContainmentEList<TPropertyMapping>(TPropertyMapping.class, this, ToscaPackage.PROPERTY_MAPPINGS_TYPE__PROPERTY_MAPPING);
		}
		return propertyMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ToscaPackage.PROPERTY_MAPPINGS_TYPE__PROPERTY_MAPPING:
				return ((InternalEList<?>)getPropertyMapping()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ToscaPackage.PROPERTY_MAPPINGS_TYPE__PROPERTY_MAPPING:
				return getPropertyMapping();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ToscaPackage.PROPERTY_MAPPINGS_TYPE__PROPERTY_MAPPING:
				getPropertyMapping().clear();
				getPropertyMapping().addAll((Collection<? extends TPropertyMapping>)newValue);
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
			case ToscaPackage.PROPERTY_MAPPINGS_TYPE__PROPERTY_MAPPING:
				getPropertyMapping().clear();
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
			case ToscaPackage.PROPERTY_MAPPINGS_TYPE__PROPERTY_MAPPING:
				return propertyMapping != null && !propertyMapping.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PropertyMappingsTypeImpl
