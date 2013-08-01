package kr.co.apexsoft.stella.cmm;

import java.util.ArrayList;
import java.util.List;

public class CMMClass extends CMMPackageableElement implements CMMAbstractableElement {
	
	private List<CMMAttribute> ownerAttributes;
	private List<CMMOperation> ownerOperations;
	private List<CMMClass> nestedClasses;
	
	private boolean isInterface;
	private boolean isAbstract;
	
	public List<CMMAttribute> getAttributes() {
		if (ownerAttributes == null) {
			ownerAttributes = new ArrayList<>();
		}
		return ownerAttributes;
	}
	
	public boolean addAttribute(CMMAttribute attribute) {
		return getAttributes().add(attribute);
	}
	
	public List<CMMOperation> getOperations() {
		if (ownerOperations == null) {
			ownerOperations = new ArrayList<>();
		}
		return ownerOperations;
	}

	public boolean addOperation(CMMOperation operation) {
		return getOperations().add(operation);
	}
	
	public List<CMMClass> getNestedClasses() {
		if (nestedClasses == null) {
			nestedClasses = new ArrayList<>();
		}
		return nestedClasses;
	}

	public boolean addNestedClass(CMMClass nestedClass) {
		return getNestedClasses().add(nestedClass);
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
