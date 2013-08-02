package kr.co.apexsoft.stella.mdd.codegen.operations;

import java.util.List;

import kr.co.apexsoft.stella.cmm.CMMAttribute;
import kr.co.apexsoft.stella.cmm.CMMClass;
import kr.co.apexsoft.stella.cmm.CMMNamespace;
import kr.co.apexsoft.stella.cmm.CMMOperation;
import kr.co.apexsoft.stella.cmm.CMMVisibilityKind;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

public class CMMClassOperations extends CMMElementOperations {

	public static CMMClass createCMMClass(Class _class) {
		CMMClass cmmClass = new CMMClass();
		
		cmmClass.setName(_class.getName());
		cmmClass.setDescription(""); // TODO
		
		cmmClass.setAbstract(_class.isAbstract());
		cmmClass.setFinal(_class.isLeaf());
		
		CMMVisibilityKind visibilityKind = getCMMVisibilityKind(_class.getVisibility());
		cmmClass.setVisibilityKind(visibilityKind);
		
		CMMNamespace namespace = CMMNamespaceOperations.createCMMNamespace(_class);
		cmmClass.setNamespace(namespace);

		List<Property> attributes = _class.getOwnedAttributes();
		for (Property attr : attributes) {
			CMMAttribute cmmAttr = CMMAttributeOperations.createCMMAttribute(attr);
			cmmClass.getAttributes().add(cmmAttr);
		}
		
		List<Operation> operations = _class.getAllOperations();
		for (Operation op : operations) {
			CMMOperation cmmOp = CMMOperationOperations.createCMMOperation(op);
			cmmClass.getOperations().add(cmmOp);
		}
		
		return cmmClass;
	}
	
}
