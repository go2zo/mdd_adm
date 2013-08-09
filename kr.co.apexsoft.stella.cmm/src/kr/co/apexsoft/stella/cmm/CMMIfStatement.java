package kr.co.apexsoft.stella.cmm;

import java.util.Iterator;

public class CMMIfStatement extends CMMContainerStatement implements Iterator<CMMIfStatement> {

	private String condition;
	
	private CMMIfStatement next;
	
	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public CMMIfStatement append(CMMIfStatement next) {
		return this.next = next;
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}
	@Override
	public CMMIfStatement next() {
		return next;
	}
	@Override
	public void remove() {
		
	}

	@Override
	public CMMStatementType getType() {
		return CMMStatementType.DECISION_MARKING;
	}

}
