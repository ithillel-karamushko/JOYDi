package org.hillel.it.joydi.concurrency.tasks;

import java.util.ArrayList;
import java.util.List;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.persistance.repository.TextRepository;

public class TheNewestArticles implements Runnable {
	private TextRepository textRepository;

	public TheNewestArticles(TextRepository textRepository) {
		this.textRepository = textRepository;
		Thread thread = new Thread(this);
		thread.start();
	}

	void findnewArticles() {
		List<Article> allArticles = textRepository.getArticle();
		List<Article> newArticles = new ArrayList<Article>();
		int count = allArticles.size();
		if (textRepository.getArticle().size() > 10) {
			count = 10;
		} else {
			count = textRepository.getArticle().size() - 1;
		}
		for (int i = count; i >= 0; i--) {
			newArticles.add(allArticles.get(count - i));
		}

		for (Article article : newArticles) {
			System.out.println(article.getThemeOfTheArticle());
		}

	}

	@Override
	public void run() {
		do {
			findnewArticles();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

}
