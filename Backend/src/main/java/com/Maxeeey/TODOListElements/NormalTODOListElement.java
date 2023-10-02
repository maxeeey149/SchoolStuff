package com.Maxeeey.TODOListElements;

public class NormalTODOListElement implements ITODOListElement {
	private String name;
	private boolean isDone = false;
	private int id;
    
	public NormalTODOListElement(String name, int id) {
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
}