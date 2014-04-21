package org.hillel.it.joydi.persistance.repository;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.User;

public interface PersonRepository {
	void saveUser(User person) throws FileNotFoundException, IOException;

	void modifyUser(User person) throws FileNotFoundException, IOException;

	void deleteUser(User person);

	void saveAdmin(Admin person) throws FileNotFoundException, IOException;

	void deleteAdmin(Admin person);
}
