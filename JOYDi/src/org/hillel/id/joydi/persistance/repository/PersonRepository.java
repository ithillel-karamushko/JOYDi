package org.hillel.id.joydi.persistance.repository;

import java.util.List;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.entities.User;

public interface PersonRepository {
	void saveUser(User person);

	void deleteUser(User person);

	void saveAdmin(Admin person);

	void deleteAdmin(Admin person);

	void getAdmin();

	void getUser();
}
