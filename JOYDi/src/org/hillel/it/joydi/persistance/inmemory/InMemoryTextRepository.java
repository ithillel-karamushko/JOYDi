package org.hillel.it.joydi.persistance.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.TextEntity;
import org.hillel.it.joydi.persistance.repository.TextRepository;

public class InMemoryTextRepository implements TextRepository {

	private List<Article> article;
	private List<Comment> comment;

	public InMemoryTextRepository() {
		this.article = new ArrayList<Article>();
		this.comment = new ArrayList<Comment>();
	}

	public synchronized List<Article> getArticle() {
		return article;
	}

	public synchronized List<Comment> getComment() {
		return comment;
	}

	@Override
	public synchronized void saveArticle(Article article) {
		article.setTextOfTheArticle(censoring(article));
		this.article.add(article);

	}

	public synchronized void modifyArticle(Article article) {
		this.article.remove(article);
		this.article.add(article);

	}

	@Override
	public synchronized void deleteArticle(Article article) {
		this.article.remove(article);

	}

	@Override
	public synchronized void saveComment(Comment comment) {
		comment.setCommentText(censoring(comment));
		this.comment.add(comment);

	}

	@Override
	public synchronized void deleteComment(Comment comment) {
		this.comment.remove(comment);

	}

	public synchronized void modifyComment(Comment comment) {
		this.comment.remove(comment);
		this.comment.add(comment);
	}
/**
 * This method finds the words, that must be censored, and chanches them for the symbols "***".
 * @param object
 * @return changed text
 */
	public <T extends TextEntity> String censoring(T object) {
		String[] words = { "shit", "fuck", "damn", "bitch" };
		String text = object.getText();
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
