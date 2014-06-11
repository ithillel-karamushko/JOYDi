package org.hillel.it.joydi.persistance.inmemory;

import static org.junit.Assert.*;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.Months;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.persistance.repository.TextRepository;
import org.junit.Test;
import org.junit.BeforeClass;

public class InMemoryTextRepositoryTest {
	private static TextRepository tr;

	@BeforeClass
	public static void before() {
		tr = new InMemoryTextRepository();
	}

	@Test
	public void testSaveArticle() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		user.setEnter(true);
		int i = tr.getArticle().size() + 1;
		Article article = new Article(user, "Java", "I like Java.", "Java");
		tr.saveArticle(article);
		assertEquals("Incorrect value", i, tr.getArticle().size());
		assertEquals("Incorrect value", true, tr.getArticle().contains(article));
	}

	@Test
	public void testDeleteArticle() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		Article article = new Article(user, "Java", "I like Java.", "Java");
		user.setEnter(true);
		tr.saveArticle(article);
		int i = tr.getArticle().size() - 1;
		tr.deleteArticle(article);
		assertEquals("Incorrect value", i, tr.getArticle().size());
		assertEquals("Incorrect value", false, tr.getArticle()
				.contains(article));
	}

	@Test
	public void testSaveComment() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		user.setEnter(true);
		int i = tr.getComment().size() + 1;
		Comment comment = new Comment(user, "Nice words");
		tr.saveComment(comment);
		assertEquals("Incorrect value", i, tr.getComment().size());
		assertEquals("Incorrect value", true, tr.getComment().contains(comment));
	}

	@Test
	public void testDeleteComment() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		user.setEnter(true);
		Comment comment = new Comment(user, "Nice words");
		tr.saveComment(comment);
		int i = tr.getComment().size() - 1;
		tr.deleteComment(comment);
		assertEquals("Incorrect value", i, tr.getComment().size());
		assertEquals("Incorrect value", false, tr.getComment()
				.contains(comment));
	}

	@Test
	public void testModifyComment() {
		User user = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		user.setEnter(true);
		Comment comment = new Comment(user, "Nice words");
		tr.saveComment(comment);
		int i = tr.getComment().size();
		tr.modifyComment(comment);
		assertEquals("Incorrect value", i, tr.getComment().size());
		assertEquals("Incorrect value", true, tr.getComment().contains(comment));
	}

}
