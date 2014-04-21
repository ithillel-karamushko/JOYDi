package org.hillel.it.joydi.persistance.inmemory;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.User;
import org.junit.Test;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.junit.BeforeClass;

public class InMemoryPersonRepositoryTest {

	private static PersonRepository pr;

	@BeforeClass
	public static void before() {
		pr = new InMemoryPersonRepository();
	}

	@Test
	public void saveUserTest() throws FileNotFoundException, IOException {
		int i = pr.getUser().size() + 1;
		User user = new User("John", "email", "ukraine", Gender.MALE, 22);
		pr.saveUser(user);
		assertEquals("Incorrect value", i, pr.getUser().size());
		assertEquals("Incorrect value", true, pr.getUser().contains(user));

	}

	@Test
	public void deleteUserTest() throws FileNotFoundException, IOException {
		User user = new User("John", "email", "ukraine", Gender.MALE, 22);
		pr.saveUser(user);
		int i = pr.getUser().size() - 1;
		pr.deleteUser(user);
		assertEquals("Incorrect value", i, pr.getUser().size());
		assertEquals("Incorrect value", false, pr.getUser().contains(user));

	}

	@Test
	public void saveAdminTest() throws FileNotFoundException, IOException {
		int i = pr.getAdmin().size() + 1;
		Admin admin = new Admin("Helen", "email", "poland", Gender.FEMALE, 23);
		pr.saveAdmin(admin);
		assertEquals("Incorrect value", i, pr.getAdmin().size());
		assertEquals("Incorrect value", true, pr.getAdmin().contains(admin));
	}

	@Test
	public void deleteAdminTest() throws FileNotFoundException, IOException {
		Admin admin = new Admin("Helen", "email", "poland", Gender.FEMALE, 23);
		pr.saveAdmin(admin);
		int i = pr.getAdmin().size() - 1;
		pr.deleteAdmin(admin);
		assertEquals("Incorrect value", i, pr.getAdmin().size());
		assertEquals("Incorrect value", false, pr.getAdmin().contains(admin));
	}

	@Test
	public void modifyUserTest() throws FileNotFoundException, IOException {
		User user = new User("John", "email", "ukraine", Gender.MALE, 22);
		pr.saveUser(user);
		int i = pr.getUser().size();
		pr.modifyUser(user);
		assertEquals("Incorrect value", i, pr.getUser().size());
		assertEquals("Incorrect value", true, pr.getUser().contains(user));

	}

}
