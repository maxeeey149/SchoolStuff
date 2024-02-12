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
	
	@GetMapping(value="/deleteListElementById")
	public String deleteTODOElementById(@RequestParam int id) {
		dbManager.executeQueryAndListIt("DELETE FROM todolistitem WHERE id ="+id);
		return "Das gewünschte Element wurde gelöscht";
	}
	
	@GetMapping(value="/changeStatusById")
	public String changeStatusById(@RequestParam int id) {
		dbManager.executeQueryAndListIt("UPDATE todolistitem SET isdone = NOT isdone WHERE id = "+id);
		return "The item property isDone with the id "+id+" got successfully changed";
	}
	
	//prints out message if databank is reachable
	@GetMapping(value="/checkConnectionPossible")
	public Connection checkConnectionToDatabase() {
		DatabaseManager dbManager = new DatabaseManager();
		return dbManager.getConnectionToDatabase();
	}
	
	//returns a list of all items in the todolistitemtable
	@GetMapping(value="/printListOfTODOs")
	public List<NormalTODOListElement> getListOfTODOsRest() {
		return dbManager.executeQueryAndListIt("SELECT * from todolistitem");
	}
	
}