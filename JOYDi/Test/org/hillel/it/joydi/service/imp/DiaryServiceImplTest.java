package org.hillel.it.joydi.service.imp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.Months;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.model.search.ArticleCriteria;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.hillel.it.joydi.persistance.repository.PictureRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;
import org.junit.BeforeClass;
import org.junit.Test;

public class DiaryServiceImplTest {
	private static DiaryServiceImpl ds;
	private static TextRepository textRepository;
	private static PersonRepository personRepository;
	private static PictureRepository pictureRepository;

	@BeforeClass
	public static void before() {
		textRepository = new InMemoryTextRepository();
		personRepository = new InMemoryPersonRepository();
		ds = new DiaryServiceImpl();
	}



	public void testEnter() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		ds.exit(user);
		ds.enter("email2@gmail.com", "rretert");
		assertEquals("Incorrect", true, user.isEnter());

	}

	public void testClose() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		ds.enter("email2@gmail.com", "rretert");
		ds.exit(user);
		assertEquals("Incorrect", false, user.isEnter());

	}
}