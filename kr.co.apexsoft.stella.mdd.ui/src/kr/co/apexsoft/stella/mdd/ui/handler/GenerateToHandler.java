package kr.co.apexsoft.stella.mdd.ui.handler;

import java.util.List;

import kr.co.apexsoft.stella.cmm.CMMElement;
import kr.co.apexsoft.stella.mdd.codegen.CMMTransformer;
import kr.co.apexsoft.stella.mdd.codegen.CodeGenerator;
import kr.co.apexsoft.stella.modeler.ui.UMLModeler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;

public class GenerateToHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<EObject> selectedElements = UMLModeler.getUMLUIHelper().getSelectedElements();
		
//		CMMTransformer transformer = new CMMTransformer();
//		List<CMMElement> list = transformer.transforms(selectedElements);

		CodeGenerator generator = new CodeGenerator(selectedElements);
		generator.generate();
		
		return null;
	}

}
