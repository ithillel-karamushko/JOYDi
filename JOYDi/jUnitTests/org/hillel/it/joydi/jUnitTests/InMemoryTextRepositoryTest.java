package org.hillel.it.joydi.jUnitTests;

import static org.junit.Assert.*;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;
import org.junit.Test;

public class InMemoryTextRepositoryTest {
	@Test
	public void testSaveArticle() {
		Article article = new Article("Hanna", "Java", "I like Java.");
		TextRepository tr = new InMemoryTextRepository();
		tr.saveArticle(article);
		assertEquals("Incorrect value", 1, tr.getArticle().size());
	}

	@Test
	public void testModifyArticle() {
		Article article = new Article("Hanna", "Java", "I like Java.");
		TextRepository tr = new InMemoryTextRepository();
		tr.saveArticle(article);
		tr.modifyArticle(article);
		assertEquals("Incorrect value", 1, tr.getArticle().size());
	}

	@Test
	public void testDeleteArticle() {
		Article article = new Article("Hanna", "Java", "I like Java.");
		TextRepository tr = new InMemoryTextRepository();
		tr.saveArticle(article);
		tr.deleteArticle(article);
		assertEquals("Incorrect value", 0, tr.getArticle().size());
	}

	@Test
	public void testSaveComment() {
		Comment comment = new Comment("Hanna", "Nice words");
		TextRepository tr = new InMemoryTextRepository();
		tr.saveComment(comment);
		assertEquals("Incorrect value", 1, tr.getComment().size());
	}

	@Test
	public void testDeleteComment() {
		Comment comment = new Comment("Hanna", "Nice words");
		TextRepository tr = new InMemoryTextRepository();
		tr.saveComment(comment);
		tr.deleteComment(comment);
		assertEquals("Incorrect value", 0, tr.getComment().size());
	}

	@Test
	public void testModifyComment() { 
		Comment comment = new Comment("Hanna", "Nice words");
		TextRepository tr = new InMemoryTextRepository();
		tr.saveComment(comment);
		tr.modifyComment(comment);
		assertEquals("Incorrect value", 1, tr.getComment().size());
	}

}
