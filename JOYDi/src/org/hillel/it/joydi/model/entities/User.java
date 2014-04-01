package org.hillel.it.joydi.model.entities;

public class User extends Person {

	public User(String name, String eMail, String country, Gender gender,
			int age) {
		this.name = name;
		this.eMail = eMail;
		this.country = country;
		this.gender = gender;
		this.age = age;
	}
}