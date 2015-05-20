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
package eu.artist.migration.deployment.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship Constraints Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.RelationshipConstraintsType#getRelationshipConstraint <em>Relationship Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getRelationshipConstraintsType()
 * @model extendedMetaData="name='RelationshipConstraints_._type' kind='elementOnly'"
 * @generated
 */
public interface RelationshipConstraintsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Relationship Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link eu.artist.migration.deployment.tosca.RelationshipConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationship Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relationship Constraint</em>' containment reference list.
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getRelationshipConstraintsType_RelationshipConstraint()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='RelationshipConstraint' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<RelationshipConstraintType> getRelationshipConstraint();

} // RelationshipConstraintsType
