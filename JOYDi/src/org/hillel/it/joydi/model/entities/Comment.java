package org.hillel.it.joydi.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author ���
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
	 * Kit of the class Comment takes parameters authorName and commentText and
	 * sets their values in fields authorName and commentText also it set in
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

	/**
	 * Getter for field Date
	 * 
	 * @return Date
	 */
	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");

	// I don`t know if we need this part

	
	/**
	 * Getter for likes
	 * 
	 * @return field likes
	 */

	public int getLikes() {
		return likes;
	}

	/**
	 * Getter for dislikes
	 * 
	 * @return dislikes
	 */

	public int getDislikes() {
		return dislikes;
	}

	/**
	 * Getter for commentText
	 * 
	 * @return commentText
	 */

	public String getCommentText() {
		return commentText;
	}

	/**
	 * Setter for commentText modify commentText
	 * 
	 * @param commentText
	 */

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getText() {
		String result = getCommentText();
		return result;
	}
}
