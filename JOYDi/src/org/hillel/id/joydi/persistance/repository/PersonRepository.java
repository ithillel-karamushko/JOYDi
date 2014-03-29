package org.hillel.id.joydi.persistance.repository;

import org.hillel.it.joydi.model.entities.User;

public interface PersonRepository {
	void saveUser(User user);
	void deleteUser(User user);
}
