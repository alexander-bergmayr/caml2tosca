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
 * A representation of the model object '<em><b>Property Constraints Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.PropertyConstraintsType#getPropertyConstraint <em>Property Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getPropertyConstraintsType()
 * @model extendedMetaData="name='PropertyConstraints_._type' kind='elementOnly'"
 * @generated
 */
public interface PropertyConstraintsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Property Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link eu.artist.migration.deployment.tosca.TPropertyConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Constraint</em>' containment reference list.
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getPropertyConstraintsType_PropertyConstraint()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='PropertyConstraint' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TPropertyConstraint> getPropertyConstraint();

} // PropertyConstraintsType
