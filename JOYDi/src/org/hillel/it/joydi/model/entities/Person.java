package org.hillel.it.joydi.model.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author Þëÿ
 *
 */


// ñóððîãàòíûé êëàññ
/* ÍÀÄÎ ÑÄÅËÀÒÜ ÌÅÒÎÄ, ÊÎÒÎÐÛÉ ÁÓÄÅÒ ÎÒÎÁÐÀÆÀÒÜ È Ñ×ÈÒÀÒÜ ÊÎËÈ×ÅÑÒÂÎ ËÅÒ ÀÂÒÎÌÀÒÈ×ÅÑÊÈ, ÊÎÃÄÀ ÌÛ
 * ÂÂÎÄÈÌ ÃÎÄ ÐÎÆÄÅÍÈß, À ÍÅ ÏÈÑÀÒÜ ÅÃÎ ÑÀÌÎÑÒÎßÒÅËÜÍÎ
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
	
	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(int yearOfBirth, Months monthOfBirth, int dayOfBirth) {
		this.dateOfBirth = new GregorianCalendar(yearOfBirth, monthOfBirth.getMonth(), dayOfBirth);}
		
	/**
	 * Getter for field gender;
	 * @return gender;
	 */
	public Gender getGender() {
		return gender;
	}
	/**
	 * Setter for field gender;
	 * modify the field gender;
	 * @param gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	/**
	 * Getter for field name;
	 * @return name;
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter for field name;
	 * modify the field name;
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Getter for field email;
	 * @return email;
	 */
	public String geteMail() {
		return eMail;
	}
	/**
	 * Setter for field email;
	 * modify the field email;
	 * @param eMail;
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	/**
	 * Getter for field country;
	 * @return country;
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * Setter for field country;
	 * modify the field country;
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * Getter for field age;
	 * @return age;
	 */
	public int getAge() {
		age = Age(dateOfBirth);
		return age;
	}
	/**
	 * Setter for field age;
	 * modify the field age;
	 * @param age
	 */

	
	protected int Age(GregorianCalendar dateOfBirth){
		GregorianCalendar today = new GregorianCalendar(); 
		if ((today.get(Calendar.MONTH) > dateOfBirth.get(Calendar.MONTH)) ||
		((today.get(Calendar.MONTH) == dateOfBirth.get(Calendar.MONTH)&&
				(today.get(Calendar.DATE) >= dateOfBirth.get(Calendar.DATE))))){
			return (today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR));
			
		}
		else {
			return (today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)-1);}
		

	}
}
