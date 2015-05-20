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
 * A representation of the model object '<em><b>TProperty Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.TPropertyMapping#getServiceTemplatePropertyRef <em>Service Template Property Ref</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TPropertyMapping#getTargetObjectRef <em>Target Object Ref</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TPropertyMapping#getTargetPropertyRef <em>Target Property Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTPropertyMapping()
 * @model extendedMetaData="name='tPropertyMapping' kind='empty'"
 * @generated
 */
public interface TPropertyMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Service Template Property Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Template Property Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Template Property Ref</em>' attribute.
	 * @see #setServiceTemplatePropertyRef(String)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTPropertyMapping_ServiceTemplatePropertyRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='serviceTemplatePropertyRef'"
	 * @generated
	 */
	String getServiceTemplatePropertyRef();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TPropertyMapping#getServiceTemplatePropertyRef <em>Service Template Property Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Template Property Ref</em>' attribute.
	 * @see #getServiceTemplatePropertyRef()
	 * @generated
	 */
	void setServiceTemplatePropertyRef(String value);

	/**
	 * Returns the value of the '<em><b>Target Object Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Object Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Object Ref</em>' attribute.
	 * @see #setTargetObjectRef(String)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTPropertyMapping_TargetObjectRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF" required="true"
	 *        extendedMetaData="kind='attribute' name='targetObjectRef'"
	 * @generated
	 */
	String getTargetObjectRef();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TPropertyMapping#getTargetObjectRef <em>Target Object Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Object Ref</em>' attribute.
	 * @see #getTargetObjectRef()
	 * @generated
	 */
	void setTargetObjectRef(String value);

	/**
	 * Returns the value of the '<em><b>Target Property Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Property Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Property Ref</em>' attribute.
	 * @see #setTargetPropertyRef(String)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTPropertyMapping_TargetPropertyRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='targetPropertyRef'"
	 * @generated
	 */
	String getTargetPropertyRef();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TPropertyMapping#getTargetPropertyRef <em>Target Property Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Property Ref</em>' attribute.
	 * @see #getTargetPropertyRef()
	 * @generated
	 */
	void setTargetPropertyRef(String value);

} // TPropertyMapping
