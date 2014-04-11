package org.hillel.it.joydi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.model.search.ArticleCriteria;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;
import org.hillel.it.joydi.service.diaryService.DiaryService;

/**
 * 
 * @author Æåíÿ, Îëÿ, Þëÿ
 * 
 */
public class DiaryServiceImpl implements DiaryService {
	private TextRepository textRepository = new InMemoryTextRepository();
	private PersonRepository personRepository = new InMemoryPersonRepository();

	/**
	 * Getter for field textRepository
	 * 
	 * @return field textRepository
	 */
	public TextRepository getTextRepository() {
		return textRepository;
	}

	/**
	 * Getter for field PersonRepository
	 * 
	 * @return field PersonRepository
	 */
	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	/**
	 * Method that calls other method and saves article in to repository
	 * 
	 * @param article
	 *            is a reference to the Object Article
	 */

	@Override
	public void saveArticle(Article article) {
		textRepository.saveArticle(article);

	}

	/**
	 * Method that calls other method and delete article from the repository
	 * 
	 * @param article
	 *            is a reference to the Object Article
	 */
	@Override
	public void deleteArticle(Article article) {
		textRepository.deleteArticle(article);

	}

	/**
	 * Method that calls other method, modify article and save changes
	 * 
	 * @param article
	 *            is a reference to the Object Article
	 * @param textOfTheArticle
	 *            is a new text of the article
	 * @param themeOfTheArticle
	 *            is a new theme of the article
	 */
	public void modifyArticle(Article article, String textOfTheArticle,
			String themeOfTheArticle) {

		if (textOfTheArticle != null) {
			article.setTextOfTheArticle(textOfTheArticle);
		}

		if (themeOfTheArticle != null) {
			article.setThemeOfTheArticle(themeOfTheArticle);
		}

		textRepository.modifyArticle(article);
	}

	/**
	 * Method that calls other method and save user to the repository
	 * 
	 * @param person
	 *            is a reference to the Object Person
	 */
	@Override
	public void saveUser(User person) {
		personRepository.saveUser(person);

	}

	/**
	 * Method that calls other method and save admin to the repository
	 * 
	 * @param person
	 *            is a reference to the Object Admin
	 */
	@Override
	public void saveAdmin(Admin person) {
		personRepository.saveAdmin(person);

	}

	/**
	 * Method that calls other method and delete user from the repository
	 * 
	 * @param user
	 *            is a reference to the Object Person
	 */
	@Override
	public void deleteUser(User person) {
		personRepository.deleteUser(person);

	}

	/**
	 * Method that calls other method, modify users data and save changes
	 * 
	 * @param person
	 *            is a reference to the Object User
	 * @param name
	 *            is a new name of the User
	 * @param eMail
	 *            is a new email of the User
	 * @param country
	 *            is a new country of the User
	 * @param age
	 *            is a new age of the User
	 * @param gender
	 *            is a reference to the Gender Object
	 */
	public void modifyUser(User person, String name, String eMail,
			String country, Gender gender, int age) {
		if (name != null) {
			person.setName(name);
		}

		if (eMail != null) {
			person.seteMail(eMail);
		}

		if (country != null) {
			person.setCountry(country);
		}

		if (gender != null) {
			person.setGender(gender);
		}

		person.setAge(age);
		personRepository.modifyUser(person);
		System.out.println("Users List: ");
		personRepository.getUser();
	}

	/**
	 * Method that calls other method and delete admin from the repository
	 * 
	 * @param person
	 *            is a reference to the Object Person
	 */
	@Override
	public void deleteAdmin(Admin person) {
		personRepository.deleteAdmin(person);

	}

	/**
	 * Method that calls other method and save comment in to the repository
	 * 
	 * @param article
	 *            is a reference to the Object Comment
	 */

	@Override
	public void saveComment(Comment comment) {
		textRepository.saveComment(comment);

	}

	/**
	 * Method that calls other method and delete comment from the repository
	 * 
	 * @param article
	 *            is a reference to the Object Comment
	 */
	@Override
	public void deleteComment(Comment comment) {
		textRepository.deleteComment(comment);
	}

	/**
	 * Method that calls other method, modify comment and save changes
	 * 
	 * @param comment
	 *            is a reference to the Object Comment
	 * @param commentText
	 *            is a new text of the comment
	 */
	public void modifyComment(Comment comment, String commentText) {
		comment.setCommentText(commentText);
		textRepository.modifyComment(comment);
	}

	public void getPersonsList() {
		System.out.println("Admins List: ");
		System.out.println(personRepository.getAdmin());
		System.out.println("Users List: ");
		System.out.println(personRepository.getUser());
	}

	public void getTextsList() {
		System.out.println("Articles List: ");
		System.out.println(textRepository.getArticle());
		System.out.println("Comments List: ");
		System.out.println(textRepository.getComment());
	}

	/**
	 * Method that counts number of likes
	 * 
	 * @param article
	 *            is a reference to Article Object
	 */
	public void pushLike(Article article) {
		article.setLike(article.getLike() + 1);

	}

	/**
	 * Method that counts number of dislikes
	 * 
	 * @param article
	 *            is a reference to Article Object
	 */
	public void pushDisLike(Article article) {
		article.setDisLike(article.getDisLike() + 1);
	}

	@Override
	public List<Article> findArticles(ArticleCriteria criteria) {
		String author = criteria.getAuthor();
		String tag = criteria.getTag();
		String theme = criteria.getThemeOfArticle();
		List<Article> result = new ArrayList<Article>();

		if (author == null && tag == null && theme == null) {
			System.out.println("ytyt1");
			return null;
		} else {
			result = textRepository.getArticle();
			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).getAuthorName() != author) {
					result.remove(result.get(i));
					System.out.println(result + "after remove");

				} else {
					System.out.println(result + "in else");
				}
			}

		}
		return result;
	}
}
