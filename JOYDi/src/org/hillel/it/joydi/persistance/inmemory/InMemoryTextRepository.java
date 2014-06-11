package org.hillel.it.joydi.persistance.inmemory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.SerializationUtils;
import org.hillel.it.joydi.concurrency.comparator.MyComparatorForDate;
import org.hillel.it.joydi.concurrency.comparator.MyComparatorForRaiting;
import org.hillel.it.joydi.infra.config.Configuration;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.entities.TextEntity;
import org.hillel.it.joydi.persistance.repository.TextRepository;

public class InMemoryTextRepository implements TextRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1566240092971695811L;
	private List<Article> article;
	private List<Comment> comment;
	private int idCount;

	public InMemoryTextRepository() {

	}

	// public InMemoryTextRepository() {
	// this.article = new ArrayList<Article>();
	// this.comment = new ArrayList<Comment>();
	// }

	public int getIdCount() {
		return idCount;
	}

	public void setIdCount(int idCount) {
		this.idCount = idCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<Article> getArticle() {
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return article;
	}

	public List<Comment> getComment() {
		return comment;
	}

	@Override
	public synchronized void saveArticle(Article article) {
		article.setTextOfTheArticle(censoring(article));
		article.setId(idCount++);
		this.article.add(article);
		try {
			serialize(this.article);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public synchronized void modifyArticle(int id, String theme, String text,
			String tag) {
		Article art = returnArticleById(id);
		art.setThemeOfTheArticle(theme);
		art.setTextOfTheArticle(text);
		art.setTags(tag);
		try {
			serialize(this.article);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void deleteArticle(Article article) {
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.article.remove(article);
		try {
			serialize(this.article);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public synchronized void saveComment(Comment comment) {
		comment.setCommentText(censoring(comment));
		comment.setId(idCount++);
		this.comment.add(comment);

	}

	@Override
	public synchronized void deleteComment(Comment comment) {
		this.comment.remove(comment);

	}

	public synchronized void modifyComment(Comment comment) {
		this.comment.remove(comment);
		this.comment.add(comment);
	}

	/**
	 * This method finds the words, that must be censored, and changes them for
	 * the symbols "***".
	 * 
	 * @param object
	 * @return changed text
	 */
	public <T extends TextEntity> String censoring(T object) {
		String[] words = { "shit", "fuck", "damn", "bitch" };
		String text = object.getText();
		for (String word : words) {
			Pattern pattern = Pattern.compile("(?i)" + word + "*");
			Matcher matcher = pattern.matcher(text);
			while (matcher.find()) {
				text = text.replaceAll("(?i)" + matcher.group(), "[CENSORED]");
			}
		}
		return text;
	}

	public List<Article> newArticles() {
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Article> result = article;
		Collections.sort(result, new MyComparatorForDate());
		if (result.size() > 10) {
			result = result.subList(0, 10);
		}
		return result;

	}

	@Override
	public List<Article> topArticles() {
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Article> top = article;
		Collections.sort(top, new MyComparatorForRaiting());
		if (top.size() > 10) {
			top = top.subList(0, 10);
		}
		return top;
	}

	@Override
	public void deleteCommentById(int id) {
		int delete = 0;
		for (Comment comm : comment) {
			if (comm.getId() == id) {
				delete = comment.indexOf(comm);
			}
		}
		comment.remove(delete);
	}

	@Override
	public synchronized void deleteArticleById(int id) {
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int delete = 0;
		for (Article art : article) {
			if (art.getId() == id) {
				delete = article.indexOf(art);
			}
		}
		article.remove(delete);
		try {
			serialize(this.article);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Article> findUserArticles(String email) {
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Article> result = new ArrayList<>();
		for (Article art : article) {
			if (art.getAuthor().geteMail().equals(email)) {
				result.add(art);
			}
		}
		return result;
	}

	public void serialize(List<Article> text) throws FileNotFoundException,
			IOException {
		Configuration config = Configuration.getInstance();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				config.getPropertie("article.path")));
		oos.writeObject(text);
		oos.close();
	}

	public List<Article> deserialize() throws FileNotFoundException,
			IOException {
		Configuration config = Configuration.getInstance();
		FileInputStream fis = new FileInputStream(new File(
				config.getPropertie("article.path")));
		article = SerializationUtils.deserialize(fis);
		return article;
	}

	@Override
	public Article returnArticleById(int id) {
		Article result = null;
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Article art : article) {
			if (art.getId() == id) {
				result = art;
			}
		}
		return result;
	}

	@Override
	public void pushLike(int id) {
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Article art = returnArticleById(id);
		art.setLike(art.getLike() + 1);
		try {
			serialize(article);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pushDisLike(int id) {
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Article art = returnArticleById(id);
		art.setDisLike(art.getDisLike() + 1);
		try {
			serialize(article);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}