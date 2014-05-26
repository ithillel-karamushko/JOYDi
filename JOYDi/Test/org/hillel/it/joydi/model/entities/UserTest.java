package org.hillel.it.joydi.model.entities;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUser() {

		User u = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 7, "asf45");

		assertEquals("Incorrect name", "Yulia", u.getName());
		assertEquals("Incorrect email", "yulia@google.com", u.geteMail());
		assertEquals("Incorrect country", Countries.Ukraine, u.getCountry());
		assertEquals("Incorrect gender", Gender.FEMALE, u.getGender());
		assertEquals("Incorrect year", 1990,
				u.getDateOfBirth().get(Calendar.YEAR));
		assertEquals("Incorrect month", Months.March.getMonth(), u
				.getDateOfBirth().get(Calendar.MONTH));
		assertEquals("Incorrect day", 7, u.getDateOfBirth().get(Calendar.DATE));
	}

	@Test
	public void testGetGender() {

		User u1 = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 7, "asf45");
		User u2 = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.MALE, 1990, Months.March, 7, "asf45");

		assertEquals("Incorrect get gender", Gender.FEMALE, u1.getGender());
		assertEquals("Incorrect get gender", Gender.MALE, u2.getGender());

	}

	@Test
	public void testSetGender() {
		User u2 = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 7, "asf45");
		u2.setGender(Gender.FEMALE);
		assertEquals("Incorrect set gender", Gender.FEMALE, u2.getGender());

	}

	@Test
	public void testGetName() {
		User u1 = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 7, "asf45");

		assertEquals("Incorrect get name", "Yulia", u1.getName());

	}

	@Test
	public void testSetName() {
		User u2 = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 7, "asf45");
		u2.setName("Yulia");

		assertEquals("Incorrect set name", "Yulia", u2.getName());
	}

	@Test
	public void testGeteMail() {
		User u1 = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 7, "asf45");

		assertEquals("Incorrect get email", "yulia@google.com", u1.geteMail());

	}

	@Test
	public void testSeteMail() {
		User u2 = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 7, "asf45");
		u2.seteMail("yulia@google.com");

		assertEquals("Incorrect set email", "yulia@google.com", u2.geteMail());
	}

	@Test
	public void testGetCountry() {
		User u1 = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 7, "asf45");

		assertEquals("Incorrect get country", Countries.Ukraine,
				u1.getCountry());
	}

	@Test
	public void testSetCountry() {
		User u2 = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 7, "asf45");
		u2.setCountry(Countries.Ukraine);

		assertEquals("Incorrect set country", Countries.Ukraine,
				u2.getCountry());

	}

	@Test
	public void testGetDateOfBirth() {
		User u1 = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 7, "asf45");

		assertEquals("Incorrect year", 1990,
				u1.getDateOfBirth().get(Calendar.YEAR));
		assertEquals("Incorrect month", Months.March.getMonth(), u1
				.getDateOfBirth().get(Calendar.MONTH));
		assertEquals("Incorrect day", 7, u1.getDateOfBirth().get(Calendar.DATE));
	}

	@Test
	public void testSetDateOfBirth() {
		User u2 = new User("Yulia", "yulia@google.com", Countries.Ukraine,
				Gender.FEMALE, 1990, Months.March, 7, "asf45");
		u2.setDateOfBirth(1995, Months.March, 15);

		assertEquals("Incorrect set year", 1995,
				u2.getDateOfBirth().get(Calendar.YEAR));
		assertEquals("Incorrect set month", Months.March.getMonth(), u2
				.getDateOfBirth().get(Calendar.MONTH));
		assertEquals("Incorrect set day", 15,
				u2.getDateOfBirth().get(Calendar.DATE));
	}

}
