package kr.co.apexsoft.stella.cmm;

public class CMMCallStatement implements CMMStatement {

	private boolean isReturn;
	
	private CMMNamedElement calledElement;
	
	public boolean isReturn() {
		return isReturn;
	}
	
	public void setReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}

	public CMMNamedElement getCalledElement() {
		return calledElement;
	}

	public void setCalledElement(CMMNamedElement calledElement) {
		this.calledElement = calledElement;
	}
}
