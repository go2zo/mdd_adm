package kr.co.apexsoft.stella.cmm;

import java.util.ArrayList;
import java.util.List;

public class CMMContainerStatement implements CMMStatement {

	private List<CMMStatement> statements;
	
	public List<CMMStatement> getStatements() {
		if (statements == null) {
			statements = new ArrayList<>();
		}
		return statements;
	}

	public boolean addStatement(CMMStatement statement) {
		return getStatements().add(statement);
	}
	
}
