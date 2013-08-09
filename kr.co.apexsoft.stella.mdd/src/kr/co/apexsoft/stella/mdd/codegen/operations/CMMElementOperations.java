package kr.co.apexsoft.stella.mdd.codegen.operations;

import kr.co.apexsoft.stella.cmm.CMMVisibilityKind;
import kr.co.apexsoft.stella.mdd.util.CMMUtil;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.VisibilityKind;

public class CMMElementOperations extends CMMUtil {
	
	protected CMMElementOperations() {
		
	}
	
	protected static CMMVisibilityKind getCMMVisibilityKind(final VisibilityKind visibilityKind) {
		switch (visibilityKind.getValue()) {
		case VisibilityKind.PUBLIC:
			return CMMVisibilityKind.PUBLIC;
		case VisibilityKind.PRIVATE:
			return CMMVisibilityKind.PRIVATE;
		case VisibilityKind.PROTECTED:
			return CMMVisibilityKind.PROTECTED;
		case VisibilityKind.PACKAGE:
			return CMMVisibilityKind.PACKAGE;
		default:
			return CMMVisibilityKind.PUBLIC;	
		}
	}
	
	protected static String getDescription(final Element element) {
		return ""; //TODO
	}
	
}
