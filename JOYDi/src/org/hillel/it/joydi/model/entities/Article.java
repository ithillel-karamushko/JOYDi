package org.hillel.it.joydi.model.entities;

public class Article {
	private String textOfTheArticle;
	private String authorName;
	private String themeOfTheArticle;
	private double addingDate;
	private double addingTime;
    private int ratingOfTheArticle;
	
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
	public double getAddingDate() {
		return addingDate;
	}
	public void setAddingDate(double addingDate) {
		this.addingDate = addingDate;
	}
	public double getAddingTime() {
		return addingTime;
	}
	public void setAddingTime(double addingTime) {
		this.addingTime = addingTime;
	}
	public int getRatingOfTheArticle() {
		return ratingOfTheArticle;
	}
	public void setRatingOfTheArticle(int ratingOfTheArticle) {
		this.ratingOfTheArticle = ratingOfTheArticle;
	} 
}
