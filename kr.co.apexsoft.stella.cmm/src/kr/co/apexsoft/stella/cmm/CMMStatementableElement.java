package kr.co.apexsoft.stella.cmm;

import java.util.List;

public interface CMMStatementableElement {
	
	public List<CMMStatement> getStatements();
	public boolean addStatement(CMMStatement statement);
	
}
