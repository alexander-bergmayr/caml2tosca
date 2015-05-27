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

package eu.artist.migration.deployment.caml2tosca;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData.EClassifierExtendedMetaData;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import eu.artist.migration.deployment.tosca.ToscaPackage;
import eu.artist.migration.deployment.tosca.util.ToscaUtil;

public class CAML2TOSCALauncher {
	
	private final String moduleLocation = "platform:/plugin/eu.artist.migration.deployment.caml2tosca/trafo/";
	private final String typesTrafo = "caml2toscaTypes";
	private final String templatesTrafo = "caml2toscaTemplates";
	
	public void runCAML2TOSCATypes(String toscaModelPath) throws IOException {
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		
		ResourceSet rs = new ResourceSetImpl();		
		rs.getPackageRegistry().put(ToscaPackage.eINSTANCE.getNsURI(), ToscaPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("genmodel", new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xsd", new XMLResourceFactoryImpl());
		
		rs.getPackageRegistry().put(UMLPackage.eINSTANCE.getNsURI(),
				UMLPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);	
		
		ToscaUtil.init(rs, "model/");
		
		// TODO: Maybe there is a better solution for 'resetting' the extended metadata
		// We changed the annotation already in the tosca.ecore
	    EClassifierExtendedMetaData.Holder holder = (EClassifierExtendedMetaData.Holder)ToscaPackage.eINSTANCE.getDefinitionsType();
	    EClassifierExtendedMetaData result = holder.getExtendedMetaData();
	    result.setName("Definitions");
		
		// Load metamodels
		Metamodel umlMM = EmftvmFactory.eINSTANCE.createMetamodel();
		umlMM.setResource(rs.getResource(URI.createURI("http://www.eclipse.org/uml2/4.0.0/UML"), true));
		env.registerMetaModel("UMLMM", umlMM);
		
		Metamodel toscaMM = EmftvmFactory.eINSTANCE.createMetamodel();
		toscaMM.setResource(rs.getResource(URI.createURI("http://docs.oasis-open.org/tosca/ns/2011/12"), true));
		env.registerMetaModel("TOSCA", toscaMM);

		//  ##### INPUT Models #####
		
		// the CAML library
		Model cL = EmftvmFactory.eINSTANCE.createModel();
		URI libraryURI = URI.createPlatformPluginURI("eu.artist.migration.caml", true);
		libraryURI = libraryURI.appendSegments(new String[]{"umllibraries", "CAMLLibrary.uml"});
		cL.setResource(rs.getResource(libraryURI, true));
		env.registerInputModel("CL", cL);
		
		// the CAML profile 
		Model cP = EmftvmFactory.eINSTANCE.createModel();
		URI profileURI = URI.createPlatformPluginURI("eu.artist.migration.caml", true);
		profileURI = profileURI.appendSegments(new String[]{"umlprofiles", "AmazonAWSProfile.profile.uml"});
		// profileURI = profileURI.appendSegments(new String[]{"umlprofiles", "OpenStackProfile.profile.uml"});
		cP.setResource(rs.getResource(profileURI, true));
		env.registerInputModel("CP", cP);
		
//		Model cCP = EmftvmFactory.eINSTANCE.createModel();
//		profileURI = URI.createPlatformPluginURI("eu.artist.migration.caml", true);
//		profileURI = profileURI.appendSegments(new String[]{"umlprofiles", "CommonCloudProfile.profile.uml"});
//		cCP.setResource(rs.getResource(profileURI, true));
//		env.registerInputModel("CCP", cCP);
		
		// ##### OUTPUT Modles ##### 
		
		// the TOSCA deployment model
		Model toscaM = EmftvmFactory.eINSTANCE.createModel();
		toscaM.setResource(rs.createResource(URI.createFileURI(new File(toscaModelPath).getAbsolutePath())));
		env.registerOutputModel("TM", toscaM);

		// Load and run module
		DefaultModuleResolver mr = new DefaultModuleResolver(moduleLocation, new ResourceSetImpl());
		TimingData td = new TimingData();
		env.loadModule(mr, typesTrafo);
		td.finishLoading();
		env.run(td);
		td.finish();
		

		toscaM.getResource().save(Collections.emptyMap());
	}

	public void runCAML2TOSCATemplates(String camlModelPath, String toscaModelPath) throws IOException {
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put(ToscaPackage.eINSTANCE.getNsURI(), ToscaPackage.eINSTANCE);
		rs.getPackageRegistry().put(UMLPackage.eINSTANCE.getNsURI(),
				UMLPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);	
		ToscaUtil.init(rs, "model/");
		
		// TODO: Maybe there is a better solution for 'resetting' the extended metadata
		// We changed the annotation already in the tosca.ecore
	    EClassifierExtendedMetaData.Holder holder = (EClassifierExtendedMetaData.Holder)ToscaPackage.eINSTANCE.getDefinitionsType();
	    EClassifierExtendedMetaData result = holder.getExtendedMetaData();
	    result.setName("Definitions");
		
		// Load metamodels
		Metamodel umlMM = EmftvmFactory.eINSTANCE.createMetamodel();
		umlMM.setResource(rs.getResource(URI.createURI("http://www.eclipse.org/uml2/4.0.0/UML"), true));
		env.registerMetaModel("UMLMM", umlMM);
		
		Metamodel toscaMM = EmftvmFactory.eINSTANCE.createMetamodel();
		toscaMM.setResource(rs.getResource(URI.createURI("http://docs.oasis-open.org/tosca/ns/2011/12"), true));
		env.registerMetaModel("TOSCA", toscaMM);

		//  ##### INPUT Models #####
		
		// the CAML deployment model
		Model umlM = EmftvmFactory.eINSTANCE.createModel();
		// umlM.setResource(rs.getResource(URI.createURI(camlModelPath, true), true));
		umlM.setResource(rs.getResource(URI.createFileURI(new File(camlModelPath).getAbsolutePath()), true));
		env.registerInputModel("UMLM", umlM);
		
		// the CAML library
		Model cL = EmftvmFactory.eINSTANCE.createModel();
		URI libraryURI = URI.createPlatformPluginURI("eu.artist.migration.caml", true);
		libraryURI = libraryURI.appendSegments(new String[]{"umllibraries", "CAMLLibrary.uml"});
		cL.setResource(rs.getResource(libraryURI, true));
		env.registerInputModel("CL", cL);
		
		// the CAML platfrom library
//		Model cPL = EmftvmFactory.eINSTANCE.createModel();
//		libraryURI = URI.createPlatformPluginURI("eu.artist.migration.caml.operatingenvironments", true);
//		libraryURI = libraryURI.appendSegments(new String[]{"umllibraries", "webOperatingEnvironment.uml"});
//		cPL.setResource(rs.getResource(libraryURI, true));
//		env.registerInputModel("CPL", cPL);
		
		// the CAML profile 
		Model cP = EmftvmFactory.eINSTANCE.createModel();
		URI profileURI = URI.createPlatformPluginURI("eu.artist.migration.caml", true);
		// profileURI = profileURI.appendSegments(new String[]{"umlprofiles", "GoogleAppEngineProfile.profile.uml"});
		// profileURI = profileURI.appendSegments(new String[]{"umlprofiles", "AmazonAWSProfile.profile.uml"});
		profileURI = profileURI.appendSegments(new String[]{"umlprofiles", "OpenStackProfile.profile.uml"});
		cP.setResource(rs.getResource(profileURI, true));
		env.registerInputModel("CP", cP);
		
		Model cCP = EmftvmFactory.eINSTANCE.createModel();
		profileURI = URI.createPlatformPluginURI("eu.artist.migration.caml", true);
		profileURI = profileURI.appendSegments(new String[]{"umlprofiles", "CommonCloudProfile.profile.uml"});
		cCP.setResource(rs.getResource(profileURI, true));
		env.registerInputModel("CCP", cCP);
		
		// ##### OUTPUT Modles ##### 
		
		// the TOSCA deployment model
		Model toscaM = EmftvmFactory.eINSTANCE.createModel();
		toscaM.setResource(rs.createResource(URI.createFileURI(new File(toscaModelPath).getAbsolutePath())));
		env.registerOutputModel("TM", toscaM);

		// Load and run module
		DefaultModuleResolver mr = new DefaultModuleResolver(moduleLocation, new ResourceSetImpl());
		TimingData td = new TimingData();
		env.loadModule(mr, templatesTrafo);
		td.finishLoading();
		env.run(td);
		td.finish();
		
		toscaM.getResource().save(Collections.emptyMap());
	}
	

}
