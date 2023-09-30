package com.Maxeeey.TODOListElements;

public class NormalTODOListElement implements ITODOListElement {
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
}