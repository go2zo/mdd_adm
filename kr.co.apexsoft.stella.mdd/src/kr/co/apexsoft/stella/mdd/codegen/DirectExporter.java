package kr.co.apexsoft.stella.mdd.codegen;

import java.util.List;

import kr.co.apexsoft.stella.cmm.CMMClass;
import kr.co.apexsoft.stella.cmm.CMMElement;
import kr.co.apexsoft.stella.mdd.codegen.operations.CMMClassOperation;

public class DirectExporter implements Exporter {

	@Override
	public void export(CMMElement element) {
		if (element instanceof CMMClass) {
			System.out.println(CMMClassOperation.getCode((CMMClass)element));
		}
	}

	@Override
	public void export(List<CMMElement> elements) {
		for (CMMElement element : elements) {
			export(element);
		}
	}

}
