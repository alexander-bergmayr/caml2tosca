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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TRelationship Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.TRelationshipType#getInstanceStates <em>Instance States</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TRelationshipType#getSourceInterfaces <em>Source Interfaces</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TRelationshipType#getTargetInterfaces <em>Target Interfaces</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TRelationshipType#getValidSource <em>Valid Source</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TRelationshipType#getValidTarget <em>Valid Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTRelationshipType()
 * @model extendedMetaData="name='tRelationshipType' kind='elementOnly'"
 * @generated
 */
public interface TRelationshipType extends TEntityType {
	/**
	 * Returns the value of the '<em><b>Instance States</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance States</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance States</em>' containment reference.
	 * @see #setInstanceStates(TTopologyElementInstanceStates)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTRelationshipType_InstanceStates()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InstanceStates' namespace='##targetNamespace'"
	 * @generated
	 */
	TTopologyElementInstanceStates getInstanceStates();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TRelationshipType#getInstanceStates <em>Instance States</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance States</em>' containment reference.
	 * @see #getInstanceStates()
	 * @generated
	 */
	void setInstanceStates(TTopologyElementInstanceStates value);

	/**
	 * Returns the value of the '<em><b>Source Interfaces</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Interfaces</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Interfaces</em>' containment reference.
	 * @see #setSourceInterfaces(SourceInterfacesType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTRelationshipType_SourceInterfaces()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SourceInterfaces' namespace='##targetNamespace'"
	 * @generated
	 */
	SourceInterfacesType getSourceInterfaces();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TRelationshipType#getSourceInterfaces <em>Source Interfaces</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Interfaces</em>' containment reference.
	 * @see #getSourceInterfaces()
	 * @generated
	 */
	void setSourceInterfaces(SourceInterfacesType value);

	/**
	 * Returns the value of the '<em><b>Target Interfaces</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Interfaces</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Interfaces</em>' containment reference.
	 * @see #setTargetInterfaces(TargetInterfacesType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTRelationshipType_TargetInterfaces()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='TargetInterfaces' namespace='##targetNamespace'"
	 * @generated
	 */
	TargetInterfacesType getTargetInterfaces();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TRelationshipType#getTargetInterfaces <em>Target Interfaces</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Interfaces</em>' containment reference.
	 * @see #getTargetInterfaces()
	 * @generated
	 */
	void setTargetInterfaces(TargetInterfacesType value);

	/**
	 * Returns the value of the '<em><b>Valid Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Source</em>' containment reference.
	 * @see #setValidSource(ValidSourceType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTRelationshipType_ValidSource()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ValidSource' namespace='##targetNamespace'"
	 * @generated
	 */
	ValidSourceType getValidSource();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TRelationshipType#getValidSource <em>Valid Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid Source</em>' containment reference.
	 * @see #getValidSource()
	 * @generated
	 */
	void setValidSource(ValidSourceType value);

	/**
	 * Returns the value of the '<em><b>Valid Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Target</em>' containment reference.
	 * @see #setValidTarget(ValidTargetType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTRelationshipType_ValidTarget()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ValidTarget' namespace='##targetNamespace'"
	 * @generated
	 */
	ValidTargetType getValidTarget();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TRelationshipType#getValidTarget <em>Valid Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid Target</em>' containment reference.
	 * @see #getValidTarget()
	 * @generated
	 */
	void setValidTarget(ValidTargetType value);

} // TRelationshipType
