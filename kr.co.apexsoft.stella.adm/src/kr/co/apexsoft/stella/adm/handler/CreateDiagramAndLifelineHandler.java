package kr.co.apexsoft.stella.adm.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.uml2.uml.Model;

public class CreateDiagramAndLifelineHandler extends ReverseHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Model model = (Model) getSelectedElement();
		
		
		
		return null;
	}

}
