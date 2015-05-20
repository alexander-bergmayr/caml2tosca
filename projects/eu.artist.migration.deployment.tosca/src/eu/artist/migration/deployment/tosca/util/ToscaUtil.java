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

package eu.artist.migration.deployment.tosca.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.converter.ModelConverter.EPackageConvertInfo;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.exporter.ModelExporter.EPackageExportInfo;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xsd.ecore.exporter.XSDExporter;

/**
 * @author Alexander Bergmayr
 *
 */
public class ToscaUtil {
	
	static ResourceSet Resource_Set = null;
	static ExtendedMetaData Extended_Meta_Data = null;
	static Map<String, EPackage> Package_Map = null;
	static EAttribute Text_Attribute = null;
	
	static String Path = "";
	static final String Ecore_Model_Fragment = "Properties.ecore";
	static final String Xsd_Model_Fragment = "Properties.xsd"; 
	
	public static void init(ResourceSet resourceSet, String path) {
		Resource_Set = resourceSet;
		Extended_Meta_Data = new BasicExtendedMetaData(resourceSet.getPackageRegistry());
		Package_Map = new HashMap<String, EPackage>();
		Text_Attribute = (EAttribute) XMLTypeFactory.eINSTANCE.createXMLTypeDocumentRoot().eClass().getEStructuralFeature("text");
		Path = path;
	}
	
	public static EPackage createTEPackage(String nsPrefix, String nsURI) {
		// create the EPackage of the temporary metamodel if it does not exist already
		if(!Package_Map.containsKey(nsURI)) {
			EPackage tPackage = EcoreFactory.eINSTANCE.createEPackage();
			tPackage.setNsPrefix(nsPrefix);
			tPackage.setNsURI(nsURI);
	
			// create the document root to which the temporary EReferences are added
			EClass documentRoot = EcoreFactory.eINSTANCE.createEClass();
			documentRoot.setName("DocumentRoot");
			
			// add the document root to the created package and add the package to the global map
			tPackage.getEClassifiers().add(documentRoot);
			Package_Map.put(nsURI, tPackage);			
			return tPackage;
		} else {
			return Package_Map.get(nsURI);
		}
	}
	
	public static EReference createTEReference(String nsPrefix, String nsURI, String name) {
		// if the package / document root does not exist yet then create it
		if(Package_Map.get(nsURI) == null) {
			createTEPackage(nsPrefix, nsURI);
		}
		
		EClass documentRoot = (EClass) Package_Map.get(nsURI).getEClassifier("DocumentRoot");
		EReference feature = (EReference) documentRoot.getEStructuralFeature(name);
		
		if(feature == null) {
			EReference propertiesTypeFeature = EcoreFactory.eINSTANCE.createEReference();
			propertiesTypeFeature.setName(name);		
			propertiesTypeFeature.setEType(EcorePackage.eINSTANCE.getEClassifier("EObject"));
			propertiesTypeFeature.setContainment(true);
			propertiesTypeFeature.setUpperBound(-2);
			// the container of the feature is the document root
			documentRoot.eClass().getEStructuralFeatures().add(propertiesTypeFeature);
			// set the namespace of the feature
			Extended_Meta_Data.setNamespace(propertiesTypeFeature, nsURI);
			// how should the feature be represented in XML: element vs. attribute
			Extended_Meta_Data.setFeatureKind(propertiesTypeFeature, ExtendedMetaData.ELEMENT_FEATURE);
			
			return propertiesTypeFeature;
		} else {
			return feature;
		}
	}
	
	// TODO: Pass the set of properties for which map entries should be created!
	public static FeatureMap.Entry createContainmentFeatureMapEntry(String nsPrefix, String nsURI, String name, Element base, Stereotype refinement) {
		AnyType anyType = XMLTypeFactory.eINSTANCE.createAnyType();
		
		// create for each property of the refinement an EReference and the SimpleFeatureMapEntry
		for(Property property : refinement.getAllAttributes()) {
			if(!property.getName().startsWith("base_")) {
				AnyType anyTypeForProperty = XMLTypeFactory.eINSTANCE.createAnyType();
				SimpleFeatureMapEntry simpleFeatureMapEntry = new SimpleFeatureMapEntry((EStructuralFeature.Internal) Text_Attribute, getStringRepresentation(base.getValue(refinement, property.getName())));
				anyTypeForProperty.getMixed().add(simpleFeatureMapEntry);
				
				EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry containmentFeatureMapEntry = 
						new EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry((EStructuralFeature.Internal) createTEReference(nsPrefix, nsURI, property.getName()), (InternalEObject) anyTypeForProperty);
			
				anyType.getMixed().add(containmentFeatureMapEntry);
			}
		}
		
		return new EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry((EStructuralFeature.Internal) createTEReference(nsPrefix, nsURI, name), 
				(InternalEObject) anyType); 		
	}
	
