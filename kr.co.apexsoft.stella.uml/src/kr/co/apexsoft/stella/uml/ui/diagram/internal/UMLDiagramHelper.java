package kr.co.apexsoft.stella.uml.ui.diagram.internal;

import java.util.List;
import java.util.Set;

import kr.co.apexsoft.stella.uml.ui.diagram.IUMLDiagramHelper;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Relationship;

public class UMLDiagramHelper implements IUMLDiagramHelper {

	public static IUMLDiagramHelper init() {
		return new UMLDiagramHelper();
	}
	
	@Override
	public Diagram createDiagram(Namespace container, UMLDiagramKind kind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diagram createDiagram(Namespace container, UMLDiagramKind kind,
			Element context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge createEdge(View source, View target, Element element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge createEdge(View source, View target, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Edge> createEdges(Diagram diagram, Relationship element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node createNode(View container, Element element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node createNode(View container, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<View> createViews(Diagram diagram, List<?> objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroyView(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Diagram findDiagram(Element root, String id, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Diagram> findDiagramByName(Element container, String name,
			IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getChildView(View container, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diagram> getDiagrams(Namespace element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diagram> getDiagrams(Namespace element, UMLDiagramKind kind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diagram getMainDiagram(Namespace element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UMLDiagramKind getUmlDiagramKind(Diagram diagram) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layout(View view, String hint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void layoutNodes(List<? extends Node> nodes, String hint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openDiagramEditor(Diagram diagram) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderToImageFile(Diagram diagram, String file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image renderToSWTImage(Diagram diagram) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMainDiagram(Namespace element, Diagram diagram) {
		// TODO Auto-generated method stub
		
	}

}
