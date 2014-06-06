package org.hillel.it.joydi.persistance.inmemory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hillel.it.joydi.concurrency.comparator.MyComparatorForDate;
import org.hillel.it.joydi.concurrency.comparator.MyComparatorForRaiting;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.TextEntity;
import org.hillel.it.joydi.persistance.repository.TextRepository;

public class InMemoryTextRepository implements TextRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1566240092971695811L;
	private List<Article> article;
	private List<Comment> comment;
	private int idCount;

	public InMemoryTextRepository() {

	}

	// public InMemoryTextRepository() {
	// this.article = new ArrayList<Article>();
	// this.comment = new ArrayList<Comment>();
	// }

	public int getIdCount() {
		return idCount;
	}

	public void setIdCount(int idCount) {
		this.idCount = idCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<Article> getArticle() {
		return article;
	}

	public List<Comment> getComment() {
		return comment;
	}

	@Override
	public synchronized void saveArticle(Article article) {
		article.setTextOfTheArticle(censoring(article));
		article.setId(idCount++);
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
		comment.setId(idCount++);
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
	 * This method finds the words, that must be censored, and changes them for
	 * the symbols "***".
	 * 
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
				text = text.replaceAll("(?i)" + matcher.group(), "[CENSORED]");
			}
		}
		return text;
	}

	@Override
	public synchronized void deleteArticleById(int id) {
		List<Article> forModifying = article;
		for (Article art : forModifying) {
			if (art.getId() == id) {
				article.remove(art);
			}
		}
		article = forModifying;

	}

	public List<Article> newArticles() {
		List<Article> result = article;
		Collections.sort(result, new MyComparatorForDate());
		if (result.size() > 10) {
			result = result.subList(0, 10);
		}
		return result;

	}

	@Override
	public List<Article> topArticles() {
		List<Article> top = article;
		Collections.sort(top, new MyComparatorForRaiting());
		if (top.size() > 10) {
			top = top.subList(0, 10);
		}
		return top;
	}
}
