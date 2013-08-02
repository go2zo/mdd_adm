package kr.co.apexsoft.stella.mdd.util;

import java.util.ArrayList;
import java.util.List;

import kr.co.apexsoft.stella.cmm.CMMAttribute;
import kr.co.apexsoft.stella.cmm.CMMClass;
import kr.co.apexsoft.stella.cmm.CMMElement;
import kr.co.apexsoft.stella.cmm.CMMEnum;
import kr.co.apexsoft.stella.cmm.CMMEnumElement;
import kr.co.apexsoft.stella.cmm.CMMNamedElement;
import kr.co.apexsoft.stella.cmm.CMMOperation;
import kr.co.apexsoft.stella.cmm.CMMParameter;
import kr.co.apexsoft.stella.cmm.CMMPrimitiveType;
import kr.co.apexsoft.stella.cmm.CMMType;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;

public class CMMUtil {
	
	public static CMMClass findCMMClass(final List<CMMElement> cmmElements, final Class clazz) {
		for (CMMElement cmmElement : cmmElements) {
			if (cmmElement instanceof CMMClass && isEqual((CMMClass) cmmElement, clazz)) {
				return (CMMClass) cmmElement;
			}
		}
		return null;
	}
	
	public static CMMEnum findCMMEnum(final List<CMMElement> cmmElements, final Enumeration enumeration) {
		for (CMMElement cmmElement : cmmElements) {
			if (cmmElement instanceof CMMEnum && isEqual((CMMEnum) cmmElement, enumeration)) {
				return (CMMEnum) cmmElement;
			}
		}
		return null;
	}
	
	public static CMMOperation findCMMOperation(final CMMClass cmmClass, final Operation operation) {
		for (CMMOperation cmmOp : cmmClass.getOperations()) {
			if (isEqual(cmmOp, operation)) {
				return cmmOp;
			}
		}
		return null;
	}
	
	public static CMMParameter findCMMParameter(final CMMOperation cmmOp, final Parameter parameter) {
		for (CMMParameter cmmParam : cmmOp.getParameters()) {
			if (isEqual(cmmParam, parameter)) {
				return cmmParam;
			}
		}
		return null;
	}
	
	public static CMMEnumElement findCMMEnumElement(final CMMEnum cmmEnum, final EnumerationLiteral literal) {
		for (CMMEnumElement cmmEnumElement : cmmEnum.getEnumElements()) {
			if (isEqual(cmmEnumElement, literal)) {
				return cmmEnumElement;
			}
		}
		return null;
	}
	
	public static boolean isEqual(final CMMNamedElement cmm, final NamedElement element) {
		if (!cmm.getName().equals(element.getName())) {
			return false;
		}
		
		if (cmm instanceof CMMClass && element instanceof Class) {
			return isEqualClass((CMMClass) cmm, (Class) element);
		} else if (cmm instanceof CMMOperation && element instanceof Operation) {
			return isEqualOperation((CMMOperation) cmm, (Operation) element);
		} else if (cmm instanceof CMMAttribute && element instanceof Property) {
			return isEqualAttribute((CMMAttribute) cmm, (Property) element);
		} else if (cmm instanceof CMMParameter && element instanceof Parameter) {
			return isEqualParameter((CMMParameter) cmm, (Parameter) element);
		} else if (cmm instanceof CMMEnum && element instanceof Enumeration) {
			return isEqualEnum((CMMEnum) cmm, (Enumeration) element);
		} else if (cmm instanceof CMMEnumElement && element instanceof EnumerationLiteral) {
			return isEqualEnumElement((CMMEnumElement) cmm, (EnumerationLiteral) element);
		}
		
		return false;
	}
	
	private static boolean isEqualEnumElement(final CMMEnumElement cmm,
			final EnumerationLiteral element) {
		return true;
	}

	private static boolean isEqualEnum(final CMMEnum cmm, final Enumeration element) {
		if (cmm.getQualifiedName().equals(getFullPath(element))) {
			return true;
		}
		return false;
	}

	private static boolean isEqualParameter(final CMMParameter cmm, final Parameter element) {
		if (isEqual(cmm.getType(), element.getType())) {
			return true;
		}
		return false;
	}

	private static boolean isEqualAttribute(final CMMAttribute cmm, final Property element) {
		if (isEqual(cmm.getType(), element.getType())) {
			return true;
		}
		return false;
	}

	private static boolean isEqualOperation(final CMMOperation cmm, final Operation element) {
		Parameter returnResult = element.getReturnResult();
		CMMType cmmType = cmm.getReturnValue();
		if (returnResult == null) {
			if (cmmType instanceof CMMPrimitiveType ||
				"void".equals(cmmType.getName())) { //$NON-NLS-1$
				return false;
			}
		} else {
			if (!isEqual(cmmType, returnResult.getType())) {
				return false;
			}
		}
		
		List<Parameter> parameters = new ArrayList<>();
		parameters.addAll(element.getOwnedParameters());
		if (returnResult != null) {
			parameters.remove(returnResult);
		}
		int paramSize = parameters.size();
		if (paramSize == cmm.getParameters().size()) {
			boolean isEquals = true;
			for (int i = 0; i < paramSize; i++) {
				isEquals = isEqual(cmm.getParameters().get(i), parameters.get(i));
				if (!isEquals) {
					return false;
				}
			}
			return isEquals;
		}
		return false;
	}

	private static boolean isEqualClass(final CMMClass cmm, final Class element) {
		if (cmm.getQualifiedName().equals(getFullPath(element))) {
			return true;
		}
		return false;
	}
	
	public static String getFullPath(final NamedElement _namedElement) {
		StringBuffer sb = new StringBuffer(_namedElement.getName());
		
		for (Namespace namespace : _namedElement.allNamespaces()) {
			if (namespace instanceof Model) {
				break;
			}
			sb.insert(0, namespace.separator());
			sb.insert(0, namespace.getName());
		}
		
		return sb.toString();
	}
	
}
