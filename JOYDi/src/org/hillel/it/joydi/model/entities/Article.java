package org.hillel.it.joydi.model.entities;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Îëÿ
 *
 */

public class Article extends BaseEntity {
	private String textOfTheArticle;
	private String authorName;
	private String themeOfTheArticle;
	private int ratingOfTheArticle;
	private String tags;
	private Date date;
	private int like;
	private int disLike;

	/**
	 * Kit of the class Article takes parameters authorName, themeOfTheArticle,
	 * and String textOfTheArticle and sets their values in fields authorName, 
	 * themeOfTheArticle and String textOfTheArticle,
	 * also it set in field date current date and time and in fields like
	 * and disLike values = 0
	 * 
	 * @param authorName
	 * @param themeOfTheArticle
	 * @param textOfTheArticle
	 */
	
	public Article(String authorName, String themeOfTheArticle,
			String textOfTheArticle) {
		date = new Date();
		this.authorName = authorName;
		this.themeOfTheArticle = themeOfTheArticle;
		this.textOfTheArticle = textOfTheArticle;
		this.setLike(0);
		this.setDisLike(0);
	}

	/**
	 * Getter for date
	 * @return field date
	 */
	
	public Date getDate() {
		return date;
	}

	/**
	 * Setter for date
	 * modify field date
	 * @param date
	 */
	
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Getter for tags
	 * @return field tags
	 */
	
	public String getTags() {
		return tags;
	}

	/**
	 * Setter for tags
	 * modify field tags
	 * @param tags
	 */
	
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * Getter for textOfTheArticle
	 * @return field textOfTheArticle
	 */
	
	public String getTextOfTheArticle() {
		return textOfTheArticle;
	}

	/**
	 * Setter for textOfTheArticle
	 * modify field textOfTheArticle
	 * @param textOfTheArticle
	 */
	
	public void setTextOfTheArticle(String textOfTheArticle) {
		this.textOfTheArticle = textOfTheArticle;
	}

	/**
	 * Getter for authorName
	 * @return field authorName
	 */
	
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * Setter for setAuthorName
	 * modify field setAuthorName
	 * @param authorName
	 */
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * Getter for themeOfArticle
	 * @return field themeOfArticle
	 */
	
	public String getThemeOfTheArticle() {
		return themeOfTheArticle;
	}

	/**
	 * Setter of themeOfArticle
	 * modify field  themeOfArfticle
	 * @param themeOfTheArticle
	 */
	
	public void setThemeOfTheArticle(String themeOfTheArticle) {
		this.themeOfTheArticle = themeOfTheArticle;
	}

	/**
	 * Getter for ratingOfArticle
	 * @return field ratingOfArticle
	 */
	
	public int getRatingOfTheArticle() {
		return ratingOfTheArticle;
	}

	/**
	 * Setter for ratingOfArticle
	 * modify field ratingOfArticle 
	 * @param ratingOfTheArticle
	 */
	
	public void setRatingOfTheArticle(int ratingOfTheArticle) {
		this.ratingOfTheArticle = ratingOfTheArticle;
	}

	/**
	 * Getter for like
	 * @return field like
	 */
	
	public int getLike() {
		return like;
	}

	/**
	 * Setter for like
	 * modify field like
	 * @param like
	 */
	
	public void setLike(int like) {
		this.like = like;
	}
	
	/**
	 * Getter for disLike 
	 * @return field disLike
	 */
	
	public int getDisLike() {
		return disLike;
	}

	/**
	 * Setter for disLike
	 * modify field disLike
	 * @param disLike
	 */
	
	public void setDisLike(int disLike) {
		this.disLike = disLike;
	}

}
