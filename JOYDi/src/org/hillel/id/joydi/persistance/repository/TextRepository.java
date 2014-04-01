package org.hillel.id.joydi.persistance.repository;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;

public interface TextRepository {
	public void saveArticle(Article article);
	void modifyArticle(Article article);
	public void deleteArticle(Article article);

	public void saveComment(Comment comment);
	void modifyComment(Comment comment);
	public void deleteComment(Comment comment);	

	void getArticle();

	void getComment();
}
