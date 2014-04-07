package org.hillel.it.joydi.jUnitTests;

import static org.junit.Assert.*;

import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.User;
import org.junit.Test;

public class UserTest {

	@Test
	public void testUser() {

		User u = new User("Yulia", "yulia@google.com", "Ukraine",
				Gender.FEMALE, 28);

		assertEquals("Incorrect name", "Yulia", u.getName());
		assertEquals("Incorrect email", "yulia@google.com", u.geteMail());
		assertEquals("Incorrect country", "Ukraine", u.getCountry());
		assertEquals("Incorrect gender", Gender.FEMALE, u.getGender());
		assertEquals("Incorrect age", 28, u.getAge());
	}

	@Test
	public void testGetGender() {

		User u1 = new User("Yulia", "yulia@google.com", "Ukraine",
				Gender.FEMALE, 28);
		User u2 = new User("Yulia", "yulia@google.com", "Ukraine", Gender.MALE,
				28);

		assertEquals("Incorrect get gender", Gender.FEMALE, u1.getGender());
		assertEquals("Incorrect get gender", Gender.MALE, u2.getGender());

	}

	@Test
	public void testSetGender() {
		User u2 = new User();
		u2.setGender(Gender.FEMALE);
		assertEquals("Incorrect set gender", Gender.FEMALE, u2.getGender());

	}

	@Test
	public void testGetName() {
		User u1 = new User("Yulia", "yulia@google.com", "Ukraine",
				Gender.FEMALE, 28);

		assertEquals("Incorrect get name", "Yulia", u1.getName());

	}

	@Test
	public void testSetName() {
		User u2 = new User();
		u2.setName("Yulia");

		assertEquals("Incorrect set name", "Yulia", u2.getName());
	}

	@Test
	public void testGeteMail() {
		User u1 = new User("Yulia", "yulia@google.com", "Ukraine",
				Gender.FEMALE, 28);

		assertEquals("Incorrect get email", "yulia@google.com", u1.geteMail());

	}

	@Test
	public void testSeteMail() {
		User u2 = new User();
		u2.seteMail("yulia@google.com");

		assertEquals("Incorrect set email", "yulia@google.com", u2.geteMail());
	}

	@Test
	public void testGetCountry() {
		User u1 = new User("Yulia", "yulia@google.com", "Ukraine",
				Gender.FEMALE, 28);

		assertEquals("Incorrect get country", "Ukraine", u1.getCountry());
	}

	@Test
	public void testSetCountry() {
		User u2 = new User();
		u2.setCountry("Ukraine");

		assertEquals("Incorrect set country", "Ukraine", u2.getCountry());

	}

	@Test
	public void testGetAge() {
		User u1 = new User("Yulia", "yulia@google.com", "Ukraine",
				Gender.FEMALE, 28);

		assertEquals("Incorrect get age", 28, u1.getAge());
	}

	@Test
	public void testSetAge() {
		User u2 = new User();
		u2.setAge(28);

		assertEquals("Incorrect set age", 28, u2.getAge());

	}

}
