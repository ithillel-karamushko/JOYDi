package org.hillel.it.joydi.model.search;

import org.hillel.it.joydi.persistance.repository.TextRepository;

/**
 * @author team JOYdi
 */
public class ArticleCriteria {
	private String tag;
	private String author;
	private String themeOfArticle;
	private TextRepository textRepository;

	public ArticleCriteria(String author, String themeOfArticle, String tag,
			TextRepository tr) {
		if (tag == null && author == null && themeOfArticle == null) {
			throw new RuntimeException("You need a criteria for searching");
		}
		this.textRepository = tr;
		this.author = author;
		this.themeOfArticle = themeOfArticle;
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThemeOfArticle() {
		return themeOfArticle;
	}

	public void setThemeOfArticle(String themeOfArticle) {
		this.themeOfArticle = themeOfArticle;
	}

}
