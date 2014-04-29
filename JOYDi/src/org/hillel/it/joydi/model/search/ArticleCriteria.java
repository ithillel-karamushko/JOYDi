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

	/**
	 * This method looks for the articles, that match the definite criteria.
	 * 
	 * @param criteria
	 * @return list of articles
	 */
//	public List<Article> match(ArticleCriteria criteria) {
//		List<Article> allArticles = textRepository.getArticle();
//		List<Article> resultAuthor = new ArrayList<Article>();
//		List<Article> resultTheme = new ArrayList<Article>();
//		List<Article> resultFinal = new ArrayList<Article>();
//
//		if (criteria.getAuthor() != null) {
//			for (Article article : allArticles) {
//				if (article.getAuthorName() == criteria.getAuthor()) {
//					resultAuthor.add(article);
//				}
//			}
//		} else {
//			resultAuthor = allArticles;
//		}
//
//		if (criteria.getThemeOfArticle() != null) {
//			for (Article article : resultAuthor) {
//				if (article.getThemeOfTheArticle() == criteria.getThemeOfArticle()) {
//					resultTheme.add(article);
//				}
//			}
//		} else {
//			resultTheme = resultAuthor;
//		}
//
//		if (criteria.getTag() != null) {
//			for (Article article : resultTheme) {
//				boolean containsTags = article.getTags().contains(criteria.tag);
//				if ((containsTags)) {
//					resultFinal.add(article);
//				}
//			}
//		} else {
//			resultFinal = resultTheme;
//		}
//		return resultFinal;
//	}
}
