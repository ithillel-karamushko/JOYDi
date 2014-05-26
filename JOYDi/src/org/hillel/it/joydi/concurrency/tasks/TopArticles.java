package org.hillel.it.joydi.concurrency.tasks;

import java.util.Collections;
import java.util.List;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.persistance.repository.TextRepository;

public class TopArticles implements Runnable {

	private TextRepository textRepository;

	public TopArticles(TextRepository textRepository) {
		this.textRepository = textRepository;
		Thread thread = new Thread(this, "TopArticles");
		thread.start();
	}

	public void findTopArticles() {
		List<Article> allArticles = textRepository.getArticle();
		List<Article> result;
		Collections.sort(allArticles, new MyComparatorForRaiting());
		if (allArticles.size()>10){
			result = allArticles.subList(0, 10);
		} else {
			result = allArticles;
		}

		for (Article art : result) {
			System.out.println(art.getAuthor().getName() + " - "
					+ art.getThemeOfTheArticle() + ", "
					+ art.getRatingOfTheArticle() + " likes");
		}System.out.println("_____________________");

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
