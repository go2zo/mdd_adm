package kr.co.apexsoft.stella.cmm;

public class CMMLoopStatement extends CMMContainerStatement {

	private String initialization;
	
	private String expression;
	
	private String update;

	public String getInitialization() {
		return initialization;
	}

	public void setInitialization(String initialization) {
		this.initialization = initialization;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	@Override
	public CMMStatementType getType() {
		return CMMStatementType.LOOP;
	}
	
}
