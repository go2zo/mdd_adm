package kr.co.apexsoft.stella.cmm.inline;

import kr.co.apexsoft.stella.cmm.CMMElement;

public interface CMMInlineElement extends CMMElement {
	boolean isStatic();
	void setStatic(boolean isStatic);
}
