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
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.junit.BeforeClass;

public class InMemoryPersonRepositoryTest {

	private static PersonRepository pr;

	@BeforeClass
	public static void before() {
		pr = new InMemoryPersonRepository();

	}

	@Test
	public void saveUserTest() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		User user = new User("Johny", "e@gmail.com", "Austria",
				Gender.MALE, 1989, Months.December, 23, "hwebryg");
		int beforeSave = pr.getPersons().size();
		pr.saveUser(user);
		int afterSave = pr.getPersons().size();
		assertTrue(afterSave > beforeSave);
	}

	@Test
	public void deleteUserTest() throws FileNotFoundException, IOException {
		User user = new User ("Johny", "e@gmail.com", "Austria",
				Gender.MALE, 1989, Months.December, 23, "hwebryg");
		pr.saveUser(user);
		int beforeDelete = pr.getPersons().size();
		pr.deleteUser(user);
		int afterDelete = pr.getPersons().size();
		assertTrue(afterDelete < beforeDelete);
	}

	@Test
	public void saveAdminTest() throws FileNotFoundException, IOException {
		Admin admin = new Admin("Johny", "e@gmail.com", "Austria",
				Gender.MALE, 1989, Months.December, 23, "hwebryg");
		int beforeSave = pr.getPersons().size();
		pr.saveAdmin(admin);
		int afterSave = pr.getPersons().size();
		assertTrue(afterSave > beforeSave);
	}

	@Test
	public void deleteAdminTest() throws FileNotFoundException, IOException {
		Admin admin = new Admin("Johny", "e@gmail.com", "Austria",
				Gender.MALE, 1989, Months.December, 23, "hwebryg");
		pr.saveAdmin(admin);
		int beforeDelete = pr.getPersons().size();
		pr.deleteAdmin(admin);
		int afterDelete = pr.getPersons().size();
		assertTrue(afterDelete < beforeDelete);
	}

	@Test
	public void modifyUserTest() throws FileNotFoundException, IOException {
		long lengthBeforeModify;
		long lengthAfterModify;
		File file = new File("d:\\test\\user.dat");
		User user3 = new User("John", "email", "Austria", Gender.MALE,
				1990, Months.March, 7, "asf45");
		pr.saveUser(user3);
		lengthBeforeModify = file.length();
		pr.modifyUser(user3);
		lengthAfterModify = file.length();
		assertTrue(lengthBeforeModify != lengthAfterModify);

	}

}
