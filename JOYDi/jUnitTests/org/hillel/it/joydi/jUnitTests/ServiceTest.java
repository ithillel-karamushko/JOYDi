package org.hillel.it.joydi.jUnitTests;

import static org.junit.Assert.*;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceTest {
	private static Article article;
	private static Comment comment;
	private static int i;
	private static DiaryServiceImpl ds;
	private static Admin admin;
	private static User user;

	@BeforeClass
	public static void before() {
		article = new Article("Hanna", "Java", "I like Java.");
		ds = new DiaryServiceImpl();
		comment = new Comment("Hanna", "Nice words");
		user = new User("John", "email", "ukraine", Gender.MALE, 22);
		admin = new Admin("Helen", "email", "poland", Gender.FEMALE, 23);

	}

	@Test
	public void testSaveArticle() {
		i = ds.getTextRepository().getArticle().size() + 1;
		ds.saveArticle(article);
		assertEquals("Incorrect", i, ds.getTextRepository().getArticle().size());
		assertEquals("Incorrect value", true, ds.getTextRepository()
				.getArticle().contains(article));
	}

	@Test
	public void testDeleteArticle() {
		i = ds.getTextRepository().getArticle().size() - 1;
		ds.deleteArticle(article);
		assertEquals("Incorrect", i, ds.getTextRepository().getArticle().size());
		assertEquals("Incorrect value", false, ds.getTextRepository()
				.getArticle().contains(article));
	}

	@Test
	public void testModifyArticle() {
		i = ds.getTextRepository().getArticle().size();
		ds.modifyArticle(article, "Java", "Java");
		assertEquals("Incorrect", i, ds.getTextRepository().getArticle().size());
	}

	@Test
	public void testSaveUser() {
		i = ds.getPersonRepository().getUser().size() + 1;
		ds.saveUser(user);
		assertEquals("Incorrect", i, ds.getPersonRepository().getUser().size());
		assertEquals("Incorrect value", true, ds.getPersonRepository()
				.getUser().contains(user));
	}

	@Test
	public void testSaveAdmin() {
		i = ds.getPersonRepository().getAdmin().size() + 1;
		ds.saveAdmin(admin);
		assertEquals("Incorrect", i, ds.getPersonRepository().getAdmin().size());

	}

	@Test
	public void testDeleteUser() {
		i = ds.getPersonRepository().getUser().size() - 1;
		ds.deleteUser(user);
		assertEquals("Incorrect", i, ds.getPersonRepository().getUser().size());
		assertEquals("Incorrect value", false, ds.getPersonRepository()
				.getUser().contains(user));

	}

	@Test
	public void testModifyUser() {
		i = ds.getPersonRepository().getUser().size();
		ds.modifyUser(user, "Masha", "email", "ukraine", Gender.MALE, 22);
		assertEquals("Incorrect", i, ds.getPersonRepository().getUser().size());

	}

	@Test
	public void testDeleteAdmin() {
		ds.saveAdmin(admin);
		i = ds.getPersonRepository().getAdmin().size() - 1;
		ds.deleteAdmin(admin);
		assertEquals("Incorrect", i, ds.getPersonRepository().getAdmin().size());

	}

	@Test
	public void testSaveComment() {
		i = ds.getTextRepository().getComment().size() + 1;
		ds.saveComment(comment);
		assertEquals("Incorrect", i, ds.getTextRepository().getComment().size());
		assertEquals("Incorrect value", true, ds.getTextRepository()
				.getComment().contains(comment));
	}

	@Test
	public void testDeleteComment() {
		ds.saveComment(comment);
		i = ds.getTextRepository().getComment().size() - 1;
		ds.deleteComment(comment);
		assertEquals("Incorrect", i, ds.getTextRepository().getComment().size());
	}

	@Test
	public void testModifyComment() {
		i = ds.getTextRepository().getComment().size();
		ds.modifyComment(comment, "Bad words");
		assertEquals("Incorrect", i, ds.getTextRepository().getComment().size());
	}

	@Test
	public void testPushLike() {
		ds.pushLike(article);
		assertEquals("Incorrect", 1, article.getLike());
	}

	@Test
	public void testPushDisLike() {
		ds.pushDisLike(article);
		assertEquals("Incorrect", 1, article.getDisLike());
	}

	// @Test
	// public void testFindArticles() {
	// fail("Not yet implemented");
	// }
	//
}
