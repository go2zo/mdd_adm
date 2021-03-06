package kr.co.apexsoft.stella.cmm;

public abstract class CMMAbstractElement implements CMMNamedElement {

	private String name;
	private String description;
	private CMMVisibilityKind visibilityKind;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CMMVisibilityKind getVisibilityKind() {
		return visibilityKind;
	}

	public void setVisibilityKind(CMMVisibilityKind visibilityKind) {
		this.visibilityKind = visibilityKind;
	}

}
