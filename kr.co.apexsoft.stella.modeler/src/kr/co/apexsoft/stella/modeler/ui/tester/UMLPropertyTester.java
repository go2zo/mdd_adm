package kr.co.apexsoft.stella.modeler.ui.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;

public class UMLPropertyTester extends PropertyTester {

	/** id for the properties to test */
	public static final String IS_NAMED_ELEMENT = "isNamedElement";
	
	/** id for the properties to test */
	public static final String IS_ROOT_MODEL = "isRootModel";

	/** id for the properties to test */
	public static final String IS_MODEL = "isModel";

	/* (non-Javadoc)
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		if (IS_NAMED_ELEMENT.equals(property) && receiver instanceof IStructuredSelection) {
			boolean currentValue = testIsNamedElement((IStructuredSelection) receiver);
			return (new Boolean(currentValue).equals(expectedValue));
		}
		if (IS_ROOT_MODEL.equals(property) && receiver instanceof IStructuredSelection) {
			boolean currentValue = testIsRootModel((IStructuredSelection) receiver);
			return (new Boolean(currentValue).equals(expectedValue));
		}
		if (IS_MODEL.equals(property) && receiver instanceof IStructuredSelection) {
			boolean currentValue = testIsModel((IStructuredSelection) receiver);
			return (new Boolean(currentValue).equals(expectedValue));
		}
		return false;
	}

	/**
	 * return <code>true</code> if the selection is a NamedElement
	 * 
	 * @param selection
	 *        the selection owning the element to test
	 * @return
	 *        <code>true</code> if the selection is a NamedElement
	 */
	private boolean testIsNamedElement(IStructuredSelection selection) {
		if(!selection.isEmpty() && selection.size() == 1) {
			Object current = selection.getFirstElement();
			if(current instanceof IAdaptable) {
				current = ((IAdaptable) current).getAdapter(EObject.class);
				return current instanceof NamedElement;
			}
			return selection.getFirstElement() instanceof NamedElement;
		}
		return false;
	}
	
	/**
	 * return <code>true</code> if the selection is a root Model
	 * 
	 * @param selection
	 *        the selection owning the element to test
	 * @return
	 *        <code>true</code> if the selection is a root Model
	 */
	private boolean testIsRootModel(IStructuredSelection selection) {
		if(!selection.isEmpty() && selection.size() == 1) {
			Object current = selection.getFirstElement();
			if(current instanceof IAdaptable) {
				EObject eObject = (EObject) ((IAdaptable) current).getAdapter(EObject.class);
				return eObject instanceof Model && eObject.eContainer() == null;
			}
			return selection.getFirstElement() instanceof NamedElement;
		}
		return false;
	}

	/**
	 * return <code>true</code> if the selection is a Model
	 * 
	 * @param selection
	 *        the selection owning the element to test
	 * @return
	 *        <code>true</code> if the selection is a Model
	 */
	private boolean testIsModel(IStructuredSelection selection) {
		if(!selection.isEmpty() && selection.size() == 1) {
			Object current = selection.getFirstElement();
			if(current instanceof IAdaptable) {
				current = ((IAdaptable) current).getAdapter(EObject.class);
				return current instanceof Model;
			}
			return selection.getFirstElement() instanceof NamedElement;
		}
		return false;
	}
}
