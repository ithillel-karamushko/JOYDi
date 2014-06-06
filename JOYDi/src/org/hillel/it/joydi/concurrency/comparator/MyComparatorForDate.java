package org.hillel.it.joydi.concurrency.comparator;

import java.util.Comparator;
import java.util.Date;

import org.hillel.it.joydi.model.entities.Article;

public class MyComparatorForDate implements Comparator<Article> {

	@Override
	public int compare(Article arg1, Article arg2) {
		Date date1;
		Date date2;
		date1 = arg1.getDate();
		date2 = arg2.getDate();
		return date2.compareTo(date1);
	}

}
