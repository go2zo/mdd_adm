package kr.co.apexsoft.stella.cmm;

import java.util.ArrayList;
import java.util.List;

public class CMMEnum extends CMMPackageableElement {

	private List<CMMEnumLiteral> enumElements;
	
	public List<CMMEnumLiteral> getEnumElements() {
		if (enumElements == null) {
			enumElements = new ArrayList<>();
		}
		return enumElements;
	}
	
	public boolean addEnumElement(CMMEnumLiteral enumElement) {
		return getEnumElements().add(enumElement);
	}
	
}
