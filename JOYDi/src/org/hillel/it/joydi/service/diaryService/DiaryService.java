package org.hillel.it.joydi.service.diaryService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.hillel.it.joydi.concurrency.comparator.MyComparatorForDate;
import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.Months;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.entities.Picture;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.model.search.ArticleCriteria;

public interface DiaryService {

	void saveArticle(Article article);

	void deleteArticle(Article article);

	boolean saveUser(User person) throws FileNotFoundException, IOException;

	void deleteUser(User person) throws IOException;

	void saveAdmin(Admin person) throws FileNotFoundException, IOException;

	void deleteAdmin(Admin person) throws IOException;

	void saveComment(Comment comment);

	void deleteComment(Comment comment);

	void pushLike(int id, String email);

	void pushDisLike(int id, String email);

	List<Article> findArticles(ArticleCriteria criteria);

	void savePicture(Picture picture) throws SQLException;

	void deletePicture(Picture picture);

	void getPicture();

	Person enter(String email, String password);

	void exit(Person person);

	Person returnUserByEmail(String email);

	Article returnArticleById(int id);

	void deleteArticleById(int id);

	public List<Article> newArticles();

	public List<Article> topArticles();

	void deleteCommentById(int id);

	String returnPictureById(int id);

	void changePassword(String oldPassword, String newPassword,
			String confirmPassword, String email);

	void changeName(String name, String email);

	void changeCountry(String country, String email);

	List<Article> findUserArticles(String email);

	void modifyArticle(int id, String theme, String text, String tag);

	void deletePictureById(int id);

}