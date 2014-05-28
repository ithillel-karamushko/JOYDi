package org.hillel.it.joydi.model.entities;

/**
 * 
 * @author JOYDi
 * 
 */
public enum Gender {
	MALE("male"), FEMALE("female");
	private String text;

	private Gender(String text) {
		this.text = text;

	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
