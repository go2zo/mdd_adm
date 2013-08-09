package kr.co.apexsoft.stella.mdd.codegen.operations;

import org.eclipse.uml2.uml.Parameter;

import kr.co.apexsoft.stella.cmm.CMMParameter;

public class CMMParameterOperations extends CMMTypedElementOperations {

	protected CMMParameterOperations() {
		
	}
	
	public static CMMParameter createCMMParameter(final Parameter element) {
		CMMParameter cmmParam = new CMMParameter();
		
		cmmParam.setName(element.getName());
		cmmParam.setDescription(getDescription(element));

		cmmParam.setType(createCMMType(element.getType()));
		
		return cmmParam;
	}
}
