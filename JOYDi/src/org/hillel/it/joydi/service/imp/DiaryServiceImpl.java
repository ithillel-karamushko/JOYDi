package org.hillel.it.joydi.service.imp;

import java.util.Set;

import org.hillel.id.joydi.persistance.repository.PersonRepository;
import org.hillel.id.joydi.persistance.repository.TextRepository;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.search.ArticleCriteria;
import org.hillel.it.joydi.persistance.inmemory.InMemory;
import org.hillel.it.joydi.service.diaryService.DiaryService;

public class DiaryServiceImpl implements DiaryService {
	private TextRepository TextRepository;
	private PersonRepository PersonRepository; // ������ ����� ����� ��� ���� ???

	@Override
	public void saveArticle(Article article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticle(Article article) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set findArticles(ArticleCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveUser(Person person) {
		InMemory.user.add(person);
	}

	public void saveAdmin(Person person) {
		InMemory.admin.add(person);
	}

	public void deleteUser(Person person) {
		InMemory.user.remove(person);

	}

	public void deleteAdmin(Person person) {
		InMemory.admin.remove(person);

	}

}
