package kr.co.apexsoft.stella.cmm;

import java.util.ArrayList;
import java.util.List;

public class CMMStatement implements CMMElement {

	private List<CMMStatement> statemenets;
	
	public List<CMMStatement> getStatements() {
		if (statemenets == null) {
			statemenets = new ArrayList<>();
		}
		return statemenets;
	}
}
