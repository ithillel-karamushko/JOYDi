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

	@Test
	public void testSaveArticle() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		user.setEnter(true);
		int i = ds.getTextRepository().getArticle().size() + 1;
		Article article = new Article(user, "Java", "I like Java.", "Java");
		ds.saveArticle(article);
		assertEquals("Incorrect", i, ds.getTextRepository().getArticle().size());
		assertEquals("Incorrect value", true, ds.getTextRepository()
				.getArticle().contains(article));
	}

	@Test
	public void testDeleteArticle() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		user.setEnter(true);
		Article article = new Article(user, "Java", "I like Java.", "Java");
		ds.saveArticle(article);
		int i = ds.getTextRepository().getArticle().size() - 1;
		ds.deleteArticle(article);
		assertEquals("Incorrect", i, ds.getTextRepository().getArticle().size());
		assertEquals("Incorrect value", false, ds.getTextRepository()
				.getArticle().contains(article));
	}

	@Test
	public void testSaveUser() throws FileNotFoundException, IOException {
		User user = new User("Johny", "e@gmail.com", "Albania",
				Gender.MALE, 1989, Months.December, 23, "hwebryg");
		int beforeSave = personRepository.getPersons().size();
		ds.saveUser(user);
		int afterSave = personRepository.getPersons().size();
		assertTrue(afterSave > beforeSave);
	}

	@Test
	public void testSaveAdmin() throws FileNotFoundException, IOException {
		Admin admin = new Admin("Johny", "e@gmail.com", "Albania",
				Gender.MALE, 1989, Months.December, 23, "hwebryg");
		int beforeSave = personRepository.getPersons().size();
		ds.saveAdmin(admin);
		int afterSave = personRepository.getPersons().size();
		assertTrue(afterSave > beforeSave);

	}

	@Test
	public void testDeleteUser() throws FileNotFoundException, IOException {
		User user = new User("Johny", "e@gmail.com", "Albania",
				Gender.MALE, 1989, Months.December, 23, "hwebryg");
		ds.saveUser(user);
		int beforeDelete = personRepository.getPersons().size();
		ds.deleteUser(user);
		int afterDelete = personRepository.getPersons().size();
		assertTrue(afterDelete < beforeDelete);

	}

	@Test
	public void testModifyUser() throws FileNotFoundException, IOException {
		long lengthBeforeModify;
		long lengthAfterModify;
		File file = new File("d:\\test\\user.dat");
		User user = new User("John", "email", "Albania", Gender.MALE,
				1990, Months.March, 7, "asf45");
		ds.saveUser(user);
		lengthBeforeModify = file.length();
		ds.modifyUser(user, "Leo", "mail", null, null, 1990, Months.March, 7);
		lengthAfterModify = file.length();
		assertTrue(lengthBeforeModify != lengthAfterModify);
		assertEquals("Incorrect", "Leo", user.getName());
		assertEquals("Incorrect", "mail", user.geteMail());

	}

	@Test
	public void testDeleteAdmin() throws FileNotFoundException, IOException {
		Admin admin = new Admin("Johny", "e@gmail.com", "Albania",
				Gender.MALE, 1989, Months.December, 23, "hwebryg");
		ds.saveAdmin(admin);
		int beforeDelete = personRepository.getPersons().size();
		ds.deleteAdmin(admin);
		int afterDelete = personRepository.getPersons().size();
		assertTrue(afterDelete < beforeDelete);

	}

	@Test
	public void testSaveComment() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		user.setEnter(true);
		Comment comment = new Comment(user, "Nice words");
		int i = ds.getTextRepository().getComment().size() + 1;
		ds.saveComment(comment);
		assertEquals("Incorrect", i, ds.getTextRepository().getComment().size());
		assertEquals("Incorrect value", true, ds.getTextRepository()
				.getComment().contains(comment));
	}

	@Test
	public void testDeleteComment() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		user.setEnter(true);
		Comment comment = new Comment(user, "Nice words");
		ds.saveComment(comment);
		int i = ds.getTextRepository().getComment().size() - 1;
		ds.deleteComment(comment);
		assertEquals("Incorrect", i, ds.getTextRepository().getComment().size());
		assertEquals("Incorrect", false, ds.getTextRepository().getComment()
				.contains(comment));
	}

	@Test
	public void findArticles() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		Article article = new Article(user, "Java", "I  don't like Java.",
				"Java");
		ds.saveArticle(article);
		Article article2 = new Article(user, "Java", "I  don't like Java.",
				"Java 2");
		ds.saveArticle(article2);
		ArticleCriteria ac = new ArticleCriteria("Java", "John", "Java",
				textRepository);
		for (Article art : ds.findArticles(ac)) {
			assertEquals("Incorrect", art.getAuthor().getName(), ac.getAuthor());
			assertEquals("Incorrect", art.getThemeOfTheArticle(),
					ac.getThemeOfArticle());
			assertEquals("Incorrect", true, art.getTags().contains(ac.getTag()));
			assertEquals("Incorrect", true, ds.getTextRepository().getArticle()
					.contains(art));
		}
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