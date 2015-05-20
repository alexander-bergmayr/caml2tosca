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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plan Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.PlanType#getPlanRef <em>Plan Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getPlanType()
 * @model extendedMetaData="name='Plan_._type' kind='empty'"
 * @generated
 */
public interface PlanType extends EObject {
	/**
	 * Returns the value of the '<em><b>Plan Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plan Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plan Ref</em>' attribute.
	 * @see #setPlanRef(String)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getPlanType_PlanRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF" required="true"
	 *        extendedMetaData="kind='attribute' name='planRef'"
	 * @generated
	 */
	String getPlanRef();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.PlanType#getPlanRef <em>Plan Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plan Ref</em>' attribute.
	 * @see #getPlanRef()
	 * @generated
	 */
	void setPlanRef(String value);

} // PlanType
