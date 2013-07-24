package kr.co.apexsoft.stella.uml.ui.diagram;

import java.util.List;
import java.util.Set;

import kr.co.apexsoft.stella.uml.ui.diagram.internal.UMLDiagramHelper;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Relationship;


public interface IUMLDiagramHelper {
	
	IUMLDiagramHelper INSTANCE = UMLDiagramHelper.init();
	
	enum UMLDiagramKind {
		ACTIVITY, CLASS, COMMUNICATION, COMPONENT, OBJECT, SEQUENCE, STATECHART, STRUCTURE, USECASE
	}
	
	Diagram createDiagram(Namespace container, UMLDiagramKind kind);
	Diagram createDiagram(Namespace container, UMLDiagramKind kind, Element context);
	Edge createEdge(View source, View target, Element element);
	Edge createEdge(View source, View target, String type);
	List<Edge> createEdges(Diagram diagram, Relationship element);
	Node createNode(View container, Element element);
	Node createNode(View container, String type);
	List<View> createViews(Diagram diagram, List<?> objects);
	void destroyView(View view);
	Diagram findDiagram(Element root, String id, IProgressMonitor monitor);
	Set<Diagram> findDiagramByName(Element container, String name, IProgressMonitor monitor);
	View getChildView(View container, String type);
	List<Diagram> getDiagrams(Namespace element);
	List<Diagram> getDiagrams(Namespace element, UMLDiagramKind kind);
	// ILayoutNode getLayoutNode(Node node);
	Diagram getMainDiagram(Namespace element);
	UMLDiagramKind getUmlDiagramKind(Diagram diagram);
	void layout(View view, String hint);
	void layoutNodes(List<? extends Node> nodes, String hint);
	void openDiagramEditor(Diagram diagram);
	void renderToImageFile(Diagram diagram, String file);
	Image renderToSWTImage(Diagram diagram);
	void setMainDiagram(Namespace element, Diagram diagram);
	
}
