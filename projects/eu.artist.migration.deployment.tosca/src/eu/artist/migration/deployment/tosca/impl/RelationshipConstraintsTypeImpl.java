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

import eu.artist.migration.deployment.tosca.RelationshipConstraintType;
import eu.artist.migration.deployment.tosca.RelationshipConstraintsType;
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
 * An implementation of the model object '<em><b>Relationship Constraints Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.impl.RelationshipConstraintsTypeImpl#getRelationshipConstraint <em>Relationship Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationshipConstraintsTypeImpl extends MinimalEObjectImpl.Container implements RelationshipConstraintsType {
	/**
	 * The cached value of the '{@link #getRelationshipConstraint() <em>Relationship Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationshipConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationshipConstraintType> relationshipConstraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationshipConstraintsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToscaPackage.Literals.RELATIONSHIP_CONSTRAINTS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RelationshipConstraintType> getRelationshipConstraint() {
		if (relationshipConstraint == null) {
			relationshipConstraint = new EObjectContainmentEList<RelationshipConstraintType>(RelationshipConstraintType.class, this, ToscaPackage.RELATIONSHIP_CONSTRAINTS_TYPE__RELATIONSHIP_CONSTRAINT);
		}
		return relationshipConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ToscaPackage.RELATIONSHIP_CONSTRAINTS_TYPE__RELATIONSHIP_CONSTRAINT:
				return ((InternalEList<?>)getRelationshipConstraint()).basicRemove(otherEnd, msgs);
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
			case ToscaPackage.RELATIONSHIP_CONSTRAINTS_TYPE__RELATIONSHIP_CONSTRAINT:
				return getRelationshipConstraint();
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
			case ToscaPackage.RELATIONSHIP_CONSTRAINTS_TYPE__RELATIONSHIP_CONSTRAINT:
				getRelationshipConstraint().clear();
				getRelationshipConstraint().addAll((Collection<? extends RelationshipConstraintType>)newValue);
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
			case ToscaPackage.RELATIONSHIP_CONSTRAINTS_TYPE__RELATIONSHIP_CONSTRAINT:
				getRelationshipConstraint().clear();
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
			case ToscaPackage.RELATIONSHIP_CONSTRAINTS_TYPE__RELATIONSHIP_CONSTRAINT:
				return relationshipConstraint != null && !relationshipConstraint.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RelationshipConstraintsTypeImpl
