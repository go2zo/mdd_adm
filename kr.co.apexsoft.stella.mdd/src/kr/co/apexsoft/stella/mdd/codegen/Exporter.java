package kr.co.apexsoft.stella.mdd.codegen;

import java.util.List;

import kr.co.apexsoft.stella.cmm.CMMElement;

public interface Exporter {

	public void export(CMMElement element);
	
	public void export(List<CMMElement> elements);
	
}
