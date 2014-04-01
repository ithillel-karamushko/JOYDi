package org.hillel.it.joydi.service.bootstrap;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;

public class Starter {
	public static void main(String[] args) {
		DiaryServiceImpl ds = new DiaryServiceImpl();

		User user1 = new User("John", "email", "ukraine", "male", 22);
		User user2 = new User("John", "email", "ukraine", "male", 22);
		User user3 = new User("Andrew", "email", "ukraine", "male", 25);
		Admin admin1 = new Admin("Hanna", "email", "poland", "female", 15);
		Admin admin2 = new Admin("Helen", "email", "poland", "female", 23);
		System.out.println(user1.getName() + " is from " + user1.getCountry());
		ds.saveUser(user1);
		ds.saveUser(user2);
		ds.saveUser(user3);
		ds.saveAdmin(admin1);
		ds.saveAdmin(admin2);
		ds.getPersonsList();
		ds.deleteUser(user3);
		ds.getPersonsList();
		Comment comment = new Comment("John", "I like it!");
		ds.saveComment(comment);
		System.out.println(comment.getDate());
		Comment comment1 = new Comment("Hanna", "I don't like it!");
		ds.saveComment(comment1);
		System.out.println(comment1.getDate());
		System.out.println(comment1.getAuthorName() + " - "
				+ comment1.getCommentText());
		Article article = new Article("Hanna", "Java", "Java is good.");
		ds.saveArticle(article);
		System.out.println(article.getTextOfTheArticle());
		ds.getTextsList();
	}
}
