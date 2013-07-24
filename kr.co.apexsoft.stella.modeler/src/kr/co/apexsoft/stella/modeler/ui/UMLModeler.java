package kr.co.apexsoft.stella.modeler.ui;

import java.net.URI;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Element;

import kr.co.apexsoft.stella.modeler.uml.IUMLDiagramHelper;
import kr.co.apexsoft.stella.modeler.uml.IUMLHelper;
import kr.co.apexsoft.stella.modeler.uml.IUMLUIHelper;

public class UMLModeler {

	private static IUMLHelper umlHelper;
	
	private static IUMLUIHelper umlUIHelper;
	
	private static IUMLDiagramHelper umlDiagramHelper;
	
	public static IUMLHelper getUMLHelper() {
		if (umlHelper == null) {
			umlHelper = IUMLHelper.INSTANCE;
		}
		return umlHelper;
	}
	
	public static IUMLUIHelper getUMLUIHelper() {
		if (umlUIHelper == null) {
			umlUIHelper = IUMLUIHelper.INSTANCE;
		}
		return umlUIHelper;
	}
	
	public static IUMLDiagramHelper getUMLDiagramHelper() {
		if (umlDiagramHelper == null) {
			umlDiagramHelper = IUMLDiagramHelper.INSTANCE;
		}
		return umlDiagramHelper;
	}
	
	public static Resource createFragment(URI fragementUri, EModelElement fragementRoot) {
		return null;
	}
	
	public static Resource createFragmentSilently(URI fragmentUri, EModelElement fragmentRoot, boolean refactorReferences) {
		return null;
	}
	
	public static <E extends Element> E createModelResource(Class<E> rootMetaclass, String file) {
		return createModelResource(rootMetaclass, URI.create(file));
	}
	
	public static <E extends Element> E createModelResource(Class<E> rootMetaclass, URI uri) {
		return null;
	}
	
	public static Element openModelResource(String file) {
		return openModelResource(URI.create(file));
	}
	
	public static Element openModelResource(URI uri) {
		return null;
	}
	
	public static void closeModelFragment(EObject element) {
		
	}
	
	public static void closeModelResource(Element element) {
		
	}
	
}
