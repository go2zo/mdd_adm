package kr.co.apexsoft.stella.mdd.codegen.operations;

import kr.co.apexsoft.stella.cmm.CMMAttribute;
import kr.co.apexsoft.stella.cmm.CMMClass;
import kr.co.apexsoft.stella.cmm.CMMPackageableElement;

public class CMMClassOperation {
	
	private final static String NEWLINE = "\r\n";
	
	private final static String TAB = "\t";
	
	public static String getCode(CMMClass _class) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("package ");
		sb.append(_class.getNamespace().getURI());
		sb.append(NEWLINE);
		sb.append(NEWLINE);
		
		for (CMMPackageableElement importElement : _class.getImportElements()) {
			sb.append("import ");
			sb.append(importElement.getFullPath());
			sb.append(NEWLINE);
		}
		
		sb.append(_class.getVisibilityKind().toString());
		sb.append(" ");
		sb.append(_class.isInterface() == false ? "class " : "interface ");
		sb.append(_class.getName());
		if (_class.getInheritances().size() > 0) {
			
		}
		sb.append(" {");
		
		for (CMMAttribute attr : _class.getAttributes()) {
			sb.append(TAB);
		}
		
		return sb.toString();
	}
	
}
