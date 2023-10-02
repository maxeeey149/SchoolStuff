package com.Maxeeey.TODOListEditor;

import java.util.List;

import com.Maxeeey.TODOListElements.ITODOListElement;

public class TODOListEditor {
	public List<ITODOListElement> deleteListElementById(List<ITODOListElement> inputList, int idToBeDeleted){
		List <ITODOListElement> copyList = inputList;
		
		for(ITODOListElement listelement: copyList) {
			if(listelement.getId() == idToBeDeleted) {
				inputList.remove(listelement);
				break;
			}
		}
		return inputList;
	}

	public List<ITODOListElement> changeStatusById(List<ITODOListElement> listOfTODOs, int id) {
		List <ITODOListElement> copyList = listOfTODOs;
		
		for(ITODOListElement listelement: copyList) {
			if(listelement.getId() == id) {
				listelement.changeIsDoneBoolean();
				break;
			}
		}
		return listOfTODOs;
	}
}
