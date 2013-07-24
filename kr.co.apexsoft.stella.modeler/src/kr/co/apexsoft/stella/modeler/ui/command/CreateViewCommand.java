package kr.co.apexsoft.stella.modeler.ui.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Element;

public class CreateViewCommand extends RecordingCommand {

	private View container;
	private Element element;
	private Rectangle bounds;
	
	public CreateViewCommand(TransactionalEditingDomain domain,
			View container, Element element, Rectangle bounds) {
		super(domain);
		this.container = container;
		this.element = element;
		bounds = bounds.getCopy();
	}

	@Override
	protected void doExecute() {
		// TODO Auto-generated method stub

	}

}
