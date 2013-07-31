package kr.co.apexsoft.stella.mdd.codegen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import kr.co.apexsoft.stella.cmm.CMMAttribute;
import kr.co.apexsoft.stella.cmm.CMMClass;
import kr.co.apexsoft.stella.cmm.CMMElement;
import kr.co.apexsoft.stella.cmm.CMMEnum;
import kr.co.apexsoft.stella.cmm.CMMEnumElement;
import kr.co.apexsoft.stella.cmm.CMMNamespace;
import kr.co.apexsoft.stella.cmm.CMMOperation;
import kr.co.apexsoft.stella.cmm.CMMPackageableElement;
import kr.co.apexsoft.stella.cmm.CMMParameter;
import kr.co.apexsoft.stella.cmm.CMMPrimitiveType;
import kr.co.apexsoft.stella.cmm.CMMType;
import kr.co.apexsoft.stella.cmm.CMMVisibilityKind;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;

public class CMMTransformer {
	
	private Set<CMMElement> cachedElements = new HashSet<>();
	
	public CMMTransformer() {
		
	}
	
	public List<CMMElement> transform(EObject element) {
		if (element instanceof Package) {
			transformPackage((Package) element);
		} else if (element instanceof Type) {
			transformType((Type) element);
		}
		
		return new ArrayList<>(cachedElements);
	}
	
	public List<CMMElement> transforms(List<EObject> elements) {
		Iterator<EObject> iterator = elements.iterator();
		while (iterator.hasNext()) {
			EObject element = iterator.next();
			transform(element);
		}
		
		return new ArrayList<>(cachedElements);
	}

	private void transformPackage(Package _package) {
		List<NamedElement> members = _package.getOwnedMembers();
		for (NamedElement member : members) {
			if (member instanceof Package) {
				transformPackage((Package) member);
			}
			if (member instanceof Class) {
				transformClass((Class) member);
			}
		}
	}

	private void transformType(Type _type) {
		if (_type instanceof Classifier) {
			transformClassifier((Classifier) _type);
		}
	}
	
	private void transformClassifier(Classifier _classifier) {
		if (_classifier instanceof Interface) {
			cachedElements.add(createCMMClass(_classifier));
		} else if (_classifier instanceof Collaboration) {
			transformCollaboration((Collaboration) _classifier);
		} else if (_classifier instanceof Class) {
			transformClass((Class) _classifier);
		}
	}
	
	private void transformCollaboration(Collaboration _collaboration) {
		List<Behavior> behaviors = _collaboration.getOwnedBehaviors();
		for (Behavior behavior : behaviors) {
			transformBehavior(behavior);
		}
	}
	
	private void transformClass(Class _class) {
		if (_class instanceof Behavior) {
			transformBehavior((Behavior) _class);
		} else {
			cachedElements.add(createCMMClass(_class));
		}
	}
	
	private void transformBehavior(Behavior _behavior) {
		if (_behavior instanceof Interaction) {
			transformInteraction((Interaction) _behavior);
		}
	}
	
	private void transformInteraction(Interaction _interaction) {
		List<Lifeline> lifelines = _interaction.getLifelines();
		
		for (Lifeline lifeline : lifelines) {
			transformLifeline(lifeline);
		}
	}
	
	private void transformLifeline(Lifeline _lifeline) {
		Type lifelineType = getLifelineType(_lifeline);
		transformType(lifelineType);
	}
	
	private Type getLifelineType(Lifeline _lifeline) {
		ConnectableElement represents = _lifeline.getRepresents();
		if (represents != null) {
			return represents.getType();
		}
		return null;
	}
	
	private void transformFragment(InteractionFragment _fragment, List<CMMElement> result) {
		if (_fragment instanceof CombinedFragment) {
			CombinedFragment cf = (CombinedFragment)_fragment;
			InteractionOperatorKind kind = cf.getInteractionOperator();
			
		} else if (_fragment instanceof ExecutionSpecification) {
			
		} else if (_fragment instanceof OccurrenceSpecification) {
			if (_fragment instanceof MessageOccurrenceSpecification) {
				MessageOccurrenceSpecification mos = (MessageOccurrenceSpecification)_fragment;
				Message message = mos.getMessage();

			}
		} else if (_fragment instanceof InteractionOperand) {
			
		} else if (_fragment instanceof InteractionUse) {
			
		}
	}
	
	private void transformCFragment(CombinedFragment cFragment) {
		InteractionOperatorKind ioKind = cFragment.getInteractionOperator();

		if (InteractionOperatorKind.ALT_LITERAL.equals(ioKind)) {
			
		} else if (InteractionOperatorKind.LOOP_LITERAL.equals(ioKind)) {
			
		}
	}
	
	private CMMEnum transformEnum(Enumeration _enum) {
		CMMEnum cmmEnum = null;
		
		
		
		return cmmEnum;
	}
	
