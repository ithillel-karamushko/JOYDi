package org.hillel.it.joydi.jUnitTests;

import static org.junit.Assert.*;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;
import org.junit.Test;

public class ServiceTest {

	@Test
	public void testSaveArticle() {

		TextRepository textRepository = new InMemoryTextRepository();
		Article article = new Article("Hanna", "Java", "Java is bad.");
		DiaryServiceImpl ds = new DiaryServiceImpl();
		int i = textRepository.getArticle().size();
		System.out.println(i);
		ds.saveArticle(article);
		System.out.println(textRepository.getArticle().size());
		assertEquals("Incorrect", 0, textRepository.getArticle().size());
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
		Article article = new Article("Hanna", "Java", "Java is bad.");
		DiaryServiceImpl ds = new DiaryServiceImpl();
		System.out.println(article.getLike());
		ds.pushLike(article);
		System.out.println(article.getLike());
		assertEquals("Incorrect", 1, article.getLike());
	}

	@Test
	public void testPushDisLike() {
		Article article = new Article("Hanna", "Java", "Java is bad.");
		DiaryServiceImpl ds = new DiaryServiceImpl();
		ds.pushDisLike(article);
		assertEquals("Incorrect", 1, article.getDisLike());
	}

	// @Test
	// public void testFindArticles() {
	// fail("Not yet implemented");
	// }
	//
}
