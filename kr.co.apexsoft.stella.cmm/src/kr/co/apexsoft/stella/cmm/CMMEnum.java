package kr.co.apexsoft.stella.cmm;

import java.util.ArrayList;
import java.util.List;

public class CMMEnum extends CMMPackageableElement {

	private List<CMMEnumElement> enumElements;
	
	public List<CMMEnumElement> getEnumElements() {
		if (enumElements == null) {
			enumElements = new ArrayList<>();
		}
		return enumElements;
	}
	
	public void setEnumElements(List<CMMEnumElement> enumElements) {
		getEnumElements().clear();
		getEnumElements().addAll(enumElements);
	}
	
}
