package kr.co.apexsoft.stella.modeler.provider;

import kr.co.apexsoft.stella.modeler.ui.UMLModeler;
import kr.co.apexsoft.stella.modeler.uml.UMLDiagramKind;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.Namespace;

public class NamespaceProvider {

	private Namespace element;
	
	public NamespaceProvider(Namespace element) {
		this.element = element;
	}
	
	public void createDiagram(String name, UMLDiagramKind kind) {
		Diagram diagram = UMLModeler.getUMLDiagramHelper().createDiagram(element, kind);
		diagram.setName(name);
	}
	
}
