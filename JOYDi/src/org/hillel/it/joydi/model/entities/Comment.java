package org.hillel.it.joydi.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Îëÿ
 * 
 */

public class Comment extends BaseEntity {
	private String authorName;
	private int likes;
	private int dislikes;
	private String commentText;
	Date date;

	/**
	 * Kit of the class Comment takes parameters authorName and commentText 
	 * and sets their values in fields authorName and commentText
	 * also it set in field date current date and time
	 * 
	 * @param authorName
	 * @param commentText
	 */

	public Comment(String authorName, String commentText) {
		this.authorName = authorName;
		this.commentText = commentText;
		date = new Date();

	}

	/**
	 * Getter for field Date
	 * @return Date
	 */
	
	public Date getDate() {
		return date;
	}

	SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");

	// I don`t know if we need this part
	
	/**
	 *  Getter for field AuthorName
	 * @return field authorName
	 */
	
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * Setter for authorName
	 * modify authorName
	 * @param authorName
	 */
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * Getter for likes
	 * @return field likes
	 */
	
	public int getLikes() {
		return likes;
	}

	/**
	 * Getter for dislikes
	 * @return dislikes
	 */
	
	public int getDislikes() {
		return dislikes;
	}

	/**
	 * Getter for commentText
	 * @return commentText
	 */
	
	public String getCommentText() {
		return commentText;
	}

	/**
	 * Setter for commentText
	 * modify commentText
	 * @param commentText
	 */
	
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

}
