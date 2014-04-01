package org.hillel.it.joydi.service.diaryService;

import java.util.Set;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.model.search.ArticleCriteria;

public interface DiaryService {

	void saveArticle(Article article);

	void deleteArticle(Article article);

	void saveUser(User person);

	void deleteUser(User person);
	
	void modifyUser(User person,  String name, String eMail, String country,
			Gender gender, int age);

	void saveAdmin(Admin person);

	void deleteAdmin(Admin person);

	void saveComment(Comment comment);

	void deleteComment(Comment comment);

	Set findArticles(ArticleCriteria criteria);
}