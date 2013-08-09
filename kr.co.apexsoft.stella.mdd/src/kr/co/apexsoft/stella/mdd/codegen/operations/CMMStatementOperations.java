package kr.co.apexsoft.stella.mdd.codegen.operations;

import java.util.List;

import kr.co.apexsoft.stella.cmm.CMMIfStatement;
import kr.co.apexsoft.stella.cmm.CMMLoopStatement;
import kr.co.apexsoft.stella.cmm.CMMStatement;

import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;

public class CMMStatementOperations {

	protected CMMStatementOperations() {
		
	}
	
	public static CMMStatement createCMMStatement(InteractionFragment fragment) {
		return null;
	}

	public static CMMStatement createCMMStatement(CombinedFragment _cFragment) {
		CMMStatement cmmStatement = null;
		
		InteractionOperatorKind ioKind = _cFragment.getInteractionOperator();
		if (InteractionOperatorKind.ALT_LITERAL.equals(ioKind)) {
			cmmStatement = createCMMIfStatement(_cFragment);
		} else if (InteractionOperatorKind.LOOP_LITERAL.equals(ioKind)) {
			cmmStatement = createCMMLoopStatement(_cFragment);
		}
		
		return cmmStatement;
	}
	
	private static CMMIfStatement createCMMIfStatement(CombinedFragment fragment) {
		CMMIfStatement ifStatement = null;
		CMMIfStatement tmpStatement = null;
		
		List<InteractionOperand> operands = fragment.getOperands();
		for (int i = 0; i < operands.size(); i++) {
			tmpStatement = new CMMIfStatement();
			tmpStatement.setCondition("condition"); //TODO
			
			if (i == 0) {
				ifStatement = tmpStatement;
			} else if (tmpStatement != null) {
				tmpStatement = tmpStatement.append(tmpStatement);
			}
		}
		
		return ifStatement;
	}
	
	private static CMMLoopStatement createCMMLoopStatement(CombinedFragment _cFragment) {
		CMMLoopStatement loopStatement = null;
		
		List<InteractionOperand> operands = _cFragment.getOperands();
		if (operands != null && operands.size() > 0) {
			InteractionOperand operand = operands.get(0);

			loopStatement = new CMMLoopStatement();
			loopStatement.setInitialization("int i = 0"); //TODO
			loopStatement.setExpression("i < 10"); //TODO
			loopStatement.setUpdate("i += 1"); //TODO
		}
		
		return loopStatement;
	}
	
}
