package org.hillel.it.joydi.persistance.inmemory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.persistance.repository.PersonRepository;

public class InMemoryPersonRepository implements PersonRepository {

	@Override
	public void saveUser(User person) throws FileNotFoundException, IOException {
		String name = person.getName();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"D://" + name + ".txt"));
		oos.writeObject(person);
		oos.close();

	}

	@Override
	public void deleteUser(User person) {
		String name = person.getName();
		File file = new File("D://" + name + ".txt");
		file.delete();

	}

	@Override
	public void saveAdmin(Admin person) throws FileNotFoundException,
			IOException {
		String name = person.getName();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"D://" + name + ".txt"));
		oos.writeObject(person);
		oos.close();

	}

	@Override
	public void deleteAdmin(Admin person) {
		String name = person.getName();
		File file = new File("D://" + name + ".txt");
		file.delete();

	}

	@Override
	public void modifyUser(User person) throws FileNotFoundException,
			IOException {
		saveUser(person);

	}

}
