package kr.co.apexsoft.stella.uml.ui;

import java.util.List;

import kr.co.apexsoft.stella.uml.ui.internal.UMLUIHelper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

public interface IUMLUIHelper {
	
	IUMLUIHelper INSTANCE = UMLUIHelper.init();
	
	List<EObject> getSelectedElements();
	List<EObject> getSelectedElements(Diagram diagram);
	List<EObject> getSelectedElements(String viewId);
	void setSelectedElements(List<? extends View> views);
	void setSelectedElements(Diagram diagram, List<? extends EObject> elements);
	void setSelectedElements(String viewId, List<? extends EObject> elements);
	
}
