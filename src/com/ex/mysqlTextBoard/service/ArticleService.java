package com.ex.mysqlTextBoard.service;

import java.util.List;

import com.ex.mysqlTextBoard.dao.ArticleDAO;
import com.ex.mysqlTextBoard.dto.Article;

public class ArticleService {
	private ArticleDAO articleDAO;
	
	public ArticleService() {
		articleDAO = new ArticleDAO();
	}

	public List<Article> getArticles() {
		return articleDAO.getArticles();
	}

}
