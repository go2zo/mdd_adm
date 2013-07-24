package kr.co.apexsoft.stella.modeler.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.Interaction;

public class NamingRules {
	
	public static String getDefaultName(EClass eClass) {
		String name = eClass.getName();
		String transString = name.substring(0, 1);
		transString.toUpperCase();
		transString += name.substring(1);
		return transString;
	}

	public static String getOrderedName(String name,
			Interaction interaction) {
		return name;
	}

}
