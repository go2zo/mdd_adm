package kr.co.apexsoft.stella.cmm;

import java.util.ArrayList;
import java.util.List;

public class CMMOperation extends CMMRedefinedElement
		implements CMMAbstractableElement {

	private List<CMMParameter> ownedParameters;
	
	private List<CMMStatement> ownedStatements;
	
	private boolean isAbstract;
	
	public List<CMMParameter> getParameters() {
		if (ownedParameters == null) {
			ownedParameters = new ArrayList<>();
		}
		return ownedParameters;
	}
	
	public boolean addParameter(CMMParameter parameter) {
		return getParameters().add(parameter);
	}
	
	public List<CMMStatement> getStatements() {
		if (ownedStatements == null) {
			ownedStatements = new ArrayList<>();
		}
		return ownedStatements;
	}
	
	public boolean addStatement(CMMStatement statement) {
		return getStatements().add(statement);
	}
	
	public CMMType getReturnValue() {
		return getType();
	}
	
	public void setReturnValue(CMMType type) {
		setType(type);
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
