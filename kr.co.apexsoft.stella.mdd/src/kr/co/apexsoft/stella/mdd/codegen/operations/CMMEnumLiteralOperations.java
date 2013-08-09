package kr.co.apexsoft.stella.mdd.codegen.operations;

import kr.co.apexsoft.stella.cmm.CMMEnumLiteral;

import org.eclipse.uml2.uml.EnumerationLiteral;

public class CMMEnumLiteralOperations extends CMMElementOperations {

	public static CMMEnumLiteral createCMMEnumLiteral(final EnumerationLiteral element) {
		return createCMMEnumLiteral(element, 0);
	}
	
	public static CMMEnumLiteral createCMMEnumLiteral(final EnumerationLiteral element, final int value) {
		CMMEnumLiteral cmmEnumLiteral = new CMMEnumLiteral();
		
		cmmEnumLiteral.setName(element.getName());
		cmmEnumLiteral.setDescription(getDescription(element));
		
		cmmEnumLiteral.setLiteral(element.getName());
		cmmEnumLiteral.setValue(value);
		
		return cmmEnumLiteral;
	}

}
