package com.Maxeeey.TODOListElements;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class NormalTODOListElement implements ITODOListElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Use Long for the primary key
	private String name;
	private boolean isDone = false;
    
	public NormalTODOListElement(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean getIsDone() {
		return isDone;
	}
	@Override
	public void changeIsDoneBoolean() {
		isDone = !isDone;
	}

	@Override
	public int getId() {
		return id;
	}
	
}