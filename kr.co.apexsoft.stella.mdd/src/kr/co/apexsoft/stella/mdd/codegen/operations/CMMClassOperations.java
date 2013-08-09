package kr.co.apexsoft.stella.mdd.codegen.operations;

import java.util.List;

import kr.co.apexsoft.stella.cmm.CMMAttribute;
import kr.co.apexsoft.stella.cmm.CMMClass;
import kr.co.apexsoft.stella.cmm.CMMNamespace;
import kr.co.apexsoft.stella.cmm.CMMOperation;
import kr.co.apexsoft.stella.cmm.CMMVisibilityKind;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

public class CMMClassOperations extends CMMElementOperations {

	public static CMMClass createCMMClass(final Class element) {
		CMMClass cmmClass = new CMMClass();
		
		cmmClass.setName(element.getName());
		cmmClass.setDescription(getDescription(element));
		
		cmmClass.setAbstract(element.isAbstract());
		cmmClass.setFinal(element.isLeaf());
		
		CMMVisibilityKind visibilityKind = getCMMVisibilityKind(element.getVisibility());
		cmmClass.setVisibilityKind(visibilityKind);
		
		CMMNamespace namespace = CMMNamespaceOperations.createCMMNamespace(element);
		cmmClass.setNamespace(namespace);

		List<Property> attributes = element.getOwnedAttributes();
		for (Property attr : attributes) {
			CMMAttribute cmmAttr = CMMAttributeOperations.createCMMAttribute(attr);
			cmmClass.getAttributes().add(cmmAttr);
		}
		
		List<Operation> operations = element.getAllOperations();
		for (Operation op : operations) {
			CMMOperation cmmOp = CMMOperationOperations.createCMMOperation(op);
			cmmClass.getOperations().add(cmmOp);
		}
		
		return cmmClass;
	}
	
	public static CMMClass createCMMClass(Interface element) {
		CMMClass cmmClass = new CMMClass();
		
		cmmClass.setName(element.getName());
		cmmClass.setDescription(getDescription(element));
		
		cmmClass.setAbstract(element.isAbstract());
		cmmClass.setFinal(element.isLeaf());
		
		CMMVisibilityKind visibilityKind = getCMMVisibilityKind(element.getVisibility());
		cmmClass.setVisibilityKind(visibilityKind);
		
		CMMNamespace namespace = CMMNamespaceOperations.createCMMNamespace(element);
		cmmClass.setNamespace(namespace);

		List<Property> attributes = element.getOwnedAttributes();
		for (Property attr : attributes) {
			CMMAttribute cmmAttr = CMMAttributeOperations.createCMMAttribute(attr);
			cmmClass.getAttributes().add(cmmAttr);
		}
		
		List<Operation> operations = element.getAllOperations();
		for (Operation op : operations) {
			CMMOperation cmmOp = CMMOperationOperations.createCMMOperation(op);
			cmmClass.getOperations().add(cmmOp);
		}
		
		return cmmClass;
	}
	
}
