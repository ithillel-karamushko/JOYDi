package org.hillel.it.joydi.persistance.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.persistance.repository.TextRepository;

public class InMemoryTextRepository implements TextRepository {

	private List<Article> article;
	private List<Comment> comment;

	public InMemoryTextRepository() {
		this.article = new ArrayList<Article>();
		this.comment = new ArrayList<Comment>();
	}

	@Override
	public void saveArticle(Article article) {
		this.article.add(article);

	}

	public void modifyArticle(Article article) {
		this.article.remove(article);
		this.article.add(article);

	}

	@Override
	public void deleteArticle(Article article) {
		this.article.remove(article);

	}

	@Override
	public void saveComment(Comment comment) {
		this.comment.add(comment);

	}

	@Override
	public void deleteComment(Comment comment) {
		this.comment.remove(comment);

	}

	public void modifyComment(Comment comment) {
		this.comment.remove(comment);
		this.comment.add(comment);
	}

	public void getComment() {
		System.out.println(comment);

	}

	public void getArticle() {
		System.out.println(article);
	}

}
