package com.ex.mysqlTextBoard.dao;

import java.util.ArrayList;
import java.util.List;

import com.ex.mysqlTextBoard.dto.Article;

public class ArticleDAO {

	public List<Article> getArticles() {

		List<Article> articles = new ArrayList<>();

		Article article;

		// 첫번째 가짜 게시물 만들기
		article = new Article();
		article.id = 1;
		article.regDate = "2021-02-18 18:22:22";
		article.updateDate = "2021-02-18 18:22:22";
		article.title = "제목1";
		article.body = "내용1";
		article.memberId = 1;
		article.boardId = 1;

		articles.add(article);

		// 두번째 가짜 게시물 만들기
		article = new Article();
		article.id = 2;
		article.regDate = "2021-02-18 18:22:23";
		article.updateDate = "2021-02-18 18:22:23";
		article.title = "제목1";
		article.body = "내용1";
		article.memberId = 1;
		article.boardId = 1;

		articles.add(article);

		return articles;
	}

}
