package kr.co.apexsoft.stella.cmm;

import java.util.ArrayList;
import java.util.List;

public class CMMPackageableElement extends CMMFinalElement implements CMMType {

	private CMMNamespace namespace;
	
	private List<CMMPackageableElement> importElements;
	private List<CMMClass> inheritances;
	
	public CMMNamespace getNamespace() {
		return namespace;
	}

	public void setNamespace(CMMNamespace namespace) {
		this.namespace = namespace;
	}
	
	public List<CMMPackageableElement> getImportElements() {
		if (importElements == null) {
			importElements = new ArrayList<>();
		}
		return importElements;
	}
	
	public void setImportElements(List<CMMPackageableElement> importElements) {
		getImportElements().clear();
		getImportElements().addAll(importElements);
	}
	
	public List<CMMClass> getInheritances() {
		if (inheritances == null) {
			inheritances = new ArrayList<>();
		}
		return inheritances;
	}
	
	public void setInheritances(List<CMMClass> inheritances) {
		getInheritances().clear();
		getInheritances().addAll(inheritances);
	}

	public String getFullPath() {
		StringBuffer sb = new StringBuffer();
		if (namespace != null) {
			sb.append(namespace.getURI());
			sb.append(".");
		}
		sb.append(getName());
		return sb.toString();
	}

}
