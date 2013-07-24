package kr.co.apexsoft.stella.adm.handler;

import java.util.List;

import kr.co.apexsoft.stella.modeler.ui.UMLModeler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;

public abstract class ReverseHandler extends AbstractHandler {

	protected List<EObject> getSelectedElements() {
		return UMLModeler.getUMLUIHelper().getSelectedElements();
	}
	
	protected EObject getSelectedElement() {
		List<EObject> selectedElements = getSelectedElements();
		if (selectedElements != null && selectedElements.size() > 0) {
			return selectedElements.get(0);
		}
		return null;
	}
	
	protected CommandStack getCommandStack() throws Exception {
		return  ServiceUtilsForActionHandlers.getInstance()
				.getTransactionalEditingDomain().getCommandStack();
	}
	
}