	public static FeatureMap.Entry createFeatureMapEntryForSlots(String nsPrefix, String nsURI, String name, Collection<Slot> slots) {
		AnyType anyType = XMLTypeFactory.eINSTANCE.createAnyType();
		
		// create for each property of the refinement an EReference and the SimpleFeatureMapEntry
		for(Slot slot : slots) {
			AnyType anyTypeForProperty = XMLTypeFactory.eINSTANCE.createAnyType();
			// TODO: What about list of values! -> currently we take the first value only
			SimpleFeatureMapEntry simpleFeatureMapEntry = new SimpleFeatureMapEntry((EStructuralFeature.Internal) Text_Attribute, getStringRepresentation(slot.getValues().get(0)));
			anyTypeForProperty.getMixed().add(simpleFeatureMapEntry);
			
			EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry containmentFeatureMapEntry = 
					new EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry((EStructuralFeature.Internal) createTEReference(nsPrefix, nsURI, slot.getDefiningFeature().getName()), (InternalEObject) anyTypeForProperty);
		
			anyType.getMixed().add(containmentFeatureMapEntry);
		}
		
		return new EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry((EStructuralFeature.Internal) createTEReference(nsPrefix, nsURI, name), 
				(InternalEObject) anyType); 		
	}
	
	public static String getStringRepresentation(Object obj) {
		String value = "";
		if(obj instanceof EnumerationLiteral) {
			value = ((EnumerationLiteral) obj).getName();
		} else if(obj instanceof PrimitiveType) {
			// TODO: CHECK!
			value = ((PrimitiveType) obj).toString();
		} else if(obj instanceof LiteralString) {
			value = ((LiteralString) obj).getValue();
		} else {
			value = obj.toString();
		}
		return value;
	}
	
	public static String createPropertiesDefinition(Classifier classifier) throws Exception {		
		EPackage _package = EcoreFactory.eINSTANCE.createEPackage();
		EClass propertyDefinition = EcoreFactory.eINSTANCE.createEClass();
		GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		ExtendedMetaData extendedMetaData = genModel.getExtendedMetaData();
		
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		String propertiesDefinition = "";
		
		for(Property property : classifier.getAttributes()) {
			// consider attributes only if they aren't members of an association
			if(property.getAssociation() == null) {
				EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
				attribute.setName(property.getName());
				attribute.setUnsettable(true);
				
				// create an EEnum in case of enumeration
				if(property.getType() instanceof Enumeration) {
					Enumeration enumeration = (Enumeration) property.getType(); 
					EEnum eenumeration = EcoreFactory.eINSTANCE.createEEnum();
					eenumeration.setName(enumeration.getName());
					
					int literalValue = 0;
					for(EnumerationLiteral literal : enumeration.getOwnedLiterals()) {
						EEnumLiteral eliteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
						eliteral.setName(literal.getName());
						eliteral.setValue(literalValue);
						literalValue++;
						eenumeration.getELiterals().add(eliteral);
					}
					
					_package.getEClassifiers().add(eenumeration);
					attribute.setEType(eenumeration);
				}
				else {
					attribute.setEType(XMLTypePackage.eINSTANCE.getString());
				}
				propertyDefinition.getEStructuralFeatures().add(attribute);
				extendedMetaData.setFeatureKind(attribute, ExtendedMetaData.ELEMENT_FEATURE);
				features.add(attribute);
			}
		}
		
		if(!features.isEmpty()) {
			// first step: create an Ecore metamodel		
			URI uri = URI.createFileURI(new File(Path + classifier.getName() + Ecore_Model_Fragment).getAbsolutePath());
			Resource resource = Resource_Set.createResource(uri);

			_package.setName(classifier.getName() + "Properties");
			_package.setNsPrefix(classifier.getName() + "Properties");
			_package.setNsURI("http://" + classifier.getName() + "Properties");
			resource.getContents().add(_package);
			propertyDefinition.setName("Properties");
			_package.getEClassifiers().add(propertyDefinition);
			
			// second step: derive the GenModel from the metamodel
			genModel.setComplianceLevel(GenJDKLevel.JDK70_LITERAL);		 
			genModel.setModelDirectory("");
			genModel.setModelName(_package.getName());
			genModel.initialize(Collections.singleton(_package));
				
			// third step: export the XSD from the GenModel			
			XSDExporter modelExporter = new XSDExporter();
			modelExporter.setGenModel(genModel);
			modelExporter.getEPackages().add(_package);
			EPackageConvertInfo convertInfo = modelExporter.getEPackageConvertInfo(_package);
			convertInfo.setConvert(true);
			EPackageExportInfo exportInfo = modelExporter.getEPackageExportInfo(_package);
			exportInfo.setArtifactLocation(Path + classifier.getName() + Xsd_Model_Fragment);
			modelExporter.export(null); 
			
			// the name of the properties definition; it allows node types to reference it
			propertiesDefinition = classifier.getName() + "Properties";
		}
		return propertiesDefinition;
	}

}
