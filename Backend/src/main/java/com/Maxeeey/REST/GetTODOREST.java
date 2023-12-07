package com.Maxeeey.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Maxeeey.TODOListElements.ITODOListElement;
import com.Maxeeey.TODOListElements.NormalTODOListElement;

@RestController
@CrossOrigin(origins = "*")
public class GetTODOREST {
	private List<NormalTODOListElement> listWithToDos = new ArrayList<>();
	static int idCounter = 0;
	
	@GetMapping(value="/addNormalTODOListItem")
	public ITODOListElement getNormalTODO(@RequestParam String name) {
		NormalTODOListElement newCreatedTODOTask = new NormalTODOListElement(name, idCounter);
		idCounter++;
		listWithToDos.add(newCreatedTODOTask);
		return newCreatedTODOTask;
	}
	
	@GetMapping(value="/printListOfTODOs")
	public List<NormalTODOListElement> getList(){
		System.out.println("Elemente in der TODOListe: "+listWithToDos.size());
		return listWithToDos;
	}
	
	@GetMapping(value="/deleteListElementById")
	public String deleteTODOElementById(@RequestParam int id) {
		if(listWithToDos.size() == 0) {
			return "Die Liste an TODOElementen ist leer!";
		}
		for(int i = 0; i<listWithToDos.size(); i++) {
			if(listWithToDos.get(i).getId() == id) {
				listWithToDos.remove(i);
				return "Das Element wurde erfolgreich gelöscht!";
			}
		}
		return "Es wurde kein Element mit passender ID gefunden";
	}
	
	@GetMapping(value="/changeStatusById")
	public String changeStatusById(@RequestParam int id) {
		
		if(listWithToDos.size() == 0) {
			return "Die Liste an TODOElementen ist leer!";
		}
		for(int i = 0; i<listWithToDos.size(); i++) {
			if(listWithToDos.get(i).getId() == id) {
				listWithToDos.get(i).changeIsDoneBoolean();
				return "Das Element wurde erfolgreich gelöscht!";
			}
		}
		return "Es wurde kein Element mit passender ID gefunden";
	}
}
