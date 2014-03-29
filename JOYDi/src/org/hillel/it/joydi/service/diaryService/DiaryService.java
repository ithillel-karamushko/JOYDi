package org.hillel.it.joydi.service.diaryService;

import java.util.HashSet;
import java.util.Set;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.search.ArticleCriteria;

public interface DiaryService {

	void saveArticle(Article article);

	void deleteArticle(Article article);

	Set findArticles(ArticleCriteria criteria);
}