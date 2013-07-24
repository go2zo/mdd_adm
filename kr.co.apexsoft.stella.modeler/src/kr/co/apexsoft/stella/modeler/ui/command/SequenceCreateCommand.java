package kr.co.apexsoft.stella.modeler.ui.command;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Interaction;

public abstract class SequenceCreateCommand extends RecordingCommand {

	private Interaction container;
	
	public SequenceCreateCommand(TransactionalEditingDomain domain
			, Interaction interaction) {
		super(domain);
		this.container = interaction;
	}

	protected Interaction getInteraction() {
		return container;
	}
}
