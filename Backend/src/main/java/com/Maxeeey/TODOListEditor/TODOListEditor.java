package com.Maxeeey.TODOListEditor;

import java.util.List;

import com.Maxeeey.TODOListElements.ITODOListElement;
import com.Maxeeey.TODOListElements.NormalTODOListElement;

public class TODOListEditor {

	public List<NormalTODOListElement> changeStatusById(List<NormalTODOListElement> listOfTODOs, int id) {
		List <NormalTODOListElement> copyList = listOfTODOs;
		
		for(ITODOListElement listelement: copyList) {
			if(listelement.getId() == id) {
				listelement.changeIsDoneBoolean();
				break;
			}
		}
		return listOfTODOs;
	}
}
