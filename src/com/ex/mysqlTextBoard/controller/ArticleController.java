package com.ex.mysqlTextBoard.controller;

import java.util.List;

import com.ex.mysqlTextBoard.dto.Article;
import com.ex.mysqlTextBoard.service.ArticleService;

public class ArticleController {
	private ArticleService articleService;
	
	public ArticleController() {
		articleService = new ArticleService();
	}

	public void showList() {
		System.out.println("==게시물 리스트==");
		
		List<Article> articles = articleService.getArticles();
			articleService = new ArticleService();
			
		System.out.println(articles);
	}

}
