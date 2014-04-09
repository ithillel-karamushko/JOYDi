package org.hillel.it.joydi.jUnitTests;

import static org.junit.Assert.*;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceTest {
	private static Article article;
	private static TextRepository tr ;
	private static Comment comment ;
	private static int i;
	private static DiaryServiceImpl ds;
	
	@BeforeClass
	public static void before() {
		article = new Article("Hanna", "Java", "I like Java.");
		tr = new InMemoryTextRepository();
		ds = new DiaryServiceImpl();
		comment = new Comment("Hanna", "Nice words");
	}

	@Test
	public void testSaveArticle() {
		i = ds.getTextRepository().getArticle().size()+1;
		System.out.println(i);
		ds.saveArticle(article);
		System.out.println(ds.getTextRepository().getArticle().size());
		assertEquals("Incorrect", i, ds.getTextRepository().getArticle().size());
		assertEquals("Incorrect value", true, ds.getTextRepository().getArticle().contains(article));
	}

	// @Test
	// public void testDeleteArticle() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testModifyArticle() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSaveUser() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSaveAdmin() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testDeleteUser() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testModifyUser() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testDeleteAdmin() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSaveComment() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testDeleteComment() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testModifyComment() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetPersonsList() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetTextsList() {
	// fail("Not yet implemented");
	// }

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
