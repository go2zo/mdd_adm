package kr.co.apexsoft.stella.cmm;

public class CMMEnumLiteral extends CMMAbstractElement {

	private int value;
	
	private String literal;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getLiteral() {
		return literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}
	
}
