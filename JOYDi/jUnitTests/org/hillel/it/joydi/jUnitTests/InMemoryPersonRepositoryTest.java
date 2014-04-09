package org.hillel.it.joydi.jUnitTests;

import static org.junit.Assert.*;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.User;
import org.junit.Test;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.junit.BeforeClass;

public class InMemoryPersonRepositoryTest {
	private static Admin admin;
	private static PersonRepository pr ;
	private static User user ;
	private static int i;
	
	@BeforeClass
	public static void before() {
		user = new User("John", "email", "ukraine", Gender.MALE, 22);
		pr = new InMemoryPersonRepository();
		admin = new Admin("Helen", "email", "poland", Gender.FEMALE, 23);
	}
	
	@Test
	public void saveUserTest() {
		i = pr.getUser().size()+1;
		pr.saveUser(user);
		assertEquals("Incorrect value", i, pr.getUser().size());
		assertEquals("Incorrect value", true, pr.getUser().contains(user));

	}

	@Test
	public void deleteUserTest() {
		pr.saveUser(user);
		i = pr.getUser().size()-1;
		pr.deleteUser(user);
		assertEquals("Incorrect value", i, pr.getUser().size());
	}

	@Test
	public void saveAdminTest() {
		i = pr.getAdmin().size()+1;
		pr.saveAdmin(admin);
		assertEquals("Incorrect value", i, pr.getAdmin().size());
		assertEquals("Incorrect value", true, pr.getAdmin().contains(admin));
	}

	@Test
	public void deleteAdminTest() {
		i = pr.getAdmin().size()-1;
		pr.deleteAdmin(admin);
		assertEquals("Incorrect value", i, pr.getAdmin().size());
		assertEquals("Incorrect value", false, pr.getAdmin().contains(admin));
	}
	
	@Test
	public void modifyUserTest() {
		i = pr.getUser().size();
		pr.modifyUser(user);
		assertEquals("Incorrect value", i, pr.getUser().size());
		assertEquals("Incorrect value", true, pr.getUser().contains(user));
		
	}

}
