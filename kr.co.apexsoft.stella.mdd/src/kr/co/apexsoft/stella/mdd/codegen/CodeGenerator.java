package kr.co.apexsoft.stella.mdd.codegen;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import kr.co.apexsoft.stella.cmm.CMMElement;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;

public class CodeGenerator {

	List<EObject> selectedElements;
	
	public CodeGenerator(Collection<? extends EObject> selectedElements) {
		this.selectedElements = new ArrayList<>(selectedElements);
	}
	
	public void generate() {
		IRunnableWithProgress op = new IRunnableWithProgress() {
			
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException,
					InterruptedException {
				doGenerate(selectedElements, monitor);
			}
		};
		
		try {
			PlatformUI.getWorkbench().getProgressService().run(true, true, op);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGenerate(List<EObject> elements, IProgressMonitor monitor) {
		int totalWork = elements.size();
		
		monitor.beginTask("Generate", totalWork);
		
		CMMTransformer transformer = new CMMTransformer();
		List<CMMElement> cmmElements = transformer.transform(elements);

		Exporter exporter = new JavaExporter();
		exporter.export(cmmElements);
		
	}
}
