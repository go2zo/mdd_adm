package kr.co.apexsoft.stella.mdd.codegen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr.co.apexsoft.stella.cmm.CMMAttribute;
import kr.co.apexsoft.stella.cmm.CMMClass;
import kr.co.apexsoft.stella.cmm.CMMElement;
import kr.co.apexsoft.stella.cmm.CMMOperation;
import kr.co.apexsoft.stella.cmm.CMMParameter;
import kr.co.apexsoft.stella.cmm.CMMType;
import kr.co.apexsoft.stella.cmm.CMMVisibilityKind;
import kr.co.apexsoft.stella.mdd.util.InteractionUtil;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.baseadaptor.loader.FragmentClasspath;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ConnectableElement;
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
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class CMMTransformer {
	
	public CMMTransformer() {
		
	}
	
	public List<CMMElement> transform(EObject element) {
		List<CMMElement> result = new ArrayList<>();
		
		if (element instanceof Package) {
			result.addAll(transformPackage((Package) element));
		} else if (element instanceof Classifier) {
			transformClassifier((Classifier) element, result);
		}
		
		return result;
	}
	
	public List<CMMElement> transforms(List<EObject> elements) {
		List<CMMElement> result = new ArrayList<>();
		
		Iterator<EObject> iterator = elements.iterator();
		while (iterator.hasNext()) {
			EObject element = iterator.next();
			result.addAll(transform(element));
		}
		
		return result;
	}

	private List<CMMElement> transformPackage(Package _package) {
		String id = _package.eResource().getURIFragment(_package);
		return null;
	}

	private void transformClassifier(Classifier _classifier, List<CMMElement> result) {
		if (_classifier instanceof Interface) {
			result.add(makeCMMClass(_classifier));
		} else if (_classifier instanceof Collaboration) {
			transformCollaboration((Collaboration) _classifier, result);
		} else if (_classifier instanceof Class) {
			transformClass((Class) _classifier, result);
		}
	}
	
	private void transformCollaboration(Collaboration _collaboration, List<CMMElement> result) {
		List<Behavior> behaviors = _collaboration.getOwnedBehaviors();
		for (Behavior behavior : behaviors) {
			transformBehavior(behavior, result);
		}
	}
	
	private void transformClass(Class _class, List<CMMElement> result) {
		if (_class instanceof Behavior) {
			transformBehavior((Behavior) _class, result);
		} else {
			result.add(makeCMMClass(_class));
		}
	}
	
	private void transformBehavior(Behavior _behavior, List<CMMElement> result) {
		if (_behavior instanceof Interaction) {
			transformInteraction((Interaction) _behavior, result);
		}
	}
	
	private void transformInteraction(Interaction _interaction, List<CMMElement> result) {
		List<Lifeline> lifelines = _interaction.getLifelines();
		List<InteractionFragment> fragments = _interaction.getFragments();
		
		List<Message> messages = _interaction.getMessages();
		
		for (InteractionFragment fragment : fragments) {
			
		}
		
		Lifeline significantLifeline = InteractionUtil.getSignificantLifeline(_interaction);
		try {
			significantLifeline.getRelationships();
			ConnectableElement represents = significantLifeline.getRepresents();
			Type type = represents.getType();
			
			if (type instanceof Class) {
				
			}
			CMMOperation cmmOp = null;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
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
	
	private CMMClass makeCMMClass(Classifier _classifier) {
		CMMClass cmmClass = new CMMClass();
		
		cmmClass.setName(_classifier.getName());
		cmmClass.setDescription(""); // TODO
		
		cmmClass.setAbstract(_classifier.isAbstract());
		cmmClass.setFinal(_classifier.isLeaf());
		cmmClass.setInterface(_classifier instanceof Interface);
		
		CMMVisibilityKind visibilityKind = CMMVisibilityKind
				.valueOf(_classifier.getVisibility().getName());
		cmmClass.setVisibilityKind(visibilityKind);

		List<Property> attributes = _classifier.getAllAttributes();
		for (Property attr : attributes) {
			CMMAttribute cmmAttr = makeCMMAttribute(attr);
			cmmClass.getAttributes().add(cmmAttr);
		}
		
		List<Operation> operations = _classifier.getAllOperations();
		for (Operation op : operations) {
			CMMOperation cmmOp = makeCMMOperation(op);
			cmmClass.getOperations().add(cmmOp);
		}
		
		return cmmClass;
	}
	
	private CMMAttribute makeCMMAttribute(Property _attribute) {
		CMMAttribute cmmAttr = new CMMAttribute();
		
		cmmAttr.setName(_attribute.getName());
		cmmAttr.setDescription(""); // TODO
		
		cmmAttr.setType(makeCMMType(_attribute.getType()));
		
		cmmAttr.setFinal(_attribute.isLeaf());
		cmmAttr.setStatic(_attribute.isStatic());
		
		return cmmAttr;
	}
	
	private CMMOperation makeCMMOperation(Operation _operation) {
		CMMOperation cmmOp = new CMMOperation();
		
		cmmOp.setName(_operation.getName());
		cmmOp.setDescription(""); // TODO
		
		Parameter returnResult = _operation.getReturnResult();
		cmmOp.setReturnValue(makeCMMType(returnResult.getType()));
		
		cmmOp.setAbstract(_operation.isAbstract());
		cmmOp.setFinal(_operation.isLeaf());
		cmmOp.setStatic(_operation.isStatic());
		
		List<Parameter> parameters = _operation.getOwnedParameters();
		for (Parameter param : parameters) {
			CMMParameter cmmParam = makeCMMParameter(param);
			cmmOp.getParameters().add(cmmParam);
		}
		
		return cmmOp;
	}
	
	private CMMParameter makeCMMParameter(Parameter _parameter) {
		CMMParameter cmmParam = new CMMParameter();
		
		cmmParam.setName(_parameter.getName());
		cmmParam.setDescription(""); // TODO
		
		cmmParam.setType(makeCMMType(_parameter.getType()));
		
		return cmmParam;
	}
	
	private CMMType makeCMMType(Type _type) {
		CMMType cmmType = null;
		
		if (_type instanceof PrimitiveType) {
			String name = ((PrimitiveType) _type).getName();
		}
		
		return cmmType;
	}
	
}
