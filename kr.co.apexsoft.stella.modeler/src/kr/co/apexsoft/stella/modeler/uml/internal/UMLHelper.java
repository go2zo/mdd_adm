package kr.co.apexsoft.stella.modeler.uml.internal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import kr.co.apexsoft.stella.modeler.uml.IUMLHelper;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class UMLHelper implements IUMLHelper {
	
	public static IUMLHelper init() {
		return new UMLHelper();
	}

	@Override
	public Element findElement(Element root, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element findElement(Element root, String id, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Element> findElementByName(Element container, String name,
			EClass type, IProgressMonitor monitor) {
		Set<Element> result = new HashSet<>();
		
		EList<Element> elements = container.getOwnedElements();
		for (int i = 0; i < elements.size(); i++) {
			Element element = elements.get(i);
			
		}
		return result;
	}

	@Override
	public Set<Class> getAllClasses(Interaction _interaction) {
		Set<Class> classes = new HashSet<Class>();
		
		EList<Lifeline> lifelines = _interaction.getLifelines();
		for (int i = 0; i < lifelines.size(); i++) {
			Lifeline lifeline = lifelines.get(i);
			Property property = (Property) lifeline.getRepresents();
			
			if (property != null) {
				Type type = property.getType();
				
				if (type instanceof Class) {
					classes.add((Class) type);
				}
			}
		}
		
		return classes;
	}

	@Override
	public Set<Property> getAllAttributes(Classifier _classifier) {
		Set<Property> attributes = new HashSet<Property>();
		
		attributes.addAll(_classifier.getAllAttributes());
		
		List<DirectedRelationship> directedRelationships = _classifier.getSourceDirectedRelationships();
		for (int i = 0; i < directedRelationships.size(); i++) {
			DirectedRelationship directedRelationship = directedRelationships.get(i);
			Iterator<Element> iteratorSupplier = directedRelationship.getTargets().iterator();
			while (iteratorSupplier.hasNext()) {
				Element tempType = iteratorSupplier.next();
				if (tempType instanceof Classifier) {
					attributes.addAll(getAllAttributes((Classifier) tempType));
				}
			}
			
		}
		
		return attributes;
	}

	@Override
	public Property getAttribute(Classifier _classifier, String attrName) {
		Property attribute = _classifier.getAttribute(attrName, null);
		
		if (attribute == null) {
			Set<Property> attributes = getAllAttributes(_classifier);
		
			Iterator<Property> iterator = attributes.iterator();
			while (iterator.hasNext()) {
				Property temp = iterator.next();
				if (attrName.equals(temp.getName())) {
					attribute = temp;
					break;
				}
			}
		}
		
		return attribute;
	}

	@Override
	public Set<Interaction> getAllInteractions(Collaboration container) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Operation> getAllOperations(Classifier container) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Operation> getOperations(Classifier container, String operName) {
		// TODO Auto-generated method stub
		return null;
	}

}
