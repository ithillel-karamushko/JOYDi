package org.hillel.it.joydi.persistance.repository;

import java.util.Collections;
import java.util.List;

import org.hillel.it.joydi.concurrency.comparator.MyComparatorForDate;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Person;

public interface TextRepository {
	public void saveArticle(Article article);

	void modifyArticle(int id, String theme, String text, String tag);

	public void deleteArticle(Article article);

	public void saveComment(Comment comment);

	void modifyComment(Comment comment);

	public void deleteComment(Comment comment);

	List<Article> getArticle();

	List<Comment> getComment();

	void deleteArticleById(int id);

	List<Article> newArticles();

	List<Article> topArticles();

	void deleteCommentById(int id);

	List<Article> findUserArticles(String email);

	Article returnArticleById(int id);

	void pushLike(int id, String email);

	void pushDisLike(int id, String email);

}
