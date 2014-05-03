package org.hillel.it.joydi.model.entities;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Admin extends Person{

	public Admin(String name, String eMail, String country, Gender gender,
			int yearOfBirth, Months monthOfBirth, int dayOfBirth) {
		this.name = name;
		this.eMail = eMail;
		this.country = country;
		this.gender = gender;
		this.dateOfBirth = new GregorianCalendar(yearOfBirth, monthOfBirth.getMonth(), dayOfBirth);
		this.age = this.Age(dateOfBirth);
	}
}