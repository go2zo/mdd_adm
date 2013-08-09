package kr.co.apexsoft.stella.mdd.codegen.operations;

import kr.co.apexsoft.stella.cmm.CMMNamespace;

import org.eclipse.uml2.uml.Namespace;

public class CMMNamespaceOperations extends CMMElementOperations {

	protected CMMNamespaceOperations() {
		
	}
	
	public static CMMNamespace createCMMNamespace(final Namespace element) {
		String uri = getFullPath(element);
		return new CMMNamespace(uri, element.separator());
	}

}
