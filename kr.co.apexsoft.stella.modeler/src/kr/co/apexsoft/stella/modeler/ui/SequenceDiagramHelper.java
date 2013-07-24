package kr.co.apexsoft.stella.modeler.ui;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

public class SequenceDiagramHelper {

	private static String getOrderedText(String name) {
		return name;
	}

	public static Lifeline createLifeline(Interaction container, Type element) {
		return createLifeline(container, element, element.getName());
	}
	
	public static Lifeline createLifeline(Interaction container, Type element, String propName) {
		if (propName == null || propName.equals("")) {
			propName = getOrderedText("Property");
		}
		
		Property property = UMLFactory.eINSTANCE.createProperty();
		property.setType(element);
		property.setName(propName);
		
		return createLifeline(container, property);
	}
	
	public static Lifeline createLifeline(Interaction container, ConnectableElement represents) {
		return createLifeline(container, represents, represents.getName());
	}
	
	public static Lifeline createLifeline(Interaction container, ConnectableElement represents, String lifelineName) {
		if (lifelineName == null || lifelineName.equals("")) {
			lifelineName = getOrderedText("Lifeline");
		}
		
		Lifeline lifeline = UMLFactory.eINSTANCE.createLifeline();
		lifeline.setRepresents(represents);
		lifeline.setName(lifelineName);
		
		return createLifeline(container, lifeline);
	}
	
	public static Lifeline createLifeline(Interaction container, Lifeline lifeline) {
		Package p = UMLFactory.eINSTANCE.createPackage();

		return null;
	}
	
}
