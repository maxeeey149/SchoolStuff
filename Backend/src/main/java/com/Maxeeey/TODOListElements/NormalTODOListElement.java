package com.Maxeeey.TODOListElements;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class NormalTODOListElement implements ITODOListElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use Long for the primary key
	private String name;
	private boolean isDone = false;
    
	public NormalTODOListElement(String name) {
		this.name = name;
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
	public Long getId() {
		return id;
	}
	
}