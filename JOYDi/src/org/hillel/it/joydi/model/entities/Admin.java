package org.hillel.it.joydi.model.entities;

public class Admin extends Person {
	public Admin(String name, String eMail, String country, String gender,
			int age) {
		this.name = name;
		this.eMail = eMail;
		this.country = country;
		this.gender = gender;
		this.age = age;
	}

}