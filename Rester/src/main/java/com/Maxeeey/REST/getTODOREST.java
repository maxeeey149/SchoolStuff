package com.Maxeeey.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Maxeeey.TODOListElements.ITODOListElement;
import com.Maxeeey.TODOListElements.NormalTODOListElement;

@RestController
public class getTODOREST {
	private List<ITODOListElement> listOfTODOs = new ArrayList<>();
	
	@GetMapping(value="/getNormalTODOListItem")
	public ITODOListElement getNormalTODO(@RequestParam String name) {
		ITODOListElement newElement = new NormalTODOListElement(name);
		listOfTODOs.add(newElement);
		return newElement;
	}
	
	@GetMapping(value="/getNormalTODOListItemString")
	public String getNormalTODOString(@RequestParam String name) {
		return new NormalTODOListElement(name).getClass().getSimpleName();
	}
	
	@GetMapping("/printListOfTODOs")
	public List<ITODOListElement> getList(){
		System.out.println(listOfTODOs.size());
		return listOfTODOs;
	}
}
