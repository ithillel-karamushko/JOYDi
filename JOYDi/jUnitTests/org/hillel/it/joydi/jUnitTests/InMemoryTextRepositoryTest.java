package org.hillel.it.joydi.jUnitTests;

import static org.junit.Assert.*;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;
import org.junit.Test;
import org.junit.BeforeClass;

public class InMemoryTextRepositoryTest {

	private static Article article;
	private static TextRepository tr ;
	private static Comment comment ;
	private static int i;
	
	@BeforeClass
	public static void before() {
		article = new Article("Hanna", "Java", "I like Java.");
		tr = new InMemoryTextRepository();
		comment = new Comment("Hanna", "Nice words");
	}
	
	@Test
	public void testSaveArticle() {		
		i = tr.getArticle().size()+1;
		tr.saveArticle(article);
		assertEquals("Incorrect value", i, tr.getArticle().size());
		assertEquals("Incorrect value", true, tr.getArticle().contains(article));
	}

	@Test
	public void testModifyArticle() {
		i = tr.getArticle().size()+1;
		tr.saveArticle(article);
		tr.modifyArticle(article);
		assertEquals("Incorrect value", i, tr.getArticle().size());
		assertEquals("Incorrect value", true, tr.getArticle().contains(article));
	}

	@Test
	public void testDeleteArticle() {
		tr.saveArticle(article);
		i = tr.getArticle().size()-1;
		tr.deleteArticle(article);
		assertEquals("Incorrect value", i, tr.getArticle().size());
	}

	@Test
	public void testSaveComment() {
		i = tr.getComment().size()+1;
		tr.saveComment(comment);
		assertEquals("Incorrect value", i, tr.getComment().size());
		assertEquals("Incorrect value", true, tr.getComment().contains(comment));
	}

	@Test
	public void testDeleteComment() {
		tr.saveComment(comment);
		i = tr.getComment().size()-1;
		tr.deleteComment(comment);
		assertEquals("Incorrect value", i, tr.getComment().size());
		assertEquals("Incorrect value", false, tr.getComment().contains(comment));
	}

	@Test
	public void testModifyComment() { 
		tr.saveComment(comment);
		i = tr.getComment().size();
		tr.modifyComment(comment);
		assertEquals("Incorrect value", i, tr.getComment().size());
		assertEquals("Incorrect value", true, tr.getComment().contains(comment));
	}

}
