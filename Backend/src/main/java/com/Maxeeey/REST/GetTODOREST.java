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
	private List<ITODOListElement> listOfTODOs = new ArrayList<>();
	
	@GetMapping(value="/getNormalTODOListItem")
	public ITODOListElement getNormalTODO(@RequestParam String name) {
		ITODOListElement newElement = new NormalTODOListElement(name);
		listOfTODOs.add(newElement);
		return newElement;
	}
	
	@GetMapping(value="/printListOfTODOs")
	public List<ITODOListElement> getList(){
		System.out.println(listOfTODOs.size());
		return listOfTODOs;
	}
	
	@GetMapping(value="/deleteListElementById")
	public String deleteTODOElementById(@RequestParam int id) {
		if(listOfTODOs.isEmpty()) {
			return "Die Liste an TODOElementen ist leer!";
		}
		return "Das Element wurde erfolgreich gelöscht!";
	}
}
