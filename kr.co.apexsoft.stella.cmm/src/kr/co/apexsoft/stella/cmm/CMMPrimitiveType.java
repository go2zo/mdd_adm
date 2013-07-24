package kr.co.apexsoft.stella.cmm;

public enum CMMPrimitiveType implements CMMType {
	VOID, INT, CHAR, BOOLEAN, STRING;

	@Override
	public String getName() {
		return name();
	}

}
