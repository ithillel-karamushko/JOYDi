package org.hillel.it.joydi.persistance.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.User;

public class InMemory {
	private List article = new ArrayList();
	private List admin = new ArrayList();
	private List user = new ArrayList();
	private List comment = new ArrayList();

	public void saveUser(User user) {
		this.user.add(user);
		System.out.println(this.user);
	}

	public void saveAdmin(Admin admin) {
		this.admin.add(admin);
	}
	public void saveArticle(Article article) {
		this.article.add(article);
	}
	public void saveComment(Comment comment) {
		this.comment.add(comment);
	}
	public void deleteUser(User user) {
		this.admin.remove(user);
	
}
}

