package org.hillel.it.joydi.service.imp;

import java.util.Set;

import org.hillel.id.joydi.persistance.repository.PersonRepository;
import org.hillel.id.joydi.persistance.repository.TextRepository;
import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.model.search.ArticleCriteria;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.service.diaryService.DiaryService;

public class DiaryServiceImpl implements DiaryService {
	private TextRepository textRepository = new InMemoryTextRepository();
	private PersonRepository personRepository = new InMemoryPersonRepository();

	@Override
	public void saveArticle(Article article) {
		textRepository.saveArticle(article);

	}

	@Override
	public void deleteArticle(Article article) {
		textRepository.deleteArticle(article);

	}
	
	public void modifyArticle(Article article, String textOfTheArticle,	String themeOfTheArticle){
		textRepository.deleteArticle(article);
		if (textOfTheArticle != null){
		article.setTextOfTheArticle(textOfTheArticle);
		}
		
		if (themeOfTheArticle != null){
		article.setThemeOfTheArticle(themeOfTheArticle);}
		
		textRepository.saveArticle(article);
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
	
	public void modifyUser(User person, String name, String eMail, String country,
			Gender gender, int age){
		personRepository.deleteUser(person);
		if (name != null){
		person.setName(name);
		}
		
		if (eMail != null){
		person.seteMail(eMail);}
		
		if (country != null){
		person.setCountry(country);}
		
		if (gender != null){
		person.setGender(gender);
		}
		
		person.setAge(age);
		
		
		personRepository.saveUser(person);
		System.out.println("Users List: ");
		personRepository.getUser();
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
	
	public void modifyComment(Comment comment, String commentText){
		textRepository.deleteComment(comment);
		comment.setCommentText(commentText);
		textRepository.saveComment(comment);
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
