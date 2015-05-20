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
package eu.artist.migration.deployment.tosca.impl;

import eu.artist.migration.deployment.tosca.ArtifactReferencesType;
import eu.artist.migration.deployment.tosca.CapabilitiesType;
import eu.artist.migration.deployment.tosca.CapabilitiesType1;
import eu.artist.migration.deployment.tosca.CapabilityDefinitionsType;
import eu.artist.migration.deployment.tosca.ConstraintsType;
import eu.artist.migration.deployment.tosca.ConstraintsType1;
import eu.artist.migration.deployment.tosca.DefinitionsType;
import eu.artist.migration.deployment.tosca.DerivedFromType;
import eu.artist.migration.deployment.tosca.DerivedFromType1;
import eu.artist.migration.deployment.tosca.DerivedFromType2;
import eu.artist.migration.deployment.tosca.DocumentRoot;
import eu.artist.migration.deployment.tosca.ExcludeType;
import eu.artist.migration.deployment.tosca.ExtensionsType;
import eu.artist.migration.deployment.tosca.ImplementationArtifactType;
import eu.artist.migration.deployment.tosca.IncludeType;
import eu.artist.migration.deployment.tosca.InputParametersType;
import eu.artist.migration.deployment.tosca.InputParametersType1;
import eu.artist.migration.deployment.tosca.InstanceStateType;
import eu.artist.migration.deployment.tosca.InterfacesType;
import eu.artist.migration.deployment.tosca.InterfacesType1;
import eu.artist.migration.deployment.tosca.MaxInstancesTypeMember1;
import eu.artist.migration.deployment.tosca.NodeOperationType;
import eu.artist.migration.deployment.tosca.NodeTypeReferenceType;
import eu.artist.migration.deployment.tosca.OutputParametersType;
import eu.artist.migration.deployment.tosca.OutputParametersType1;
import eu.artist.migration.deployment.tosca.PlanModelReferenceType;
import eu.artist.migration.deployment.tosca.PlanModelType;
import eu.artist.migration.deployment.tosca.PlanType;
import eu.artist.migration.deployment.tosca.PoliciesType;
import eu.artist.migration.deployment.tosca.PoliciesType1;
import eu.artist.migration.deployment.tosca.PropertiesDefinitionType;
import eu.artist.migration.deployment.tosca.PropertiesType;
import eu.artist.migration.deployment.tosca.PropertiesType1;
import eu.artist.migration.deployment.tosca.PropertyConstraintsType;
import eu.artist.migration.deployment.tosca.PropertyConstraintsType1;
import eu.artist.migration.deployment.tosca.PropertyMappingsType;
import eu.artist.migration.deployment.tosca.RelationshipConstraintType;
import eu.artist.migration.deployment.tosca.RelationshipConstraintsType;
import eu.artist.migration.deployment.tosca.RelationshipOperationType;
import eu.artist.migration.deployment.tosca.RequirementDefinitionsType;
import eu.artist.migration.deployment.tosca.RequirementsType;
import eu.artist.migration.deployment.tosca.RequirementsType1;
import eu.artist.migration.deployment.tosca.SourceElementType;
import eu.artist.migration.deployment.tosca.SourceInterfacesType;
import eu.artist.migration.deployment.tosca.TAppliesTo;
import eu.artist.migration.deployment.tosca.TArtifactReference;
import eu.artist.migration.deployment.tosca.TArtifactTemplate;
import eu.artist.migration.deployment.tosca.TArtifactType;
import eu.artist.migration.deployment.tosca.TBoolean;
import eu.artist.migration.deployment.tosca.TBoundaryDefinitions;
import eu.artist.migration.deployment.tosca.TCapability;
import eu.artist.migration.deployment.tosca.TCapabilityDefinition;
import eu.artist.migration.deployment.tosca.TCapabilityRef;
import eu.artist.migration.deployment.tosca.TCapabilityType;
import eu.artist.migration.deployment.tosca.TCondition;
import eu.artist.migration.deployment.tosca.TConstraint;
import eu.artist.migration.deployment.tosca.TDefinitions;
import eu.artist.migration.deployment.tosca.TDeploymentArtifact;
import eu.artist.migration.deployment.tosca.TDeploymentArtifacts;
import eu.artist.migration.deployment.tosca.TDocumentation;
import eu.artist.migration.deployment.tosca.TEntityTemplate;
import eu.artist.migration.deployment.tosca.TEntityType;
import eu.artist.migration.deployment.tosca.TExportedInterface;
import eu.artist.migration.deployment.tosca.TExportedOperation;
import eu.artist.migration.deployment.tosca.TExtensibleElements;
import eu.artist.migration.deployment.tosca.TExtension;
import eu.artist.migration.deployment.tosca.TExtensions;
import eu.artist.migration.deployment.tosca.TImplementationArtifact;
import eu.artist.migration.deployment.tosca.TImplementationArtifacts;
import eu.artist.migration.deployment.tosca.TImport;
import eu.artist.migration.deployment.tosca.TInterface;
import eu.artist.migration.deployment.tosca.TNodeTemplate;
import eu.artist.migration.deployment.tosca.TNodeType;
import eu.artist.migration.deployment.tosca.TNodeTypeImplementation;
import eu.artist.migration.deployment.tosca.TOperation;
import eu.artist.migration.deployment.tosca.TParameter;
import eu.artist.migration.deployment.tosca.TPlan;
import eu.artist.migration.deployment.tosca.TPlans;
import eu.artist.migration.deployment.tosca.TPolicy;
import eu.artist.migration.deployment.tosca.TPolicyTemplate;
import eu.artist.migration.deployment.tosca.TPolicyType;
import eu.artist.migration.deployment.tosca.TPropertyConstraint;
import eu.artist.migration.deployment.tosca.TPropertyMapping;
import eu.artist.migration.deployment.tosca.TRelationshipTemplate;
import eu.artist.migration.deployment.tosca.TRelationshipType;
import eu.artist.migration.deployment.tosca.TRelationshipTypeImplementation;
import eu.artist.migration.deployment.tosca.TRequiredContainerFeature;
import eu.artist.migration.deployment.tosca.TRequiredContainerFeatures;
import eu.artist.migration.deployment.tosca.TRequirement;
import eu.artist.migration.deployment.tosca.TRequirementDefinition;
import eu.artist.migration.deployment.tosca.TRequirementRef;
import eu.artist.migration.deployment.tosca.TRequirementType;
import eu.artist.migration.deployment.tosca.TServiceTemplate;
import eu.artist.migration.deployment.tosca.TTag;
import eu.artist.migration.deployment.tosca.TTags;
import eu.artist.migration.deployment.tosca.TTopologyElementInstanceStates;
import eu.artist.migration.deployment.tosca.TTopologyTemplate;
import eu.artist.migration.deployment.tosca.TargetElementType;
import eu.artist.migration.deployment.tosca.TargetInterfacesType;
import eu.artist.migration.deployment.tosca.ToscaFactory;
import eu.artist.migration.deployment.tosca.ToscaPackage;
import eu.artist.migration.deployment.tosca.TypesType;
import eu.artist.migration.deployment.tosca.UpperBoundTypeMember1;
import eu.artist.migration.deployment.tosca.UpperBoundTypeMember11;
import eu.artist.migration.deployment.tosca.ValidSourceType;
import eu.artist.migration.deployment.tosca.ValidTargetType;

