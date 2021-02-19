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

	public Article getArticle(int id) {
		return articleDAO.getArticle(id);	
	}

	public int delete(int id) {
		return articleDAO.delete(id);
		
	}

	public int write(int boardId, int memberId, String title, String body) {
		return articleDAO.save(boardId, memberId, title, body);
	}

	public int modify(int id, String title, String body) {
		return articleDAO.modify(id, title, body);
	}

}
