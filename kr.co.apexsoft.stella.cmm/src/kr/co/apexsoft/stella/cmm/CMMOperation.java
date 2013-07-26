package kr.co.apexsoft.stella.cmm;

import java.util.ArrayList;
import java.util.List;

public class CMMOperation extends CMMRedefinedElement
		implements CMMAbstractableElement {

	private List<CMMParameter> ownedParameters;
	
	private List<CMMStatement> statements;
	
	private boolean isAbstract;
	
	public List<CMMParameter> getParameters() {
		if (ownedParameters == null) {
			ownedParameters = new ArrayList<>();
		}
		return ownedParameters;
	}
	
	public void setParameters(List<CMMParameter> parapeters) {
		getParameters().clear();
		getParameters().addAll(parapeters);
	}
	
	public List<CMMStatement> getStatements() {
		if (statements == null) {
			statements = new ArrayList<>();
		}
		return statements;
	}
	
	public void setStatements(List<CMMStatement> statements) {
		getStatements().clear();
		getStatements().addAll(statements);
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
