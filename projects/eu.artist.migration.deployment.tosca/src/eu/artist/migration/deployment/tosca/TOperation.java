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
 * A representation of the model object '<em><b>TOperation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.TOperation#getInputParameters <em>Input Parameters</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TOperation#getOutputParameters <em>Output Parameters</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TOperation#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTOperation()
 * @model extendedMetaData="name='tOperation' kind='elementOnly'"
 * @generated
 */
public interface TOperation extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Input Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameters</em>' containment reference.
	 * @see #setInputParameters(InputParametersType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTOperation_InputParameters()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InputParameters' namespace='##targetNamespace'"
	 * @generated
	 */
	InputParametersType getInputParameters();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TOperation#getInputParameters <em>Input Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Parameters</em>' containment reference.
	 * @see #getInputParameters()
	 * @generated
	 */
	void setInputParameters(InputParametersType value);

	/**
	 * Returns the value of the '<em><b>Output Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parameters</em>' containment reference.
	 * @see #setOutputParameters(OutputParametersType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTOperation_OutputParameters()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='OutputParameters' namespace='##targetNamespace'"
	 * @generated
	 */
	OutputParametersType getOutputParameters();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TOperation#getOutputParameters <em>Output Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Parameters</em>' containment reference.
	 * @see #getOutputParameters()
	 * @generated
	 */
	void setOutputParameters(OutputParametersType value);

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
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTOperation_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TOperation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TOperation
