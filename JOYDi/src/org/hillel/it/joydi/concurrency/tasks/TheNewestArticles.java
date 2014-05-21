package org.hillel.it.joydi.concurrency.tasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
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

	public void newArticles() {
		List<Article> allArticles = textRepository.getArticle();
		List<Article> result;
		Collections.sort(allArticles, new MyComparatorForDate());
		if (allArticles.size() > 10) {
			result = allArticles.subList(0, 10);
		} else {
			result = allArticles;
		}

		for (Article a : result) {
			System.out.println(a.getAuthor().getName() + " - "
					+ a.getThemeOfTheArticle()+ " - "
					+ a.getDate());
		}
		System.out.println(" _ _ _ _   _ _ _ _ _ _ _   _ _ _ _ _ _ ");

	}

	@Override
	public void run() {
		do {
			newArticles();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

}
