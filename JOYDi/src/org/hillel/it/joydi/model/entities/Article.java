package org.hillel.it.joydi.model.entities;
import java.util.Date;
public class Article extends BaseEntity{
	private String textOfTheArticle;
	private String authorName;
	private String themeOfTheArticle;
	private Date addingDate;
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
	public Date getAddingDate() {
		return addingDate;
	}
	public void setAddingDate(Date addingDate) {
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
