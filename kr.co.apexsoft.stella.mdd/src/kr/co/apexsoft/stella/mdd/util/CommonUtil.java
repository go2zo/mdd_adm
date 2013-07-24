package kr.co.apexsoft.stella.mdd.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class CommonUtil {

	public static List<Class> getClassList(Interaction _interaction) {
		List<Class> classList = new ArrayList<>();
		
		EList<Lifeline> lifelines = _interaction.getLifelines();
		for (int i = 0; i < lifelines.size(); i++) {
			Lifeline lifeline = lifelines.get(i);
			Property property = (Property) lifeline.getRepresents();
			
			if (property != null) {
				Type type = property.getType();
				
				if (type instanceof Class) {
					classList.add((Class) type);
				}
			}
		}
		
		return classList;
	}
	
	public static List<Interaction> getInteractionList(Collaboration _collaboration) {
		List<Interaction> interactionList = new ArrayList<>();
		
		return interactionList;
	}
}
