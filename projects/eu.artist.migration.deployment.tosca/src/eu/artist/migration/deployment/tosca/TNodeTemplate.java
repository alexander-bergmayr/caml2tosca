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
 * A representation of the model object '<em><b>TNode Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getCapabilities <em>Capabilities</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getPolicies <em>Policies</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getDeploymentArtifacts <em>Deployment Artifacts</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getMaxInstances <em>Max Instances</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getMinInstances <em>Min Instances</em>}</li>
 *   <li>{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTNodeTemplate()
 * @model extendedMetaData="name='tNodeTemplate' kind='elementOnly'"
 * @generated
 */
public interface TNodeTemplate extends TEntityTemplate {
	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' containment reference.
	 * @see #setRequirements(RequirementsType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTNodeTemplate_Requirements()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Requirements' namespace='##targetNamespace'"
	 * @generated
	 */
	RequirementsType getRequirements();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getRequirements <em>Requirements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirements</em>' containment reference.
	 * @see #getRequirements()
	 * @generated
	 */
	void setRequirements(RequirementsType value);

	/**
	 * Returns the value of the '<em><b>Capabilities</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capabilities</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capabilities</em>' containment reference.
	 * @see #setCapabilities(CapabilitiesType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTNodeTemplate_Capabilities()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Capabilities' namespace='##targetNamespace'"
	 * @generated
	 */
	CapabilitiesType getCapabilities();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getCapabilities <em>Capabilities</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capabilities</em>' containment reference.
	 * @see #getCapabilities()
	 * @generated
	 */
	void setCapabilities(CapabilitiesType value);

	/**
	 * Returns the value of the '<em><b>Policies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policies</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policies</em>' containment reference.
	 * @see #setPolicies(PoliciesType)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTNodeTemplate_Policies()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Policies' namespace='##targetNamespace'"
	 * @generated
	 */
	PoliciesType getPolicies();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getPolicies <em>Policies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policies</em>' containment reference.
	 * @see #getPolicies()
	 * @generated
	 */
	void setPolicies(PoliciesType value);

	/**
	 * Returns the value of the '<em><b>Deployment Artifacts</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployment Artifacts</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployment Artifacts</em>' containment reference.
	 * @see #setDeploymentArtifacts(TDeploymentArtifacts)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTNodeTemplate_DeploymentArtifacts()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='DeploymentArtifacts' namespace='##targetNamespace'"
	 * @generated
	 */
	TDeploymentArtifacts getDeploymentArtifacts();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getDeploymentArtifacts <em>Deployment Artifacts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deployment Artifacts</em>' containment reference.
	 * @see #getDeploymentArtifacts()
	 * @generated
	 */
	void setDeploymentArtifacts(TDeploymentArtifacts value);

	/**
	 * Returns the value of the '<em><b>Max Instances</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Instances</em>' attribute.
	 * @see #isSetMaxInstances()
	 * @see #unsetMaxInstances()
	 * @see #setMaxInstances(Object)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTNodeTemplate_MaxInstances()
	 * @model default="1" unsettable="true" dataType="eu.artist.migration.deployment.tosca.MaxInstancesType"
	 *        extendedMetaData="kind='attribute' name='maxInstances'"
	 * @generated
	 */
	Object getMaxInstances();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getMaxInstances <em>Max Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Instances</em>' attribute.
	 * @see #isSetMaxInstances()
	 * @see #unsetMaxInstances()
	 * @see #getMaxInstances()
	 * @generated
	 */
	void setMaxInstances(Object value);

	/**
	 * Unsets the value of the '{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getMaxInstances <em>Max Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxInstances()
	 * @see #getMaxInstances()
	 * @see #setMaxInstances(Object)
	 * @generated
	 */
	void unsetMaxInstances();

	/**
	 * Returns whether the value of the '{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getMaxInstances <em>Max Instances</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Instances</em>' attribute is set.
	 * @see #unsetMaxInstances()
	 * @see #getMaxInstances()
	 * @see #setMaxInstances(Object)
	 * @generated
	 */
	boolean isSetMaxInstances();

	/**
	 * Returns the value of the '<em><b>Min Instances</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Instances</em>' attribute.
	 * @see #isSetMinInstances()
	 * @see #unsetMinInstances()
	 * @see #setMinInstances(int)
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTNodeTemplate_MinInstances()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='minInstances'"
	 * @generated
	 */
	int getMinInstances();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getMinInstances <em>Min Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Instances</em>' attribute.
	 * @see #isSetMinInstances()
	 * @see #unsetMinInstances()
	 * @see #getMinInstances()
	 * @generated
	 */
	void setMinInstances(int value);

	/**
	 * Unsets the value of the '{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getMinInstances <em>Min Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinInstances()
	 * @see #getMinInstances()
	 * @see #setMinInstances(int)
	 * @generated
	 */
	void unsetMinInstances();

	/**
	 * Returns whether the value of the '{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getMinInstances <em>Min Instances</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min Instances</em>' attribute is set.
	 * @see #unsetMinInstances()
	 * @see #getMinInstances()
	 * @see #setMinInstances(int)
	 * @generated
	 */
	boolean isSetMinInstances();

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
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#getTNodeTemplate_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.artist.migration.deployment.tosca.TNodeTemplate#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TNodeTemplate
