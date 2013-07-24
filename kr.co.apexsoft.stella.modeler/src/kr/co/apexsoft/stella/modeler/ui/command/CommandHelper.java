package kr.co.apexsoft.stella.modeler.ui.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Type;

public class CommandHelper {
	
	private TransactionalEditingDomain domain;
	
	public CommandHelper(TransactionalEditingDomain domain) {
		this.domain = domain;
	}
	
	protected TransactionalEditingDomain getTransactionalEditingDomain() {
		return domain;
	}

	public Command getCreateLifelineCommand(Interaction interaction, Type type) {
		return new LifelineCreateCommand(getTransactionalEditingDomain(), interaction, type);
	}
	
	public Command getDrawLifelineCommand(Diagram diagram,
			Lifeline lifeline, Rectangle bounds) {
		return getCreateViewCommand(diagram, lifeline, bounds);
	}
	
	public Command getDrawLifelineCommand(Diagram diagram,
			Type type, Bounds bounds) {
		
		return null;
	}
	
	public Command getDrawLifelineCommand(Diagram diagram,
			ConnectableElement represents, Bounds bounds) {
		return null;
	}
	
	public Command getCreateViewCommand(View container, Element element, Rectangle bounds) {
		return new CreateViewCommand(domain, container, element, bounds);
	}
	
	private static Interaction getInteraction(Diagram diagram) {
		return (Interaction) diagram.getElement();
	}
	
}