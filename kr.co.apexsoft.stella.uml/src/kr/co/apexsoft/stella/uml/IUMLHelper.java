package kr.co.apexsoft.stella.uml;

import java.util.Set;

import kr.co.apexsoft.stella.uml.internal.UMLHelper;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

public interface IUMLHelper {
	
	IUMLHelper INSTANCE = UMLHelper.init(); 
			
	Element findElement(Element root, String id);
	Element findElement(Element root, String id, IProgressMonitor monitor);
	Set<Element> findElementByName(Element container, String name, EClass type, IProgressMonitor monitor);
	
	Set<Class> getAllClasses(Interaction container);
	Set<Property> getAllAttributes(Classifier container);
	Property getAttribute(Classifier container, String attrName);
	Set<Operation> getAllOperations(Classifier container);
	Set<Operation> getOperations(Classifier container, String operName);
	Set<Interaction> getAllInteractions(Collaboration container);
}
