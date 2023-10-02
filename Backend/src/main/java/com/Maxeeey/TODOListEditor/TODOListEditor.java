package com.Maxeeey.TODOListEditor;

import java.util.List;

import com.Maxeeey.TODOListElements.ITODOListElement;

public class TODOListEditor {
	public List<ITODOListElement> deleteListElementById(List<ITODOListElement> inputList, int idToBeDeleted){
		for(ITODOListElement listelement: inputList) {
			if(listelement.getId() == idToBeDeleted) {
				inputList.remove(listelement);
			}
		}
		return inputList;
	}
}
