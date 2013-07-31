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
	
	public void setAttributes(List<CMMAttribute> attributes) {
		getAttributes().clear();
		getAttributes().addAll(attributes);
	}
	
	public List<CMMOperation> getOperations() {
		if (ownerOperations == null) {
			ownerOperations = new ArrayList<>();
		}
		return ownerOperations;
	}
	
	public void setOperations(List<CMMOperation> operations) {
		getOperations().clear();
		getOperations().addAll(operations);
	}
	
	public List<CMMClass> getNestedClasses() {
		if (nestedClasses == null) {
			nestedClasses = new ArrayList<>();
		}
		return nestedClasses;
	}

	public void setNestedClasses(List<CMMClass> nestedClasses) {
		getNestedClasses().clear();
		getNestedClasses().addAll(nestedClasses);
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
