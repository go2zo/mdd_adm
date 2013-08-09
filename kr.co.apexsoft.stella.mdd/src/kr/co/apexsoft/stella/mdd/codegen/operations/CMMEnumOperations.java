package kr.co.apexsoft.stella.mdd.codegen.operations;

import kr.co.apexsoft.stella.cmm.CMMEnum;

import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;

public class CMMEnumOperations extends CMMElementOperations {
	
	public enum aa{
		
	}
	
	protected CMMEnumOperations() {
		
	}
	
	public static CMMEnum transform(final Enumeration element) {
		CMMEnum cmmEnum = new CMMEnum();
		
		cmmEnum.setName(element.getName());
		cmmEnum.setDescription(getDescription(element));
		
		cmmEnum.setAbstract(element.isAbstract());
		cmmEnum.setFinal(element.isLeaf());
		
		for (EnumerationLiteral literal : element.getOwnedLiterals()) {
			cmmEnum.addEnumElement(CMMEnumLiteralOperations.createCMMEnumLiteral(literal));
		}
		
		return cmmEnum;
	}

}
