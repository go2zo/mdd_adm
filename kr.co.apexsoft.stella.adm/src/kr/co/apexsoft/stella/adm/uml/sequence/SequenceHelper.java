package kr.co.apexsoft.stella.adm.uml.sequence;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public class SequenceHelper {

	private static String getOrderedText(String text) {
		return text;
	}

	private static String getType(View view, Element element) {
		return UMLVisualIDRegistry.getType(UMLVisualIDRegistry.
				getNodeVisualID(view, element));
	}

	public static Diagram createDiagram(Package _package, String name) {
		Collaboration collaboration = (Collaboration) _package
				.createPackagedElement(name, UMLPackage.Literals.COLLABORATION);
		collaboration.createClassifierBehavior(name, UMLPackage.Literals.INTERACTION);
		return null;
	}
	
	public static Lifeline createLifeline(Interaction container, Type element) {
		return createLifeline(container, element, element.getName(), element.getName());
	}

	public static Lifeline createLifeline(Interaction container,
			Type element, String name, String propName) throws 
			IllegalArgumentException, NullPointerException {
		if (name == null || propName == null) {
			throw new NullPointerException();
		} else if (name.equals("") || propName.equals("")) {
			throw new IllegalArgumentException();
		}

		propName = getOrderedText(propName);

		Property property = UMLFactory.eINSTANCE.createProperty();
		property.setType(element);
		property.setName(propName);

		return createLifeline(container, property, name);
	}

	public static Lifeline createLifeline(Interaction container,
			ConnectableElement represents) {
		return createLifeline(container, represents, represents.getName());
	}

	public static Lifeline createLifeline(Interaction container,
			ConnectableElement represents, String name) throws
			IllegalArgumentException, NullPointerException {
		if (name == null) {
			throw new NullPointerException();
		} else if (name.equals("")) {
			throw new IllegalArgumentException();
		}

		Lifeline lifeline = createLifeline(container, name);
		lifeline.setRepresents(represents);
		return lifeline;
	}

	public static Lifeline createLifeline(Interaction container, String name) {
		name = getOrderedText(name);

		Lifeline lifeline = container.createLifeline(name);
		return lifeline;
	}

	public static Node drawLifeline(Diagram diagram, Lifeline lifeline) {
		return ViewService.createNode(diagram, lifeline, getType(diagram, lifeline),
				UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
	}

	public static Node drawLifeline(Diagram diagram, Type element) {
		EObject container = diagram.getElement();
		Lifeline lifeline = null;
		if (container instanceof Interaction) {
			lifeline = createLifeline((Interaction) container, element);
		}
		return drawLifeline(diagram, lifeline);
	}

	public static Node drawLifeline(Diagram diagram, ConnectableElement represents) {
		EObject container = diagram.getElement();
		Lifeline lifeline = null;
		if (container instanceof Interaction) {
			lifeline = createLifeline((Interaction) container, represents);
		}
		return drawLifeline(diagram, lifeline);
	}

	public static Node drawCombinedFragment(Diagram diagram, String type) {
		// TODO
		return null;
	}

	public static Edge drawMessage(Lifeline source, Lifeline target, String type) {
		// TODO
		return null;
	}

}
