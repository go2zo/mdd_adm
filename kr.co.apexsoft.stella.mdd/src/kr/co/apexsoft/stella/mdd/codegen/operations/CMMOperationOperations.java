package kr.co.apexsoft.stella.mdd.codegen.operations;

import java.util.List;

import kr.co.apexsoft.stella.cmm.CMMOperation;
import kr.co.apexsoft.stella.cmm.CMMParameter;
import kr.co.apexsoft.stella.cmm.CMMVisibilityKind;

import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;

public class CMMOperationOperations extends CMMTypedElementOperations {

	protected CMMOperationOperations() {
		
	}
	
	public static CMMOperation createCMMOperation(final Operation element) {
		CMMOperation cmmOp = new CMMOperation();
		
		cmmOp.setName(element.getName());
		cmmOp.setDescription(getDescription(element));
		
		Parameter returnResult = element.getReturnResult();
		if (returnResult != null) {
			cmmOp.setReturnValue(createCMMType(returnResult.getType()));
		}
		
		cmmOp.setAbstract(element.isAbstract());
		cmmOp.setFinal(element.isLeaf());
		cmmOp.setStatic(element.isStatic());
		
		CMMVisibilityKind visibilityKind = getCMMVisibilityKind(element.getVisibility());
		cmmOp.setVisibilityKind(visibilityKind);
		
		List<Parameter> parameters = element.getOwnedParameters();
		for (Parameter param : parameters) {
			CMMParameter cmmParam = CMMParameterOperations.createCMMParameter(param);
			cmmOp.getParameters().add(cmmParam);
		}
		
		return cmmOp;
	}

}
