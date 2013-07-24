package kr.co.apexsoft.stella.mdd.util;

import java.util.List;

import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;

public class InteractionUtil {

	public static List<InteractionFragment> getSortedFragments(Interaction _interaction) {
		return _interaction.getFragments();
	}
	
	public static Lifeline getSignificantLifeline(Interaction _interaction) {
		List<Lifeline> lifelines = _interaction.getLifelines();
		if (lifelines != null && lifelines.size() > 0) {
			return lifelines.get(0);
		}
		
		return null;
	}
}
