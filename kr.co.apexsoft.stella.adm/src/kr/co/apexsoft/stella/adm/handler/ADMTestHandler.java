package kr.co.apexsoft.stella.adm.handler;

import kr.co.apexsoft.stella.adm.util.ReverseHelper;
import kr.co.apexsoft.stella.cmm.CMMElement;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;

public class ADMTestHandler extends ReverseHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		EObject element = getSelectedElement();
		
		IResource[] resources = getReversedResources();
		
		CMMElement[] cmmElements = getCodeMetamodel(resources);

		
		ICommand command = ReverseHelper.getInstance().getReverseCommand(element, cmmElements);
		try {
			getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private IResource[] getReversedResources() {
		// TODO
		return null;
	}
	
	private CMMElement[] getCodeMetamodel(IResource[] resources) {
		// TODO
		return new CMMElement[0];
	}
	
}
