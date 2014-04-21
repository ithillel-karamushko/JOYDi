package org.hillel.it.joydi.service.imp;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.model.search.ArticleCriteria;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository;
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
		personRepository = new InMemoryPersonRepository();
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
		User user = new User("John", "email", "ukraine", Gender.MALE, 22);
		int i = ds.getPersonRepository().getUser().size() + 1;
		ds.saveUser(user);
		assertEquals("Incorrect", i, ds.getPersonRepository().getUser().size());
		assertEquals("Incorrect value", true, ds.getPersonRepository()
				.getUser().contains(user));
	}

	@Test
	public void testSaveAdmin() throws FileNotFoundException, IOException {
		Admin admin = new Admin("Helen", "email", "poland", Gender.FEMALE, 23);
		int i = ds.getPersonRepository().getAdmin().size() + 1;
		ds.saveAdmin(admin);
		assertEquals("Incorrect", i, ds.getPersonRepository().getAdmin().size());
		assertEquals("Incorrect value", true, ds.getPersonRepository()
				.getAdmin().contains(admin));
	}

	@Test
	public void testDeleteUser() throws FileNotFoundException, IOException {
		User user = new User("Mike", "email", "ukraine", Gender.MALE, 25);
		ds.saveUser(user);
		int i = ds.getPersonRepository().getUser().size() - 1;
		ds.deleteUser(user);
		assertEquals("Incorrect", i, ds.getPersonRepository().getUser().size());
		assertEquals("Incorrect value", false, ds.getPersonRepository()
				.getUser().contains(user));

	}

	@Test
	public void testModifyUser() throws FileNotFoundException, IOException {
		User user = new User("Mary", "email", "ukraine", Gender.FEMALE, 22);
		ds.saveUser(user);
		int i = ds.getPersonRepository().getUser().size();
		ds.modifyUser(user, "Masha", "email", "ukraine", Gender.FEMALE, 22);
		assertEquals("Incorrect", i, ds.getPersonRepository().getUser().size());
		assertEquals("Incorrect value", true, ds.getPersonRepository()
				.getUser().contains(user));

	}

	@Test
	public void testDeleteAdmin() throws FileNotFoundException, IOException {
		Admin admin = new Admin("Suzy", "email", "poland", Gender.FEMALE, 28);
		ds.saveAdmin(admin);
		int i = ds.getPersonRepository().getAdmin().size() - 1;
		ds.deleteAdmin(admin);
		assertEquals("Incorrect", i, ds.getPersonRepository().getAdmin().size());
		assertEquals("Incorrect value", false, ds.getPersonRepository()
				.getAdmin().contains(admin));

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