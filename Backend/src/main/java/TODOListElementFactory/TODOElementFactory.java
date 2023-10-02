package TODOListElementFactory;

import com.Maxeeey.TODOListElements.ITODOListElement;
import com.Maxeeey.TODOListElements.NormalTODOListElement;

/*
 * This Factory is meant for the case that more types of 
 * TODOListElements should ever be created
 * 
 * This factory sets the Id as a int
 */
public class TODOElementFactory {
	private static int staticId = 1;
	
	//until now only returns NormalTODOListElements
	public ITODOListElement createTODOListElement(String name) {
		int currentId = staticId;
		staticId++;
		
		return new NormalTODOListElement(name, currentId);
	}
}
