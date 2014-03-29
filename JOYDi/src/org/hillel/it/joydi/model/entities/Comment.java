package org.hillel.it.joydi.model.entities;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hillel.id.joydi.persistance.repository.TextRepository;

public class Comment extends BaseEntity implements TextRepository{
	//private Date addingDate = new Date();
	//private double addingTime;
	private String authorName;
	private int likes;
	private int dislikes;
    private String commentText;
    Date date;
    
    public Date getDate() {
		return date;
	}



	SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
    
    public Comment (String authorName, String commentText){
    	    	this.authorName=authorName;
    	this.commentText=commentText;
    	date = new Date();
    	    	
    }


	
	
	//I don`t know if we need this part
	
    public String getAuthorName(){
    	return authorName;
    }
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public int getLikes() {
		return likes;
	}
	
	public int getDislikes() {
		return dislikes;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	public Comment addText(String text){
		return null;
	}
	
	public Comment modifyText(Comment text){
		return null;
	}
	
	public void deleteText(Comment text){
		
	}
}
