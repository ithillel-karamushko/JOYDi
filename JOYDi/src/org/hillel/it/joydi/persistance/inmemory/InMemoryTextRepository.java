package org.hillel.it.joydi.persistance.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public List<Article> getArticle() {
		return article;
	}

	public List<Comment> getComment() {
		return comment;
	}

	@Override
	public void saveArticle(Article article) {
		article.setTextOfTheArticle(censoring(article));
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

	public String censoring(Article article) {
		String[] words = { "shit", "fuck", "damn", "bitch" };
		String text = article.getTextOfTheArticle();
		for (String word : words) {
			Pattern pattern = Pattern.compile("(?i)" + word + "*");
			Matcher matcher = pattern.matcher(text);
			while (matcher.find()) {
				text = text.replaceAll("(?i)" + matcher.group(), "***");
			}
		}
		return text;
	}
}
