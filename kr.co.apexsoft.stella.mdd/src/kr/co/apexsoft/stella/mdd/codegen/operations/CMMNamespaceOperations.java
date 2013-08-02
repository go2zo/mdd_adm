package kr.co.apexsoft.stella.mdd.codegen.operations;

import kr.co.apexsoft.stella.cmm.CMMNamespace;

import org.eclipse.uml2.uml.Namespace;

public class CMMNamespaceOperations extends CMMElementOperations {

	protected CMMNamespaceOperations() {
		
	}
	
	public static CMMNamespace createCMMNamespace(final Namespace _namespace) {
		String uri = getFullPath(_namespace);
		return new CMMNamespace(uri, _namespace.separator());
	}

}
