package org.hillel.it.joydi.model.entities;

public enum Gender {
	MALE ("male"),
	FEMALE ("female");
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	private Gender (String text){
		this.text = text;
	
	}
}
