package com.Maxeeey.TODOListElements;

public class NormalTODOListElement implements ITODOListElement {
    private int id; 
	private String name;
	private boolean isDone = false;
    
	public NormalTODOListElement(String name, int id, boolean isDone) {
		this.name = name;
		this.id = id;
		this.isDone = isDone;
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