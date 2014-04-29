package org.hillel.it.joydi.service.bootstrap;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.naming.ConfigurationException;

import org.hillel.it.joydi.infra.config.Configuration;
import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.search.ArticleCriteria;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonFileRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;

public class Starter {
	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		TextRepository textRepository = new InMemoryTextRepository();
		PersonRepository personRepository = new InMemoryPersonFileRepository();
		DiaryServiceImpl ds = new DiaryServiceImpl(textRepository,
				personRepository);
		User user1 = new User("John", "email", "ukraine", Gender.MALE, 22);
		User user2 = new User("Johny", "email", "ukraine", Gender.MALE, 22);
		User user3 = new User("Andrew", "email", "ukraine", Gender.MALE, 25);
		ds.saveUser(user1);
		ds.saveUser(user2);
		ds.saveUser(user3);
		// Admin admin1 = new Admin("Hanna", "email", "poland", Gender.FEMALE,
		// 15);
		// Admin admin2 = new Admin("Helen", "email", "poland", Gender.FEMALE,
		// 23);
		Article article1 = new Article("John", "IT", "Java is good.", "Java");
		Article article = new Article("John", "IT", "Shitty C++.", "Java");
		ds.saveArticle(article1);
		ds.saveArticle(article);
		ArticleCriteria ac = new ArticleCriteria("John", "IT", null,
				textRepository);
		System.out.println(ds.findArticles(ac));
		// System.out.println(article.getTextOfTheArticle());
		// ds.saveUser(user1);
		// ds.modifyUser(user1, "Leo", null, "Russia", Gender.FEMALE, 25);
		// ds.saveUser(user2);
		// ds.saveUser(user3);
		// ds.deleteUser(user1);
		// System.out.println(user1.getName() + " is from " +
		// user1.getCountry());
		// System.out.println("The gender of " + admin1.getName() + " is "
		// + admin1.getGender().getText());
		// System.out.println("The gender of " + user1.getName() + " is "
		// + user1.getGender().getText());
		// ds.saveUser(user1);
		// ds.saveUser(user2);
		// ds.saveUser(user3);
		// ds.saveAdmin(admin1);
		// ds.saveAdmin(admin2);
		// ds.deleteAdmin(admin2);
		// ds.getPersonsList();
		// ds.deleteUser(user3);
		// ds.getPersonsList();
		// System.out.println("user1 " + user1.getName() + " is from "
		// + user1.getCountry());
		// System.out.println("user1 " + user1.getName() + " is from "
		// + user1.getCountry());
		// Comment comment = new Comment("John", "I like it!");
		// ds.saveComment(comment);
		// System.out.println(comment.getDate());
		// Comment comment1 = new Comment("Hanna", "I don't like it!");
		// ds.saveComment(comment1);
		// System.out.println(comment1.getDate());
		// System.out.println(comment1.getAuthorName() + " - "
		// + comment1.getCommentText());
		// ds.modifyComment(comment1, "I like it!");
		// System.out.println(comment1.getAuthorName() + " - "
		// + comment1.getCommentText());
		// ds.pushLike(article);
		// ds.pushLike(article);
		// ds.pushDisLike(article);
		// System.out.println(article.getAuthorName() + " "
		// + article.getThemeOfTheArticle() + " "
		// + article.getTextOfTheArticle());
		// ds.modifyArticle(article, "Java is good", null);
		// System.out.println(article.getAuthorName() + " "
		// + article.getThemeOfTheArticle() + " "
		// + article.getTextOfTheArticle());
		// ds.getTextsList();
		// System.out.println(article.getLike());
		// System.out.println(article.getDisLike());
		//

		// Comment comment = new Comment("John", "Nice shit");
		// ds.saveComment(comment);
		// System.out.println(article.getTextOfTheArticle());
		// System.out.println(comment.getCommentText());
	}
}