import eu.artist.migration.deployment.tosca.util.ToscaValidator;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ToscaPackageImpl extends EPackageImpl implements ToscaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass artifactReferencesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass capabilitiesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass capabilitiesType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass capabilityDefinitionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintsType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definitionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivedFromTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivedFromType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivedFromType2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass excludeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationArtifactTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass includeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputParametersTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputParametersType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceStateTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfacesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfacesType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeOperationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeTypeReferenceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputParametersTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputParametersType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass planModelReferenceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass planModelTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass planTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass policiesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass policiesType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertiesDefinitionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertiesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertiesType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyConstraintsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyConstraintsType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyMappingsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipConstraintsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipConstraintTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipOperationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementDefinitionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementsType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceInterfacesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tAppliesToEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetInterfacesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tArtifactReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tArtifactTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tArtifactTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tBoundaryDefinitionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCapabilityDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCapabilityRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCapabilityTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDefinitionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDeploymentArtifactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDeploymentArtifactsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDocumentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tEntityTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tEntityTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExportedInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExportedOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExtensibleElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExtensionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tImplementationArtifactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tImplementationArtifactsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tNodeTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tNodeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tNodeTypeImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPlanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPlansEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPolicyTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPolicyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPropertyConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPropertyMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRelationshipTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRelationshipTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRelationshipTypeImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRequiredContainerFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRequiredContainerFeaturesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRequirementDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRequirementRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRequirementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tServiceTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTagsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTopologyElementInstanceStatesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTopologyTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validSourceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validTargetTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum maxInstancesTypeMember1EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tBooleanEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum upperBoundTypeMember1EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum upperBoundTypeMember11EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType importedURIEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType maxInstancesTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType maxInstancesTypeMember0EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType maxInstancesTypeMember1ObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tBooleanObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType upperBoundTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType upperBoundType1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType upperBoundTypeMember0EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType upperBoundTypeMember01EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType upperBoundTypeMember1ObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType upperBoundTypeMember1Object1EDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see eu.artist.migration.deployment.tosca.ToscaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ToscaPackageImpl() {
		super(eNS_URI, ToscaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ToscaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ToscaPackage init() {
		if (isInited) return (ToscaPackage)EPackage.Registry.INSTANCE.getEPackage(ToscaPackage.eNS_URI);

		// Obtain or create and register package
		ToscaPackageImpl theToscaPackage = (ToscaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ToscaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ToscaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLNamespacePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theToscaPackage.createPackageContents();

		// Initialize created meta-data
		theToscaPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theToscaPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ToscaValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theToscaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ToscaPackage.eNS_URI, theToscaPackage);
		return theToscaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArtifactReferencesType() {
		return artifactReferencesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArtifactReferencesType_ArtifactReference() {
		return (EReference)artifactReferencesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCapabilitiesType() {
		return capabilitiesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCapabilitiesType_Capability() {
		return (EReference)capabilitiesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCapabilitiesType1() {
		return capabilitiesType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCapabilitiesType1_Capability() {
		return (EReference)capabilitiesType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCapabilityDefinitionsType() {
		return capabilityDefinitionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCapabilityDefinitionsType_CapabilityDefinition() {
		return (EReference)capabilityDefinitionsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintsType() {
		return constraintsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintsType_Constraint() {
		return (EReference)constraintsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintsType1() {
		return constraintsType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintsType1_Constraint() {
		return (EReference)constraintsType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinitionsType() {
		return definitionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerivedFromType() {
		return derivedFromTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerivedFromType_RelationshipTypeImplementationRef() {
		return (EAttribute)derivedFromTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerivedFromType1() {
		return derivedFromType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerivedFromType1_NodeTypeImplementationRef() {
		return (EAttribute)derivedFromType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerivedFromType2() {
		return derivedFromType2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerivedFromType2_TypeRef() {
		return (EAttribute)derivedFromType2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Definitions() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Documentation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExcludeType() {
		return excludeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExcludeType_Pattern() {
		return (EAttribute)excludeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionsType() {
		return extensionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionsType_Extension() {
		return (EReference)extensionsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationArtifactType() {
		return implementationArtifactTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIncludeType() {
		return includeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncludeType_Pattern() {
		return (EAttribute)includeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputParametersType() {
		return inputParametersTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputParametersType_InputParameter() {
		return (EReference)inputParametersTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputParametersType1() {
		return inputParametersType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputParametersType1_InputParameter() {
		return (EReference)inputParametersType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceStateType() {
		return instanceStateTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceStateType_State() {
		return (EAttribute)instanceStateTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfacesType() {
		return interfacesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfacesType_Interface() {
		return (EReference)interfacesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfacesType1() {
		return interfacesType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfacesType1_Interface() {
		return (EReference)interfacesType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeOperationType() {
		return nodeOperationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeOperationType_InterfaceName() {
		return (EAttribute)nodeOperationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeOperationType_NodeRef() {
		return (EAttribute)nodeOperationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeOperationType_OperationName() {
		return (EAttribute)nodeOperationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeTypeReferenceType() {
		return nodeTypeReferenceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeTypeReferenceType_TypeRef() {
		return (EAttribute)nodeTypeReferenceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputParametersType() {
		return outputParametersTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputParametersType_OutputParameter() {
		return (EReference)outputParametersTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputParametersType1() {
		return outputParametersType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputParametersType1_OutputParameter() {
		return (EReference)outputParametersType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlanModelReferenceType() {
		return planModelReferenceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlanModelReferenceType_Reference() {
		return (EAttribute)planModelReferenceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlanModelType() {
		return planModelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlanModelType_Any() {
		return (EAttribute)planModelTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlanType() {
		return planTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlanType_PlanRef() {
		return (EAttribute)planTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoliciesType() {
		return policiesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPoliciesType_Policy() {
		return (EReference)policiesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoliciesType1() {
		return policiesType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPoliciesType1_Policy() {
		return (EReference)policiesType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertiesDefinitionType() {
		return propertiesDefinitionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertiesDefinitionType_Element() {
		return (EAttribute)propertiesDefinitionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertiesDefinitionType_Type() {
		return (EAttribute)propertiesDefinitionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertiesType() {
		return propertiesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertiesType_Any() {
		return (EAttribute)propertiesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertiesType1() {
		return propertiesType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertiesType1_Any() {
		return (EAttribute)propertiesType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertiesType1_PropertyMappings() {
		return (EReference)propertiesType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyConstraintsType() {
		return propertyConstraintsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyConstraintsType_PropertyConstraint() {
		return (EReference)propertyConstraintsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyConstraintsType1() {
		return propertyConstraintsType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyConstraintsType1_PropertyConstraint() {
		return (EReference)propertyConstraintsType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyMappingsType() {
		return propertyMappingsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyMappingsType_PropertyMapping() {
		return (EReference)propertyMappingsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationshipConstraintsType() {
		return relationshipConstraintsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationshipConstraintsType_RelationshipConstraint() {
		return (EReference)relationshipConstraintsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationshipConstraintType() {
		return relationshipConstraintTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationshipConstraintType_Any() {
		return (EAttribute)relationshipConstraintTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationshipConstraintType_ConstraintType() {
		return (EAttribute)relationshipConstraintTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationshipOperationType() {
		return relationshipOperationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationshipOperationType_InterfaceName() {
		return (EAttribute)relationshipOperationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationshipOperationType_OperationName() {
		return (EAttribute)relationshipOperationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationshipOperationType_RelationshipRef() {
		return (EAttribute)relationshipOperationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirementDefinitionsType() {
		return requirementDefinitionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirementDefinitionsType_RequirementDefinition() {
		return (EReference)requirementDefinitionsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirementsType() {
		return requirementsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirementsType_Requirement() {
		return (EReference)requirementsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirementsType1() {
		return requirementsType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirementsType1_Requirement() {
		return (EReference)requirementsType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceElementType() {
		return sourceElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceElementType_Ref() {
		return (EAttribute)sourceElementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceInterfacesType() {
		return sourceInterfacesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceInterfacesType_Interface() {
		return (EReference)sourceInterfacesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTAppliesTo() {
		return tAppliesToEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTAppliesTo_NodeTypeReference() {
		return (EReference)tAppliesToEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetElementType() {
		return targetElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTargetElementType_Ref() {
		return (EAttribute)targetElementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetInterfacesType() {
		return targetInterfacesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetInterfacesType_Interface() {
		return (EReference)targetInterfacesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTArtifactReference() {
		return tArtifactReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTArtifactReference_Group() {
		return (EAttribute)tArtifactReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTArtifactReference_Include() {
		return (EReference)tArtifactReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTArtifactReference_Exclude() {
		return (EReference)tArtifactReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTArtifactReference_Reference() {
		return (EAttribute)tArtifactReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTArtifactTemplate() {
		return tArtifactTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTArtifactTemplate_ArtifactReferences() {
		return (EReference)tArtifactTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTArtifactTemplate_Name() {
		return (EAttribute)tArtifactTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTArtifactType() {
		return tArtifactTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTBoundaryDefinitions() {
		return tBoundaryDefinitionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBoundaryDefinitions_Properties() {
		return (EReference)tBoundaryDefinitionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBoundaryDefinitions_PropertyConstraints() {
		return (EReference)tBoundaryDefinitionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBoundaryDefinitions_Requirements() {
		return (EReference)tBoundaryDefinitionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBoundaryDefinitions_Capabilities() {
		return (EReference)tBoundaryDefinitionsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBoundaryDefinitions_Policies() {
		return (EReference)tBoundaryDefinitionsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBoundaryDefinitions_Interfaces() {
		return (EReference)tBoundaryDefinitionsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCapability() {
		return tCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCapability_Name() {
		return (EAttribute)tCapabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCapabilityDefinition() {
		return tCapabilityDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCapabilityDefinition_Constraints() {
		return (EReference)tCapabilityDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCapabilityDefinition_CapabilityType() {
		return (EAttribute)tCapabilityDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCapabilityDefinition_LowerBound() {
		return (EAttribute)tCapabilityDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCapabilityDefinition_Name() {
		return (EAttribute)tCapabilityDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCapabilityDefinition_UpperBound() {
		return (EAttribute)tCapabilityDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCapabilityRef() {
		return tCapabilityRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCapabilityRef_Name() {
		return (EAttribute)tCapabilityRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCapabilityRef_Ref() {
		return (EAttribute)tCapabilityRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCapabilityType() {
		return tCapabilityTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCondition() {
		return tConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCondition_Any() {
		return (EAttribute)tConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCondition_ExpressionLanguage() {
		return (EAttribute)tConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTConstraint() {
		return tConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTConstraint_Any() {
		return (EAttribute)tConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTConstraint_ConstraintType() {
		return (EAttribute)tConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDefinitions() {
		return tDefinitionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_Extensions() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_Import() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_Types() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDefinitions_Group() {
		return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_ServiceTemplate() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_NodeType() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_NodeTypeImplementation() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_RelationshipType() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_RelationshipTypeImplementation() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_RequirementType() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_CapabilityType() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_ArtifactType() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_ArtifactTemplate() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_PolicyType() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_PolicyTemplate() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDefinitions_Id() {
		return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDefinitions_Name() {
		return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDefinitions_TargetNamespace() {
		return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDeploymentArtifact() {
		return tDeploymentArtifactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDeploymentArtifact_ArtifactRef() {
		return (EAttribute)tDeploymentArtifactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDeploymentArtifact_ArtifactType() {
		return (EAttribute)tDeploymentArtifactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDeploymentArtifact_Name() {
		return (EAttribute)tDeploymentArtifactEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDeploymentArtifacts() {
		return tDeploymentArtifactsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDeploymentArtifacts_DeploymentArtifact() {
		return (EReference)tDeploymentArtifactsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDocumentation() {
		return tDocumentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDocumentation_Mixed() {
		return (EAttribute)tDocumentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDocumentation_Any() {
		return (EAttribute)tDocumentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDocumentation_Lang() {
		return (EAttribute)tDocumentationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDocumentation_Source() {
		return (EAttribute)tDocumentationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTEntityTemplate() {
		return tEntityTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEntityTemplate_Properties() {
		return (EReference)tEntityTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEntityTemplate_PropertyConstraints() {
		return (EReference)tEntityTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTEntityTemplate_Id() {
		return (EAttribute)tEntityTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTEntityTemplate_Type() {
		return (EAttribute)tEntityTemplateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTEntityType() {
		return tEntityTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEntityType_Tags() {
		return (EReference)tEntityTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEntityType_DerivedFrom() {
		return (EReference)tEntityTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEntityType_PropertiesDefinition() {
		return (EReference)tEntityTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTEntityType_Abstract() {
		return (EAttribute)tEntityTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTEntityType_Final() {
		return (EAttribute)tEntityTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTEntityType_Name() {
		return (EAttribute)tEntityTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTEntityType_TargetNamespace() {
		return (EAttribute)tEntityTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExportedInterface() {
		return tExportedInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTExportedInterface_Operation() {
		return (EReference)tExportedInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExportedInterface_Name() {
		return (EAttribute)tExportedInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExportedOperation() {
		return tExportedOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTExportedOperation_NodeOperation() {
		return (EReference)tExportedOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTExportedOperation_RelationshipOperation() {
		return (EReference)tExportedOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTExportedOperation_Plan() {
		return (EReference)tExportedOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExportedOperation_Name() {
		return (EAttribute)tExportedOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExtensibleElements() {
		return tExtensibleElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTExtensibleElements_Documentation() {
		return (EReference)tExtensibleElementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibleElements_Any() {
		return (EAttribute)tExtensibleElementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibleElements_AnyAttribute() {
		return (EAttribute)tExtensibleElementsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExtension() {
		return tExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtension_MustUnderstand() {
		return (EAttribute)tExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtension_Namespace() {
		return (EAttribute)tExtensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExtensions() {
		return tExtensionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTExtensions_Extension() {
		return (EReference)tExtensionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTImplementationArtifact() {
		return tImplementationArtifactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImplementationArtifact_ArtifactRef() {
		return (EAttribute)tImplementationArtifactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImplementationArtifact_ArtifactType() {
		return (EAttribute)tImplementationArtifactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImplementationArtifact_InterfaceName() {
		return (EAttribute)tImplementationArtifactEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImplementationArtifact_OperationName() {
		return (EAttribute)tImplementationArtifactEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTImplementationArtifacts() {
		return tImplementationArtifactsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTImplementationArtifacts_ImplementationArtifact() {
		return (EReference)tImplementationArtifactsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTImport() {
		return tImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImport_ImportType() {
		return (EAttribute)tImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImport_Location() {
		return (EAttribute)tImportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImport_Namespace() {
		return (EAttribute)tImportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTInterface() {
		return tInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInterface_Operation() {
		return (EReference)tInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTInterface_Name() {
		return (EAttribute)tInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTNodeTemplate() {
		return tNodeTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeTemplate_Requirements() {
		return (EReference)tNodeTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeTemplate_Capabilities() {
		return (EReference)tNodeTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeTemplate_Policies() {
		return (EReference)tNodeTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeTemplate_DeploymentArtifacts() {
		return (EReference)tNodeTemplateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTNodeTemplate_MaxInstances() {
		return (EAttribute)tNodeTemplateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTNodeTemplate_MinInstances() {
		return (EAttribute)tNodeTemplateEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTNodeTemplate_Name() {
		return (EAttribute)tNodeTemplateEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTNodeType() {
		return tNodeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeType_RequirementDefinitions() {
		return (EReference)tNodeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeType_CapabilityDefinitions() {
		return (EReference)tNodeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeType_InstanceStates() {
		return (EReference)tNodeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeType_Interfaces() {
		return (EReference)tNodeTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTNodeTypeImplementation() {
		return tNodeTypeImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeTypeImplementation_Tags() {
		return (EReference)tNodeTypeImplementationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeTypeImplementation_DerivedFrom() {
		return (EReference)tNodeTypeImplementationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeTypeImplementation_RequiredContainerFeatures() {
		return (EReference)tNodeTypeImplementationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeTypeImplementation_ImplementationArtifacts() {
		return (EReference)tNodeTypeImplementationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNodeTypeImplementation_DeploymentArtifacts() {
		return (EReference)tNodeTypeImplementationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTNodeTypeImplementation_Abstract() {
		return (EAttribute)tNodeTypeImplementationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTNodeTypeImplementation_Final() {
		return (EAttribute)tNodeTypeImplementationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTNodeTypeImplementation_Name() {
		return (EAttribute)tNodeTypeImplementationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTNodeTypeImplementation_NodeType() {
		return (EAttribute)tNodeTypeImplementationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTNodeTypeImplementation_TargetNamespace() {
		return (EAttribute)tNodeTypeImplementationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTOperation() {
		return tOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOperation_InputParameters() {
		return (EReference)tOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOperation_OutputParameters() {
		return (EReference)tOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTOperation_Name() {
		return (EAttribute)tOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTParameter() {
		return tParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTParameter_Name() {
		return (EAttribute)tParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTParameter_Required() {
		return (EAttribute)tParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTParameter_Type() {
		return (EAttribute)tParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPlan() {
		return tPlanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPlan_Precondition() {
		return (EReference)tPlanEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPlan_InputParameters() {
		return (EReference)tPlanEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPlan_OutputParameters() {
		return (EReference)tPlanEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPlan_PlanModel() {
		return (EReference)tPlanEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPlan_PlanModelReference() {
		return (EReference)tPlanEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPlan_Id() {
		return (EAttribute)tPlanEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPlan_Name() {
		return (EAttribute)tPlanEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPlan_PlanLanguage() {
		return (EAttribute)tPlanEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPlan_PlanType() {
		return (EAttribute)tPlanEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPlans() {
		return tPlansEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPlans_Plan() {
		return (EReference)tPlansEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPlans_TargetNamespace() {
		return (EAttribute)tPlansEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPolicy() {
		return tPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPolicy_Name() {
		return (EAttribute)tPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPolicy_PolicyRef() {
		return (EAttribute)tPolicyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPolicy_PolicyType() {
		return (EAttribute)tPolicyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPolicyTemplate() {
		return tPolicyTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPolicyTemplate_Name() {
		return (EAttribute)tPolicyTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPolicyType() {
		return tPolicyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPolicyType_AppliesTo() {
		return (EReference)tPolicyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPolicyType_PolicyLanguage() {
		return (EAttribute)tPolicyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPropertyConstraint() {
		return tPropertyConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPropertyConstraint_Property() {
		return (EAttribute)tPropertyConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPropertyMapping() {
		return tPropertyMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPropertyMapping_ServiceTemplatePropertyRef() {
		return (EAttribute)tPropertyMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPropertyMapping_TargetObjectRef() {
		return (EAttribute)tPropertyMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPropertyMapping_TargetPropertyRef() {
		return (EAttribute)tPropertyMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRelationshipTemplate() {
		return tRelationshipTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipTemplate_SourceElement() {
		return (EReference)tRelationshipTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipTemplate_TargetElement() {
		return (EReference)tRelationshipTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipTemplate_RelationshipConstraints() {
		return (EReference)tRelationshipTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRelationshipTemplate_Name() {
		return (EAttribute)tRelationshipTemplateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRelationshipType() {
		return tRelationshipTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipType_InstanceStates() {
		return (EReference)tRelationshipTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipType_SourceInterfaces() {
		return (EReference)tRelationshipTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipType_TargetInterfaces() {
		return (EReference)tRelationshipTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipType_ValidSource() {
		return (EReference)tRelationshipTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipType_ValidTarget() {
		return (EReference)tRelationshipTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRelationshipTypeImplementation() {
		return tRelationshipTypeImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipTypeImplementation_Tags() {
		return (EReference)tRelationshipTypeImplementationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipTypeImplementation_DerivedFrom() {
		return (EReference)tRelationshipTypeImplementationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipTypeImplementation_RequiredContainerFeatures() {
		return (EReference)tRelationshipTypeImplementationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationshipTypeImplementation_ImplementationArtifacts() {
		return (EReference)tRelationshipTypeImplementationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRelationshipTypeImplementation_Abstract() {
		return (EAttribute)tRelationshipTypeImplementationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRelationshipTypeImplementation_Final() {
		return (EAttribute)tRelationshipTypeImplementationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRelationshipTypeImplementation_Name() {
		return (EAttribute)tRelationshipTypeImplementationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRelationshipTypeImplementation_RelationshipType() {
		return (EAttribute)tRelationshipTypeImplementationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRelationshipTypeImplementation_TargetNamespace() {
		return (EAttribute)tRelationshipTypeImplementationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRequiredContainerFeature() {
		return tRequiredContainerFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRequiredContainerFeature_Feature() {
		return (EAttribute)tRequiredContainerFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRequiredContainerFeatures() {
		return tRequiredContainerFeaturesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRequiredContainerFeatures_RequiredContainerFeature() {
		return (EReference)tRequiredContainerFeaturesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRequirement() {
		return tRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRequirement_Name() {
		return (EAttribute)tRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRequirementDefinition() {
		return tRequirementDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRequirementDefinition_Constraints() {
		return (EReference)tRequirementDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRequirementDefinition_LowerBound() {
		return (EAttribute)tRequirementDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRequirementDefinition_Name() {
		return (EAttribute)tRequirementDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRequirementDefinition_RequirementType() {
		return (EAttribute)tRequirementDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRequirementDefinition_UpperBound() {
		return (EAttribute)tRequirementDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRequirementRef() {
		return tRequirementRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRequirementRef_Name() {
		return (EAttribute)tRequirementRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRequirementRef_Ref() {
		return (EAttribute)tRequirementRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRequirementType() {
		return tRequirementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRequirementType_RequiredCapabilityType() {
		return (EAttribute)tRequirementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTServiceTemplate() {
		return tServiceTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTServiceTemplate_Tags() {
		return (EReference)tServiceTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTServiceTemplate_BoundaryDefinitions() {
		return (EReference)tServiceTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTServiceTemplate_TopologyTemplate() {
		return (EReference)tServiceTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTServiceTemplate_Plans() {
		return (EReference)tServiceTemplateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTServiceTemplate_Id() {
		return (EAttribute)tServiceTemplateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTServiceTemplate_Name() {
		return (EAttribute)tServiceTemplateEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTServiceTemplate_SubstitutableNodeType() {
		return (EAttribute)tServiceTemplateEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTServiceTemplate_TargetNamespace() {
		return (EAttribute)tServiceTemplateEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTag() {
		return tTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTag_Name() {
		return (EAttribute)tTagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTag_Value() {
		return (EAttribute)tTagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTags() {
		return tTagsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTags_Tag() {
		return (EReference)tTagsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTopologyElementInstanceStates() {
		return tTopologyElementInstanceStatesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTopologyElementInstanceStates_InstanceState() {
		return (EReference)tTopologyElementInstanceStatesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTopologyTemplate() {
		return tTopologyTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTopologyTemplate_Group() {
		return (EAttribute)tTopologyTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTopologyTemplate_NodeTemplate() {
		return (EReference)tTopologyTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTopologyTemplate_RelationshipTemplate() {
		return (EReference)tTopologyTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypesType() {
		return typesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypesType_Any() {
		return (EAttribute)typesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidSourceType() {
		return validSourceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidSourceType_TypeRef() {
		return (EAttribute)validSourceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidTargetType() {
		return validTargetTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidTargetType_TypeRef() {
		return (EAttribute)validTargetTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMaxInstancesTypeMember1() {
		return maxInstancesTypeMember1EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTBoolean() {
		return tBooleanEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUpperBoundTypeMember1() {
		return upperBoundTypeMember1EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUpperBoundTypeMember11() {
		return upperBoundTypeMember11EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImportedURI() {
		return importedURIEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMaxInstancesType() {
		return maxInstancesTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMaxInstancesTypeMember0() {
		return maxInstancesTypeMember0EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMaxInstancesTypeMember1Object() {
		return maxInstancesTypeMember1ObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTBooleanObject() {
		return tBooleanObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUpperBoundType() {
		return upperBoundTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUpperBoundType1() {
		return upperBoundType1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUpperBoundTypeMember0() {
		return upperBoundTypeMember0EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUpperBoundTypeMember01() {
		return upperBoundTypeMember01EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUpperBoundTypeMember1Object() {
		return upperBoundTypeMember1ObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUpperBoundTypeMember1Object1() {
		return upperBoundTypeMember1Object1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToscaFactory getToscaFactory() {
		return (ToscaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		artifactReferencesTypeEClass = createEClass(ARTIFACT_REFERENCES_TYPE);
		createEReference(artifactReferencesTypeEClass, ARTIFACT_REFERENCES_TYPE__ARTIFACT_REFERENCE);

		capabilitiesTypeEClass = createEClass(CAPABILITIES_TYPE);
		createEReference(capabilitiesTypeEClass, CAPABILITIES_TYPE__CAPABILITY);

		capabilitiesType1EClass = createEClass(CAPABILITIES_TYPE1);
		createEReference(capabilitiesType1EClass, CAPABILITIES_TYPE1__CAPABILITY);

		capabilityDefinitionsTypeEClass = createEClass(CAPABILITY_DEFINITIONS_TYPE);
		createEReference(capabilityDefinitionsTypeEClass, CAPABILITY_DEFINITIONS_TYPE__CAPABILITY_DEFINITION);

		constraintsTypeEClass = createEClass(CONSTRAINTS_TYPE);
		createEReference(constraintsTypeEClass, CONSTRAINTS_TYPE__CONSTRAINT);

		constraintsType1EClass = createEClass(CONSTRAINTS_TYPE1);
		createEReference(constraintsType1EClass, CONSTRAINTS_TYPE1__CONSTRAINT);

		definitionsTypeEClass = createEClass(DEFINITIONS_TYPE);

		derivedFromTypeEClass = createEClass(DERIVED_FROM_TYPE);
		createEAttribute(derivedFromTypeEClass, DERIVED_FROM_TYPE__RELATIONSHIP_TYPE_IMPLEMENTATION_REF);

		derivedFromType1EClass = createEClass(DERIVED_FROM_TYPE1);
		createEAttribute(derivedFromType1EClass, DERIVED_FROM_TYPE1__NODE_TYPE_IMPLEMENTATION_REF);

		derivedFromType2EClass = createEClass(DERIVED_FROM_TYPE2);
		createEAttribute(derivedFromType2EClass, DERIVED_FROM_TYPE2__TYPE_REF);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DEFINITIONS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DOCUMENTATION);

		excludeTypeEClass = createEClass(EXCLUDE_TYPE);
		createEAttribute(excludeTypeEClass, EXCLUDE_TYPE__PATTERN);

		extensionsTypeEClass = createEClass(EXTENSIONS_TYPE);
		createEReference(extensionsTypeEClass, EXTENSIONS_TYPE__EXTENSION);

		implementationArtifactTypeEClass = createEClass(IMPLEMENTATION_ARTIFACT_TYPE);

		includeTypeEClass = createEClass(INCLUDE_TYPE);
		createEAttribute(includeTypeEClass, INCLUDE_TYPE__PATTERN);

		inputParametersTypeEClass = createEClass(INPUT_PARAMETERS_TYPE);
		createEReference(inputParametersTypeEClass, INPUT_PARAMETERS_TYPE__INPUT_PARAMETER);

		inputParametersType1EClass = createEClass(INPUT_PARAMETERS_TYPE1);
		createEReference(inputParametersType1EClass, INPUT_PARAMETERS_TYPE1__INPUT_PARAMETER);

		instanceStateTypeEClass = createEClass(INSTANCE_STATE_TYPE);
		createEAttribute(instanceStateTypeEClass, INSTANCE_STATE_TYPE__STATE);

		interfacesTypeEClass = createEClass(INTERFACES_TYPE);
		createEReference(interfacesTypeEClass, INTERFACES_TYPE__INTERFACE);

		interfacesType1EClass = createEClass(INTERFACES_TYPE1);
		createEReference(interfacesType1EClass, INTERFACES_TYPE1__INTERFACE);

		nodeOperationTypeEClass = createEClass(NODE_OPERATION_TYPE);
		createEAttribute(nodeOperationTypeEClass, NODE_OPERATION_TYPE__INTERFACE_NAME);
		createEAttribute(nodeOperationTypeEClass, NODE_OPERATION_TYPE__NODE_REF);
		createEAttribute(nodeOperationTypeEClass, NODE_OPERATION_TYPE__OPERATION_NAME);

		nodeTypeReferenceTypeEClass = createEClass(NODE_TYPE_REFERENCE_TYPE);
		createEAttribute(nodeTypeReferenceTypeEClass, NODE_TYPE_REFERENCE_TYPE__TYPE_REF);

		outputParametersTypeEClass = createEClass(OUTPUT_PARAMETERS_TYPE);
		createEReference(outputParametersTypeEClass, OUTPUT_PARAMETERS_TYPE__OUTPUT_PARAMETER);

		outputParametersType1EClass = createEClass(OUTPUT_PARAMETERS_TYPE1);
		createEReference(outputParametersType1EClass, OUTPUT_PARAMETERS_TYPE1__OUTPUT_PARAMETER);

		planModelReferenceTypeEClass = createEClass(PLAN_MODEL_REFERENCE_TYPE);
		createEAttribute(planModelReferenceTypeEClass, PLAN_MODEL_REFERENCE_TYPE__REFERENCE);

		planModelTypeEClass = createEClass(PLAN_MODEL_TYPE);
		createEAttribute(planModelTypeEClass, PLAN_MODEL_TYPE__ANY);

		planTypeEClass = createEClass(PLAN_TYPE);
		createEAttribute(planTypeEClass, PLAN_TYPE__PLAN_REF);

		policiesTypeEClass = createEClass(POLICIES_TYPE);
		createEReference(policiesTypeEClass, POLICIES_TYPE__POLICY);

		policiesType1EClass = createEClass(POLICIES_TYPE1);
		createEReference(policiesType1EClass, POLICIES_TYPE1__POLICY);

		propertiesDefinitionTypeEClass = createEClass(PROPERTIES_DEFINITION_TYPE);
		createEAttribute(propertiesDefinitionTypeEClass, PROPERTIES_DEFINITION_TYPE__ELEMENT);
		createEAttribute(propertiesDefinitionTypeEClass, PROPERTIES_DEFINITION_TYPE__TYPE);

		propertiesTypeEClass = createEClass(PROPERTIES_TYPE);
		createEAttribute(propertiesTypeEClass, PROPERTIES_TYPE__ANY);

		propertiesType1EClass = createEClass(PROPERTIES_TYPE1);
		createEAttribute(propertiesType1EClass, PROPERTIES_TYPE1__ANY);
		createEReference(propertiesType1EClass, PROPERTIES_TYPE1__PROPERTY_MAPPINGS);

		propertyConstraintsTypeEClass = createEClass(PROPERTY_CONSTRAINTS_TYPE);
		createEReference(propertyConstraintsTypeEClass, PROPERTY_CONSTRAINTS_TYPE__PROPERTY_CONSTRAINT);

		propertyConstraintsType1EClass = createEClass(PROPERTY_CONSTRAINTS_TYPE1);
		createEReference(propertyConstraintsType1EClass, PROPERTY_CONSTRAINTS_TYPE1__PROPERTY_CONSTRAINT);

		propertyMappingsTypeEClass = createEClass(PROPERTY_MAPPINGS_TYPE);
		createEReference(propertyMappingsTypeEClass, PROPERTY_MAPPINGS_TYPE__PROPERTY_MAPPING);

		relationshipConstraintsTypeEClass = createEClass(RELATIONSHIP_CONSTRAINTS_TYPE);
		createEReference(relationshipConstraintsTypeEClass, RELATIONSHIP_CONSTRAINTS_TYPE__RELATIONSHIP_CONSTRAINT);

		relationshipConstraintTypeEClass = createEClass(RELATIONSHIP_CONSTRAINT_TYPE);
		createEAttribute(relationshipConstraintTypeEClass, RELATIONSHIP_CONSTRAINT_TYPE__ANY);
		createEAttribute(relationshipConstraintTypeEClass, RELATIONSHIP_CONSTRAINT_TYPE__CONSTRAINT_TYPE);

		relationshipOperationTypeEClass = createEClass(RELATIONSHIP_OPERATION_TYPE);
		createEAttribute(relationshipOperationTypeEClass, RELATIONSHIP_OPERATION_TYPE__INTERFACE_NAME);
		createEAttribute(relationshipOperationTypeEClass, RELATIONSHIP_OPERATION_TYPE__OPERATION_NAME);
		createEAttribute(relationshipOperationTypeEClass, RELATIONSHIP_OPERATION_TYPE__RELATIONSHIP_REF);

		requirementDefinitionsTypeEClass = createEClass(REQUIREMENT_DEFINITIONS_TYPE);
		createEReference(requirementDefinitionsTypeEClass, REQUIREMENT_DEFINITIONS_TYPE__REQUIREMENT_DEFINITION);

		requirementsTypeEClass = createEClass(REQUIREMENTS_TYPE);
		createEReference(requirementsTypeEClass, REQUIREMENTS_TYPE__REQUIREMENT);

		requirementsType1EClass = createEClass(REQUIREMENTS_TYPE1);
		createEReference(requirementsType1EClass, REQUIREMENTS_TYPE1__REQUIREMENT);

		sourceElementTypeEClass = createEClass(SOURCE_ELEMENT_TYPE);
		createEAttribute(sourceElementTypeEClass, SOURCE_ELEMENT_TYPE__REF);

		sourceInterfacesTypeEClass = createEClass(SOURCE_INTERFACES_TYPE);
		createEReference(sourceInterfacesTypeEClass, SOURCE_INTERFACES_TYPE__INTERFACE);

		tAppliesToEClass = createEClass(TAPPLIES_TO);
		createEReference(tAppliesToEClass, TAPPLIES_TO__NODE_TYPE_REFERENCE);

		targetElementTypeEClass = createEClass(TARGET_ELEMENT_TYPE);
		createEAttribute(targetElementTypeEClass, TARGET_ELEMENT_TYPE__REF);

		targetInterfacesTypeEClass = createEClass(TARGET_INTERFACES_TYPE);
		createEReference(targetInterfacesTypeEClass, TARGET_INTERFACES_TYPE__INTERFACE);

		tArtifactReferenceEClass = createEClass(TARTIFACT_REFERENCE);
		createEAttribute(tArtifactReferenceEClass, TARTIFACT_REFERENCE__GROUP);
		createEReference(tArtifactReferenceEClass, TARTIFACT_REFERENCE__INCLUDE);
		createEReference(tArtifactReferenceEClass, TARTIFACT_REFERENCE__EXCLUDE);
		createEAttribute(tArtifactReferenceEClass, TARTIFACT_REFERENCE__REFERENCE);

		tArtifactTemplateEClass = createEClass(TARTIFACT_TEMPLATE);
		createEReference(tArtifactTemplateEClass, TARTIFACT_TEMPLATE__ARTIFACT_REFERENCES);
		createEAttribute(tArtifactTemplateEClass, TARTIFACT_TEMPLATE__NAME);

		tArtifactTypeEClass = createEClass(TARTIFACT_TYPE);

		tBoundaryDefinitionsEClass = createEClass(TBOUNDARY_DEFINITIONS);
		createEReference(tBoundaryDefinitionsEClass, TBOUNDARY_DEFINITIONS__PROPERTIES);
		createEReference(tBoundaryDefinitionsEClass, TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS);
		createEReference(tBoundaryDefinitionsEClass, TBOUNDARY_DEFINITIONS__REQUIREMENTS);
		createEReference(tBoundaryDefinitionsEClass, TBOUNDARY_DEFINITIONS__CAPABILITIES);
		createEReference(tBoundaryDefinitionsEClass, TBOUNDARY_DEFINITIONS__POLICIES);
		createEReference(tBoundaryDefinitionsEClass, TBOUNDARY_DEFINITIONS__INTERFACES);

		tCapabilityEClass = createEClass(TCAPABILITY);
		createEAttribute(tCapabilityEClass, TCAPABILITY__NAME);

		tCapabilityDefinitionEClass = createEClass(TCAPABILITY_DEFINITION);
		createEReference(tCapabilityDefinitionEClass, TCAPABILITY_DEFINITION__CONSTRAINTS);
		createEAttribute(tCapabilityDefinitionEClass, TCAPABILITY_DEFINITION__CAPABILITY_TYPE);
		createEAttribute(tCapabilityDefinitionEClass, TCAPABILITY_DEFINITION__LOWER_BOUND);
		createEAttribute(tCapabilityDefinitionEClass, TCAPABILITY_DEFINITION__NAME);
		createEAttribute(tCapabilityDefinitionEClass, TCAPABILITY_DEFINITION__UPPER_BOUND);

		tCapabilityRefEClass = createEClass(TCAPABILITY_REF);
		createEAttribute(tCapabilityRefEClass, TCAPABILITY_REF__NAME);
		createEAttribute(tCapabilityRefEClass, TCAPABILITY_REF__REF);

		tCapabilityTypeEClass = createEClass(TCAPABILITY_TYPE);

		tConditionEClass = createEClass(TCONDITION);
		createEAttribute(tConditionEClass, TCONDITION__ANY);
		createEAttribute(tConditionEClass, TCONDITION__EXPRESSION_LANGUAGE);

		tConstraintEClass = createEClass(TCONSTRAINT);
		createEAttribute(tConstraintEClass, TCONSTRAINT__ANY);
		createEAttribute(tConstraintEClass, TCONSTRAINT__CONSTRAINT_TYPE);

		tDefinitionsEClass = createEClass(TDEFINITIONS);
		createEReference(tDefinitionsEClass, TDEFINITIONS__EXTENSIONS);
		createEReference(tDefinitionsEClass, TDEFINITIONS__IMPORT);
		createEReference(tDefinitionsEClass, TDEFINITIONS__TYPES);
		createEAttribute(tDefinitionsEClass, TDEFINITIONS__GROUP);
		createEReference(tDefinitionsEClass, TDEFINITIONS__SERVICE_TEMPLATE);
		createEReference(tDefinitionsEClass, TDEFINITIONS__NODE_TYPE);
		createEReference(tDefinitionsEClass, TDEFINITIONS__NODE_TYPE_IMPLEMENTATION);
		createEReference(tDefinitionsEClass, TDEFINITIONS__RELATIONSHIP_TYPE);
		createEReference(tDefinitionsEClass, TDEFINITIONS__RELATIONSHIP_TYPE_IMPLEMENTATION);
		createEReference(tDefinitionsEClass, TDEFINITIONS__REQUIREMENT_TYPE);
		createEReference(tDefinitionsEClass, TDEFINITIONS__CAPABILITY_TYPE);
		createEReference(tDefinitionsEClass, TDEFINITIONS__ARTIFACT_TYPE);
		createEReference(tDefinitionsEClass, TDEFINITIONS__ARTIFACT_TEMPLATE);
		createEReference(tDefinitionsEClass, TDEFINITIONS__POLICY_TYPE);
		createEReference(tDefinitionsEClass, TDEFINITIONS__POLICY_TEMPLATE);
		createEAttribute(tDefinitionsEClass, TDEFINITIONS__ID);
		createEAttribute(tDefinitionsEClass, TDEFINITIONS__NAME);
		createEAttribute(tDefinitionsEClass, TDEFINITIONS__TARGET_NAMESPACE);

		tDeploymentArtifactEClass = createEClass(TDEPLOYMENT_ARTIFACT);
		createEAttribute(tDeploymentArtifactEClass, TDEPLOYMENT_ARTIFACT__ARTIFACT_REF);
		createEAttribute(tDeploymentArtifactEClass, TDEPLOYMENT_ARTIFACT__ARTIFACT_TYPE);
		createEAttribute(tDeploymentArtifactEClass, TDEPLOYMENT_ARTIFACT__NAME);

		tDeploymentArtifactsEClass = createEClass(TDEPLOYMENT_ARTIFACTS);
		createEReference(tDeploymentArtifactsEClass, TDEPLOYMENT_ARTIFACTS__DEPLOYMENT_ARTIFACT);

		tDocumentationEClass = createEClass(TDOCUMENTATION);
		createEAttribute(tDocumentationEClass, TDOCUMENTATION__MIXED);
		createEAttribute(tDocumentationEClass, TDOCUMENTATION__ANY);
		createEAttribute(tDocumentationEClass, TDOCUMENTATION__LANG);
		createEAttribute(tDocumentationEClass, TDOCUMENTATION__SOURCE);

		tEntityTemplateEClass = createEClass(TENTITY_TEMPLATE);
		createEReference(tEntityTemplateEClass, TENTITY_TEMPLATE__PROPERTIES);
		createEReference(tEntityTemplateEClass, TENTITY_TEMPLATE__PROPERTY_CONSTRAINTS);
		createEAttribute(tEntityTemplateEClass, TENTITY_TEMPLATE__ID);
		createEAttribute(tEntityTemplateEClass, TENTITY_TEMPLATE__TYPE);

		tEntityTypeEClass = createEClass(TENTITY_TYPE);
		createEReference(tEntityTypeEClass, TENTITY_TYPE__TAGS);
		createEReference(tEntityTypeEClass, TENTITY_TYPE__DERIVED_FROM);
		createEReference(tEntityTypeEClass, TENTITY_TYPE__PROPERTIES_DEFINITION);
		createEAttribute(tEntityTypeEClass, TENTITY_TYPE__ABSTRACT);
		createEAttribute(tEntityTypeEClass, TENTITY_TYPE__FINAL);
		createEAttribute(tEntityTypeEClass, TENTITY_TYPE__NAME);
		createEAttribute(tEntityTypeEClass, TENTITY_TYPE__TARGET_NAMESPACE);

		tExportedInterfaceEClass = createEClass(TEXPORTED_INTERFACE);
		createEReference(tExportedInterfaceEClass, TEXPORTED_INTERFACE__OPERATION);
		createEAttribute(tExportedInterfaceEClass, TEXPORTED_INTERFACE__NAME);

		tExportedOperationEClass = createEClass(TEXPORTED_OPERATION);
		createEReference(tExportedOperationEClass, TEXPORTED_OPERATION__NODE_OPERATION);
		createEReference(tExportedOperationEClass, TEXPORTED_OPERATION__RELATIONSHIP_OPERATION);
		createEReference(tExportedOperationEClass, TEXPORTED_OPERATION__PLAN);
		createEAttribute(tExportedOperationEClass, TEXPORTED_OPERATION__NAME);

		tExtensibleElementsEClass = createEClass(TEXTENSIBLE_ELEMENTS);
		createEReference(tExtensibleElementsEClass, TEXTENSIBLE_ELEMENTS__DOCUMENTATION);
		createEAttribute(tExtensibleElementsEClass, TEXTENSIBLE_ELEMENTS__ANY);
		createEAttribute(tExtensibleElementsEClass, TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE);

		tExtensionEClass = createEClass(TEXTENSION);
		createEAttribute(tExtensionEClass, TEXTENSION__MUST_UNDERSTAND);
		createEAttribute(tExtensionEClass, TEXTENSION__NAMESPACE);

		tExtensionsEClass = createEClass(TEXTENSIONS);
		createEReference(tExtensionsEClass, TEXTENSIONS__EXTENSION);

		tImplementationArtifactEClass = createEClass(TIMPLEMENTATION_ARTIFACT);
		createEAttribute(tImplementationArtifactEClass, TIMPLEMENTATION_ARTIFACT__ARTIFACT_REF);
		createEAttribute(tImplementationArtifactEClass, TIMPLEMENTATION_ARTIFACT__ARTIFACT_TYPE);
		createEAttribute(tImplementationArtifactEClass, TIMPLEMENTATION_ARTIFACT__INTERFACE_NAME);
		createEAttribute(tImplementationArtifactEClass, TIMPLEMENTATION_ARTIFACT__OPERATION_NAME);

		tImplementationArtifactsEClass = createEClass(TIMPLEMENTATION_ARTIFACTS);
		createEReference(tImplementationArtifactsEClass, TIMPLEMENTATION_ARTIFACTS__IMPLEMENTATION_ARTIFACT);

		tImportEClass = createEClass(TIMPORT);
		createEAttribute(tImportEClass, TIMPORT__IMPORT_TYPE);
		createEAttribute(tImportEClass, TIMPORT__LOCATION);
		createEAttribute(tImportEClass, TIMPORT__NAMESPACE);

		tInterfaceEClass = createEClass(TINTERFACE);
		createEReference(tInterfaceEClass, TINTERFACE__OPERATION);
		createEAttribute(tInterfaceEClass, TINTERFACE__NAME);

		tNodeTemplateEClass = createEClass(TNODE_TEMPLATE);
		createEReference(tNodeTemplateEClass, TNODE_TEMPLATE__REQUIREMENTS);
		createEReference(tNodeTemplateEClass, TNODE_TEMPLATE__CAPABILITIES);
		createEReference(tNodeTemplateEClass, TNODE_TEMPLATE__POLICIES);
		createEReference(tNodeTemplateEClass, TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS);
		createEAttribute(tNodeTemplateEClass, TNODE_TEMPLATE__MAX_INSTANCES);
		createEAttribute(tNodeTemplateEClass, TNODE_TEMPLATE__MIN_INSTANCES);
		createEAttribute(tNodeTemplateEClass, TNODE_TEMPLATE__NAME);

		tNodeTypeEClass = createEClass(TNODE_TYPE);
		createEReference(tNodeTypeEClass, TNODE_TYPE__REQUIREMENT_DEFINITIONS);
		createEReference(tNodeTypeEClass, TNODE_TYPE__CAPABILITY_DEFINITIONS);
		createEReference(tNodeTypeEClass, TNODE_TYPE__INSTANCE_STATES);
		createEReference(tNodeTypeEClass, TNODE_TYPE__INTERFACES);

		tNodeTypeImplementationEClass = createEClass(TNODE_TYPE_IMPLEMENTATION);
		createEReference(tNodeTypeImplementationEClass, TNODE_TYPE_IMPLEMENTATION__TAGS);
		createEReference(tNodeTypeImplementationEClass, TNODE_TYPE_IMPLEMENTATION__DERIVED_FROM);
		createEReference(tNodeTypeImplementationEClass, TNODE_TYPE_IMPLEMENTATION__REQUIRED_CONTAINER_FEATURES);
		createEReference(tNodeTypeImplementationEClass, TNODE_TYPE_IMPLEMENTATION__IMPLEMENTATION_ARTIFACTS);
		createEReference(tNodeTypeImplementationEClass, TNODE_TYPE_IMPLEMENTATION__DEPLOYMENT_ARTIFACTS);
		createEAttribute(tNodeTypeImplementationEClass, TNODE_TYPE_IMPLEMENTATION__ABSTRACT);
		createEAttribute(tNodeTypeImplementationEClass, TNODE_TYPE_IMPLEMENTATION__FINAL);
		createEAttribute(tNodeTypeImplementationEClass, TNODE_TYPE_IMPLEMENTATION__NAME);
		createEAttribute(tNodeTypeImplementationEClass, TNODE_TYPE_IMPLEMENTATION__NODE_TYPE);
		createEAttribute(tNodeTypeImplementationEClass, TNODE_TYPE_IMPLEMENTATION__TARGET_NAMESPACE);

		tOperationEClass = createEClass(TOPERATION);
		createEReference(tOperationEClass, TOPERATION__INPUT_PARAMETERS);
		createEReference(tOperationEClass, TOPERATION__OUTPUT_PARAMETERS);
		createEAttribute(tOperationEClass, TOPERATION__NAME);

		tParameterEClass = createEClass(TPARAMETER);
		createEAttribute(tParameterEClass, TPARAMETER__NAME);
		createEAttribute(tParameterEClass, TPARAMETER__REQUIRED);
		createEAttribute(tParameterEClass, TPARAMETER__TYPE);

		tPlanEClass = createEClass(TPLAN);
		createEReference(tPlanEClass, TPLAN__PRECONDITION);
		createEReference(tPlanEClass, TPLAN__INPUT_PARAMETERS);
		createEReference(tPlanEClass, TPLAN__OUTPUT_PARAMETERS);
		createEReference(tPlanEClass, TPLAN__PLAN_MODEL);
		createEReference(tPlanEClass, TPLAN__PLAN_MODEL_REFERENCE);
		createEAttribute(tPlanEClass, TPLAN__ID);
		createEAttribute(tPlanEClass, TPLAN__NAME);
		createEAttribute(tPlanEClass, TPLAN__PLAN_LANGUAGE);
		createEAttribute(tPlanEClass, TPLAN__PLAN_TYPE);

		tPlansEClass = createEClass(TPLANS);
		createEReference(tPlansEClass, TPLANS__PLAN);
		createEAttribute(tPlansEClass, TPLANS__TARGET_NAMESPACE);

		tPolicyEClass = createEClass(TPOLICY);
		createEAttribute(tPolicyEClass, TPOLICY__NAME);
		createEAttribute(tPolicyEClass, TPOLICY__POLICY_REF);
		createEAttribute(tPolicyEClass, TPOLICY__POLICY_TYPE);

		tPolicyTemplateEClass = createEClass(TPOLICY_TEMPLATE);
		createEAttribute(tPolicyTemplateEClass, TPOLICY_TEMPLATE__NAME);

		tPolicyTypeEClass = createEClass(TPOLICY_TYPE);
		createEReference(tPolicyTypeEClass, TPOLICY_TYPE__APPLIES_TO);
		createEAttribute(tPolicyTypeEClass, TPOLICY_TYPE__POLICY_LANGUAGE);

		tPropertyConstraintEClass = createEClass(TPROPERTY_CONSTRAINT);
		createEAttribute(tPropertyConstraintEClass, TPROPERTY_CONSTRAINT__PROPERTY);

		tPropertyMappingEClass = createEClass(TPROPERTY_MAPPING);
		createEAttribute(tPropertyMappingEClass, TPROPERTY_MAPPING__SERVICE_TEMPLATE_PROPERTY_REF);
		createEAttribute(tPropertyMappingEClass, TPROPERTY_MAPPING__TARGET_OBJECT_REF);
		createEAttribute(tPropertyMappingEClass, TPROPERTY_MAPPING__TARGET_PROPERTY_REF);

		tRelationshipTemplateEClass = createEClass(TRELATIONSHIP_TEMPLATE);
		createEReference(tRelationshipTemplateEClass, TRELATIONSHIP_TEMPLATE__SOURCE_ELEMENT);
		createEReference(tRelationshipTemplateEClass, TRELATIONSHIP_TEMPLATE__TARGET_ELEMENT);
		createEReference(tRelationshipTemplateEClass, TRELATIONSHIP_TEMPLATE__RELATIONSHIP_CONSTRAINTS);
		createEAttribute(tRelationshipTemplateEClass, TRELATIONSHIP_TEMPLATE__NAME);

		tRelationshipTypeEClass = createEClass(TRELATIONSHIP_TYPE);
		createEReference(tRelationshipTypeEClass, TRELATIONSHIP_TYPE__INSTANCE_STATES);
		createEReference(tRelationshipTypeEClass, TRELATIONSHIP_TYPE__SOURCE_INTERFACES);
		createEReference(tRelationshipTypeEClass, TRELATIONSHIP_TYPE__TARGET_INTERFACES);
		createEReference(tRelationshipTypeEClass, TRELATIONSHIP_TYPE__VALID_SOURCE);
		createEReference(tRelationshipTypeEClass, TRELATIONSHIP_TYPE__VALID_TARGET);

		tRelationshipTypeImplementationEClass = createEClass(TRELATIONSHIP_TYPE_IMPLEMENTATION);
		createEReference(tRelationshipTypeImplementationEClass, TRELATIONSHIP_TYPE_IMPLEMENTATION__TAGS);
		createEReference(tRelationshipTypeImplementationEClass, TRELATIONSHIP_TYPE_IMPLEMENTATION__DERIVED_FROM);
		createEReference(tRelationshipTypeImplementationEClass, TRELATIONSHIP_TYPE_IMPLEMENTATION__REQUIRED_CONTAINER_FEATURES);
		createEReference(tRelationshipTypeImplementationEClass, TRELATIONSHIP_TYPE_IMPLEMENTATION__IMPLEMENTATION_ARTIFACTS);
		createEAttribute(tRelationshipTypeImplementationEClass, TRELATIONSHIP_TYPE_IMPLEMENTATION__ABSTRACT);
		createEAttribute(tRelationshipTypeImplementationEClass, TRELATIONSHIP_TYPE_IMPLEMENTATION__FINAL);
		createEAttribute(tRelationshipTypeImplementationEClass, TRELATIONSHIP_TYPE_IMPLEMENTATION__NAME);
		createEAttribute(tRelationshipTypeImplementationEClass, TRELATIONSHIP_TYPE_IMPLEMENTATION__RELATIONSHIP_TYPE);
		createEAttribute(tRelationshipTypeImplementationEClass, TRELATIONSHIP_TYPE_IMPLEMENTATION__TARGET_NAMESPACE);

		tRequiredContainerFeatureEClass = createEClass(TREQUIRED_CONTAINER_FEATURE);
		createEAttribute(tRequiredContainerFeatureEClass, TREQUIRED_CONTAINER_FEATURE__FEATURE);

		tRequiredContainerFeaturesEClass = createEClass(TREQUIRED_CONTAINER_FEATURES);
		createEReference(tRequiredContainerFeaturesEClass, TREQUIRED_CONTAINER_FEATURES__REQUIRED_CONTAINER_FEATURE);

		tRequirementEClass = createEClass(TREQUIREMENT);
		createEAttribute(tRequirementEClass, TREQUIREMENT__NAME);

		tRequirementDefinitionEClass = createEClass(TREQUIREMENT_DEFINITION);
		createEReference(tRequirementDefinitionEClass, TREQUIREMENT_DEFINITION__CONSTRAINTS);
		createEAttribute(tRequirementDefinitionEClass, TREQUIREMENT_DEFINITION__LOWER_BOUND);
		createEAttribute(tRequirementDefinitionEClass, TREQUIREMENT_DEFINITION__NAME);
		createEAttribute(tRequirementDefinitionEClass, TREQUIREMENT_DEFINITION__REQUIREMENT_TYPE);
		createEAttribute(tRequirementDefinitionEClass, TREQUIREMENT_DEFINITION__UPPER_BOUND);

		tRequirementRefEClass = createEClass(TREQUIREMENT_REF);
		createEAttribute(tRequirementRefEClass, TREQUIREMENT_REF__NAME);
		createEAttribute(tRequirementRefEClass, TREQUIREMENT_REF__REF);

		tRequirementTypeEClass = createEClass(TREQUIREMENT_TYPE);
		createEAttribute(tRequirementTypeEClass, TREQUIREMENT_TYPE__REQUIRED_CAPABILITY_TYPE);

		tServiceTemplateEClass = createEClass(TSERVICE_TEMPLATE);
		createEReference(tServiceTemplateEClass, TSERVICE_TEMPLATE__TAGS);
		createEReference(tServiceTemplateEClass, TSERVICE_TEMPLATE__BOUNDARY_DEFINITIONS);
		createEReference(tServiceTemplateEClass, TSERVICE_TEMPLATE__TOPOLOGY_TEMPLATE);
		createEReference(tServiceTemplateEClass, TSERVICE_TEMPLATE__PLANS);
		createEAttribute(tServiceTemplateEClass, TSERVICE_TEMPLATE__ID);
		createEAttribute(tServiceTemplateEClass, TSERVICE_TEMPLATE__NAME);
		createEAttribute(tServiceTemplateEClass, TSERVICE_TEMPLATE__SUBSTITUTABLE_NODE_TYPE);
		createEAttribute(tServiceTemplateEClass, TSERVICE_TEMPLATE__TARGET_NAMESPACE);

		tTagEClass = createEClass(TTAG);
		createEAttribute(tTagEClass, TTAG__NAME);
		createEAttribute(tTagEClass, TTAG__VALUE);

		tTagsEClass = createEClass(TTAGS);
		createEReference(tTagsEClass, TTAGS__TAG);

		tTopologyElementInstanceStatesEClass = createEClass(TTOPOLOGY_ELEMENT_INSTANCE_STATES);
		createEReference(tTopologyElementInstanceStatesEClass, TTOPOLOGY_ELEMENT_INSTANCE_STATES__INSTANCE_STATE);

		tTopologyTemplateEClass = createEClass(TTOPOLOGY_TEMPLATE);
		createEAttribute(tTopologyTemplateEClass, TTOPOLOGY_TEMPLATE__GROUP);
		createEReference(tTopologyTemplateEClass, TTOPOLOGY_TEMPLATE__NODE_TEMPLATE);
		createEReference(tTopologyTemplateEClass, TTOPOLOGY_TEMPLATE__RELATIONSHIP_TEMPLATE);

		typesTypeEClass = createEClass(TYPES_TYPE);
		createEAttribute(typesTypeEClass, TYPES_TYPE__ANY);

		validSourceTypeEClass = createEClass(VALID_SOURCE_TYPE);
		createEAttribute(validSourceTypeEClass, VALID_SOURCE_TYPE__TYPE_REF);

		validTargetTypeEClass = createEClass(VALID_TARGET_TYPE);
		createEAttribute(validTargetTypeEClass, VALID_TARGET_TYPE__TYPE_REF);

		// Create enums
		maxInstancesTypeMember1EEnum = createEEnum(MAX_INSTANCES_TYPE_MEMBER1);
		tBooleanEEnum = createEEnum(TBOOLEAN);
		upperBoundTypeMember1EEnum = createEEnum(UPPER_BOUND_TYPE_MEMBER1);
		upperBoundTypeMember11EEnum = createEEnum(UPPER_BOUND_TYPE_MEMBER11);

		// Create data types
		importedURIEDataType = createEDataType(IMPORTED_URI);
		maxInstancesTypeEDataType = createEDataType(MAX_INSTANCES_TYPE);
		maxInstancesTypeMember0EDataType = createEDataType(MAX_INSTANCES_TYPE_MEMBER0);
		maxInstancesTypeMember1ObjectEDataType = createEDataType(MAX_INSTANCES_TYPE_MEMBER1_OBJECT);
		tBooleanObjectEDataType = createEDataType(TBOOLEAN_OBJECT);
		upperBoundTypeEDataType = createEDataType(UPPER_BOUND_TYPE);
		upperBoundType1EDataType = createEDataType(UPPER_BOUND_TYPE1);
		upperBoundTypeMember0EDataType = createEDataType(UPPER_BOUND_TYPE_MEMBER0);
		upperBoundTypeMember01EDataType = createEDataType(UPPER_BOUND_TYPE_MEMBER01);
		upperBoundTypeMember1ObjectEDataType = createEDataType(UPPER_BOUND_TYPE_MEMBER1_OBJECT);
		upperBoundTypeMember1Object1EDataType = createEDataType(UPPER_BOUND_TYPE_MEMBER1_OBJECT1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		XMLNamespacePackage theXMLNamespacePackage = (XMLNamespacePackage)EPackage.Registry.INSTANCE.getEPackage(XMLNamespacePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		definitionsTypeEClass.getESuperTypes().add(this.getTDefinitions());
		implementationArtifactTypeEClass.getESuperTypes().add(this.getTImplementationArtifact());
		tArtifactTemplateEClass.getESuperTypes().add(this.getTEntityTemplate());
		tArtifactTypeEClass.getESuperTypes().add(this.getTEntityType());
		tCapabilityEClass.getESuperTypes().add(this.getTEntityTemplate());
		tCapabilityDefinitionEClass.getESuperTypes().add(this.getTExtensibleElements());
		tCapabilityTypeEClass.getESuperTypes().add(this.getTEntityType());
		tDefinitionsEClass.getESuperTypes().add(this.getTExtensibleElements());
		tDeploymentArtifactEClass.getESuperTypes().add(this.getTExtensibleElements());
		tEntityTemplateEClass.getESuperTypes().add(this.getTExtensibleElements());
		tEntityTypeEClass.getESuperTypes().add(this.getTExtensibleElements());
		tExtensionEClass.getESuperTypes().add(this.getTExtensibleElements());
		tExtensionsEClass.getESuperTypes().add(this.getTExtensibleElements());
		tImplementationArtifactEClass.getESuperTypes().add(this.getTExtensibleElements());
		tImportEClass.getESuperTypes().add(this.getTExtensibleElements());
		tNodeTemplateEClass.getESuperTypes().add(this.getTEntityTemplate());
		tNodeTypeEClass.getESuperTypes().add(this.getTEntityType());
		tNodeTypeImplementationEClass.getESuperTypes().add(this.getTExtensibleElements());
		tOperationEClass.getESuperTypes().add(this.getTExtensibleElements());
		tPlanEClass.getESuperTypes().add(this.getTExtensibleElements());
		tPolicyEClass.getESuperTypes().add(this.getTExtensibleElements());
		tPolicyTemplateEClass.getESuperTypes().add(this.getTEntityTemplate());
		tPolicyTypeEClass.getESuperTypes().add(this.getTEntityType());
		tPropertyConstraintEClass.getESuperTypes().add(this.getTConstraint());
		tRelationshipTemplateEClass.getESuperTypes().add(this.getTEntityTemplate());
		tRelationshipTypeEClass.getESuperTypes().add(this.getTEntityType());
		tRelationshipTypeImplementationEClass.getESuperTypes().add(this.getTExtensibleElements());
		tRequirementEClass.getESuperTypes().add(this.getTEntityTemplate());
		tRequirementDefinitionEClass.getESuperTypes().add(this.getTExtensibleElements());
		tRequirementTypeEClass.getESuperTypes().add(this.getTEntityType());
		tServiceTemplateEClass.getESuperTypes().add(this.getTExtensibleElements());
		tTopologyTemplateEClass.getESuperTypes().add(this.getTExtensibleElements());

		// Initialize classes, features, and operations; add parameters
		initEClass(artifactReferencesTypeEClass, ArtifactReferencesType.class, "ArtifactReferencesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArtifactReferencesType_ArtifactReference(), this.getTArtifactReference(), null, "artifactReference", null, 1, -1, ArtifactReferencesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(capabilitiesTypeEClass, CapabilitiesType.class, "CapabilitiesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCapabilitiesType_Capability(), this.getTCapability(), null, "capability", null, 1, -1, CapabilitiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(capabilitiesType1EClass, CapabilitiesType1.class, "CapabilitiesType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCapabilitiesType1_Capability(), this.getTCapabilityRef(), null, "capability", null, 1, -1, CapabilitiesType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(capabilityDefinitionsTypeEClass, CapabilityDefinitionsType.class, "CapabilityDefinitionsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCapabilityDefinitionsType_CapabilityDefinition(), this.getTCapabilityDefinition(), null, "capabilityDefinition", null, 1, -1, CapabilityDefinitionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintsTypeEClass, ConstraintsType.class, "ConstraintsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraintsType_Constraint(), this.getTConstraint(), null, "constraint", null, 1, -1, ConstraintsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintsType1EClass, ConstraintsType1.class, "ConstraintsType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraintsType1_Constraint(), this.getTConstraint(), null, "constraint", null, 1, -1, ConstraintsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(definitionsTypeEClass, DefinitionsType.class, "DefinitionsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(derivedFromTypeEClass, DerivedFromType.class, "DerivedFromType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDerivedFromType_RelationshipTypeImplementationRef(), theXMLTypePackage.getQName(), "relationshipTypeImplementationRef", null, 1, 1, DerivedFromType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(derivedFromType1EClass, DerivedFromType1.class, "DerivedFromType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDerivedFromType1_NodeTypeImplementationRef(), theXMLTypePackage.getQName(), "nodeTypeImplementationRef", null, 1, 1, DerivedFromType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(derivedFromType2EClass, DerivedFromType2.class, "DerivedFromType2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDerivedFromType2_TypeRef(), theXMLTypePackage.getQName(), "typeRef", null, 1, 1, DerivedFromType2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Definitions(), this.getDefinitionsType(), null, "definitions", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Documentation(), this.getTDocumentation(), null, "documentation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(excludeTypeEClass, ExcludeType.class, "ExcludeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExcludeType_Pattern(), theXMLTypePackage.getString(), "pattern", null, 1, 1, ExcludeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extensionsTypeEClass, ExtensionsType.class, "ExtensionsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensionsType_Extension(), this.getTExtension(), null, "extension", null, 1, -1, ExtensionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implementationArtifactTypeEClass, ImplementationArtifactType.class, "ImplementationArtifactType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(includeTypeEClass, IncludeType.class, "IncludeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIncludeType_Pattern(), theXMLTypePackage.getString(), "pattern", null, 1, 1, IncludeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputParametersTypeEClass, InputParametersType.class, "InputParametersType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputParametersType_InputParameter(), this.getTParameter(), null, "inputParameter", null, 1, -1, InputParametersType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputParametersType1EClass, InputParametersType1.class, "InputParametersType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputParametersType1_InputParameter(), this.getTParameter(), null, "inputParameter", null, 1, -1, InputParametersType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instanceStateTypeEClass, InstanceStateType.class, "InstanceStateType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInstanceStateType_State(), theXMLTypePackage.getAnyURI(), "state", null, 1, 1, InstanceStateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfacesTypeEClass, InterfacesType.class, "InterfacesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfacesType_Interface(), this.getTInterface(), null, "interface", null, 1, -1, InterfacesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfacesType1EClass, InterfacesType1.class, "InterfacesType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfacesType1_Interface(), this.getTExportedInterface(), null, "interface", null, 1, -1, InterfacesType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeOperationTypeEClass, NodeOperationType.class, "NodeOperationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNodeOperationType_InterfaceName(), theXMLTypePackage.getAnyURI(), "interfaceName", null, 1, 1, NodeOperationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeOperationType_NodeRef(), theXMLTypePackage.getIDREF(), "nodeRef", null, 1, 1, NodeOperationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeOperationType_OperationName(), theXMLTypePackage.getNCName(), "operationName", null, 1, 1, NodeOperationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeTypeReferenceTypeEClass, NodeTypeReferenceType.class, "NodeTypeReferenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNodeTypeReferenceType_TypeRef(), theXMLTypePackage.getQName(), "typeRef", null, 1, 1, NodeTypeReferenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputParametersTypeEClass, OutputParametersType.class, "OutputParametersType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputParametersType_OutputParameter(), this.getTParameter(), null, "outputParameter", null, 1, -1, OutputParametersType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputParametersType1EClass, OutputParametersType1.class, "OutputParametersType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputParametersType1_OutputParameter(), this.getTParameter(), null, "outputParameter", null, 1, -1, OutputParametersType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(planModelReferenceTypeEClass, PlanModelReferenceType.class, "PlanModelReferenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlanModelReferenceType_Reference(), theXMLTypePackage.getAnyURI(), "reference", null, 1, 1, PlanModelReferenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(planModelTypeEClass, PlanModelType.class, "PlanModelType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlanModelType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 1, 1, PlanModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(planTypeEClass, PlanType.class, "PlanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlanType_PlanRef(), theXMLTypePackage.getIDREF(), "planRef", null, 1, 1, PlanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(policiesTypeEClass, PoliciesType.class, "PoliciesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPoliciesType_Policy(), this.getTPolicy(), null, "policy", null, 1, -1, PoliciesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(policiesType1EClass, PoliciesType1.class, "PoliciesType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPoliciesType1_Policy(), this.getTPolicy(), null, "policy", null, 1, -1, PoliciesType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertiesDefinitionTypeEClass, PropertiesDefinitionType.class, "PropertiesDefinitionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertiesDefinitionType_Element(), theXMLTypePackage.getQName(), "element", null, 0, 1, PropertiesDefinitionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertiesDefinitionType_Type(), theXMLTypePackage.getQName(), "type", null, 0, 1, PropertiesDefinitionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertiesTypeEClass, PropertiesType.class, "PropertiesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertiesType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 1, 1, PropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertiesType1EClass, PropertiesType1.class, "PropertiesType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertiesType1_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 1, 1, PropertiesType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertiesType1_PropertyMappings(), this.getPropertyMappingsType(), null, "propertyMappings", null, 0, 1, PropertiesType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyConstraintsTypeEClass, PropertyConstraintsType.class, "PropertyConstraintsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyConstraintsType_PropertyConstraint(), this.getTPropertyConstraint(), null, "propertyConstraint", null, 1, -1, PropertyConstraintsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyConstraintsType1EClass, PropertyConstraintsType1.class, "PropertyConstraintsType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyConstraintsType1_PropertyConstraint(), this.getTPropertyConstraint(), null, "propertyConstraint", null, 1, -1, PropertyConstraintsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyMappingsTypeEClass, PropertyMappingsType.class, "PropertyMappingsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyMappingsType_PropertyMapping(), this.getTPropertyMapping(), null, "propertyMapping", null, 1, -1, PropertyMappingsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationshipConstraintsTypeEClass, RelationshipConstraintsType.class, "RelationshipConstraintsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationshipConstraintsType_RelationshipConstraint(), this.getRelationshipConstraintType(), null, "relationshipConstraint", null, 1, -1, RelationshipConstraintsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationshipConstraintTypeEClass, RelationshipConstraintType.class, "RelationshipConstraintType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationshipConstraintType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, 1, RelationshipConstraintType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationshipConstraintType_ConstraintType(), theXMLTypePackage.getAnyURI(), "constraintType", null, 1, 1, RelationshipConstraintType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationshipOperationTypeEClass, RelationshipOperationType.class, "RelationshipOperationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationshipOperationType_InterfaceName(), theXMLTypePackage.getAnyURI(), "interfaceName", null, 1, 1, RelationshipOperationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationshipOperationType_OperationName(), theXMLTypePackage.getNCName(), "operationName", null, 1, 1, RelationshipOperationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationshipOperationType_RelationshipRef(), theXMLTypePackage.getIDREF(), "relationshipRef", null, 1, 1, RelationshipOperationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementDefinitionsTypeEClass, RequirementDefinitionsType.class, "RequirementDefinitionsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequirementDefinitionsType_RequirementDefinition(), this.getTRequirementDefinition(), null, "requirementDefinition", null, 1, -1, RequirementDefinitionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementsTypeEClass, RequirementsType.class, "RequirementsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequirementsType_Requirement(), this.getTRequirement(), null, "requirement", null, 1, -1, RequirementsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementsType1EClass, RequirementsType1.class, "RequirementsType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequirementsType1_Requirement(), this.getTRequirementRef(), null, "requirement", null, 1, -1, RequirementsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceElementTypeEClass, SourceElementType.class, "SourceElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceElementType_Ref(), theXMLTypePackage.getIDREF(), "ref", null, 1, 1, SourceElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceInterfacesTypeEClass, SourceInterfacesType.class, "SourceInterfacesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceInterfacesType_Interface(), this.getTInterface(), null, "interface", null, 1, -1, SourceInterfacesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tAppliesToEClass, TAppliesTo.class, "TAppliesTo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTAppliesTo_NodeTypeReference(), this.getNodeTypeReferenceType(), null, "nodeTypeReference", null, 1, -1, TAppliesTo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetElementTypeEClass, TargetElementType.class, "TargetElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTargetElementType_Ref(), theXMLTypePackage.getIDREF(), "ref", null, 1, 1, TargetElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetInterfacesTypeEClass, TargetInterfacesType.class, "TargetInterfacesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetInterfacesType_Interface(), this.getTInterface(), null, "interface", null, 1, -1, TargetInterfacesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tArtifactReferenceEClass, TArtifactReference.class, "TArtifactReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTArtifactReference_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, TArtifactReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTArtifactReference_Include(), this.getIncludeType(), null, "include", null, 0, -1, TArtifactReference.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTArtifactReference_Exclude(), this.getExcludeType(), null, "exclude", null, 0, -1, TArtifactReference.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTArtifactReference_Reference(), theXMLTypePackage.getAnyURI(), "reference", null, 1, 1, TArtifactReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tArtifactTemplateEClass, TArtifactTemplate.class, "TArtifactTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTArtifactTemplate_ArtifactReferences(), this.getArtifactReferencesType(), null, "artifactReferences", null, 0, 1, TArtifactTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTArtifactTemplate_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TArtifactTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tArtifactTypeEClass, TArtifactType.class, "TArtifactType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tBoundaryDefinitionsEClass, TBoundaryDefinitions.class, "TBoundaryDefinitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTBoundaryDefinitions_Properties(), this.getPropertiesType1(), null, "properties", null, 0, 1, TBoundaryDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTBoundaryDefinitions_PropertyConstraints(), this.getPropertyConstraintsType1(), null, "propertyConstraints", null, 0, 1, TBoundaryDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTBoundaryDefinitions_Requirements(), this.getRequirementsType1(), null, "requirements", null, 0, 1, TBoundaryDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTBoundaryDefinitions_Capabilities(), this.getCapabilitiesType1(), null, "capabilities", null, 0, 1, TBoundaryDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTBoundaryDefinitions_Policies(), this.getPoliciesType1(), null, "policies", null, 0, 1, TBoundaryDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTBoundaryDefinitions_Interfaces(), this.getInterfacesType1(), null, "interfaces", null, 0, 1, TBoundaryDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCapabilityEClass, TCapability.class, "TCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCapability_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, TCapability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCapabilityDefinitionEClass, TCapabilityDefinition.class, "TCapabilityDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCapabilityDefinition_Constraints(), this.getConstraintsType(), null, "constraints", null, 0, 1, TCapabilityDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCapabilityDefinition_CapabilityType(), theXMLTypePackage.getQName(), "capabilityType", null, 1, 1, TCapabilityDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCapabilityDefinition_LowerBound(), theXMLTypePackage.getInt(), "lowerBound", "1", 0, 1, TCapabilityDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCapabilityDefinition_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, TCapabilityDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCapabilityDefinition_UpperBound(), this.getUpperBoundType(), "upperBound", "1", 0, 1, TCapabilityDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCapabilityRefEClass, TCapabilityRef.class, "TCapabilityRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCapabilityRef_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TCapabilityRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCapabilityRef_Ref(), theXMLTypePackage.getIDREF(), "ref", null, 1, 1, TCapabilityRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCapabilityTypeEClass, TCapabilityType.class, "TCapabilityType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tConditionEClass, TCondition.class, "TCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCondition_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCondition_ExpressionLanguage(), theXMLTypePackage.getAnyURI(), "expressionLanguage", null, 1, 1, TCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tConstraintEClass, TConstraint.class, "TConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTConstraint_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 1, 1, TConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTConstraint_ConstraintType(), theXMLTypePackage.getAnyURI(), "constraintType", null, 1, 1, TConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDefinitionsEClass, TDefinitions.class, "TDefinitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTDefinitions_Extensions(), this.getExtensionsType(), null, "extensions", null, 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_Import(), this.getTImport(), null, "import", null, 0, -1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_Types(), this.getTypesType(), null, "types", null, 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDefinitions_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_ServiceTemplate(), this.getTServiceTemplate(), null, "serviceTemplate", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_NodeType(), this.getTNodeType(), null, "nodeType", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_NodeTypeImplementation(), this.getTNodeTypeImplementation(), null, "nodeTypeImplementation", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_RelationshipType(), this.getTRelationshipType(), null, "relationshipType", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_RelationshipTypeImplementation(), this.getTRelationshipTypeImplementation(), null, "relationshipTypeImplementation", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_RequirementType(), this.getTRequirementType(), null, "requirementType", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_CapabilityType(), this.getTCapabilityType(), null, "capabilityType", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_ArtifactType(), this.getTArtifactType(), null, "artifactType", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_ArtifactTemplate(), this.getTArtifactTemplate(), null, "artifactTemplate", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_PolicyType(), this.getTPolicyType(), null, "policyType", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_PolicyTemplate(), this.getTPolicyTemplate(), null, "policyTemplate", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDefinitions_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDefinitions_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDefinitions_TargetNamespace(), theXMLTypePackage.getAnyURI(), "targetNamespace", null, 1, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDeploymentArtifactEClass, TDeploymentArtifact.class, "TDeploymentArtifact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTDeploymentArtifact_ArtifactRef(), theXMLTypePackage.getQName(), "artifactRef", null, 0, 1, TDeploymentArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDeploymentArtifact_ArtifactType(), theXMLTypePackage.getQName(), "artifactType", null, 1, 1, TDeploymentArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDeploymentArtifact_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, TDeploymentArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDeploymentArtifactsEClass, TDeploymentArtifacts.class, "TDeploymentArtifacts", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTDeploymentArtifacts_DeploymentArtifact(), this.getTDeploymentArtifact(), null, "deploymentArtifact", null, 1, -1, TDeploymentArtifacts.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDocumentationEClass, TDocumentation.class, "TDocumentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTDocumentation_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, TDocumentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDocumentation_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TDocumentation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDocumentation_Lang(), theXMLNamespacePackage.getLangType(), "lang", null, 0, 1, TDocumentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDocumentation_Source(), theXMLTypePackage.getAnyURI(), "source", null, 0, 1, TDocumentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tEntityTemplateEClass, TEntityTemplate.class, "TEntityTemplate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTEntityTemplate_Properties(), this.getPropertiesType(), null, "properties", null, 0, 1, TEntityTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTEntityTemplate_PropertyConstraints(), this.getPropertyConstraintsType(), null, "propertyConstraints", null, 0, 1, TEntityTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTEntityTemplate_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, TEntityTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTEntityTemplate_Type(), theXMLTypePackage.getQName(), "type", null, 1, 1, TEntityTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tEntityTypeEClass, TEntityType.class, "TEntityType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTEntityType_Tags(), this.getTTags(), null, "tags", null, 0, 1, TEntityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTEntityType_DerivedFrom(), this.getDerivedFromType2(), null, "derivedFrom", null, 0, 1, TEntityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTEntityType_PropertiesDefinition(), this.getPropertiesDefinitionType(), null, "propertiesDefinition", null, 0, 1, TEntityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTEntityType_Abstract(), this.getTBoolean(), "abstract", "no", 0, 1, TEntityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTEntityType_Final(), this.getTBoolean(), "final", "no", 0, 1, TEntityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTEntityType_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TEntityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTEntityType_TargetNamespace(), theXMLTypePackage.getAnyURI(), "targetNamespace", null, 0, 1, TEntityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExportedInterfaceEClass, TExportedInterface.class, "TExportedInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTExportedInterface_Operation(), this.getTExportedOperation(), null, "operation", null, 1, -1, TExportedInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExportedInterface_Name(), theXMLTypePackage.getAnyURI(), "name", null, 1, 1, TExportedInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExportedOperationEClass, TExportedOperation.class, "TExportedOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTExportedOperation_NodeOperation(), this.getNodeOperationType(), null, "nodeOperation", null, 0, 1, TExportedOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTExportedOperation_RelationshipOperation(), this.getRelationshipOperationType(), null, "relationshipOperation", null, 0, 1, TExportedOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTExportedOperation_Plan(), this.getPlanType(), null, "plan", null, 0, 1, TExportedOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExportedOperation_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TExportedOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExtensibleElementsEClass, TExtensibleElements.class, "TExtensibleElements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTExtensibleElements_Documentation(), this.getTDocumentation(), null, "documentation", null, 0, -1, TExtensibleElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExtensibleElements_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TExtensibleElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExtensibleElements_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TExtensibleElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExtensionEClass, TExtension.class, "TExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTExtension_MustUnderstand(), this.getTBoolean(), "mustUnderstand", "yes", 0, 1, TExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExtension_Namespace(), theXMLTypePackage.getAnyURI(), "namespace", null, 1, 1, TExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExtensionsEClass, TExtensions.class, "TExtensions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTExtensions_Extension(), this.getTExtension(), null, "extension", null, 1, -1, TExtensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tImplementationArtifactEClass, TImplementationArtifact.class, "TImplementationArtifact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTImplementationArtifact_ArtifactRef(), theXMLTypePackage.getQName(), "artifactRef", null, 0, 1, TImplementationArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTImplementationArtifact_ArtifactType(), theXMLTypePackage.getQName(), "artifactType", null, 1, 1, TImplementationArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTImplementationArtifact_InterfaceName(), theXMLTypePackage.getAnyURI(), "interfaceName", null, 0, 1, TImplementationArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTImplementationArtifact_OperationName(), theXMLTypePackage.getNCName(), "operationName", null, 0, 1, TImplementationArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tImplementationArtifactsEClass, TImplementationArtifacts.class, "TImplementationArtifacts", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTImplementationArtifacts_ImplementationArtifact(), this.getImplementationArtifactType(), null, "implementationArtifact", null, 1, -1, TImplementationArtifacts.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tImportEClass, TImport.class, "TImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTImport_ImportType(), this.getImportedURI(), "importType", null, 1, 1, TImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTImport_Location(), theXMLTypePackage.getAnyURI(), "location", null, 0, 1, TImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTImport_Namespace(), theXMLTypePackage.getAnyURI(), "namespace", null, 0, 1, TImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tInterfaceEClass, TInterface.class, "TInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTInterface_Operation(), this.getTOperation(), null, "operation", null, 1, -1, TInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTInterface_Name(), theXMLTypePackage.getAnyURI(), "name", null, 1, 1, TInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tNodeTemplateEClass, TNodeTemplate.class, "TNodeTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTNodeTemplate_Requirements(), this.getRequirementsType(), null, "requirements", null, 0, 1, TNodeTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNodeTemplate_Capabilities(), this.getCapabilitiesType(), null, "capabilities", null, 0, 1, TNodeTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNodeTemplate_Policies(), this.getPoliciesType(), null, "policies", null, 0, 1, TNodeTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNodeTemplate_DeploymentArtifacts(), this.getTDeploymentArtifacts(), null, "deploymentArtifacts", null, 0, 1, TNodeTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTemplate_MaxInstances(), this.getMaxInstancesType(), "maxInstances", "1", 0, 1, TNodeTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTemplate_MinInstances(), theXMLTypePackage.getInt(), "minInstances", "1", 0, 1, TNodeTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTemplate_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TNodeTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tNodeTypeEClass, TNodeType.class, "TNodeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTNodeType_RequirementDefinitions(), this.getRequirementDefinitionsType(), null, "requirementDefinitions", null, 0, 1, TNodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNodeType_CapabilityDefinitions(), this.getCapabilityDefinitionsType(), null, "capabilityDefinitions", null, 0, 1, TNodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNodeType_InstanceStates(), this.getTTopologyElementInstanceStates(), null, "instanceStates", null, 0, 1, TNodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNodeType_Interfaces(), this.getInterfacesType(), null, "interfaces", null, 0, 1, TNodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tNodeTypeImplementationEClass, TNodeTypeImplementation.class, "TNodeTypeImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTNodeTypeImplementation_Tags(), this.getTTags(), null, "tags", null, 0, 1, TNodeTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNodeTypeImplementation_DerivedFrom(), this.getDerivedFromType1(), null, "derivedFrom", null, 0, 1, TNodeTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNodeTypeImplementation_RequiredContainerFeatures(), this.getTRequiredContainerFeatures(), null, "requiredContainerFeatures", null, 0, 1, TNodeTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNodeTypeImplementation_ImplementationArtifacts(), this.getTImplementationArtifacts(), null, "implementationArtifacts", null, 0, 1, TNodeTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNodeTypeImplementation_DeploymentArtifacts(), this.getTDeploymentArtifacts(), null, "deploymentArtifacts", null, 0, 1, TNodeTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTypeImplementation_Abstract(), this.getTBoolean(), "abstract", "no", 0, 1, TNodeTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTypeImplementation_Final(), this.getTBoolean(), "final", "no", 0, 1, TNodeTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTypeImplementation_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TNodeTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTypeImplementation_NodeType(), theXMLTypePackage.getQName(), "nodeType", null, 1, 1, TNodeTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTypeImplementation_TargetNamespace(), theXMLTypePackage.getAnyURI(), "targetNamespace", null, 0, 1, TNodeTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tOperationEClass, TOperation.class, "TOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTOperation_InputParameters(), this.getInputParametersType(), null, "inputParameters", null, 0, 1, TOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOperation_OutputParameters(), this.getOutputParametersType(), null, "outputParameters", null, 0, 1, TOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTOperation_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tParameterEClass, TParameter.class, "TParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTParameter_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, TParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTParameter_Required(), this.getTBoolean(), "required", "yes", 0, 1, TParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTParameter_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, TParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPlanEClass, TPlan.class, "TPlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPlan_Precondition(), this.getTCondition(), null, "precondition", null, 0, 1, TPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPlan_InputParameters(), this.getInputParametersType1(), null, "inputParameters", null, 0, 1, TPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPlan_OutputParameters(), this.getOutputParametersType1(), null, "outputParameters", null, 0, 1, TPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPlan_PlanModel(), this.getPlanModelType(), null, "planModel", null, 0, 1, TPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPlan_PlanModelReference(), this.getPlanModelReferenceType(), null, "planModelReference", null, 0, 1, TPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPlan_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, TPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPlan_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPlan_PlanLanguage(), theXMLTypePackage.getAnyURI(), "planLanguage", null, 1, 1, TPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPlan_PlanType(), theXMLTypePackage.getAnyURI(), "planType", null, 1, 1, TPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPlansEClass, TPlans.class, "TPlans", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPlans_Plan(), this.getTPlan(), null, "plan", null, 1, -1, TPlans.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPlans_TargetNamespace(), theXMLTypePackage.getAnyURI(), "targetNamespace", null, 0, 1, TPlans.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPolicyEClass, TPolicy.class, "TPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTPolicy_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPolicy_PolicyRef(), theXMLTypePackage.getQName(), "policyRef", null, 0, 1, TPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPolicy_PolicyType(), theXMLTypePackage.getQName(), "policyType", null, 1, 1, TPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPolicyTemplateEClass, TPolicyTemplate.class, "TPolicyTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTPolicyTemplate_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TPolicyTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPolicyTypeEClass, TPolicyType.class, "TPolicyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPolicyType_AppliesTo(), this.getTAppliesTo(), null, "appliesTo", null, 0, 1, TPolicyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPolicyType_PolicyLanguage(), theXMLTypePackage.getAnyURI(), "policyLanguage", null, 0, 1, TPolicyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPropertyConstraintEClass, TPropertyConstraint.class, "TPropertyConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTPropertyConstraint_Property(), theXMLTypePackage.getString(), "property", null, 1, 1, TPropertyConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPropertyMappingEClass, TPropertyMapping.class, "TPropertyMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTPropertyMapping_ServiceTemplatePropertyRef(), theXMLTypePackage.getString(), "serviceTemplatePropertyRef", null, 1, 1, TPropertyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPropertyMapping_TargetObjectRef(), theXMLTypePackage.getIDREF(), "targetObjectRef", null, 1, 1, TPropertyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPropertyMapping_TargetPropertyRef(), theXMLTypePackage.getString(), "targetPropertyRef", null, 1, 1, TPropertyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRelationshipTemplateEClass, TRelationshipTemplate.class, "TRelationshipTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTRelationshipTemplate_SourceElement(), this.getSourceElementType(), null, "sourceElement", null, 1, 1, TRelationshipTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationshipTemplate_TargetElement(), this.getTargetElementType(), null, "targetElement", null, 1, 1, TRelationshipTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationshipTemplate_RelationshipConstraints(), this.getRelationshipConstraintsType(), null, "relationshipConstraints", null, 0, 1, TRelationshipTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTRelationshipTemplate_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TRelationshipTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRelationshipTypeEClass, TRelationshipType.class, "TRelationshipType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTRelationshipType_InstanceStates(), this.getTTopologyElementInstanceStates(), null, "instanceStates", null, 0, 1, TRelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationshipType_SourceInterfaces(), this.getSourceInterfacesType(), null, "sourceInterfaces", null, 0, 1, TRelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationshipType_TargetInterfaces(), this.getTargetInterfacesType(), null, "targetInterfaces", null, 0, 1, TRelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationshipType_ValidSource(), this.getValidSourceType(), null, "validSource", null, 0, 1, TRelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationshipType_ValidTarget(), this.getValidTargetType(), null, "validTarget", null, 0, 1, TRelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRelationshipTypeImplementationEClass, TRelationshipTypeImplementation.class, "TRelationshipTypeImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTRelationshipTypeImplementation_Tags(), this.getTTags(), null, "tags", null, 0, 1, TRelationshipTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationshipTypeImplementation_DerivedFrom(), this.getDerivedFromType(), null, "derivedFrom", null, 0, 1, TRelationshipTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationshipTypeImplementation_RequiredContainerFeatures(), this.getTRequiredContainerFeatures(), null, "requiredContainerFeatures", null, 0, 1, TRelationshipTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationshipTypeImplementation_ImplementationArtifacts(), this.getTImplementationArtifacts(), null, "implementationArtifacts", null, 0, 1, TRelationshipTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTRelationshipTypeImplementation_Abstract(), this.getTBoolean(), "abstract", "no", 0, 1, TRelationshipTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTRelationshipTypeImplementation_Final(), this.getTBoolean(), "final", "no", 0, 1, TRelationshipTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTRelationshipTypeImplementation_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TRelationshipTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTRelationshipTypeImplementation_RelationshipType(), theXMLTypePackage.getQName(), "relationshipType", null, 1, 1, TRelationshipTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTRelationshipTypeImplementation_TargetNamespace(), theXMLTypePackage.getAnyURI(), "targetNamespace", null, 0, 1, TRelationshipTypeImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRequiredContainerFeatureEClass, TRequiredContainerFeature.class, "TRequiredContainerFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTRequiredContainerFeature_Feature(), theXMLTypePackage.getAnyURI(), "feature", null, 1, 1, TRequiredContainerFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRequiredContainerFeaturesEClass, TRequiredContainerFeatures.class, "TRequiredContainerFeatures", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTRequiredContainerFeatures_RequiredContainerFeature(), this.getTRequiredContainerFeature(), null, "requiredContainerFeature", null, 1, -1, TRequiredContainerFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRequirementEClass, TRequirement.class, "TRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTRequirement_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, TRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRequirementDefinitionEClass, TRequirementDefinition.class, "TRequirementDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTRequirementDefinition_Constraints(), this.getConstraintsType1(), null, "constraints", null, 0, 1, TRequirementDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTRequirementDefinition_LowerBound(), theXMLTypePackage.getInt(), "lowerBound", "1", 0, 1, TRequirementDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTRequirementDefinition_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, TRequirementDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTRequirementDefinition_RequirementType(), theXMLTypePackage.getQName(), "requirementType", null, 1, 1, TRequirementDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTRequirementDefinition_UpperBound(), this.getUpperBoundType1(), "upperBound", "1", 0, 1, TRequirementDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRequirementRefEClass, TRequirementRef.class, "TRequirementRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTRequirementRef_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TRequirementRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTRequirementRef_Ref(), theXMLTypePackage.getIDREF(), "ref", null, 1, 1, TRequirementRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRequirementTypeEClass, TRequirementType.class, "TRequirementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTRequirementType_RequiredCapabilityType(), theXMLTypePackage.getQName(), "requiredCapabilityType", null, 0, 1, TRequirementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tServiceTemplateEClass, TServiceTemplate.class, "TServiceTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTServiceTemplate_Tags(), this.getTTags(), null, "tags", null, 0, 1, TServiceTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTServiceTemplate_BoundaryDefinitions(), this.getTBoundaryDefinitions(), null, "boundaryDefinitions", null, 0, 1, TServiceTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTServiceTemplate_TopologyTemplate(), this.getTTopologyTemplate(), null, "topologyTemplate", null, 1, 1, TServiceTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTServiceTemplate_Plans(), this.getTPlans(), null, "plans", null, 0, 1, TServiceTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTServiceTemplate_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, TServiceTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTServiceTemplate_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TServiceTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTServiceTemplate_SubstitutableNodeType(), theXMLTypePackage.getQName(), "substitutableNodeType", null, 0, 1, TServiceTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTServiceTemplate_TargetNamespace(), theXMLTypePackage.getAnyURI(), "targetNamespace", null, 0, 1, TServiceTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTagEClass, TTag.class, "TTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTTag_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, TTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTag_Value(), theXMLTypePackage.getString(), "value", null, 1, 1, TTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTagsEClass, TTags.class, "TTags", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTTags_Tag(), this.getTTag(), null, "tag", null, 1, -1, TTags.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTopologyElementInstanceStatesEClass, TTopologyElementInstanceStates.class, "TTopologyElementInstanceStates", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTTopologyElementInstanceStates_InstanceState(), this.getInstanceStateType(), null, "instanceState", null, 1, -1, TTopologyElementInstanceStates.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTopologyTemplateEClass, TTopologyTemplate.class, "TTopologyTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTTopologyTemplate_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, TTopologyTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTTopologyTemplate_NodeTemplate(), this.getTNodeTemplate(), null, "nodeTemplate", null, 0, -1, TTopologyTemplate.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTTopologyTemplate_RelationshipTemplate(), this.getTRelationshipTemplate(), null, "relationshipTemplate", null, 0, -1, TTopologyTemplate.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(typesTypeEClass, TypesType.class, "TypesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypesType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TypesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validSourceTypeEClass, ValidSourceType.class, "ValidSourceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValidSourceType_TypeRef(), theXMLTypePackage.getQName(), "typeRef", null, 1, 1, ValidSourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validTargetTypeEClass, ValidTargetType.class, "ValidTargetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValidTargetType_TypeRef(), theXMLTypePackage.getQName(), "typeRef", null, 1, 1, ValidTargetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(maxInstancesTypeMember1EEnum, MaxInstancesTypeMember1.class, "MaxInstancesTypeMember1");
		addEEnumLiteral(maxInstancesTypeMember1EEnum, MaxInstancesTypeMember1.UNBOUNDED);

		initEEnum(tBooleanEEnum, TBoolean.class, "TBoolean");
		addEEnumLiteral(tBooleanEEnum, TBoolean.YES);
		addEEnumLiteral(tBooleanEEnum, TBoolean.NO);

		initEEnum(upperBoundTypeMember1EEnum, UpperBoundTypeMember1.class, "UpperBoundTypeMember1");
		addEEnumLiteral(upperBoundTypeMember1EEnum, UpperBoundTypeMember1.UNBOUNDED);

		initEEnum(upperBoundTypeMember11EEnum, UpperBoundTypeMember11.class, "UpperBoundTypeMember11");
		addEEnumLiteral(upperBoundTypeMember11EEnum, UpperBoundTypeMember11.UNBOUNDED);

		// Initialize data types
		initEDataType(importedURIEDataType, String.class, "ImportedURI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(maxInstancesTypeEDataType, Object.class, "MaxInstancesType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(maxInstancesTypeMember0EDataType, BigInteger.class, "MaxInstancesTypeMember0", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(maxInstancesTypeMember1ObjectEDataType, MaxInstancesTypeMember1.class, "MaxInstancesTypeMember1Object", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tBooleanObjectEDataType, TBoolean.class, "TBooleanObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(upperBoundTypeEDataType, Object.class, "UpperBoundType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(upperBoundType1EDataType, Object.class, "UpperBoundType1", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(upperBoundTypeMember0EDataType, BigInteger.class, "UpperBoundTypeMember0", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(upperBoundTypeMember01EDataType, BigInteger.class, "UpperBoundTypeMember01", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(upperBoundTypeMember1ObjectEDataType, UpperBoundTypeMember1.class, "UpperBoundTypeMember1Object", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(upperBoundTypeMember1Object1EDataType, UpperBoundTypeMember11.class, "UpperBoundTypeMember1Object1", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (artifactReferencesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ArtifactReferences_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getArtifactReferencesType_ArtifactReference(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ArtifactReference",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (capabilitiesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Capabilities_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getCapabilitiesType_Capability(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Capability",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (capabilitiesType1EClass, 
		   source, 
		   new String[] {
			 "name", "Capabilities_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getCapabilitiesType1_Capability(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Capability",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (capabilityDefinitionsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "CapabilityDefinitions_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getCapabilityDefinitionsType_CapabilityDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CapabilityDefinition",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (constraintsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Constraints_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getConstraintsType_Constraint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Constraint",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (constraintsType1EClass, 
		   source, 
		   new String[] {
			 "name", "Constraints_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getConstraintsType1_Constraint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Constraint",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (definitionsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Definitions_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (derivedFromTypeEClass, 
		   source, 
		   new String[] {
			 "name", "DerivedFrom_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getDerivedFromType_RelationshipTypeImplementationRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "relationshipTypeImplementationRef"
		   });	
		addAnnotation
		  (derivedFromType1EClass, 
		   source, 
		   new String[] {
			 "name", "DerivedFrom_._1_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getDerivedFromType1_NodeTypeImplementationRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "nodeTypeImplementationRef"
		   });	
		addAnnotation
		  (derivedFromType2EClass, 
		   source, 
		   new String[] {
			 "name", "DerivedFrom_._2_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getDerivedFromType2_TypeRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "typeRef"
		   });	
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });	
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });	
		addAnnotation
		  (getDocumentRoot_Definitions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Definitions",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Documentation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "documentation",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (excludeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Exclude_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getExcludeType_Pattern(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "pattern"
		   });	
		addAnnotation
		  (extensionsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Extensions_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getExtensionsType_Extension(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Extension",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (implementationArtifactTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ImplementationArtifact_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (importedURIEDataType, 
		   source, 
		   new String[] {
			 "name", "importedURI",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#anyURI"
		   });	
		addAnnotation
		  (includeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Include_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getIncludeType_Pattern(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "pattern"
		   });	
		addAnnotation
		  (inputParametersTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InputParameters_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getInputParametersType_InputParameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InputParameter",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (inputParametersType1EClass, 
		   source, 
		   new String[] {
			 "name", "InputParameters_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getInputParametersType1_InputParameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InputParameter",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (instanceStateTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InstanceState_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getInstanceStateType_State(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "state"
		   });	
		addAnnotation
		  (interfacesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Interfaces_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getInterfacesType_Interface(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Interface",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (interfacesType1EClass, 
		   source, 
		   new String[] {
			 "name", "Interfaces_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getInterfacesType1_Interface(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Interface",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (maxInstancesTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "maxInstances_._type",
			 "memberTypes", "maxInstances_._type_._member_._0 maxInstances_._type_._member_._1"
		   });	
		addAnnotation
		  (maxInstancesTypeMember0EDataType, 
		   source, 
		   new String[] {
			 "name", "maxInstances_._type_._member_._0",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#nonNegativeInteger",
			 "pattern", "([1-9]+[0-9]*)"
		   });	
		addAnnotation
		  (maxInstancesTypeMember1EEnum, 
		   source, 
		   new String[] {
			 "name", "maxInstances_._type_._member_._1"
		   });	
		addAnnotation
		  (maxInstancesTypeMember1ObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "maxInstances_._type_._member_._1:Object",
			 "baseType", "maxInstances_._type_._member_._1"
		   });	
		addAnnotation
		  (nodeOperationTypeEClass, 
		   source, 
		   new String[] {
			 "name", "NodeOperation_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getNodeOperationType_InterfaceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "interfaceName"
		   });	
		addAnnotation
		  (getNodeOperationType_NodeRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "nodeRef"
		   });	
		addAnnotation
		  (getNodeOperationType_OperationName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operationName"
		   });	
		addAnnotation
		  (nodeTypeReferenceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "NodeTypeReference_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getNodeTypeReferenceType_TypeRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "typeRef"
		   });	
		addAnnotation
		  (outputParametersTypeEClass, 
		   source, 
		   new String[] {
			 "name", "OutputParameters_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getOutputParametersType_OutputParameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "OutputParameter",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (outputParametersType1EClass, 
		   source, 
		   new String[] {
			 "name", "OutputParameters_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getOutputParametersType1_OutputParameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "OutputParameter",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (planModelReferenceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "PlanModelReference_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getPlanModelReferenceType_Reference(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "reference"
		   });	
		addAnnotation
		  (planModelTypeEClass, 
		   source, 
		   new String[] {
			 "name", "PlanModel_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getPlanModelType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":0",
			 "processing", "lax"
		   });	
		addAnnotation
		  (planTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Plan_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getPlanType_PlanRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "planRef"
		   });	
		addAnnotation
		  (policiesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Policies_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getPoliciesType_Policy(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Policy",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (policiesType1EClass, 
		   source, 
		   new String[] {
			 "name", "Policies_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getPoliciesType1_Policy(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Policy",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (propertiesDefinitionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "PropertiesDefinition_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getPropertiesDefinitionType_Element(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "element"
		   });	
		addAnnotation
		  (getPropertiesDefinitionType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });	
		addAnnotation
		  (propertiesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Properties_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getPropertiesType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":0",
			 "processing", "lax"
		   });	
		addAnnotation
		  (propertiesType1EClass, 
		   source, 
		   new String[] {
			 "name", "Properties_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getPropertiesType1_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":0",
			 "processing", "strict"
		   });	
		addAnnotation
		  (getPropertiesType1_PropertyMappings(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PropertyMappings",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (propertyConstraintsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "PropertyConstraints_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getPropertyConstraintsType_PropertyConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PropertyConstraint",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (propertyConstraintsType1EClass, 
		   source, 
		   new String[] {
			 "name", "PropertyConstraints_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getPropertyConstraintsType1_PropertyConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PropertyConstraint",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (propertyMappingsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "PropertyMappings_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getPropertyMappingsType_PropertyMapping(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PropertyMapping",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (relationshipConstraintsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RelationshipConstraints_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRelationshipConstraintsType_RelationshipConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RelationshipConstraint",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (relationshipConstraintTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RelationshipConstraint_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRelationshipConstraintType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":0",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getRelationshipConstraintType_ConstraintType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "constraintType"
		   });	
		addAnnotation
		  (relationshipOperationTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RelationshipOperation_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getRelationshipOperationType_InterfaceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "interfaceName"
		   });	
		addAnnotation
		  (getRelationshipOperationType_OperationName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operationName"
		   });	
		addAnnotation
		  (getRelationshipOperationType_RelationshipRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "relationshipRef"
		   });	
		addAnnotation
		  (requirementDefinitionsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RequirementDefinitions_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRequirementDefinitionsType_RequirementDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RequirementDefinition",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (requirementsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Requirements_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRequirementsType_Requirement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Requirement",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (requirementsType1EClass, 
		   source, 
		   new String[] {
			 "name", "Requirements_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRequirementsType1_Requirement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Requirement",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (sourceElementTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SourceElement_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getSourceElementType_Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ref"
		   });	
		addAnnotation
		  (sourceInterfacesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SourceInterfaces_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getSourceInterfacesType_Interface(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Interface",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tAppliesToEClass, 
		   source, 
		   new String[] {
			 "name", "tAppliesTo",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTAppliesTo_NodeTypeReference(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeTypeReference",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (targetElementTypeEClass, 
		   source, 
		   new String[] {
			 "name", "TargetElement_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getTargetElementType_Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ref"
		   });	
		addAnnotation
		  (targetInterfacesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "TargetInterfaces_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTargetInterfacesType_Interface(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Interface",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tArtifactReferenceEClass, 
		   source, 
		   new String[] {
			 "name", "tArtifactReference",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTArtifactReference_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });	
		addAnnotation
		  (getTArtifactReference_Include(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Include",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });	
		addAnnotation
		  (getTArtifactReference_Exclude(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Exclude",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });	
		addAnnotation
		  (getTArtifactReference_Reference(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "reference"
		   });	
		addAnnotation
		  (tArtifactTemplateEClass, 
		   source, 
		   new String[] {
			 "name", "tArtifactTemplate",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTArtifactTemplate_ArtifactReferences(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ArtifactReferences",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTArtifactTemplate_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (tArtifactTypeEClass, 
		   source, 
		   new String[] {
			 "name", "tArtifactType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (tBooleanEEnum, 
		   source, 
		   new String[] {
			 "name", "tBoolean"
		   });	
		addAnnotation
		  (tBooleanObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "tBoolean:Object",
			 "baseType", "tBoolean"
		   });	
		addAnnotation
		  (tBoundaryDefinitionsEClass, 
		   source, 
		   new String[] {
			 "name", "tBoundaryDefinitions",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTBoundaryDefinitions_Properties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Properties",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTBoundaryDefinitions_PropertyConstraints(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PropertyConstraints",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTBoundaryDefinitions_Requirements(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Requirements",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTBoundaryDefinitions_Capabilities(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Capabilities",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTBoundaryDefinitions_Policies(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Policies",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTBoundaryDefinitions_Interfaces(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Interfaces",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tCapabilityEClass, 
		   source, 
		   new String[] {
			 "name", "tCapability",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTCapability_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (tCapabilityDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tCapabilityDefinition",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTCapabilityDefinition_Constraints(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Constraints",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTCapabilityDefinition_CapabilityType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "capabilityType"
		   });	
		addAnnotation
		  (getTCapabilityDefinition_LowerBound(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lowerBound"
		   });	
		addAnnotation
		  (getTCapabilityDefinition_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTCapabilityDefinition_UpperBound(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "upperBound"
		   });	
		addAnnotation
		  (tCapabilityRefEClass, 
		   source, 
		   new String[] {
			 "name", "tCapabilityRef",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getTCapabilityRef_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTCapabilityRef_Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ref"
		   });	
		addAnnotation
		  (tCapabilityTypeEClass, 
		   source, 
		   new String[] {
			 "name", "tCapabilityType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (tConditionEClass, 
		   source, 
		   new String[] {
			 "name", "tCondition",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTCondition_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##any",
			 "name", ":0",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getTCondition_ExpressionLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "expressionLanguage"
		   });	
		addAnnotation
		  (tConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "tConstraint",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTConstraint_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":0",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getTConstraint_ConstraintType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "constraintType"
		   });	
		addAnnotation
		  (tDefinitionsEClass, 
		   source, 
		   new String[] {
			 "name", "tDefinitions",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTDefinitions_Extensions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Extensions",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTDefinitions_Import(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Import",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTDefinitions_Types(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Types",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTDefinitions_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:6"
		   });	
		addAnnotation
		  (getTDefinitions_ServiceTemplate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceTemplate",
			 "namespace", "##targetNamespace",
			 "group", "#group:6"
		   });	
		addAnnotation
		  (getTDefinitions_NodeType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeType",
			 "namespace", "##targetNamespace",
			 "group", "#group:6"
		   });	
		addAnnotation
		  (getTDefinitions_NodeTypeImplementation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeTypeImplementation",
			 "namespace", "##targetNamespace",
			 "group", "#group:6"
		   });	
		addAnnotation
		  (getTDefinitions_RelationshipType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RelationshipType",
			 "namespace", "##targetNamespace",
			 "group", "#group:6"
		   });	
		addAnnotation
		  (getTDefinitions_RelationshipTypeImplementation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RelationshipTypeImplementation",
			 "namespace", "##targetNamespace",
			 "group", "#group:6"
		   });	
		addAnnotation
		  (getTDefinitions_RequirementType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RequirementType",
			 "namespace", "##targetNamespace",
			 "group", "#group:6"
		   });	
		addAnnotation
		  (getTDefinitions_CapabilityType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CapabilityType",
			 "namespace", "##targetNamespace",
			 "group", "#group:6"
		   });	
		addAnnotation
		  (getTDefinitions_ArtifactType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ArtifactType",
			 "namespace", "##targetNamespace",
			 "group", "#group:6"
		   });	
		addAnnotation
		  (getTDefinitions_ArtifactTemplate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ArtifactTemplate",
			 "namespace", "##targetNamespace",
			 "group", "#group:6"
		   });	
		addAnnotation
		  (getTDefinitions_PolicyType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PolicyType",
			 "namespace", "##targetNamespace",
			 "group", "#group:6"
		   });	
		addAnnotation
		  (getTDefinitions_PolicyTemplate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PolicyTemplate",
			 "namespace", "##targetNamespace",
			 "group", "#group:6"
		   });	
		addAnnotation
		  (getTDefinitions_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });	
		addAnnotation
		  (getTDefinitions_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTDefinitions_TargetNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetNamespace"
		   });	
		addAnnotation
		  (tDeploymentArtifactEClass, 
		   source, 
		   new String[] {
			 "name", "tDeploymentArtifact",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTDeploymentArtifact_ArtifactRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "artifactRef"
		   });	
		addAnnotation
		  (getTDeploymentArtifact_ArtifactType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "artifactType"
		   });	
		addAnnotation
		  (getTDeploymentArtifact_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (tDeploymentArtifactsEClass, 
		   source, 
		   new String[] {
			 "name", "tDeploymentArtifacts",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTDeploymentArtifacts_DeploymentArtifact(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DeploymentArtifact",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tDocumentationEClass, 
		   source, 
		   new String[] {
			 "name", "tDocumentation",
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getTDocumentation_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (getTDocumentation_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##any",
			 "name", ":1",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getTDocumentation_Lang(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lang",
			 "namespace", "http://www.w3.org/XML/1998/namespace"
		   });	
		addAnnotation
		  (getTDocumentation_Source(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "source"
		   });	
		addAnnotation
		  (tEntityTemplateEClass, 
		   source, 
		   new String[] {
			 "name", "tEntityTemplate",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTEntityTemplate_Properties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Properties",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTEntityTemplate_PropertyConstraints(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PropertyConstraints",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTEntityTemplate_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });	
		addAnnotation
		  (getTEntityTemplate_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });	
		addAnnotation
		  (tEntityTypeEClass, 
		   source, 
		   new String[] {
			 "name", "tEntityType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTEntityType_Tags(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Tags",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTEntityType_DerivedFrom(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DerivedFrom",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTEntityType_PropertiesDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PropertiesDefinition",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTEntityType_Abstract(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "abstract"
		   });	
		addAnnotation
		  (getTEntityType_Final(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "final"
		   });	
		addAnnotation
		  (getTEntityType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTEntityType_TargetNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetNamespace"
		   });	
		addAnnotation
		  (tExportedInterfaceEClass, 
		   source, 
		   new String[] {
			 "name", "tExportedInterface",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTExportedInterface_Operation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Operation",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTExportedInterface_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (tExportedOperationEClass, 
		   source, 
		   new String[] {
			 "name", "tExportedOperation",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTExportedOperation_NodeOperation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeOperation",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTExportedOperation_RelationshipOperation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RelationshipOperation",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTExportedOperation_Plan(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Plan",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTExportedOperation_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (tExtensibleElementsEClass, 
		   source, 
		   new String[] {
			 "name", "tExtensibleElements",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTExtensibleElements_Documentation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "documentation",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTExtensibleElements_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getTExtensibleElements_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":2",
			 "processing", "lax"
		   });	
		addAnnotation
		  (tExtensionEClass, 
		   source, 
		   new String[] {
			 "name", "tExtension",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTExtension_MustUnderstand(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "mustUnderstand"
		   });	
		addAnnotation
		  (getTExtension_Namespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "namespace"
		   });	
		addAnnotation
		  (tExtensionsEClass, 
		   source, 
		   new String[] {
			 "name", "tExtensions",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTExtensions_Extension(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Extension",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tImplementationArtifactEClass, 
		   source, 
		   new String[] {
			 "name", "tImplementationArtifact",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTImplementationArtifact_ArtifactRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "artifactRef"
		   });	
		addAnnotation
		  (getTImplementationArtifact_ArtifactType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "artifactType"
		   });	
		addAnnotation
		  (getTImplementationArtifact_InterfaceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "interfaceName"
		   });	
		addAnnotation
		  (getTImplementationArtifact_OperationName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operationName"
		   });	
		addAnnotation
		  (tImplementationArtifactsEClass, 
		   source, 
		   new String[] {
			 "name", "tImplementationArtifacts",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTImplementationArtifacts_ImplementationArtifact(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ImplementationArtifact",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tImportEClass, 
		   source, 
		   new String[] {
			 "name", "tImport",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTImport_ImportType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "importType"
		   });	
		addAnnotation
		  (getTImport_Location(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "location"
		   });	
		addAnnotation
		  (getTImport_Namespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "namespace"
		   });	
		addAnnotation
		  (tInterfaceEClass, 
		   source, 
		   new String[] {
			 "name", "tInterface",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTInterface_Operation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Operation",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTInterface_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (tNodeTemplateEClass, 
		   source, 
		   new String[] {
			 "name", "tNodeTemplate",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTNodeTemplate_Requirements(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Requirements",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeTemplate_Capabilities(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Capabilities",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeTemplate_Policies(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Policies",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeTemplate_DeploymentArtifacts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DeploymentArtifacts",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeTemplate_MaxInstances(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxInstances"
		   });	
		addAnnotation
		  (getTNodeTemplate_MinInstances(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "minInstances"
		   });	
		addAnnotation
		  (getTNodeTemplate_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (tNodeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "tNodeType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTNodeType_RequirementDefinitions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RequirementDefinitions",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeType_CapabilityDefinitions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CapabilityDefinitions",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeType_InstanceStates(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InstanceStates",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeType_Interfaces(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Interfaces",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tNodeTypeImplementationEClass, 
		   source, 
		   new String[] {
			 "name", "tNodeTypeImplementation",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTNodeTypeImplementation_Tags(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Tags",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeTypeImplementation_DerivedFrom(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DerivedFrom",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeTypeImplementation_RequiredContainerFeatures(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RequiredContainerFeatures",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeTypeImplementation_ImplementationArtifacts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ImplementationArtifacts",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeTypeImplementation_DeploymentArtifacts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DeploymentArtifacts",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTNodeTypeImplementation_Abstract(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "abstract"
		   });	
		addAnnotation
		  (getTNodeTypeImplementation_Final(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "final"
		   });	
		addAnnotation
		  (getTNodeTypeImplementation_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTNodeTypeImplementation_NodeType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "nodeType"
		   });	
		addAnnotation
		  (getTNodeTypeImplementation_TargetNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetNamespace"
		   });	
		addAnnotation
		  (tOperationEClass, 
		   source, 
		   new String[] {
			 "name", "tOperation",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTOperation_InputParameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InputParameters",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTOperation_OutputParameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "OutputParameters",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTOperation_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (tParameterEClass, 
		   source, 
		   new String[] {
			 "name", "tParameter",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getTParameter_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTParameter_Required(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "required"
		   });	
		addAnnotation
		  (getTParameter_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });	
		addAnnotation
		  (tPlanEClass, 
		   source, 
		   new String[] {
			 "name", "tPlan",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTPlan_Precondition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Precondition",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTPlan_InputParameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InputParameters",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTPlan_OutputParameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "OutputParameters",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTPlan_PlanModel(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PlanModel",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTPlan_PlanModelReference(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PlanModelReference",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTPlan_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });	
		addAnnotation
		  (getTPlan_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTPlan_PlanLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "planLanguage"
		   });	
		addAnnotation
		  (getTPlan_PlanType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "planType"
		   });	
		addAnnotation
		  (tPlansEClass, 
		   source, 
		   new String[] {
			 "name", "tPlans",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTPlans_Plan(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Plan",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTPlans_TargetNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetNamespace"
		   });	
		addAnnotation
		  (tPolicyEClass, 
		   source, 
		   new String[] {
			 "name", "tPolicy",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTPolicy_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTPolicy_PolicyRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "policyRef"
		   });	
		addAnnotation
		  (getTPolicy_PolicyType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "policyType"
		   });	
		addAnnotation
		  (tPolicyTemplateEClass, 
		   source, 
		   new String[] {
			 "name", "tPolicyTemplate",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTPolicyTemplate_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (tPolicyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "tPolicyType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTPolicyType_AppliesTo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AppliesTo",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTPolicyType_PolicyLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "policyLanguage"
		   });	
		addAnnotation
		  (tPropertyConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "tPropertyConstraint",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTPropertyConstraint_Property(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "property"
		   });	
		addAnnotation
		  (tPropertyMappingEClass, 
		   source, 
		   new String[] {
			 "name", "tPropertyMapping",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getTPropertyMapping_ServiceTemplatePropertyRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "serviceTemplatePropertyRef"
		   });	
		addAnnotation
		  (getTPropertyMapping_TargetObjectRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetObjectRef"
		   });	
		addAnnotation
		  (getTPropertyMapping_TargetPropertyRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetPropertyRef"
		   });	
		addAnnotation
		  (tRelationshipTemplateEClass, 
		   source, 
		   new String[] {
			 "name", "tRelationshipTemplate",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTRelationshipTemplate_SourceElement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SourceElement",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRelationshipTemplate_TargetElement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "TargetElement",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRelationshipTemplate_RelationshipConstraints(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RelationshipConstraints",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRelationshipTemplate_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (tRelationshipTypeEClass, 
		   source, 
		   new String[] {
			 "name", "tRelationshipType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTRelationshipType_InstanceStates(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InstanceStates",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRelationshipType_SourceInterfaces(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SourceInterfaces",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRelationshipType_TargetInterfaces(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "TargetInterfaces",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRelationshipType_ValidSource(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ValidSource",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRelationshipType_ValidTarget(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ValidTarget",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tRelationshipTypeImplementationEClass, 
		   source, 
		   new String[] {
			 "name", "tRelationshipTypeImplementation",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTRelationshipTypeImplementation_Tags(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Tags",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRelationshipTypeImplementation_DerivedFrom(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DerivedFrom",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRelationshipTypeImplementation_RequiredContainerFeatures(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RequiredContainerFeatures",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRelationshipTypeImplementation_ImplementationArtifacts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ImplementationArtifacts",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRelationshipTypeImplementation_Abstract(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "abstract"
		   });	
		addAnnotation
		  (getTRelationshipTypeImplementation_Final(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "final"
		   });	
		addAnnotation
		  (getTRelationshipTypeImplementation_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTRelationshipTypeImplementation_RelationshipType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "relationshipType"
		   });	
		addAnnotation
		  (getTRelationshipTypeImplementation_TargetNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetNamespace"
		   });	
		addAnnotation
		  (tRequiredContainerFeatureEClass, 
		   source, 
		   new String[] {
			 "name", "tRequiredContainerFeature",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getTRequiredContainerFeature_Feature(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "feature"
		   });	
		addAnnotation
		  (tRequiredContainerFeaturesEClass, 
		   source, 
		   new String[] {
			 "name", "tRequiredContainerFeatures",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTRequiredContainerFeatures_RequiredContainerFeature(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RequiredContainerFeature",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tRequirementEClass, 
		   source, 
		   new String[] {
			 "name", "tRequirement",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTRequirement_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (tRequirementDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tRequirementDefinition",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTRequirementDefinition_Constraints(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Constraints",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTRequirementDefinition_LowerBound(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lowerBound"
		   });	
		addAnnotation
		  (getTRequirementDefinition_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTRequirementDefinition_RequirementType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "requirementType"
		   });	
		addAnnotation
		  (getTRequirementDefinition_UpperBound(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "upperBound"
		   });	
		addAnnotation
		  (tRequirementRefEClass, 
		   source, 
		   new String[] {
			 "name", "tRequirementRef",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getTRequirementRef_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTRequirementRef_Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ref"
		   });	
		addAnnotation
		  (tRequirementTypeEClass, 
		   source, 
		   new String[] {
			 "name", "tRequirementType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTRequirementType_RequiredCapabilityType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "requiredCapabilityType"
		   });	
		addAnnotation
		  (tServiceTemplateEClass, 
		   source, 
		   new String[] {
			 "name", "tServiceTemplate",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTServiceTemplate_Tags(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Tags",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTServiceTemplate_BoundaryDefinitions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "BoundaryDefinitions",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTServiceTemplate_TopologyTemplate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "TopologyTemplate",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTServiceTemplate_Plans(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Plans",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getTServiceTemplate_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });	
		addAnnotation
		  (getTServiceTemplate_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTServiceTemplate_SubstitutableNodeType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "substitutableNodeType"
		   });	
		addAnnotation
		  (getTServiceTemplate_TargetNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetNamespace"
		   });	
		addAnnotation
		  (tTagEClass, 
		   source, 
		   new String[] {
			 "name", "tTag",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getTTag_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getTTag_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "value"
		   });	
		addAnnotation
		  (tTagsEClass, 
		   source, 
		   new String[] {
			 "name", "tTags",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTTags_Tag(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Tag",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tTopologyElementInstanceStatesEClass, 
		   source, 
		   new String[] {
			 "name", "tTopologyElementInstanceStates",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTTopologyElementInstanceStates_InstanceState(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InstanceState",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tTopologyTemplateEClass, 
		   source, 
		   new String[] {
			 "name", "tTopologyTemplate",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTTopologyTemplate_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:3"
		   });	
		addAnnotation
		  (getTTopologyTemplate_NodeTemplate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeTemplate",
			 "namespace", "##targetNamespace",
			 "group", "#group:3"
		   });	
		addAnnotation
		  (getTTopologyTemplate_RelationshipTemplate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RelationshipTemplate",
			 "namespace", "##targetNamespace",
			 "group", "#group:3"
		   });	
		addAnnotation
		  (typesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Types_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTypesType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":0",
			 "processing", "lax"
		   });	
		addAnnotation
		  (upperBoundTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "upperBound_._type",
			 "memberTypes", "upperBound_._type_._member_._0 upperBound_._type_._member_._1"
		   });	
		addAnnotation
		  (upperBoundType1EDataType, 
		   source, 
		   new String[] {
			 "name", "upperBound_._1_._type",
			 "memberTypes", "upperBound_._1_._type_._member_._0 upperBound_._1_._type_._member_._1"
		   });	
		addAnnotation
		  (upperBoundTypeMember0EDataType, 
		   source, 
		   new String[] {
			 "name", "upperBound_._type_._member_._0",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#nonNegativeInteger",
			 "pattern", "([1-9]+[0-9]*)"
		   });	
		addAnnotation
		  (upperBoundTypeMember01EDataType, 
		   source, 
		   new String[] {
			 "name", "upperBound_._1_._type_._member_._0",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#nonNegativeInteger",
			 "pattern", "([1-9]+[0-9]*)"
		   });	
		addAnnotation
		  (upperBoundTypeMember1EEnum, 
		   source, 
		   new String[] {
			 "name", "upperBound_._type_._member_._1"
		   });	
		addAnnotation
		  (upperBoundTypeMember11EEnum, 
		   source, 
		   new String[] {
			 "name", "upperBound_._1_._type_._member_._1"
		   });	
		addAnnotation
		  (upperBoundTypeMember1ObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "upperBound_._type_._member_._1:Object",
			 "baseType", "upperBound_._type_._member_._1"
		   });	
		addAnnotation
		  (upperBoundTypeMember1Object1EDataType, 
		   source, 
		   new String[] {
			 "name", "upperBound_._1_._type_._member_._1:Object",
			 "baseType", "upperBound_._1_._type_._member_._1"
		   });	
		addAnnotation
		  (validSourceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ValidSource_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getValidSourceType_TypeRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "typeRef"
		   });	
		addAnnotation
		  (validTargetTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ValidTarget_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getValidTargetType_TypeRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "typeRef"
		   });
	}

} //ToscaPackageImpl
