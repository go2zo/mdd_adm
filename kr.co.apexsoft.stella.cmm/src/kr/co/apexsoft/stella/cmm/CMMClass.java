package kr.co.apexsoft.stella.cmm;

import java.util.ArrayList;
import java.util.List;

public class CMMClass extends CMMFinalElement implements CMMAbstractElement, CMMType {
	
	private CMMNamespace namespace;
	
	private List<CMMNamedElement> importElements;
	private List<CMMClass> inheritances;
	
	private List<CMMAttribute> ownerAttributes;
	private List<CMMOperation> ownerOperations;
	private List<CMMClass> nestedClasses;
	
	private boolean isInterface;
	private boolean isAbstract;
	
	public CMMNamespace getNamespace() {
		return namespace;
	}

	public void setNamespace(CMMNamespace namespace) {
		this.namespace = namespace;
	}
	
	public List<CMMNamedElement> getImportElements() {
		if (importElements == null) {
			importElements = new ArrayList<>();
		}
		return importElements;
	}
	
	public List<CMMClass> getInheritances() {
		if (inheritances == null) {
			inheritances = new ArrayList<>();
		}
		return inheritances;
	}
	
	public List<CMMAttribute> getAttributes() {
		if (ownerAttributes == null) {
			ownerAttributes = new ArrayList<>();
		}
		return ownerAttributes;
	}
	
	public List<CMMOperation> getOperations() {
		if (ownerOperations == null) {
			ownerOperations = new ArrayList<>();
		}
		return ownerOperations;
	}
	
	public List<CMMClass> getNestedClasses() {
		if (nestedClasses == null) {
			nestedClasses = new ArrayList<>();
		}
		return nestedClasses;
	}

	public boolean isInterface() {
		return isInterface;
	}

	public void setInterface(boolean isInterface) {
		this.isInterface = isInterface;
	}

	@Override
	public boolean isAbstract() {
		return isAbstract;
	}

	@Override
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

}
