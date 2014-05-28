package org.hillel.it.joydi.model.entities;

import java.util.Date;

/**
 * 
 * @author JOYDi
 * 
 */

public class Comment extends TextEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6765453702641087954L;
	private Person author;
	private int likes;
	private int dislikes;
	private String commentText;
	Date date;

	/**
	 * Kit of the class Comment set in
	 * field date current date and time
	 * 
	 * @param authorName
	 * @param commentText
	 */

	public Comment(Person author, String commentText) {
		this.author = author;
		this.commentText = commentText;
		date = new Date();

	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
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

	public String getText() {
		String result = getCommentText();
		return result;
	}
}
