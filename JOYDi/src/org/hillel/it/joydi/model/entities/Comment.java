package org.hillel.it.joydi.model.entities;
import java.util.Date;

import org.hillel.id.joydi.persistance.repository.TextRepository;

public class Comment extends BaseEntity implements TextRepository <Comment> {
	private Date addingDate;
	private double addingTime;
	private String authorName;
	private int likes;
	private int dislikes;
    private String commentText;
    
	//I don`t know if we need this part
	public Date getAddingDate() {
		return addingDate;
	}

	public void setAddingDate(Date addingDate) {
		this.addingDate = addingDate;
	}
	//I don`t know if we need this part
	public double getAddingTime() {
		return addingTime;
	}

	public void setAddingTime(double addingTime) {
		this.addingTime = addingTime;
	}

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
