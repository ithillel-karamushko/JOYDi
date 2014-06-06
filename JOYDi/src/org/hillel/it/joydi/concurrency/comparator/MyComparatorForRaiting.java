package org.hillel.it.joydi.concurrency.comparator;

import java.util.Comparator;

import org.hillel.it.joydi.model.entities.Article;

public class MyComparatorForRaiting implements Comparator<Article> {

	@Override
	public int compare(Article arg1, Article arg2) {
		Integer like1;
		Integer like2;
		like1 = arg1.getRatingOfTheArticle();
		like2 = arg2.getRatingOfTheArticle();
		return like2.compareTo(like1);
	}

}
