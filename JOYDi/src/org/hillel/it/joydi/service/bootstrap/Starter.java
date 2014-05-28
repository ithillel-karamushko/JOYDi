package org.hillel.it.joydi.service.bootstrap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.hillel.it.joydi.concurrency.tasks.TheNewestArticles;
import org.hillel.it.joydi.model.entities.Article;
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
		 TheNewestArticles na = new TheNewestArticles(textRepository);
		User user1 = new User("John", "email@gmail.com", Countries.Albania,
				Gender.MALE, 2004, Months.February, 28, "rretert");
		ds.saveUser(user1);
		ds.enter("email@gmail.com", "rretert");
		User user2 = new User("Mary", "email2@gmail.com", Countries.Albania,
				Gender.MALE, 2004, Months.February, 28, "rretert");
		ds.saveUser(user2);
		ds.enter("email2@gmail.com", "rretert");
		//
		Article article = new Article(user1, "IT", "Java rules", "Java, IT");
		Article article1 = new Article(user1, "IT", "Java rules", "Java, IT");
		Article article2 = new Article(user1, "My Java", "Java rules",
				"Java, IT");
		Article article3 = new Article(user2, "IT3",
				"Damned, C++ is fucking shit", "Java, IT");
		Article article4 = new Article(user1, "IT4", "Java rules", "Java, IT");
		Article article5 = new Article(user2, "IT5", "Java rules", "Java, IT");
		Article article6 = new Article(user1, "IT6", "Java rules", "Java, IT");
		Article article7 = new Article(user2, "IT7", "Java rules", "Java, IT");
		Article article8 = new Article(user1, "IT8", "Java rules", "Java, IT");
		Article article9 = new Article(user1, "IT9", "Java rules", "Java, IT");
		Article article10 = new Article(user1, "IT10", "Java rules", "Java, IT");
		Article article11 = new Article(user2, "IT11", "Java rules", "Java, IT");
		Article article12 = new Article(user1, "IT12", "Java rules", "Java, IT");

		ds.saveArticle(article);
		ds.saveArticle(article1);
		ds.saveArticle(article2);
		ds.saveArticle(article3);
		ds.saveArticle(article4);
		ds.saveArticle(article5);
		ds.saveArticle(article6);
		ds.saveArticle(article7);
		ds.saveArticle(article8);
		ds.saveArticle(article9);
		ds.saveArticle(article10);
		ds.saveArticle(article11);
		ds.saveArticle(article12);

		ds.pushLike(article7);
		ds.pushLike(article7);
		ds.pushLike(article3);
		ds.pushLike(article12);
		ds.pushLike(article12);
		ds.pushLike(article12);

		Article article13 = new Article(user2, "Last Article", "Java rules",
				"Java, IT");
		ds.saveArticle(article13);
		ds.pushLike(article13);
		ds.pushLike(article13);
		ds.pushLike(article13);
		ds.pushLike(article13);
		ds.pushLike(article13);

		Picture p = new Picture("uhweiuhwe");
		ds.savePicture(p);
		
		
	}
}
