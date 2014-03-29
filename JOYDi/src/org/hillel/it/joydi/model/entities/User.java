package org.hillel.it.joydi.model.entities;

import org.hillel.it.joydi.persistance.inmemory.InMemory;

import org.hillel.id.joydi.persistance.repository.PersonRepository;

public class User extends Person implements PersonRepository {
	private InMemory inMemory;

	public User(String name, String eMail, String country, String gender,
			int age) {
		this.name = name;
		this.eMail = eMail;
		this.country = country;
		this.gender = gender;
		this.age = age;

	}

	public void saveUser(User user) {
		inMemory.saveUser(user);
	}

	public void deleteUser(User user) {
		inMemory.deleteUser(user);
	}

}
