package org.hillel.it.joydi.service.imp;

import java.util.List;
import java.util.Set;

import org.hillel.id.joydi.persistance.repository.PersonRepository;
import org.hillel.id.joydi.persistance.repository.TextRepository;
import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.model.search.ArticleCriteria;
import org.hillel.it.joydi.persistance.inmemory.InMemory;
import org.hillel.it.joydi.service.diaryService.DiaryService;

public class DiaryServiceImpl implements DiaryService {
	private TextRepository textRepository = new InMemory();
	private PersonRepository personRepository = new InMemory();

	@Override
	public void saveArticle(Article article) {
		textRepository.saveArticle(article);

	}

	@Override
	public void deleteArticle(Article article) {
		textRepository.deleteArticle(article);

	}

	@Override
	public void saveUser(User person) {
		personRepository.saveUser(person);

	}

	@Override
	public void saveAdmin(Admin person) {
		personRepository.saveAdmin(person);

	}

	@Override
	public void deleteUser(User person) {
		personRepository.deleteUser(person);

	}

	@Override
	public void deleteAdmin(Admin person) {
		personRepository.deleteAdmin(person);

	}

	@Override
	public void saveComment(Comment comment) {
		textRepository.saveComment(comment);

	}

	@Override
	public void deleteComment(Comment comment) {
		textRepository.deleteComment(comment);

	}

	public void getPersonsList() {
		System.out.println("Admins List: ");
		personRepository.getAdmin();
		System.out.println("Users List: ");
		personRepository.getUser();
	}

	public void getTextsList() {
		System.out.println("Articles List: ");
		textRepository.getArticle();
		System.out.println("Comments List: ");
		textRepository.getComment();
	}

	@Override
	public Set findArticles(ArticleCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}
}
