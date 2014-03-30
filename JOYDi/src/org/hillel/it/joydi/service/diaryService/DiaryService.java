package org.hillel.it.joydi.service.diaryService;

import java.util.Set;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.search.ArticleCriteria;
import org.hillel.it.joydi.persistance.inmemory.InMemory;

public interface DiaryService {

	void saveArticle(Article article);

	void deleteArticle(Article article);

	void saveUser(Person person);

	void saveAdmin(Person person);

	void deleteUser(Person person);

	void deleteAdmin(Person person);

	void saveComment(Comment comment);

	void deleteComment(Comment comment);

	Set findArticles(ArticleCriteria criteria);
}