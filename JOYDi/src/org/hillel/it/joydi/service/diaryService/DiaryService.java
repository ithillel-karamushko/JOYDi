package org.hillel.it.joydi.service.diaryService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.model.search.ArticleCriteria;

public interface DiaryService {

	void saveArticle(Article article);

	void modifyArticle(Article article, String textOfTheArticle,
			String themeOfTheArticle);

	void deleteArticle(Article article);

	void saveUser(User person) throws FileNotFoundException, IOException;

	void modifyUser(User person, String name, String eMail, String country,
			Gender gender, int age) throws FileNotFoundException, IOException;

	void deleteUser(User person) throws IOException;

	void saveAdmin(Admin person) throws FileNotFoundException, IOException;

	void deleteAdmin(Admin person) throws IOException;

	void saveComment(Comment comment);

	void deleteComment(Comment comment);

	void modifyComment(Comment comment, String commentText);

	void pushLike(Article article);

	void pushDisLike(Article article);

	List<Article> findArticles(ArticleCriteria criteria);
}