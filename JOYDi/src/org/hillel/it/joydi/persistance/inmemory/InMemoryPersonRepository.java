package org.hillel.it.joydi.persistance.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.persistance.repository.PersonRepository;

public class InMemoryPersonRepository implements PersonRepository {

	private List<Admin> admin;
	private List<User> user;

	public InMemoryPersonRepository() {
		this.admin = new ArrayList<Admin>();
		this.user = new ArrayList<User>();
	}

	@Override
	public void saveUser(User person) {
		user.add(person);

	}

	@Override
	public void deleteUser(User person) {
		user.remove(person);

	}

	@Override
	public void saveAdmin(Admin person) {
		admin.add(person);

	}

	@Override
	public void deleteAdmin(Admin person) {
		admin.remove(person);

	}

	public void getAdmin() {
		System.out.println(admin);
	}

	public void getUser() {
		System.out.println(user);
	}

	@Override
	public void modifyUser(User person) {
		user.remove(person);
		user.add(person);
	}

}
