package org.hillel.it.joydi.concurrency.tasks;

import java.util.List;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.persistance.repository.TextRepository;

public class TopArticles implements Runnable {

	private TextRepository textRepository;


	public TopArticles(TextRepository textRepository) {
		this.textRepository = textRepository;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void findTopArticles() {
		List<Article> allArticles = textRepository.getArticle();
		int count = allArticles.size() - 1;
		Article article;
		int k;
		for (int i = 0; i <= count; i++) {
			for (int j = count; j > 0; j--) {
				k = j - 1;
				if (allArticles.get(j).getRatingOfTheArticle() > allArticles
						.get(k).getRatingOfTheArticle()) {
					article = allArticles.get(j);
					allArticles.set(j, allArticles.get(k));
					allArticles.set(k, article);
				}
			}
		}
		for (Article art : allArticles) {
			System.out.println(art.getAuthorName() + " - "
					+ art.getThemeOfTheArticle() + ", "
					+ art.getRatingOfTheArticle() + " likes");
		}
	}

	@Override
	public void run() {
		do {
			findTopArticles();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}
}
