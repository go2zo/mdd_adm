package kr.co.apexsoft.stella.cmm;

public enum CMMPrimitiveType implements CMMType {
	VOID, INT, CHAR, BOOLEAN;

	@Override
	public String getName() {
		return name();
	}

}
