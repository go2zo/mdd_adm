package kr.co.apexsoft.stella.cmm;

public enum CMMVisibilityKind {
	PUBLIC, PRIVATE, PROTECTED, PACKAGE;

	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

}
