package org.hillel.it.joydi.model.entities;

public class User extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User(String name, String eMail, String country, Gender gender,
			int age) {
		this.name = name;
		this.eMail = eMail;
		this.country = country;
		this.gender = gender;
		this.age = age;
	}
	
	public User() {
		
	}
}