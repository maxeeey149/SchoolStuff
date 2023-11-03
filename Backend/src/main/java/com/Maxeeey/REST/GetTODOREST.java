package com.Maxeeey.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Maxeeey.Database.TODOListRepo;
import com.Maxeeey.TODOListEditor.TODOListEditor;
import com.Maxeeey.TODOListElements.ITODOListElement;
import com.Maxeeey.TODOListElements.NormalTODOListElement;

@RestController
@CrossOrigin(origins = "*")
public class GetTODOREST {
	@Autowired
	private TODOListRepo tODOListRepo;
	private TODOListEditor todoDeleter = new TODOListEditor();
	
	@GetMapping(value="/addNormalTODOListItem")
	public ITODOListElement getNormalTODO(@RequestParam String name) {
		NormalTODOListElement newCreatedTODOTask = new NormalTODOListElement(name);
		tODOListRepo.save(newCreatedTODOTask);
		return newCreatedTODOTask;
	}
	
	@GetMapping(value="/printListOfTODOs")
	public List<NormalTODOListElement> getList(){
		System.out.println("Elemente in der TODOListe: "+tODOListRepo.count());
		return tODOListRepo.findAll();
	}
	
	@GetMapping(value="/deleteListElementById")
	public String deleteTODOElementById(@RequestParam long id) {
		if(tODOListRepo.count() == 0) {
			return "Die Liste an TODOElementen ist leer!";
		}
		tODOListRepo.deleteById(id);
		return "Das Element wurde erfolgreich gelöscht!";
	}
	
	@GetMapping(value="/changeStatusById")
	public String changeStatusById(@RequestParam int id) {
		tODOListRepo = todoDeleter.changeStatusById(tODOListRepo, id);
		return "Das Element wurde erfolgreich gelöscht!";
	}
}
