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

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCapability Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getCapabilityType <em>Capability Type</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getName <em>Name</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTCapabilityDefinition()
 * @model extendedMetaData="name='tCapabilityDefinition' kind='elementOnly'"
 * @generated
 */
public interface TCapabilityDefinition extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference.
	 * @see #setConstraints(ConstraintsType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTCapabilityDefinition_Constraints()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Constraints' namespace='##targetNamespace'"
	 * @generated
	 */
	ConstraintsType getConstraints();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getConstraints <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraints</em>' containment reference.
	 * @see #getConstraints()
	 * @generated
	 */
	void setConstraints(ConstraintsType value);

	/**
	 * Returns the value of the '<em><b>Capability Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Type</em>' attribute.
	 * @see #setCapabilityType(QName)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTCapabilityDefinition_CapabilityType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
	 *        extendedMetaData="kind='attribute' name='capabilityType'"
	 * @generated
	 */
	QName getCapabilityType();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getCapabilityType <em>Capability Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Type</em>' attribute.
	 * @see #getCapabilityType()
	 * @generated
	 */
	void setCapabilityType(QName value);

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #isSetLowerBound()
	 * @see #unsetLowerBound()
	 * @see #setLowerBound(int)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTCapabilityDefinition_LowerBound()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='lowerBound'"
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #isSetLowerBound()
	 * @see #unsetLowerBound()
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Unsets the value of the '{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLowerBound()
	 * @see #getLowerBound()
	 * @see #setLowerBound(int)
	 * @generated
	 */
	void unsetLowerBound();

	/**
	 * Returns whether the value of the '{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getLowerBound <em>Lower Bound</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lower Bound</em>' attribute is set.
	 * @see #unsetLowerBound()
	 * @see #getLowerBound()
	 * @see #setLowerBound(int)
	 * @generated
	 */
	boolean isSetLowerBound();

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
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTCapabilityDefinition_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #isSetUpperBound()
	 * @see #unsetUpperBound()
	 * @see #setUpperBound(Object)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTCapabilityDefinition_UpperBound()
	 * @model default="1" unsettable="true" dataType="eu.artist.migration.deployment.tosca.UpperBoundType"
	 *        extendedMetaData="kind='attribute' name='upperBound'"
	 * @generated
	 */
	Object getUpperBound();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #isSetUpperBound()
	 * @see #unsetUpperBound()
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(Object value);

	/**
	 * Unsets the value of the '{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUpperBound()
	 * @see #getUpperBound()
	 * @see #setUpperBound(Object)
	 * @generated
	 */
	void unsetUpperBound();

	/**
	 * Returns whether the value of the '{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition#getUpperBound <em>Upper Bound</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Upper Bound</em>' attribute is set.
	 * @see #unsetUpperBound()
	 * @see #getUpperBound()
	 * @see #setUpperBound(Object)
	 * @generated
	 */
	boolean isSetUpperBound();

} // TCapabilityDefinition
