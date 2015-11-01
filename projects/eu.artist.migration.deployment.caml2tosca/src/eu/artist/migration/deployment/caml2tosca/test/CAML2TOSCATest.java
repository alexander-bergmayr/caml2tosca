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
 * 
 */
package eu.artist.migration.deployment.caml2tosca.test;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.artist.migration.deployment.caml2tosca.CAML2TOSCALauncher;

public class CAML2TOSCATest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCAML2TOSCATemplates() throws IOException {
		CAML2TOSCALauncher launcher = new CAML2TOSCALauncher();
		launcher.runCAML2TOSCATemplates("model/HelloApp.uml", "model/HelloApp.tosca");
	}
	
	@Test
	public void testCAML2TOSCATypes() throws IOException {
		CAML2TOSCALauncher launcher = new CAML2TOSCALauncher();
		URI profileURI = URI.createPlatformPluginURI("eu.artist.migration.caml", true);
		profileURI = profileURI.appendSegments(new String[]{"umlprofiles", "AmazonAWSProfile.profile.uml"});
		// profileURI = profileURI.appendSegments(new String[]{"umlprofiles", "OpenStackProfile.profile.uml"});
		
		launcher.runCAML2TOSCATypes(profileURI, "model/NodeType_Test.tosca");
	}
	
	@Test
	public void testCAML2TOSCATypesWithOperation() throws IOException {
		CAML2TOSCALauncher launcher = new CAML2TOSCALauncher();
		String profilePath = "model/type-including-operation.profile.uml";
		URI profileURI = URI.createFileURI(new File(profilePath).getAbsolutePath());
		
		launcher.runCAML2TOSCATypes(profileURI, "model/type-including-operation.tosca");
	}

}
