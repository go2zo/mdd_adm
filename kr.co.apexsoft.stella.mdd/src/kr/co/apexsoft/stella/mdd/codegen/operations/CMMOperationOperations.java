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
	
	public static CMMOperation createCMMOperation(final Operation _operation) {
		CMMOperation cmmOp = new CMMOperation();
		
		cmmOp.setName(_operation.getName());
		cmmOp.setDescription(""); // TODO
		
		Parameter returnResult = _operation.getReturnResult();
		if (returnResult != null) {
			cmmOp.setReturnValue(createCMMType(returnResult.getType()));
		}
		
		cmmOp.setAbstract(_operation.isAbstract());
		cmmOp.setFinal(_operation.isLeaf());
		cmmOp.setStatic(_operation.isStatic());
		
		CMMVisibilityKind visibilityKind = getCMMVisibilityKind(_operation.getVisibility());
		cmmOp.setVisibilityKind(visibilityKind);
		
		List<Parameter> parameters = _operation.getOwnedParameters();
		for (Parameter param : parameters) {
			CMMParameter cmmParam = CMMParameterOperations.createCMMParameter(param);
			cmmOp.getParameters().add(cmmParam);
		}
		
		return cmmOp;
	}

}
