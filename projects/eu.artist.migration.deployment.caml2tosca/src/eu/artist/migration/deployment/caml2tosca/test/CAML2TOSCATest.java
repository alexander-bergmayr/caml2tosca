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

import java.io.IOException;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.artist.migration.deployment.caml2tosca.CAML2TOSCALauncher;
import eu.artist.migration.deployment.tosca.util.ToscaResourceFactoryImpl;

/**
 * @author abergmay
 *
 */
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
		// launcher.runCAML2TOSCATemplates("model/HelloApp.uml", "model/HelloApp.tosca");
		launcher.runCAML2TOSCATemplates("D:\\03_DEVELOPMENT\\workspace-eclipse-luna\\test\\HelloApp.uml",
				"D:\\03_DEVELOPMENT\\workspace-eclipse-luna\\test\\HelloApp.tosca");
	}
	
	@Test
	public void testCAML2TOSCATypes() throws IOException {
		CAML2TOSCALauncher launcher = new CAML2TOSCALauncher();
		launcher.runCAML2TOSCATypes("model/NodeType_Test.tosca");
	}

}
