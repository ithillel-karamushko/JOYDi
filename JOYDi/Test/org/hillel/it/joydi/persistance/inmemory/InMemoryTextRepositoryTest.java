package org.hillel.it.joydi.persistance.inmemory;

import static org.junit.Assert.*;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
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
		int i = tr.getArticle().size() + 1;
		Article article = new Article("Hanna", "Java", "I like Java.", "Java");
		tr.saveArticle(article);
		assertEquals("Incorrect value", i, tr.getArticle().size());
		assertEquals("Incorrect value", true, tr.getArticle().contains(article));
	}

	@Test
	public void testModifyArticle() {
		int i = tr.getArticle().size() + 1;
		Article article = new Article("Mary", "Java", "I like Java.", "Java");
		tr.saveArticle(article);
		tr.modifyArticle(article);
		assertEquals("Incorrect value", i, tr.getArticle().size());
		assertEquals("Incorrect value", true, tr.getArticle().contains(article));
	}

	@Test
	public void testDeleteArticle() {
		Article article = new Article("Mary", "Java", "I like Java.", "Java");
		tr.saveArticle(article);
		int i = tr.getArticle().size() - 1;
		tr.deleteArticle(article);
		assertEquals("Incorrect value", i, tr.getArticle().size());
		assertEquals("Incorrect value", false, tr.getArticle()
				.contains(article));
	}

	@Test
	public void testSaveComment() {
		int i = tr.getComment().size() + 1;
		Comment comment = new Comment("Hanna", "Nice words");
		tr.saveComment(comment);
		assertEquals("Incorrect value", i, tr.getComment().size());
		assertEquals("Incorrect value", true, tr.getComment().contains(comment));
	}

	@Test
	public void testDeleteComment() {
		Comment comment = new Comment("Hanna", "Nice words");
		tr.saveComment(comment);
		int i = tr.getComment().size() - 1;
		tr.deleteComment(comment);
		assertEquals("Incorrect value", i, tr.getComment().size());
		assertEquals("Incorrect value", false, tr.getComment()
				.contains(comment));
	}

	@Test
	public void testModifyComment() {
		Comment comment = new Comment("Hanna", "Nice words");
		tr.saveComment(comment);
		int i = tr.getComment().size();
		tr.modifyComment(comment);
		assertEquals("Incorrect value", i, tr.getComment().size());
		assertEquals("Incorrect value", true, tr.getComment().contains(comment));
	}

}
