package org.hillel.it.joydi.persistance.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.entities.User;

public interface PersonRepository {
	void saveUser(User person) throws FileNotFoundException, IOException;

	void modifyUser(User person) throws FileNotFoundException, IOException;

	void deleteUser(User person) throws IOException;

	void saveAdmin(Admin person) throws FileNotFoundException, IOException;

	void deleteAdmin(Admin person) throws IOException;

	void birthday();

	List<Person> getPersons();
}
