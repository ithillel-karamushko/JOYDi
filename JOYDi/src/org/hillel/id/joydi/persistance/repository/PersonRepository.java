package org.hillel.id.joydi.persistance.repository;

public interface PersonRepository <T> {
	T createPerson();
	T modifyPerson(T person);
	void deletePerson(T person);
}
