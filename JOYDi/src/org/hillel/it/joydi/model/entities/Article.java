package org.hillel.it.joydi.model.entities;
import java.util.Date;
import java.util.List;

import org.hillel.id.joydi.persistance.repository.TextRepository;


public class Article extends BaseEntity {
	private String textOfTheArticle;
	private String authorName;
	private String themeOfTheArticle;
	//private Date addingDate;
	//private double addingTime;
	Date date;
    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private int ratingOfTheArticle;
    private List tags;
    
   public Article (String authorName,String themeOfTheArticle, String textOfTheArticle){
    	date = new Date();
    	this.authorName=authorName;
    	this.themeOfTheArticle=themeOfTheArticle;
    	this.textOfTheArticle=textOfTheArticle; 
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
	
	public Article addText(String text){
		return null;
	}
	
	public Article modifyText(Article text){
		return null;
	}
	
	public void deleteText(Article text){
		
	}
}
