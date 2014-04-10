package org.hillel.it.joydi.model.search;

public class ArticleCriteria {
	private String tag;
	private String author;
	private String themeOfArticle;
  
	
	public ArticleCriteria (String tag, String author, String themeOfArticle){
		this.tag = tag;
		this.author = author;
		this.themeOfArticle = themeOfArticle;
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThemeOfArticle() {
		return themeOfArticle;
	}

	public void setThemeOfArticle(String themeOfArticle) {
		this.themeOfArticle = themeOfArticle;
	}


}