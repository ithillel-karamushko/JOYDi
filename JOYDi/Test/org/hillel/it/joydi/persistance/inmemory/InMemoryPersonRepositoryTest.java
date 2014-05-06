package org.hillel.it.joydi.persistance.inmemory;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Countries;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.Months;
import org.hillel.it.joydi.model.entities.User;
import org.junit.Test;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonFileRepository;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.junit.BeforeClass;

public class InMemoryPersonRepositoryTest {

	private static PersonRepository pr;

	@BeforeClass
	public static void before() {
		pr = new InMemoryPersonFileRepository();
	}

	@Test
	public void saveUserTest() throws FileNotFoundException, IOException {
		User user = new User("John", "email", Countries.Ukraine, Gender.MALE, 1990, Months.March ,07, "asf45");
		pr.saveUser(user);
		File file = new File("D://" + user.getName() + ".txt");
		boolean isExist = file.exists();
		assertTrue(isExist);

	}

	@Test
	public void deleteUserTest() throws FileNotFoundException, IOException {
		User user = new User("John", "email", Countries.Ukraine, Gender.MALE, 1990, Months.March ,07, "asf45");
		pr.saveUser(user);
		pr.deleteUser(user);
		File file = new File("D://" + user.getName() + ".txt");
		boolean isExist = file.exists();
		assertFalse(isExist);

	}

	@Test
	public void saveAdminTest() throws FileNotFoundException, IOException {
		Admin admin = new Admin("Helen", "email", Countries.Ukraine, Gender.FEMALE, 1990, Months.March, 07, "asf45");
		pr.saveAdmin(admin);
		File file = new File("D://" + admin.getName() + ".txt");
		boolean isExist = file.exists();
		assertTrue(isExist);

	}

	@Test
	public void deleteAdminTest() throws FileNotFoundException, IOException {
		Admin admin = new Admin("Helen", "email", Countries.Ukraine, Gender.FEMALE, 1990, Months.March ,07, "asf45");
		pr.saveAdmin(admin);
		pr.deleteAdmin(admin);
		File file = new File("D://" + admin.getName() + ".txt");
		boolean isExist = file.exists();
		assertFalse(isExist);
	}

	@Test
	public void modifyUserTest() throws FileNotFoundException, IOException {
		User user = new User("John", "email", Countries.Ukraine, Gender.MALE, 1990, Months.March ,07, "asf45");
		pr.saveUser(user);
		pr.modifyUser(user);
		File file = new File("D://" + user.getName() + ".txt");
		boolean isExist = file.exists();
		assertTrue(isExist);

	}

}
