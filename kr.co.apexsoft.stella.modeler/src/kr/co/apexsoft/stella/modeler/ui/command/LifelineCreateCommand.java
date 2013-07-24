package kr.co.apexsoft.stella.modeler.ui.command;

import kr.co.apexsoft.stella.modeler.util.NamingRules;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public class LifelineCreateCommand extends SequenceCreateCommand {

	private String lifelineName;
	private String propertyName;
	private Type type;
	private ConnectableElement represents;
	private Lifeline lifeline;
	
	public LifelineCreateCommand(TransactionalEditingDomain domain,
			Interaction container, Type type) {
		this(domain, container, type, type.getName(), type.getName());
	}
	
	public LifelineCreateCommand(TransactionalEditingDomain domain,
			Interaction container, Type type, String lifelineName, String propertyName) {
		super(domain, container);
		this.lifelineName = lifelineName;
		this.propertyName = propertyName;
		this.type = type;
	}

	public LifelineCreateCommand(TransactionalEditingDomain domain,
			Interaction container, ConnectableElement represents) {
		this(domain, container, represents, represents.getName());
	}

	public LifelineCreateCommand(TransactionalEditingDomain domain,
			Interaction container, ConnectableElement represents, String lifelineName) {
		super(domain, container);
		this.lifelineName = lifelineName;
		this.represents = represents;
	}
	
	public LifelineCreateCommand(TransactionalEditingDomain domain,
			Interaction container, String lifelineName) {
		super(domain, container);
		this.lifelineName = lifelineName;
	}

	@Override
	protected void doExecute() {
		if (lifelineName == null || lifelineName.equals("")) {
			lifelineName = NamingRules.getDefaultName(UMLPackage.Literals.LIFELINE);
		}
		if (propertyName == null || propertyName.equals("")) {
			propertyName = NamingRules.getDefaultName(UMLPackage.Literals.PROPERTY);
		}
		
		lifelineName = NamingRules.getOrderedName(lifelineName, getInteraction());
		
		lifeline = getInteraction().createLifeline(lifelineName);
	}

	private Property createProperty(String name) {
		Property property = UMLFactory.eINSTANCE.createProperty();
		property.setName(name);
		return property;
	}
	
	protected Lifeline createLifeline() {
		UMLFactory.eINSTANCE.createLifeline();
		
		return null;
	}
}
