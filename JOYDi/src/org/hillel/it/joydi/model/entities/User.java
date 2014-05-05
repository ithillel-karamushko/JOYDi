package org.hillel.it.joydi.model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User(String name, String eMail, Countries country, Gender gender,
			int yearOfBirth, Months monthOfBirth, int dayOfBirth,
			String password) {
		this.name = name;
		this.eMail = eMail;
		this.country = country;
		this.gender = gender;
		GregorianCalendar cal = new GregorianCalendar();

		try {
			test(yearOfBirth, 1925, 2004);

			switch (monthOfBirth.getMonth()) {
			case 0:
			case 2:
			case 4:
			case 6:
			case 7:
			case 9:
			case 11:
				test(dayOfBirth, 1, 31);
			case 3:
			case 5:
			case 8:
			case 10:
				test(dayOfBirth, 1, 31);
			case 1: {
				if (cal.isLeapYear(yearOfBirth)) {
					test(dayOfBirth, 1, 29);
				} else {
					test(dayOfBirth, 1, 28);
				}
			}
			}
			this.dateOfBirth = new GregorianCalendar(yearOfBirth,
					monthOfBirth.getMonth(), dayOfBirth);
			this.age = this.Age(dateOfBirth);
		} catch (InputException ce) {

			System.out.println("Enter the real date of birth! " + ce);
		}

		Pattern p = Pattern.compile("[a-z0-9]{4,10}");

		Matcher m = p.matcher(password);
		boolean b = m.matches();
		if (b == true) {
			this.password = password;
		} else {
			System.out
					.println("The password may contains only digits and letters and it length should be >=4 && <= 10");
		}

	}

}