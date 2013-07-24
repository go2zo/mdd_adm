package kr.co.apexsoft.stella.cmm.inline;

import kr.co.apexsoft.stella.cmm.CMMEnum;

public class CMMInlineEnum extends CMMEnum implements CMMInlineElement {

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
