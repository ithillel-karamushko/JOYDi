package org.hillel.it.joydi.persistance.inmemory;

import static org.junit.Assert.*;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.junit.BeforeClass;

public class InMemoryPersonRepositoryTest {

	private static PersonRepository pr;

	@BeforeClass
	public static void before() {
		pr = new InMemoryPersonRepository();

	}
}