	private CMMClass createCMMClass(Classifier _classifier) {
		CMMClass cmmClass = new CMMClass();
		
		cmmClass.setName(_classifier.getName());
		cmmClass.setDescription(""); // TODO
		
		cmmClass.setAbstract(_classifier.isAbstract());
		cmmClass.setFinal(_classifier.isLeaf());
		cmmClass.setInterface(_classifier instanceof Interface);
		
		CMMVisibilityKind visibilityKind = getCMMVisibilityKind(_classifier.getVisibility());
		cmmClass.setVisibilityKind(visibilityKind);
		
		CMMNamespace namespace = createCMMNamespace(_classifier.getNamespace());
		cmmClass.setNamespace(namespace);

		List<Property> attributes = _classifier.getAllAttributes();
		for (Property attr : attributes) {
			CMMAttribute cmmAttr = createCMMAttribute(attr);
			cmmClass.getAttributes().add(cmmAttr);
		}
		
		List<Operation> operations = _classifier.getAllOperations();
		for (Operation op : operations) {
			CMMOperation cmmOp = createCMMOperation(op);
			cmmClass.getOperations().add(cmmOp);
		}
		
		return cmmClass;
	}
	
	private CMMNamespace createCMMNamespace(Namespace _namespace) {
		String uri = getFullPath(_namespace);
		return new CMMNamespace(uri, _namespace.separator());
	}
	
	private CMMAttribute createCMMAttribute(Property _attribute) {
		CMMAttribute cmmAttr = new CMMAttribute();
		
		cmmAttr.setName(_attribute.getName());
		cmmAttr.setDescription(""); // TODO
		
		cmmAttr.setType(getCMMType(_attribute.getType()));
		
		cmmAttr.setFinal(_attribute.isLeaf());
		cmmAttr.setStatic(_attribute.isStatic());
		
		CMMVisibilityKind visibilityKind = getCMMVisibilityKind(_attribute.getVisibility());
		cmmAttr.setVisibilityKind(visibilityKind);
		
		return cmmAttr;
	}
	
	private CMMOperation createCMMOperation(Operation _operation) {
		CMMOperation cmmOp = new CMMOperation();
		
		cmmOp.setName(_operation.getName());
		cmmOp.setDescription(""); // TODO
		
		Parameter returnResult = _operation.getReturnResult();
		if (returnResult != null) {
			cmmOp.setReturnValue(getCMMType(returnResult.getType()));
		}
		
		cmmOp.setAbstract(_operation.isAbstract());
		cmmOp.setFinal(_operation.isLeaf());
		cmmOp.setStatic(_operation.isStatic());
		
		CMMVisibilityKind visibilityKind = getCMMVisibilityKind(_operation.getVisibility());
		cmmOp.setVisibilityKind(visibilityKind);
		
		List<Parameter> parameters = _operation.getOwnedParameters();
		for (Parameter param : parameters) {
			CMMParameter cmmParam = createCMMParameter(param);
			cmmOp.getParameters().add(cmmParam);
		}
		
		return cmmOp;
	}
	
	private CMMParameter createCMMParameter(Parameter _parameter) {
		CMMParameter cmmParam = new CMMParameter();
		
		cmmParam.setName(_parameter.getName());
		cmmParam.setDescription(""); // TODO
		
		cmmParam.setType(getCMMType(_parameter.getType()));
		
		return cmmParam;
	}
	
	private CMMType createCMMType(Type _type) {
		CMMType cmmType = null;
		
		if (_type instanceof PrimitiveType) {
			cmmType = createCMMPrimitiveType((PrimitiveType) _type);
		} else if (_type instanceof Enumeration) {
			cmmType = createCMMEnum((Enumeration) _type);
		} else if (_type instanceof Class) {
			cmmType = createCMMClass((Class) _type);
		}
		
		return cmmType;
	}
	
	private CMMType getCMMType(Type _type) {
		CMMType cmmType = findCMMType(_type);
		if (cmmType == null) {
			cmmType = createCMMType(_type);
		}
		return cmmType;
	}
	
	private CMMEnum createCMMEnum(Enumeration _enum) {
		CMMEnum cmmEnum = new CMMEnum();
		
		cmmEnum.setName(_enum.getName());
		cmmEnum.setDescription(""); // TODO
		
		cmmEnum.setFinal(_enum.isLeaf());
		
		CMMVisibilityKind visibilityKind = getCMMVisibilityKind(_enum.getVisibility());
		cmmEnum.setVisibilityKind(visibilityKind);
		
		for (EnumerationLiteral literal : _enum.getOwnedLiterals()) {
			cmmEnum.getEnumElements().add(createCMMEnumElement(literal));
		}
		
		return cmmEnum;
	}
	
	private CMMEnumElement createCMMEnumElement(EnumerationLiteral _literal) {
		CMMEnumElement enumElement = new CMMEnumElement();
		
		enumElement.setName(_literal.getName());
		enumElement.setDescription(""); // TODO
		
		return enumElement;
	}
	
	private CMMVisibilityKind getCMMVisibilityKind(VisibilityKind visibilityKind) {
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
	
	private CMMPrimitiveType createCMMPrimitiveType(PrimitiveType primitiveType) {
		return new CMMPrimitiveType(primitiveType.getName());
	}
	
	private CMMType findCMMType(Type _type) {
		String fullPath = getFullPath(_type);
		fullPath = fullPath.replaceAll(_type.separator(), CMMNamespace.SEPERATOR);
		
		for (CMMElement cmmElement : cachedElements) {
			if (cmmElement instanceof CMMPackageableElement) {
				String fp = ((CMMPackageableElement) cmmElement).getFullPath();
				if (fullPath.equals(fp)) {
					return (CMMPackageableElement) cmmElement;
				}
			}
		}
		
		return null;
	}
	
	private String getFullPath(NamedElement _namedElement) {
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
