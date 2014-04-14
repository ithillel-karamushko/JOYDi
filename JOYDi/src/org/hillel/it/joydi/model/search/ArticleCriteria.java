package org.hillel.it.joydi.model.search;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.persistance.repository.TextRepository;

/**
 * @author team JOYdi
 */
public class ArticleCriteria {
	private String tag;
	private String author;
	private String themeOfArticle;
	private TextRepository textRepository;

	public ArticleCriteria(String tag, String author, String themeOfArticle, TextRepository tr) {
		this.textRepository = tr;
		this.author = author;
		this.themeOfArticle = themeOfArticle;
		this.tag = tag;
	}

	/**
	 * Getter for field tag;
	 * 
	 * @return tag;
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Setter for field tag; modify field tag;
	 * 
	 * @param tag
	 *            ;
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * Getter for field author;
	 * 
	 * @return author;
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Setter for field author;; modify field author;
	 * 
	 * @param author
	 */

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Getter for field ThemeOfArticle;
	 * 
	 * @return themeOfArticle;
	 */
	public String getThemeOfArticle() {
		return themeOfArticle;
	}

	/**
	 * Setter for field themeOfArticle;
	 * 
	 * @param themeOfArticle
	 */
	public void setThemeOfArticle(String themeOfArticle) {
		this.themeOfArticle = themeOfArticle;
	}

	public List<Article> match (ArticleCriteria criteria){
		List<Article> allArticles = textRepository.getArticle();
		List<Article> result = new ArrayList<Article>();
		for (Article article : allArticles) {
			boolean containsTags = article.getTags().contains(criteria.tag);
			if (article.getAuthorName() == criteria.getAuthor()
					&& article.getThemeOfTheArticle() == criteria
							.getThemeOfArticle() && (containsTags)) {
				result.add(article);
			}
		}
		return result;
	}
}
