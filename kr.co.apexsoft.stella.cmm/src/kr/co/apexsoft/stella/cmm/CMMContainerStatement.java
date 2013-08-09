package kr.co.apexsoft.stella.cmm;

import java.util.ArrayList;
import java.util.List;

public abstract class CMMContainerStatement implements CMMStatement, CMMStatementableElement {

	private List<CMMStatement> statements;
	
	@Override
	public List<CMMStatement> getStatements() {
		if (statements == null) {
			statements = new ArrayList<>();
		}
		return statements;
	}

	@Override
	public boolean addStatement(CMMStatement statement) {
		return getStatements().add(statement);
	}
	
}
