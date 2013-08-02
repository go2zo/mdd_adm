package kr.co.apexsoft.stella.cmm;

public abstract class CMMTypedElement extends CMMFinalElement {
	
	private CMMType type;

	public CMMType getType() {
		return type;
	}

	public void setType(CMMType type) {
		this.type = type;
	}
	
	
}
