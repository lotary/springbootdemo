package hello.article.service;

import java.util.List;

import hello.article.beans.Article;

public interface IArticleService {
	List<Article> getAllArticles();

	Article getArticleById(long articleId);

	boolean addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(int articleId);
}
