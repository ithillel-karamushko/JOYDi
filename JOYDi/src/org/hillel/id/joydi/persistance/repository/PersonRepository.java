package org.hillel.id.joydi.persistance.repository;

import org.hillel.it.joydi.model.entities.Person;

public interface PersonRepository {
	void savePerson(Person person);
	void deletePerson(Person person);
}
