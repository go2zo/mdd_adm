package kr.co.apexsoft.stella.adm.handler;

import kr.co.apexsoft.stella.adm.uml.sequence.SequenceHelper;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

public class CreateLifelineHandler extends ReverseHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Diagram diagram = (Diagram) getSelectedElement();
		
		TransactionalEditingDomain editingDomain = null;
		editingDomain = TransactionUtil.getEditingDomain(diagram);
//		editingDomain = TransactionUtil.getEditingDomain(interaction);
//		try {
//			editingDomain = ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		RecordingCommand command = new RecordingCommand(editingDomain) {
			
			@Override
			protected void doExecute() {
				EObject rootElement = diagram.getElement();
				while (rootElement != null && !(rootElement instanceof Model)) {
					rootElement = rootElement.eContainer();
				}
				
				if (rootElement instanceof Model) {
					Model model = (Model) rootElement;
					Package pack = (Package) model.createPackagedElement("package1", UMLPackage.Literals.PACKAGE);
					Class clazz = pack.createOwnedClass("class1", false);
					SequenceHelper.drawLifeline(diagram, clazz);
				}
			}
		};
		
		editingDomain.getCommandStack().execute(command);
		
		return null;
	}
	
}
