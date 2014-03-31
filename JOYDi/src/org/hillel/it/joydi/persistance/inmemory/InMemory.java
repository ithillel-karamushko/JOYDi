package org.hillel.it.joydi.persistance.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.hillel.id.joydi.persistance.repository.PersonRepository;
import org.hillel.id.joydi.persistance.repository.PictureRepository;
import org.hillel.id.joydi.persistance.repository.TextRepository;
import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.entities.Picture;
import org.hillel.it.joydi.model.entities.User;

public class InMemory implements PersonRepository, TextRepository,
		PictureRepository {

	private List<Article> article = new ArrayList();;
	private List<Person> admin = new ArrayList();;
	private List<Person> user = new ArrayList();;
	private List<Comment> comment = new ArrayList();;
	private List<Picture> picture = new ArrayList();;

	public void getArticle() {
		System.out.println(article);
	}

	public void getAdmin() {
		System.out.println(admin);
	}

	public void getUser() {
		System.out.println(user);
	}

	public void getComment() {
		System.out.println(comment);
	}

	public void getPicture() {
		System.out.println(picture);
	}

	@Override
	public void addPicture(Picture picture) {
		this.picture.add(picture);

	}

	@Override
	public void deletePicture(Picture picture) {
		this.picture.remove(picture);

	}

	@Override
	public void saveArticle(Article article) {
		this.article.add(article);

	}

	@Override
	public void deleteArticle(Article article) {
		this.article.remove(article);

	}

	@Override
	public void saveComment(Comment comment) {
		this.comment.add(comment);

	}

	@Override
	public void deleteComment(Comment comment) {
		this.comment.remove(comment);

	}

	@Override
	public void saveUser(User person) {
		user.add(person);

	}

	@Override
	public void deleteUser(User person) {
		user.remove(person);

	}

	@Override
	public void saveAdmin(Admin person) {
		admin.add(person);

	}

	@Override
	public void deleteAdmin(Admin person) {
		admin.remove(person);

	}

}
