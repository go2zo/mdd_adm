package kr.co.apexsoft.stella.mdd.codegen.operations;

import kr.co.apexsoft.stella.cmm.CMMAttribute;
import kr.co.apexsoft.stella.cmm.CMMVisibilityKind;

import org.eclipse.uml2.uml.Property;

public class CMMAttributeOperations extends CMMTypedElementOperations {
	
	protected CMMAttributeOperations() {
		
	}
	
	public static CMMAttribute createCMMAttribute(final Property _attribute) {
		CMMAttribute cmmAttr = new CMMAttribute();
		
		cmmAttr.setName(_attribute.getName());
		cmmAttr.setDescription(""); // TODO
		
		cmmAttr.setType(createCMMType(_attribute.getType()));
		
		cmmAttr.setFinal(_attribute.isLeaf());
		cmmAttr.setStatic(_attribute.isStatic());
		
		CMMVisibilityKind visibilityKind = getCMMVisibilityKind(_attribute.getVisibility());
		cmmAttr.setVisibilityKind(visibilityKind);
		
		return cmmAttr;
	}

}
