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

import eu.artist.migration.deployment.tosca.ImplementationArtifactType;
import eu.artist.migration.deployment.tosca.TImplementationArtifacts;
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
 * An implementation of the model object '<em><b>TImplementation Artifacts</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.impl.TImplementationArtifactsImpl#getImplementationArtifact <em>Implementation Artifact</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TImplementationArtifactsImpl extends MinimalEObjectImpl.Container implements TImplementationArtifacts {
	/**
	 * The cached value of the '{@link #getImplementationArtifact() <em>Implementation Artifact</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationArtifact()
	 * @generated
	 * @ordered
	 */
	protected EList<ImplementationArtifactType> implementationArtifact;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TImplementationArtifactsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToscaPackage.Literals.TIMPLEMENTATION_ARTIFACTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImplementationArtifactType> getImplementationArtifact() {
		if (implementationArtifact == null) {
			implementationArtifact = new EObjectContainmentEList<ImplementationArtifactType>(ImplementationArtifactType.class, this, ToscaPackage.TIMPLEMENTATION_ARTIFACTS__IMPLEMENTATION_ARTIFACT);
		}
		return implementationArtifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ToscaPackage.TIMPLEMENTATION_ARTIFACTS__IMPLEMENTATION_ARTIFACT:
				return ((InternalEList<?>)getImplementationArtifact()).basicRemove(otherEnd, msgs);
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
			case ToscaPackage.TIMPLEMENTATION_ARTIFACTS__IMPLEMENTATION_ARTIFACT:
				return getImplementationArtifact();
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
			case ToscaPackage.TIMPLEMENTATION_ARTIFACTS__IMPLEMENTATION_ARTIFACT:
				getImplementationArtifact().clear();
				getImplementationArtifact().addAll((Collection<? extends ImplementationArtifactType>)newValue);
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
			case ToscaPackage.TIMPLEMENTATION_ARTIFACTS__IMPLEMENTATION_ARTIFACT:
				getImplementationArtifact().clear();
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
			case ToscaPackage.TIMPLEMENTATION_ARTIFACTS__IMPLEMENTATION_ARTIFACT:
				return implementationArtifact != null && !implementationArtifact.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TImplementationArtifactsImpl
