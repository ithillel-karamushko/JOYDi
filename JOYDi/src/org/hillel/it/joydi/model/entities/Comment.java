package org.hillel.it.joydi.model.entities;

public class Comment {
	private double addingDate;
	private double addingTime;
	private String authorName;
	private int likes;
	private int dislikes;

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
