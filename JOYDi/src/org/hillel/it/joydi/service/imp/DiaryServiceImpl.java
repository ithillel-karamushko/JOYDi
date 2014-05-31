package org.hillel.it.joydi.service.imp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Countries;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.model.entities.Months;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.entities.Picture;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.model.search.ArticleCriteria;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.hillel.it.joydi.persistance.repository.PictureRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;
import org.hillel.it.joydi.service.diaryService.DiaryService;

/**
 * 
 * @author team JOYdi
 * 
 */
public class DiaryServiceImpl implements DiaryService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2578361153123463872L;

	private TextRepository textRepository;
	private PersonRepository personRepository;
	private PictureRepository pictureRepository;

	public DiaryServiceImpl(TextRepository textRepository,
			PersonRepository personRepository,
			PictureRepository pictureRepository) {
		this.textRepository = textRepository;
		this.personRepository = personRepository;
		this.pictureRepository = pictureRepository;

	}

	public DiaryServiceImpl() {

	}

	public PictureRepository getPictureRepository() {
		return pictureRepository;
	}

	public void setPictureRepository(PictureRepository pictureRepository) {
		this.pictureRepository = pictureRepository;
	}

	public void setTextRepository(TextRepository textRepository) {
		this.textRepository = textRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public TextRepository getTextRepository() {
		return textRepository;
	}

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
		if (article.getAuthor().isEnter()) {
			textRepository.saveArticle(article);
		} else
			System.out
					.println("Please login or register, we can't save your article!");
	}

	/**
	 * Method that calls other method and delete article from the repository
	 * 
	 * @param article
	 *            is a reference to the Object Article
	 */
	@Override
	public void deleteArticle(Article article) {
		if (article.getAuthor().isEnter()) {
			textRepository.deleteArticle(article);
		} else
			System.out
					.println("Please login or register, we can't save your article!");

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
		if (article.getAuthor().isEnter()) {
			if (textOfTheArticle != null) {
				article.setTextOfTheArticle(textOfTheArticle);
			}

			if (themeOfTheArticle != null) {
				article.setThemeOfTheArticle(themeOfTheArticle);
			}

			textRepository.modifyArticle(article);
		}

		else
			System.out
					.println("Please login or register, we can't save your article!");
	}

	/**
	 * Method that calls other method and save user to the repository
	 * 
	 * @param person
	 *            is a reference to the Object Person
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Override
	public void saveUser(User person) throws FileNotFoundException, IOException {
		personRepository.saveUser(person);

	}

	/**
	 * Method that calls other method and save admin to the repository
	 * 
	 * @param person
	 *            is a reference to the Object Admin
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Override
	public void saveAdmin(Admin person) throws FileNotFoundException,
			IOException {
		personRepository.saveAdmin(person);

	}

	/**
	 * Method that calls other method and delete user from the repository
	 * 
	 * @param user
	 *            is a reference to the Object Person
	 * @throws IOException
	 */
	@Override
	public void deleteUser(User person) throws IOException {
		personRepository.deleteUser(person);

	}

	public void modifyUser(User person, String name, String eMail,
			Countries country, Gender gender, int yearOfBirth,
			Months monthOfBirth, int dayOfBirth) throws FileNotFoundException,
			IOException {
		deleteUser(person);

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

		person.setDateOfBirth(yearOfBirth, monthOfBirth, dayOfBirth);
		personRepository.modifyUser(person);
	}

	/**
	 * Method that calls other method and delete admin from the repository
	 * 
	 * @param person
	 *            is a reference to the Object Person
	 * @throws IOException
	 */
	@Override
	public void deleteAdmin(Admin person) throws IOException {
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
		if (comment.getAuthor().isEnter()) {
			textRepository.saveComment(comment);
		} else
			System.out
					.println("Please login or register, we can't save your article!");

	}

	/**
	 * Method that calls other method and delete comment from the repository
	 * 
	 * @param article
	 *            is a reference to the Object Comment
	 */
	@Override
	public void deleteComment(Comment comment) {
		if (comment.getAuthor().isEnter()) {
			textRepository.deleteComment(comment);
		} else
			System.out
					.println("Please login or register, we can't save your article!");
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
		if (comment.getAuthor().isEnter()) {
			comment.setCommentText(commentText);
			textRepository.modifyComment(comment);
		} else
			System.out
					.println("Please login or register, we can't save your article!");
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

	/**
	 * This method add to list all the articles, that match to definite
	 * criteria.
	 */
	@Override
	public List<Article> findArticles(ArticleCriteria criteria) {
		List<Article> allArticles = textRepository.getArticle();
		List<Article> result = new ArrayList<Article>();
		for (Article article : allArticles) {
			if (article.match(criteria)) {
				result.add(article);
			}
		}
		return result;

	}

	@Override
	public void savePicture(Picture picture) throws SQLException {
		pictureRepository.savePicture(picture);

	}

	@Override
	public void deletePicture(Picture picture) {
		pictureRepository.deletePicture(picture);

	}

	@Override
	public void getPicture() {
		pictureRepository.getPicture();

	}

	public void enter(String email, String password) {
		List<Person> allPersons = personRepository.getPersons();
		for (Person person : allPersons) {
			if (person.geteMail().equals(email)
					&& person.getPassword().equals(password)) {
				person.setEnter(true);
			}
		}
	}

	@Override
	public void exit(Person person) {
		person.setEnter(false);
	}

}
