package org.hillel.it.joydi.model.entities;

/**
 * 
 * @author Æåíÿ
 * 
 */
public enum Gender {
	MALE("male"), FEMALE("female");
	private String text;

	private Gender(String text) {
		this.text = text;

	}

	/**
	 * Getter for field text
	 * @return field text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Setter for field text
	 * @param text - String that we need to initialized in field text
	 */
	public void setText(String text) {
		this.text = text;
	}

}
