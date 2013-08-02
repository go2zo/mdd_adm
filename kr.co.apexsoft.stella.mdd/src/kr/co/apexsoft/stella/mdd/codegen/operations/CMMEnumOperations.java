package kr.co.apexsoft.stella.mdd.codegen.operations;

import kr.co.apexsoft.stella.cmm.CMMEnum;

import org.eclipse.uml2.uml.Enumeration;

public class CMMEnumOperations extends CMMElementOperations {
	
	protected CMMEnumOperations() {
		
	}
	
	public static CMMEnum transform(Enumeration enumeration) {
		CMMEnum cmmEnum = new CMMEnum();
		return cmmEnum;
	}

}
