package org.hillel.it.joydi.model.entities;

import java.util.Date;
import java.util.List;

public class Article extends BaseEntity {
	private String textOfTheArticle;
	private String authorName;
	private String themeOfTheArticle;
	private int ratingOfTheArticle;
	private List tags;
	private Date date;
	private int like;
	private int disLike;

	public Article(String authorName, String themeOfTheArticle,
			String textOfTheArticle) {
		date = new Date();
		this.authorName = authorName;
		this.themeOfTheArticle = themeOfTheArticle;
		this.textOfTheArticle = textOfTheArticle;
		this.setLike(0);
		this.setDisLike(0);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List getTags() {
		return tags;
	}

	public void setTags(List tags) {
		this.tags = tags;
	}

	public String getTextOfTheArticle() {
		return textOfTheArticle;
	}

	public void setTextOfTheArticle(String textOfTheArticle) {
		this.textOfTheArticle = textOfTheArticle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getThemeOfTheArticle() {
		return themeOfTheArticle;
	}

	public void setThemeOfTheArticle(String themeOfTheArticle) {
		this.themeOfTheArticle = themeOfTheArticle;
	}

	public int getRatingOfTheArticle() {
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

}
