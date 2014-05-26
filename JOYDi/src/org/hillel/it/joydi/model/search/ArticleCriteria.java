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

}
