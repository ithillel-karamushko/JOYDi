package org.hillel.it.joydi.persistance.repository;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.User;

public interface PersonRepository {
	void saveUser(User person);

	void modifyUser(User person);

	void deleteUser(User person);

	void saveAdmin(Admin person);

	void deleteAdmin(Admin person);

	void getAdmin();

	void getUser();
}
