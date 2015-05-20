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
 * A representation of the model object '<em><b>TExported Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.TExportedOperation#getNodeOperation <em>Node Operation</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TExportedOperation#getRelationshipOperation <em>Relationship Operation</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TExportedOperation#getPlan <em>Plan</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TExportedOperation#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTExportedOperation()
 * @model extendedMetaData="name='tExportedOperation' kind='elementOnly'"
 * @generated
 */
public interface TExportedOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Operation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Operation</em>' containment reference.
	 * @see #setNodeOperation(NodeOperationType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTExportedOperation_NodeOperation()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='NodeOperation' namespace='##targetNamespace'"
	 * @generated
	 */
	NodeOperationType getNodeOperation();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TExportedOperation#getNodeOperation <em>Node Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Operation</em>' containment reference.
	 * @see #getNodeOperation()
	 * @generated
	 */
	void setNodeOperation(NodeOperationType value);

	/**
	 * Returns the value of the '<em><b>Relationship Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationship Operation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relationship Operation</em>' containment reference.
	 * @see #setRelationshipOperation(RelationshipOperationType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTExportedOperation_RelationshipOperation()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='RelationshipOperation' namespace='##targetNamespace'"
	 * @generated
	 */
	RelationshipOperationType getRelationshipOperation();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TExportedOperation#getRelationshipOperation <em>Relationship Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relationship Operation</em>' containment reference.
	 * @see #getRelationshipOperation()
	 * @generated
	 */
	void setRelationshipOperation(RelationshipOperationType value);

	/**
	 * Returns the value of the '<em><b>Plan</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plan</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plan</em>' containment reference.
	 * @see #setPlan(PlanType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTExportedOperation_Plan()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Plan' namespace='##targetNamespace'"
	 * @generated
	 */
	PlanType getPlan();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TExportedOperation#getPlan <em>Plan</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plan</em>' containment reference.
	 * @see #getPlan()
	 * @generated
	 */
	void setPlan(PlanType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTExportedOperation_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TExportedOperation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TExportedOperation
