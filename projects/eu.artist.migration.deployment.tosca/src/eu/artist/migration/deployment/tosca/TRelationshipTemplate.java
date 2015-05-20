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
 * A representation of the model object '<em><b>TRelationship Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.TRelationshipTemplate#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TRelationshipTemplate#getTargetElement <em>Target Element</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TRelationshipTemplate#getRelationshipConstraints <em>Relationship Constraints</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TRelationshipTemplate#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTRelationshipTemplate()
 * @model extendedMetaData="name='tRelationshipTemplate' kind='elementOnly'"
 * @generated
 */
public interface TRelationshipTemplate extends TEntityTemplate {
	/**
	 * Returns the value of the '<em><b>Source Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Element</em>' containment reference.
	 * @see #setSourceElement(SourceElementType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTRelationshipTemplate_SourceElement()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='SourceElement' namespace='##targetNamespace'"
	 * @generated
	 */
	SourceElementType getSourceElement();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TRelationshipTemplate#getSourceElement <em>Source Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Element</em>' containment reference.
	 * @see #getSourceElement()
	 * @generated
	 */
	void setSourceElement(SourceElementType value);

	/**
	 * Returns the value of the '<em><b>Target Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Element</em>' containment reference.
	 * @see #setTargetElement(TargetElementType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTRelationshipTemplate_TargetElement()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='TargetElement' namespace='##targetNamespace'"
	 * @generated
	 */
	TargetElementType getTargetElement();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TRelationshipTemplate#getTargetElement <em>Target Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Element</em>' containment reference.
	 * @see #getTargetElement()
	 * @generated
	 */
	void setTargetElement(TargetElementType value);

	/**
	 * Returns the value of the '<em><b>Relationship Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationship Constraints</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relationship Constraints</em>' containment reference.
	 * @see #setRelationshipConstraints(RelationshipConstraintsType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTRelationshipTemplate_RelationshipConstraints()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='RelationshipConstraints' namespace='##targetNamespace'"
	 * @generated
	 */
	RelationshipConstraintsType getRelationshipConstraints();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TRelationshipTemplate#getRelationshipConstraints <em>Relationship Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relationship Constraints</em>' containment reference.
	 * @see #getRelationshipConstraints()
	 * @generated
	 */
	void setRelationshipConstraints(RelationshipConstraintsType value);

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
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTRelationshipTemplate_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TRelationshipTemplate#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TRelationshipTemplate
