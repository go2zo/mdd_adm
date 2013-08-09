package kr.co.apexsoft.stella.cmm;

public class CMMDecisionMarkingElement implements CMMStatement {

	@Override
	public CMMStatementType getType() {
		return CMMStatementType.DECISION_MARKING;
	}

}
