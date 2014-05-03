package org.hillel.it.joydi.model.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class User extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User(String name, String eMail, String country, Gender gender,
			int yearOfBirth, Months monthOfBirth, int dayOfBirth) {
		this.name = name;
		this.eMail = eMail;
		this.country = country;
		this.gender = gender;
		this.dateOfBirth = new GregorianCalendar(yearOfBirth, monthOfBirth.getMonth(), dayOfBirth);
		this.age = this.Age(dateOfBirth);
	}
	
	public User() {
		
	}
}