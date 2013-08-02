package kr.co.apexsoft.stella.cmm;

public abstract class CMMFinalElement extends CMMAbstractElement {

	private boolean isFinal;
	
	public boolean isFinal() {
		return isFinal;
	}
	
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
}
