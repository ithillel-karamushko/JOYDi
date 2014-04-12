package org.hillel.it.joydi.model.entities;
/**
 * 
 * @author Юля
 *
 */


// суррогатный класс

abstract public class Person extends BaseEntity {
	protected String name;
	protected String eMail;
	protected String country;
	protected Gender gender;
	protected int age; 
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
		return age;
	}
	/**
	 * Setter for field age;
	 * modify the field age;
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
