package kr.co.apexsoft.stella.mdd.codegen.operations;

import kr.co.apexsoft.stella.cmm.CMMAttribute;
import kr.co.apexsoft.stella.cmm.CMMVisibilityKind;

import org.eclipse.uml2.uml.Property;

public class CMMAttributeOperations extends CMMTypedElementOperations {
	
	protected CMMAttributeOperations() {
		
	}
	
	public static CMMAttribute createCMMAttribute(final Property element) {
		CMMAttribute cmmAttr = new CMMAttribute();
		
		cmmAttr.setName(element.getName());
		cmmAttr.setDescription(""); // TODO
		
		cmmAttr.setType(createCMMType(element.getType()));
		
		cmmAttr.setFinal(element.isLeaf());
		cmmAttr.setStatic(element.isStatic());
		
		CMMVisibilityKind visibilityKind = getCMMVisibilityKind(element.getVisibility());
		cmmAttr.setVisibilityKind(visibilityKind);
		
		return cmmAttr;
	}

}
