package com.Maxeeey.REST;

import java.sql.Connection;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Maxeeey.PostgreSQL.DatabaseManager;
import com.Maxeeey.TODOListElements.NormalTODOListElement;

@RestController
@CrossOrigin(origins = "*")
public class GetTODOREST {	
	DatabaseManager dbManager = new DatabaseManager();
	
	@CrossOrigin(origins = "http://localhost:9001")
	@GetMapping(value="/addNormalTODOListItem")
	public String getNormalTODO(@RequestParam String name) {
		int maxID = dbManager.executeQueryToGetMaxInt("SELECT MAX(id) from todolistitem");
		if(maxID == -1) {
			return "There was a problem when trying to get the MaxID";
		}
		dbManager.executeQueryAndListIt("INSERT INTO todolistitem (name, id, isdone) "
				+ "VALUES ('"+name+"',"+(maxID+1)+",false)");
		return "A new Element with the name "+name+" was created.";
	}

	@CrossOrigin(origins = "http://localhost:9001")
	@GetMapping(value="/deleteListElementById")
	public String deleteTODOElementById(@RequestParam int id) {
		dbManager.executeQueryAndListIt("DELETE FROM todolistitem WHERE id ="+id);
		return "Das gewünschte Element wurde gelöscht";
	}

	@CrossOrigin(origins = "http://localhost:9001")
	@GetMapping(value="/changeStatusById")
	public String changeStatusById(@RequestParam int id) {
		dbManager.executeQueryAndListIt("UPDATE todolistitem SET isdone = NOT isdone WHERE id = "+id);
		return "The item property isDone with the id "+id+" got successfully changed";
	}
	
	//prints out message if databank is reachable
	@CrossOrigin(origins = "http://localhost:9001")
	@GetMapping(value="/checkConnectionPossible")
	public String checkConnectionToDatabase() {
		DatabaseManager dbManager = new DatabaseManager();
		return dbManager.checkConnectionPossible();
	}
	
	//returns a list of all items in the todolistitemtable
	@CrossOrigin(origins = "http://localhost:9001")
	@GetMapping(value="/printListOfTODOs")
	public List<NormalTODOListElement> getListOfTODOsRest() {
		return dbManager.executeQueryAndListIt("SELECT * from todolistitem");
	}
}