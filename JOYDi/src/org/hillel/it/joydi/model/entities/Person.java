package org.hillel.it.joydi.model.entities;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author JOYDi
 * 
 */

abstract public class Person extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 371819977920264704L;
	protected String name;
	protected String eMail;
	protected String country;
	protected Gender gender;
	protected GregorianCalendar dateOfBirth;
	protected int age;
	protected String password;
	protected boolean isEnter = false;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnter() {
		return isEnter;
	}

	public void setEnter(boolean isEnter) {
		this.isEnter = isEnter;
	}

	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int yearOfBirth, Months monthOfBirth,
			int dayOfBirth) {
		this.dateOfBirth = new GregorianCalendar(yearOfBirth,
				monthOfBirth.getMonth(), dayOfBirth);
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getAge() {
		age = Age(dateOfBirth);
		return age;
	}

	protected int Age(GregorianCalendar dateOfBirth) {
		GregorianCalendar today = new GregorianCalendar();
		if ((today.get(Calendar.MONTH) > dateOfBirth.get(Calendar.MONTH))
				|| ((today.get(Calendar.MONTH) == dateOfBirth
						.get(Calendar.MONTH) && (today.get(Calendar.DATE) >= dateOfBirth
						.get(Calendar.DATE))))) {
			return (today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR));

		} else {
			return (today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR) - 1);
		}

	}

	protected void test(int value, int theLowestLimit, int theHighestLimit)
			throws InputException {
		if (value < theLowestLimit || value > theHighestLimit)
			throw new InputException();

	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
