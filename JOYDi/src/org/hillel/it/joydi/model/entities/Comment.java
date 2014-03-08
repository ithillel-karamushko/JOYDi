package org.hillel.it.joydi.model.entities;

public class Comment {
	private double addingDate;
	private double addingTime;
	private String authorName;
	private int likes;
	private int dislikes;
    private String commentText;
    
	//I dont know if we need this part
	public double getAddingDate() {
		return addingDate;
	}

	public void setAddingDate(double addingDate) {
		this.addingDate = addingDate;
	}
	//I dont know if we need this part
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


	

	
	
	
}
