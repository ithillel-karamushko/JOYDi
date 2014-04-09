package org.hillel.it.joydi.jUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;
import org.junit.Test;

public class ServiceTest {
	//
	// @Test
	// public void testSaveArticle() {
	// fail("Not yet implemented");
	// }

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
	
	private TextRepository textRepository = new InMemoryTextRepository();
	private PersonRepository personRepository = new InMemoryPersonRepository();	

	Article article = new Article("Hanna", "Java", "Java is bad.");
	DiaryServiceImpl ds = new DiaryServiceImpl();
	 
	public void TestSaveArticle(){
		int i;
		i = textRepository.getArticle().size()+1;
		ds.saveArticle(article);
		assertEquals("Incorrect", i, textRepository.getArticle().size());
	}
	
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
