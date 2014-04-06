package org.hillel.it.joydi.model.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUser() {
		
		User u = new User("Yulia", "yulia@google.com", "Ukraine", Gender.FEMALE, 28);
		
		assertEquals("Incorrect name", "Yulia", u.getName());
		assertEquals("Incorrect email", "yulia@google.com", u.geteMail());
	}

	@Test
	public void testGetGender() {
		
		User u1 = new User("Yulia", "yulia@google.com", "Ukraine", Gender.FEMALE, 28);
		User u2 = new User("Yulia", "yulia@google.com", "Ukraine", Gender.MALE, 28);
		
		assertEquals("Wrong get gender", Gender.FEMALE, u1.getGender());
		assertEquals("Wrong get gender", Gender.MALE, u2.getGender());
		
	}

	@Test
	public void testSetGender() {
		User u2 = new User();
		u2.setGender(Gender.FEMALE);
		assertEquals("Wrong set gender", Gender.FEMALE, u2.getGender());
		
	}

	@Test
	public void testGetName() {
		User u1 = new User("Yulia", "yulia@google.com", "Ukraine", Gender.FEMALE, 28);
				
		assertEquals("Wrong get name", "Yulia", u1.getName());
				
	}

	@Test
	public void testSetName() {
		User u2 = new User();
		u2.setName("Yulia");
	
		assertEquals("Wrong set name","Yulia", u2.getName());
	}

	@Test
	public void testGeteMail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeteMail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCountry() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCountry() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAge() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAge() {
		fail("Not yet implemented");
	}

}
