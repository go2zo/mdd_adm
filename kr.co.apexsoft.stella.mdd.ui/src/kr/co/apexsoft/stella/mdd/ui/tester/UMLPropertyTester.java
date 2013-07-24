package kr.co.apexsoft.stella.mdd.ui.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.uml2.uml.NamedElement;

public class UMLPropertyTester extends PropertyTester {

	/** id for the properties to test */
	public static final String IS_NAMED_ELEMENT = "isNamedElement";
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		if(IS_NAMED_ELEMENT.equals(property) && receiver instanceof IStructuredSelection) {
			boolean currentValue = testIsNamedElement((IStructuredSelection)receiver);
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
				current = ((IAdaptable)current).getAdapter(EObject.class);
				return current instanceof NamedElement;
			}
			return selection.getFirstElement() instanceof NamedElement;
		}
		return false;
	}
}
