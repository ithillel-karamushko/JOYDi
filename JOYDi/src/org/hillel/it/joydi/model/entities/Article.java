package org.hillel.it.joydi.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hillel.it.joydi.model.search.ArticleCriteria;

/**
 * 
 * @author JOYDi
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
	private Picture picture;
	private List<String> whoLike;
	private List<String> whoDoesntLike;

	/**
	 * Kit of the class Article set in field date current date and time and in
	 * fields like and disLike initial values = 0
	 * 
	 * @param authorName
	 * @param themeOfTheArticle
	 * @param textOfTheArticle
	 */

	public Article(Person author, String themeOfTheArticle,
			String textOfTheArticle, String tags, Picture picture) {
		date = new Date();
		this.author = author;
		this.themeOfTheArticle = themeOfTheArticle;
		this.textOfTheArticle = textOfTheArticle;
		this.setLike(0);
		this.setDisLike(0);
		this.tags = tags;
		ratingOfTheArticle = 0;
		this.picture = picture;
		whoLike = new ArrayList<String>();
		whoDoesntLike = new ArrayList<String>();

	}

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

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
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

	public List<String> getWhoLike() {
		return whoLike;
	}

	public void setWhoLike(List<String> whoLiked) {
		this.whoLike = whoLiked;
	}

	public List<String> getWhoDoesntLike() {
		return whoDoesntLike;
	}

	public void setWhoDoesntLike(List<String> whoDoesntLike) {
		this.whoDoesntLike = whoDoesntLike;
	}

	public boolean isInWhoLike(String email) {
		boolean result = false;
		if (whoLike.contains(email)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public boolean isInWhoDoesntLike(String email) {
		boolean result = false;
		if (whoDoesntLike.contains(email)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}
