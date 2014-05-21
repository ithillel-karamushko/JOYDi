package org.hillel.it.joydi.model.entities;

import java.util.Date;

import org.hillel.it.joydi.model.search.ArticleCriteria;

/**
 * 
 * @author Îëÿ
 * 
 */

public class Article extends TextEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1020794148833096658L;
	private String textOfTheArticle;
	private Person author;
	private String themeOfTheArticle;
	private int ratingOfTheArticle;
	private String tags;
	private Date date;
	private int like;
	private int disLike;

	/**
	 * Kit of the class Article takes parameters authorName, themeOfTheArticle,
	 * and String textOfTheArticle and sets their values in fields authorName,
	 * themeOfTheArticle and String textOfTheArticle, also it set in field date
	 * current date and time and in fields like and disLike values = 0
	 * 
	 * @param authorName
	 * @param themeOfTheArticle
	 * @param textOfTheArticle
	 */

	public Article(Person author, String themeOfTheArticle,
			String textOfTheArticle, String tags) {
		date = new Date();
		this.author = author;
		this.themeOfTheArticle = themeOfTheArticle;
		this.textOfTheArticle = textOfTheArticle;
		this.setLike(0);
		this.setDisLike(0);
		this.tags = tags;
		ratingOfTheArticle = 0;

	}

	public Date getDate() {
		return date;
	}

	public Person getAuthor() {
		return author;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTextOfTheArticle() {
		return textOfTheArticle;
	}

	public void setTextOfTheArticle(String textOfTheArticle) {
		this.textOfTheArticle = textOfTheArticle;
	}

	public String getThemeOfTheArticle() {
		return themeOfTheArticle;
	}

	public void setThemeOfTheArticle(String themeOfTheArticle) {
		this.themeOfTheArticle = themeOfTheArticle;
	}

	public int getRatingOfTheArticle() {
		ratingOfTheArticle = like - disLike;
		return ratingOfTheArticle;
	}

	public void setRatingOfTheArticle(int ratingOfTheArticle) {
		this.ratingOfTheArticle = ratingOfTheArticle;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDisLike() {
		return disLike;
	}

	public void setDisLike(int disLike) {
		this.disLike = disLike;
	}

	public String getText() {
		String result = getTextOfTheArticle();
		return result;
	}

	/**
	 * This method looks for the articles, that match the definite criteria.
	 * 
	 * @param criteria
	 * @return result of matching
	 */

	public boolean match(ArticleCriteria criteria) {
		String authorName = author.getName();
		boolean match = false;
		boolean author = criteria.getAuthor() == null
				|| authorName.equalsIgnoreCase(criteria.getAuthor());
		boolean theme = criteria.getThemeOfArticle() == null
				|| themeOfTheArticle.equalsIgnoreCase(criteria
						.getThemeOfArticle());
		boolean tag = criteria.getTag() == null
				|| tags.contains(criteria.getTag());
		if ((author) && (theme) && (tag)) {
			match = true;
		} else {
			match = false;
		}
		return match;
	}

}
