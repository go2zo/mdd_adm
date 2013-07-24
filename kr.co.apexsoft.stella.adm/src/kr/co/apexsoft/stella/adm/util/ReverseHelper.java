package kr.co.apexsoft.stella.adm.util;

import kr.co.apexsoft.stella.cmm.CMMClass;
import kr.co.apexsoft.stella.cmm.CMMElement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.Package;

public class ReverseHelper {

	private static class ReverseHelperHolder {
		public static final ReverseHelper instance = new ReverseHelper();
	}
	
	public static ReverseHelper getInstance() {
		return ReverseHelperHolder.instance;
	}
	
	public ICommand getReverseCommand(EObject container, CMMElement[] cmmElements) {
		
		for (CMMElement cmm : cmmElements) {
			if (cmm instanceof CMMClass) {
			}
		}
		
		return null;
	}
	
	private ICommand getReverseClassCommand(EObject container, CMMClass cmmClass) {
		
		if (container instanceof Package) {
			return getCreateCommand(container, UMLElementTypes.CLASS, null);
		}
		return null;
	}
	
	private ICommand getCreateCommand(EObject container, IElementType elementType, EReference reference) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);
		
		CreateElementRequest req = new CreateElementRequest(container, elementType, reference);
		ICommand command = provider.getEditCommand(req);
		return command;
	}
	
}
