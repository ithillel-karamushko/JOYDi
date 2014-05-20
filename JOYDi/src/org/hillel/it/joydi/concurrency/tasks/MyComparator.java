package org.hillel.it.joydi.concurrency.tasks;

import java.util.Comparator;

import org.hillel.it.joydi.model.entities.Article;

public class MyComparator implements Comparator<Article> {

	@Override
	public int compare(Article arg1, Article arg2) {
		Integer like1;
		Integer like2;
		like1 = arg1.getLike();
		like2 = arg2.getLike();
		return like2.compareTo(like1);
	}

}
