package org.hillel.it.joydi.service.bootstrap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.hillel.it.joydi.concurrency.tasks.TopArticles;
import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Countries;
import org.hillel.it.joydi.model.entities.Months;
import org.hillel.it.joydi.model.entities.Picture;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.search.ArticleCriteria;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonFileRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPictureRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.hillel.it.joydi.persistance.repository.PictureRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;

public class Starter {
	public static void main(String[] args) throws FileNotFoundException,
			IOException, SQLException {
		TextRepository textRepository = new InMemoryTextRepository();
		PersonRepository personRepository = new InMemoryPersonFileRepository();
		PictureRepository pictureRepository = new InMemoryPictureRepository();
		// TopArticles ta = new TopArticles(textRepository);
		DiaryServiceImpl ds = new DiaryServiceImpl(textRepository,
				personRepository, pictureRepository);
		//
		// User user1 = new User("John", "email@gmail.com", Countries.Albania,
		// Gender.MALE, 2004, Months.February, 28, "rretert");
		// ds.saveUser(user1);
		//
		// Article article = new Article("John", "IT", "Java rules",
		// "Java, IT");
		// Article article1 = new Article("John", "Java", "Java rules",
		// "Java, IT");
		// Article article2 = new Article("John", "My Java", "Java rules",
		// "Java, IT");
		//
		// ds.saveArticle(article);
		// ds.saveArticle(article1);
		// ds.saveArticle(article2);
		// ds.pushLike(article2);
		// ds.pushLike(article1);
		// ds.pushLike(article1);
		// ds.pushLike(article1);
		// try {
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// ds.pushLike(article2);

		Picture pic = new Picture("D:\\picture.jpeg");
		ds.savePicture(pic);
	}
}
