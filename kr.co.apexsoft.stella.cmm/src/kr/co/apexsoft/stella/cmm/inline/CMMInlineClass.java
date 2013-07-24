package kr.co.apexsoft.stella.cmm.inline;

import kr.co.apexsoft.stella.cmm.CMMClass;

public class CMMInlineClass extends CMMClass implements CMMInlineElement {

	private boolean isStatic;

	@Override
	public boolean isStatic() {
		return isStatic;
	}

	@Override
	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}
	
}
