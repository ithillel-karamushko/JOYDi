package org.hillel.it.joydi.persistance.inmemory;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

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
	public void saveUserTest() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		long lengthBeforeSave;
		long lengthAfterSave;
		File file = new File("d:\\test\\user.dat");
		User user = new User("John", "email", Countries.Ukraine, Gender.MALE,
				1990, Months.March, 07, "asf45");
		lengthBeforeSave = file.length();
		pr.saveUser(user);
		lengthAfterSave = file.length();
		assertTrue(lengthBeforeSave < lengthAfterSave);
	}

	@Test
	public void deleteUserTest() throws FileNotFoundException, IOException {
		long lengthBeforeDelete;
		long lengthAfterDelete;
		File file = new File("d:\\test\\user.dat");
		User user1 = new User("John", "email", Countries.Ukraine, Gender.MALE,
				1990, Months.March, 07, "asf45");
		pr.saveUser(user1);
		lengthBeforeDelete = file.length();
		pr.deleteUser(user1);
		lengthAfterDelete = file.length();
		assertTrue(lengthBeforeDelete > lengthAfterDelete);
	}

	@Test
	public void saveAdminTest() throws FileNotFoundException, IOException {
		long lengthBeforeSave;
		long lengthAfterSave;
		File file = new File("d:\\test\\user.dat");
		Admin admin = new Admin("Helen", "email", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 07, "asf45");
		lengthBeforeSave = file.length();
		pr.saveAdmin(admin);
		lengthAfterSave = file.length();
		assertTrue(lengthBeforeSave != lengthAfterSave);
	}

	@Test
	public void deleteAdminTest() throws FileNotFoundException, IOException {
		long lengthBeforeDelete;
		long lengthAfterDelete;
		File file = new File("d:\\test\\user.dat");
		Admin admin1 = new Admin("Helen", "email", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 07, "asf45");
		pr.saveAdmin(admin1);
		lengthBeforeDelete = file.length();
		pr.deleteAdmin(admin1);
		lengthAfterDelete = file.length();
		assertTrue(lengthBeforeDelete > lengthAfterDelete);
	}

	@Test
	public void modifyUserTest() throws FileNotFoundException, IOException {
		long lengthBeforeModify;
		long lengthAfterModify;
		File file = new File("d:\\test\\user.dat");
		User user3 = new User("John", "email", Countries.Ukraine, Gender.MALE,
				1990, Months.March, 07, "asf45");
		pr.saveUser(user3);
		lengthBeforeModify = file.length();
		pr.modifyUser(user3);
		lengthAfterModify = file.length();
		assertTrue(lengthBeforeModify != lengthAfterModify);

	}

}
