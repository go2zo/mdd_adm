package kr.co.apexsoft.stella.uml.ui.internal;

import java.util.ArrayList;
import java.util.List;

import kr.co.apexsoft.stella.uml.ui.IUMLUIHelper;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class UMLUIHelper implements IUMLUIHelper {

	public static IUMLUIHelper init() {
		return new UMLUIHelper();
	}
	
	private List<?> getSelections() {
		List<?> result = new ArrayList<>(0);
		
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return result;
		}
		
		ISelection selection = window.getSelectionService().getSelection();
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection s = (IStructuredSelection) selection;
			return s.toList();
		}
		
		return result;
	}
	
	private IViewPart findViewPart(String viewId) {
		try {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			IViewReference reference = page.findViewReference(viewId);

			IWorkbenchPart part = reference.getPart(false);
			if (part instanceof IViewPart) {
				return (IViewPart) part;
			}
		} catch (NullPointerException e) {
			return null;
		}
		return null;
	}
	
	@Override
	public List<EObject> getSelectedElements() {
		List<EObject> result = new ArrayList<EObject>();
		
		for (Object selection : getSelections()) {
			if (selection instanceof IAdaptable) {
				EObject eObject = (EObject) ((IAdaptable)
						selection).getAdapter(EObject.class);
				if (eObject != null) {
					result.add(eObject);
				}
			}
		}
		return result;
	}

	@Override
	public List<EObject> getSelectedElements(Diagram diagram) {
		return null;
	}

	@Override
	public List<EObject> getSelectedElements(String viewId)
			throws IllegalArgumentException, NullPointerException {
		if (viewId == null) {
			throw new NullPointerException();
		} else if (viewId.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		IViewPart part = findViewPart(viewId);

		return null;
	}

	@Override
	public void setSelectedElements(List<? extends View> views) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setSelectedElements(Diagram diagram,
			List<? extends EObject> elements) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectedElements(String viewId,
			List<? extends EObject> elements) {
		// TODO Auto-generated method stub
		
	}

}
