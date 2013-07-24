package kr.co.apexsoft.stella.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class StellaUtils {
	
	public static <T> List<T> getSelections(Class<T> templateClass) {
		ISelection selection = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow()
				.getSelectionService().getSelection();
		
		List<T> result = new ArrayList<T>();
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection s = (IStructuredSelection) selection;
			for (Iterator iter = s.iterator(); iter.hasNext(); ) {
				Object next = iter.next();
				if (next instanceof IAdaptable) {
					T element = (T) ((IAdaptable)next).getAdapter(templateClass);
					result.add(element);
				}
			}
		}
		
		return result;
	}
	
}
