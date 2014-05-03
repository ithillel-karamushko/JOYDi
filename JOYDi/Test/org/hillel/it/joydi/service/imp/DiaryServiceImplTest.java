package org.hillel.it.joydi.service.imp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.Months;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.model.search.ArticleCriteria;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonFileRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

public class DiaryServiceImplTest {
	private static DiaryServiceImpl ds;
	private static TextRepository textRepository;
	private static PersonRepository personRepository;

	@BeforeClass
	public static void before() {
		textRepository = new InMemoryTextRepository();
		personRepository = new InMemoryPersonFileRepository();
		ds = new DiaryServiceImpl(textRepository, personRepository);
	}

	@Test
	public void testSaveArticle() {
		int i = ds.getTextRepository().getArticle().size() + 1;
		Article article = new Article("Hanna", "Java", "I like Java.","Java");
		ds.saveArticle(article);
		assertEquals("Incorrect", i, ds.getTextRepository().getArticle().size());
		assertEquals("Incorrect value", true, ds.getTextRepository()
				.getArticle().contains(article));
	}

	@Test
	public void testDeleteArticle() {
		Article article = new Article("Mary", "Java", "I like Java.","Java");
		ds.saveArticle(article);
		int i = ds.getTextRepository().getArticle().size() - 1;
		ds.deleteArticle(article);
		assertEquals("Incorrect", i, ds.getTextRepository().getArticle().size());
		assertEquals("Incorrect value", false, ds.getTextRepository()
				.getArticle().contains(article));
	}

	@Test
	public void testModifyArticle() {
		Article article = new Article("Mike", "Java", "I like Java.","Java");
		ds.saveArticle(article);
		int i = ds.getTextRepository().getArticle().size();
		ds.modifyArticle(article, "Java", "I don't like Java");
		assertEquals("Incorrect", i, ds.getTextRepository().getArticle().size());
		assertEquals("Incorrect value", true, ds.getTextRepository()
				.getArticle().contains(article));
	}

	@Test
	public void testSaveUser() throws FileNotFoundException, IOException {
		User user = new User("John", "email", "ukraine", Gender.MALE, 1990, Months.March ,07, "asf45");
		ds.saveUser(user);
		File file = new File("D://" + user.getName() + ".txt");
		boolean isExist = file.exists();
		assertTrue(isExist);
	}

	@Test
	public void testSaveAdmin() throws FileNotFoundException, IOException {
		Admin admin = new Admin("Helen", "email", "poland", Gender.FEMALE, 1990, Months.March ,07);
		ds.saveAdmin(admin);
		File file = new File("D://" + admin.getName() + ".txt");
		boolean isExist = file.exists();
		assertTrue(isExist);
	}

	@Test
	public void testDeleteUser() throws FileNotFoundException, IOException {
		User user = new User("John", "email", "ukraine", Gender.MALE, 1990, Months.March ,07, "asf45");
		ds.saveUser(user);
		ds.deleteUser(user);
		File file = new File("D://" + user.getName() + ".txt");
		boolean isExist = file.exists();
		assertFalse(isExist);

	}

	@Test
	public void testModifyUser() throws FileNotFoundException, IOException {
		User user = new User("John", "email", "ukraine", Gender.MALE, 1990, Months.March ,07, "asf45");
		ds.saveUser(user);
		ds.modifyUser(user, "Leo", "mail", null, null, 1990, Months.March ,07);
		File file = new File("D://" + user.getName() + ".txt");
		boolean isExist = file.exists();
		assertTrue(isExist);
		assertEquals("Incorrect", "Leo", user.getName());
		assertEquals("Incorrect", "ukraine", user.getCountry());
		

	}

	@Test
	public void testDeleteAdmin() throws FileNotFoundException, IOException {
		Admin admin = new Admin("Helen", "email", "poland", Gender.FEMALE, 1990, Months.March ,07);
		ds.saveAdmin(admin);
		ds.deleteAdmin(admin);
		File file = new File("D://" + admin.getName() + ".txt");
		boolean isExist = file.exists();
		assertFalse(isExist);

	}

	@Test
	public void testSaveComment() {
		 Comment comment = new Comment("Hanna", "Nice words");
		int i = ds.getTextRepository().getComment().size() + 1;
		ds.saveComment(comment);
		assertEquals("Incorrect", i, ds.getTextRepository().getComment().size());
		assertEquals("Incorrect value", true, ds.getTextRepository()
				.getComment().contains(comment));
	}

	@Test
	public void testDeleteComment() {
		Comment comment = new Comment("Suzy", "Nice words");
		ds.saveComment(comment);
		int i = ds.getTextRepository().getComment().size() - 1;
		ds.deleteComment(comment);
		assertEquals("Incorrect", i, ds.getTextRepository().getComment().size());
		assertEquals("Incorrect", false, ds.getTextRepository().getComment().contains(comment));
	}

	@Test
	public void testModifyComment() {
		Comment comment = new Comment("Frank", "Nice words");
		ds.saveComment(comment);
		int i = ds.getTextRepository().getComment().size();
		ds.modifyComment(comment, "Bad words");
		assertEquals("Incorrect", i, ds.getTextRepository().getComment().size());
		assertEquals("Incorrect", true, ds.getTextRepository().getComment().contains(comment));
	}

	@Test
	public void testPushLike() {
		Article article = new Article("Frank", "Java", "I like Java.","Java");
		ds.saveArticle(article);
		ds.pushLike(article);
		assertEquals("Incorrect", 1, article.getLike());
	}

	@Test
	public void testPushDisLike() {
		Article article = new Article("John", "Java", "I like Java.","Java");
		ds.saveArticle(article);
		ds.pushDisLike(article);
		assertEquals("Incorrect", 1, article.getDisLike());
	}

	@Test
	public void findArticles() {
		Article article = new Article("John", "Java", "I  don't like Java.","Java");
		ds.saveArticle(article);
		Article article2 = new Article("John", "Java", "I  don't like Java.","Java 2");
		ds.saveArticle(article2);
		ArticleCriteria ac = new ArticleCriteria("Java", "John", "Java", textRepository);
		for (Article art : ds.findArticles(ac)){
		assertEquals("Incorrect", art.getAuthorName(), ac.getAuthor());
		assertEquals("Incorrect", art.getThemeOfTheArticle(), ac.getThemeOfArticle());
		assertEquals("Incorrect", true, art.getTags().contains(ac.getTag()));
		assertEquals("Incorrect", true, ds.getTextRepository().getArticle().contains(art));
		}
}
}