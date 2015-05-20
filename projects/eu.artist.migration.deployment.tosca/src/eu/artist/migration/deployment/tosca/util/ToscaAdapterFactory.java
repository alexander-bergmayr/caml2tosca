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
package eu.artist.migration.deployment.tosca.util;

import eu.artist.migration.deployment.tosca.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.artist.migration.deployment.tosca.ToscaPackage
 * @generated
 */
public class ToscaAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ToscaPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToscaAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ToscaPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToscaSwitch<Adapter> modelSwitch =
		new ToscaSwitch<Adapter>() {
			@Override
			public Adapter caseArtifactReferencesType(ArtifactReferencesType object) {
				return createArtifactReferencesTypeAdapter();
			}
			@Override
			public Adapter caseCapabilitiesType(CapabilitiesType object) {
				return createCapabilitiesTypeAdapter();
			}
			@Override
			public Adapter caseCapabilitiesType1(CapabilitiesType1 object) {
				return createCapabilitiesType1Adapter();
			}
			@Override
			public Adapter caseCapabilityDefinitionsType(CapabilityDefinitionsType object) {
				return createCapabilityDefinitionsTypeAdapter();
			}
			@Override
			public Adapter caseConstraintsType(ConstraintsType object) {
				return createConstraintsTypeAdapter();
			}
			@Override
			public Adapter caseConstraintsType1(ConstraintsType1 object) {
				return createConstraintsType1Adapter();
			}
			@Override
			public Adapter caseDefinitionsType(DefinitionsType object) {
				return createDefinitionsTypeAdapter();
			}
			@Override
			public Adapter caseDerivedFromType(DerivedFromType object) {
				return createDerivedFromTypeAdapter();
			}
			@Override
			public Adapter caseDerivedFromType1(DerivedFromType1 object) {
				return createDerivedFromType1Adapter();
			}
			@Override
			public Adapter caseDerivedFromType2(DerivedFromType2 object) {
				return createDerivedFromType2Adapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseExcludeType(ExcludeType object) {
				return createExcludeTypeAdapter();
			}
			@Override
			public Adapter caseExtensionsType(ExtensionsType object) {
				return createExtensionsTypeAdapter();
			}
			@Override
			public Adapter caseImplementationArtifactType(ImplementationArtifactType object) {
				return createImplementationArtifactTypeAdapter();
			}
			@Override
			public Adapter caseIncludeType(IncludeType object) {
				return createIncludeTypeAdapter();
			}
			@Override
			public Adapter caseInputParametersType(InputParametersType object) {
				return createInputParametersTypeAdapter();
			}
			@Override
			public Adapter caseInputParametersType1(InputParametersType1 object) {
				return createInputParametersType1Adapter();
			}
			@Override
			public Adapter caseInstanceStateType(InstanceStateType object) {
				return createInstanceStateTypeAdapter();
			}
			@Override
			public Adapter caseInterfacesType(InterfacesType object) {
				return createInterfacesTypeAdapter();
			}
			@Override
			public Adapter caseInterfacesType1(InterfacesType1 object) {
				return createInterfacesType1Adapter();
			}
			@Override
			public Adapter caseNodeOperationType(NodeOperationType object) {
				return createNodeOperationTypeAdapter();
			}
			@Override
			public Adapter caseNodeTypeReferenceType(NodeTypeReferenceType object) {
				return createNodeTypeReferenceTypeAdapter();
			}
			@Override
			public Adapter caseOutputParametersType(OutputParametersType object) {
				return createOutputParametersTypeAdapter();
			}
			@Override
			public Adapter caseOutputParametersType1(OutputParametersType1 object) {
				return createOutputParametersType1Adapter();
			}
			@Override
			public Adapter casePlanModelReferenceType(PlanModelReferenceType object) {
				return createPlanModelReferenceTypeAdapter();
			}
			@Override
			public Adapter casePlanModelType(PlanModelType object) {
				return createPlanModelTypeAdapter();
			}
			@Override
			public Adapter casePlanType(PlanType object) {
				return createPlanTypeAdapter();
			}
			@Override
			public Adapter casePoliciesType(PoliciesType object) {
				return createPoliciesTypeAdapter();
			}
			@Override
			public Adapter casePoliciesType1(PoliciesType1 object) {
				return createPoliciesType1Adapter();
			}
			@Override
			public Adapter casePropertiesDefinitionType(PropertiesDefinitionType object) {
				return createPropertiesDefinitionTypeAdapter();
			}
			@Override
			public Adapter casePropertiesType(PropertiesType object) {
				return createPropertiesTypeAdapter();
			}
			@Override
			public Adapter casePropertiesType1(PropertiesType1 object) {
				return createPropertiesType1Adapter();
			}
			@Override
			public Adapter casePropertyConstraintsType(PropertyConstraintsType object) {
				return createPropertyConstraintsTypeAdapter();
			}
			@Override
			public Adapter casePropertyConstraintsType1(PropertyConstraintsType1 object) {
				return createPropertyConstraintsType1Adapter();
			}
			@Override
			public Adapter casePropertyMappingsType(PropertyMappingsType object) {
				return createPropertyMappingsTypeAdapter();
			}
			@Override
			public Adapter caseRelationshipConstraintsType(RelationshipConstraintsType object) {
				return createRelationshipConstraintsTypeAdapter();
			}
			@Override
			public Adapter caseRelationshipConstraintType(RelationshipConstraintType object) {
				return createRelationshipConstraintTypeAdapter();
			}
			@Override
			public Adapter caseRelationshipOperationType(RelationshipOperationType object) {
				return createRelationshipOperationTypeAdapter();
			}
			@Override
			public Adapter caseRequirementDefinitionsType(RequirementDefinitionsType object) {
				return createRequirementDefinitionsTypeAdapter();
			}
			@Override
			public Adapter caseRequirementsType(RequirementsType object) {
				return createRequirementsTypeAdapter();
			}
			@Override
			public Adapter caseRequirementsType1(RequirementsType1 object) {
				return createRequirementsType1Adapter();
			}
			@Override
			public Adapter caseSourceElementType(SourceElementType object) {
				return createSourceElementTypeAdapter();
			}
			@Override
			public Adapter caseSourceInterfacesType(SourceInterfacesType object) {
				return createSourceInterfacesTypeAdapter();
			}
			@Override
			public Adapter caseTAppliesTo(TAppliesTo object) {
				return createTAppliesToAdapter();
			}
			@Override
			public Adapter caseTargetElementType(TargetElementType object) {
				return createTargetElementTypeAdapter();
			}
			@Override
			public Adapter caseTargetInterfacesType(TargetInterfacesType object) {
				return createTargetInterfacesTypeAdapter();
			}
			@Override
			public Adapter caseTArtifactReference(TArtifactReference object) {
				return createTArtifactReferenceAdapter();
			}
			@Override
			public Adapter caseTArtifactTemplate(TArtifactTemplate object) {
				return createTArtifactTemplateAdapter();
			}
			@Override
			public Adapter caseTArtifactType(TArtifactType object) {
				return createTArtifactTypeAdapter();
			}
			@Override
			public Adapter caseTBoundaryDefinitions(TBoundaryDefinitions object) {
				return createTBoundaryDefinitionsAdapter();
			}
			@Override
			public Adapter caseTCapability(TCapability object) {
				return createTCapabilityAdapter();
			}
			@Override
			public Adapter caseTCapabilityDefinition(TCapabilityDefinition object) {
				return createTCapabilityDefinitionAdapter();
			}
			@Override
			public Adapter caseTCapabilityRef(TCapabilityRef object) {
				return createTCapabilityRefAdapter();
			}
			@Override
			public Adapter caseTCapabilityType(TCapabilityType object) {
				return createTCapabilityTypeAdapter();
			}
			@Override
			public Adapter caseTCondition(TCondition object) {
				return createTConditionAdapter();
			}
			@Override
			public Adapter caseTConstraint(TConstraint object) {
				return createTConstraintAdapter();
			}
			@Override
			public Adapter caseTDefinitions(TDefinitions object) {
				return createTDefinitionsAdapter();
			}
			@Override
			public Adapter caseTDeploymentArtifact(TDeploymentArtifact object) {
				return createTDeploymentArtifactAdapter();
			}
			@Override
			public Adapter caseTDeploymentArtifacts(TDeploymentArtifacts object) {
				return createTDeploymentArtifactsAdapter();
			}
			@Override
			public Adapter caseTDocumentation(TDocumentation object) {
				return createTDocumentationAdapter();
			}
			@Override
			public Adapter caseTEntityTemplate(TEntityTemplate object) {
				return createTEntityTemplateAdapter();
			}
			@Override
			public Adapter caseTEntityType(TEntityType object) {
				return createTEntityTypeAdapter();
			}
			@Override
			public Adapter caseTExportedInterface(TExportedInterface object) {
				return createTExportedInterfaceAdapter();
			}
			@Override
			public Adapter caseTExportedOperation(TExportedOperation object) {
				return createTExportedOperationAdapter();
			}
			@Override
			public Adapter caseTExtensibleElements(TExtensibleElements object) {
				return createTExtensibleElementsAdapter();
			}
			@Override
			public Adapter caseTExtension(TExtension object) {
				return createTExtensionAdapter();
			}
			@Override
			public Adapter caseTExtensions(TExtensions object) {
				return createTExtensionsAdapter();
			}
			@Override
			public Adapter caseTImplementationArtifact(TImplementationArtifact object) {
				return createTImplementationArtifactAdapter();
			}
			@Override
			public Adapter caseTImplementationArtifacts(TImplementationArtifacts object) {
				return createTImplementationArtifactsAdapter();
			}
			@Override
			public Adapter caseTImport(TImport object) {
				return createTImportAdapter();
			}
			@Override
			public Adapter caseTInterface(TInterface object) {
				return createTInterfaceAdapter();
			}
			@Override
			public Adapter caseTNodeTemplate(TNodeTemplate object) {
				return createTNodeTemplateAdapter();
			}
			@Override
			public Adapter caseTNodeType(TNodeType object) {
				return createTNodeTypeAdapter();
			}
			@Override
			public Adapter caseTNodeTypeImplementation(TNodeTypeImplementation object) {
				return createTNodeTypeImplementationAdapter();
			}
			@Override
			public Adapter caseTOperation(TOperation object) {
				return createTOperationAdapter();
			}
			@Override
			public Adapter caseTParameter(TParameter object) {
				return createTParameterAdapter();
			}
			@Override
			public Adapter caseTPlan(TPlan object) {
				return createTPlanAdapter();
			}
			@Override
			public Adapter caseTPlans(TPlans object) {
				return createTPlansAdapter();
			}
			@Override
			public Adapter caseTPolicy(TPolicy object) {
				return createTPolicyAdapter();
			}
			@Override
			public Adapter caseTPolicyTemplate(TPolicyTemplate object) {
				return createTPolicyTemplateAdapter();
			}
			@Override
			public Adapter caseTPolicyType(TPolicyType object) {
				return createTPolicyTypeAdapter();
			}
			@Override
			public Adapter caseTPropertyConstraint(TPropertyConstraint object) {
				return createTPropertyConstraintAdapter();
			}
			@Override
			public Adapter caseTPropertyMapping(TPropertyMapping object) {
				return createTPropertyMappingAdapter();
			}
			@Override
			public Adapter caseTRelationshipTemplate(TRelationshipTemplate object) {
				return createTRelationshipTemplateAdapter();
			}
			@Override
			public Adapter caseTRelationshipType(TRelationshipType object) {
				return createTRelationshipTypeAdapter();
			}
			@Override
			public Adapter caseTRelationshipTypeImplementation(TRelationshipTypeImplementation object) {
				return createTRelationshipTypeImplementationAdapter();
			}
			@Override
			public Adapter caseTRequiredContainerFeature(TRequiredContainerFeature object) {
				return createTRequiredContainerFeatureAdapter();
			}
			@Override
			public Adapter caseTRequiredContainerFeatures(TRequiredContainerFeatures object) {
				return createTRequiredContainerFeaturesAdapter();
			}
			@Override
			public Adapter caseTRequirement(TRequirement object) {
				return createTRequirementAdapter();
			}
			@Override
			public Adapter caseTRequirementDefinition(TRequirementDefinition object) {
				return createTRequirementDefinitionAdapter();
			}
			@Override
			public Adapter caseTRequirementRef(TRequirementRef object) {
				return createTRequirementRefAdapter();
			}
			@Override
			public Adapter caseTRequirementType(TRequirementType object) {
				return createTRequirementTypeAdapter();
			}
			@Override
			public Adapter caseTServiceTemplate(TServiceTemplate object) {
				return createTServiceTemplateAdapter();
			}
			@Override
			public Adapter caseTTag(TTag object) {
				return createTTagAdapter();
			}
			@Override
			public Adapter caseTTags(TTags object) {
				return createTTagsAdapter();
			}
			@Override
			public Adapter caseTTopologyElementInstanceStates(TTopologyElementInstanceStates object) {
				return createTTopologyElementInstanceStatesAdapter();
			}
			@Override
			public Adapter caseTTopologyTemplate(TTopologyTemplate object) {
				return createTTopologyTemplateAdapter();
			}
			@Override
			public Adapter caseTypesType(TypesType object) {
				return createTypesTypeAdapter();
			}
			@Override
			public Adapter caseValidSourceType(ValidSourceType object) {
				return createValidSourceTypeAdapter();
			}
			@Override
			public Adapter caseValidTargetType(ValidTargetType object) {
				return createValidTargetTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.ArtifactReferencesType <em>Artifact References Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.ArtifactReferencesType
	 * @generated
	 */
	public Adapter createArtifactReferencesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.CapabilitiesType <em>Capabilities Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.CapabilitiesType
	 * @generated
	 */
	public Adapter createCapabilitiesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.CapabilitiesType1 <em>Capabilities Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.CapabilitiesType1
	 * @generated
	 */
	public Adapter createCapabilitiesType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.CapabilityDefinitionsType <em>Capability Definitions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.CapabilityDefinitionsType
	 * @generated
	 */
	public Adapter createCapabilityDefinitionsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.ConstraintsType <em>Constraints Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.ConstraintsType
	 * @generated
	 */
	public Adapter createConstraintsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.ConstraintsType1 <em>Constraints Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.ConstraintsType1
	 * @generated
	 */
	public Adapter createConstraintsType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.DefinitionsType <em>Definitions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.DefinitionsType
	 * @generated
	 */
	public Adapter createDefinitionsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.DerivedFromType <em>Derived From Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.DerivedFromType
	 * @generated
	 */
	public Adapter createDerivedFromTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.DerivedFromType1 <em>Derived From Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.DerivedFromType1
	 * @generated
	 */
	public Adapter createDerivedFromType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.DerivedFromType2 <em>Derived From Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.DerivedFromType2
	 * @generated
	 */
	public Adapter createDerivedFromType2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.ExcludeType <em>Exclude Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.ExcludeType
	 * @generated
	 */
	public Adapter createExcludeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.ExtensionsType <em>Extensions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.ExtensionsType
	 * @generated
	 */
	public Adapter createExtensionsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.ImplementationArtifactType <em>Implementation Artifact Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.ImplementationArtifactType
	 * @generated
	 */
	public Adapter createImplementationArtifactTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.IncludeType <em>Include Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.IncludeType
	 * @generated
	 */
	public Adapter createIncludeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.InputParametersType <em>Input Parameters Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.InputParametersType
	 * @generated
	 */
	public Adapter createInputParametersTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.InputParametersType1 <em>Input Parameters Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.InputParametersType1
	 * @generated
	 */
	public Adapter createInputParametersType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.InstanceStateType <em>Instance State Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.InstanceStateType
	 * @generated
	 */
	public Adapter createInstanceStateTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.InterfacesType <em>Interfaces Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.InterfacesType
	 * @generated
	 */
	public Adapter createInterfacesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.InterfacesType1 <em>Interfaces Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.InterfacesType1
	 * @generated
	 */
	public Adapter createInterfacesType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.NodeOperationType <em>Node Operation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.NodeOperationType
	 * @generated
	 */
	public Adapter createNodeOperationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.NodeTypeReferenceType <em>Node Type Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.NodeTypeReferenceType
	 * @generated
	 */
	public Adapter createNodeTypeReferenceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.OutputParametersType <em>Output Parameters Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.OutputParametersType
	 * @generated
	 */
	public Adapter createOutputParametersTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.OutputParametersType1 <em>Output Parameters Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.OutputParametersType1
	 * @generated
	 */
	public Adapter createOutputParametersType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.PlanModelReferenceType <em>Plan Model Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.PlanModelReferenceType
	 * @generated
	 */
	public Adapter createPlanModelReferenceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.PlanModelType <em>Plan Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.PlanModelType
	 * @generated
	 */
	public Adapter createPlanModelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.PlanType <em>Plan Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.PlanType
	 * @generated
	 */
	public Adapter createPlanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.PoliciesType <em>Policies Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.PoliciesType
	 * @generated
	 */
	public Adapter createPoliciesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.PoliciesType1 <em>Policies Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.PoliciesType1
	 * @generated
	 */
	public Adapter createPoliciesType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.PropertiesDefinitionType <em>Properties Definition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.PropertiesDefinitionType
	 * @generated
	 */
	public Adapter createPropertiesDefinitionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.PropertiesType <em>Properties Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.PropertiesType
	 * @generated
	 */
	public Adapter createPropertiesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.PropertiesType1 <em>Properties Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.PropertiesType1
	 * @generated
	 */
	public Adapter createPropertiesType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.PropertyConstraintsType <em>Property Constraints Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.PropertyConstraintsType
	 * @generated
	 */
	public Adapter createPropertyConstraintsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.PropertyConstraintsType1 <em>Property Constraints Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.PropertyConstraintsType1
	 * @generated
	 */
	public Adapter createPropertyConstraintsType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.PropertyMappingsType <em>Property Mappings Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.PropertyMappingsType
	 * @generated
	 */
	public Adapter createPropertyMappingsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.RelationshipConstraintsType <em>Relationship Constraints Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.RelationshipConstraintsType
	 * @generated
	 */
	public Adapter createRelationshipConstraintsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.RelationshipConstraintType <em>Relationship Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.RelationshipConstraintType
	 * @generated
	 */
	public Adapter createRelationshipConstraintTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.RelationshipOperationType <em>Relationship Operation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.RelationshipOperationType
	 * @generated
	 */
	public Adapter createRelationshipOperationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.RequirementDefinitionsType <em>Requirement Definitions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.RequirementDefinitionsType
	 * @generated
	 */
	public Adapter createRequirementDefinitionsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.RequirementsType <em>Requirements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.RequirementsType
	 * @generated
	 */
	public Adapter createRequirementsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.RequirementsType1 <em>Requirements Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.RequirementsType1
	 * @generated
	 */
	public Adapter createRequirementsType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.SourceElementType <em>Source Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.SourceElementType
	 * @generated
	 */
	public Adapter createSourceElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.SourceInterfacesType <em>Source Interfaces Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.SourceInterfacesType
	 * @generated
	 */
	public Adapter createSourceInterfacesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TAppliesTo <em>TApplies To</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TAppliesTo
	 * @generated
	 */
	public Adapter createTAppliesToAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TargetElementType <em>Target Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TargetElementType
	 * @generated
	 */
	public Adapter createTargetElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TargetInterfacesType <em>Target Interfaces Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TargetInterfacesType
	 * @generated
	 */
	public Adapter createTargetInterfacesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TArtifactReference <em>TArtifact Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TArtifactReference
	 * @generated
	 */
	public Adapter createTArtifactReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TArtifactTemplate <em>TArtifact Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TArtifactTemplate
	 * @generated
	 */
	public Adapter createTArtifactTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TArtifactType <em>TArtifact Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TArtifactType
	 * @generated
	 */
	public Adapter createTArtifactTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TBoundaryDefinitions <em>TBoundary Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TBoundaryDefinitions
	 * @generated
	 */
	public Adapter createTBoundaryDefinitionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TCapability <em>TCapability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TCapability
	 * @generated
	 */
	public Adapter createTCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TCapabilityDefinition <em>TCapability Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TCapabilityDefinition
	 * @generated
	 */
	public Adapter createTCapabilityDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TCapabilityRef <em>TCapability Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TCapabilityRef
	 * @generated
	 */
	public Adapter createTCapabilityRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TCapabilityType <em>TCapability Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TCapabilityType
	 * @generated
	 */
	public Adapter createTCapabilityTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TCondition <em>TCondition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TCondition
	 * @generated
	 */
	public Adapter createTConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TConstraint <em>TConstraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TConstraint
	 * @generated
	 */
	public Adapter createTConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TDefinitions <em>TDefinitions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TDefinitions
	 * @generated
	 */
	public Adapter createTDefinitionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TDeploymentArtifact <em>TDeployment Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TDeploymentArtifact
	 * @generated
	 */
	public Adapter createTDeploymentArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TDeploymentArtifacts <em>TDeployment Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TDeploymentArtifacts
	 * @generated
	 */
	public Adapter createTDeploymentArtifactsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TDocumentation <em>TDocumentation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TDocumentation
	 * @generated
	 */
	public Adapter createTDocumentationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TEntityTemplate <em>TEntity Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TEntityTemplate
	 * @generated
	 */
	public Adapter createTEntityTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TEntityType <em>TEntity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TEntityType
	 * @generated
	 */
	public Adapter createTEntityTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TExportedInterface <em>TExported Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TExportedInterface
	 * @generated
	 */
	public Adapter createTExportedInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TExportedOperation <em>TExported Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TExportedOperation
	 * @generated
	 */
	public Adapter createTExportedOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TExtensibleElements <em>TExtensible Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TExtensibleElements
	 * @generated
	 */
	public Adapter createTExtensibleElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TExtension <em>TExtension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TExtension
	 * @generated
	 */
	public Adapter createTExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TExtensions <em>TExtensions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TExtensions
	 * @generated
	 */
	public Adapter createTExtensionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TImplementationArtifact <em>TImplementation Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TImplementationArtifact
	 * @generated
	 */
	public Adapter createTImplementationArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TImplementationArtifacts <em>TImplementation Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TImplementationArtifacts
	 * @generated
	 */
	public Adapter createTImplementationArtifactsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TImport <em>TImport</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TImport
	 * @generated
	 */
	public Adapter createTImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TInterface <em>TInterface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TInterface
	 * @generated
	 */
	public Adapter createTInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TNodeTemplate <em>TNode Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TNodeTemplate
	 * @generated
	 */
	public Adapter createTNodeTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TNodeType <em>TNode Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TNodeType
	 * @generated
	 */
	public Adapter createTNodeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TNodeTypeImplementation <em>TNode Type Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TNodeTypeImplementation
	 * @generated
	 */
	public Adapter createTNodeTypeImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TOperation <em>TOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TOperation
	 * @generated
	 */
	public Adapter createTOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TParameter <em>TParameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TParameter
	 * @generated
	 */
	public Adapter createTParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TPlan <em>TPlan</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TPlan
	 * @generated
	 */
	public Adapter createTPlanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TPlans <em>TPlans</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TPlans
	 * @generated
	 */
	public Adapter createTPlansAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TPolicy <em>TPolicy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TPolicy
	 * @generated
	 */
	public Adapter createTPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TPolicyTemplate <em>TPolicy Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TPolicyTemplate
	 * @generated
	 */
	public Adapter createTPolicyTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TPolicyType <em>TPolicy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TPolicyType
	 * @generated
	 */
	public Adapter createTPolicyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TPropertyConstraint <em>TProperty Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TPropertyConstraint
	 * @generated
	 */
	public Adapter createTPropertyConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TPropertyMapping <em>TProperty Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TPropertyMapping
	 * @generated
	 */
	public Adapter createTPropertyMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TRelationshipTemplate <em>TRelationship Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TRelationshipTemplate
	 * @generated
	 */
	public Adapter createTRelationshipTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TRelationshipType <em>TRelationship Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TRelationshipType
	 * @generated
	 */
	public Adapter createTRelationshipTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TRelationshipTypeImplementation <em>TRelationship Type Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TRelationshipTypeImplementation
	 * @generated
	 */
	public Adapter createTRelationshipTypeImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TRequiredContainerFeature <em>TRequired Container Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TRequiredContainerFeature
	 * @generated
	 */
	public Adapter createTRequiredContainerFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TRequiredContainerFeatures <em>TRequired Container Features</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TRequiredContainerFeatures
	 * @generated
	 */
	public Adapter createTRequiredContainerFeaturesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TRequirement <em>TRequirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TRequirement
	 * @generated
	 */
	public Adapter createTRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TRequirementDefinition <em>TRequirement Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TRequirementDefinition
	 * @generated
	 */
	public Adapter createTRequirementDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TRequirementRef <em>TRequirement Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TRequirementRef
	 * @generated
	 */
	public Adapter createTRequirementRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TRequirementType <em>TRequirement Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TRequirementType
	 * @generated
	 */
	public Adapter createTRequirementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TServiceTemplate <em>TService Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TServiceTemplate
	 * @generated
	 */
	public Adapter createTServiceTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TTag <em>TTag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TTag
	 * @generated
	 */
	public Adapter createTTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TTags <em>TTags</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TTags
	 * @generated
	 */
	public Adapter createTTagsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TTopologyElementInstanceStates <em>TTopology Element Instance States</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TTopologyElementInstanceStates
	 * @generated
	 */
	public Adapter createTTopologyElementInstanceStatesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TTopologyTemplate <em>TTopology Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TTopologyTemplate
	 * @generated
	 */
	public Adapter createTTopologyTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.TypesType <em>Types Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.TypesType
	 * @generated
	 */
	public Adapter createTypesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.ValidSourceType <em>Valid Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.ValidSourceType
	 * @generated
	 */
	public Adapter createValidSourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.artist.migration.deployment.tosca.ValidTargetType <em>Valid Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.artist.migration.deployment.tosca.ValidTargetType
	 * @generated
	 */
	public Adapter createValidTargetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ToscaAdapterFactory
