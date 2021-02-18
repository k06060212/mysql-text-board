package com.ex.mysqlTextBoard.controller;

import java.util.List;

import com.ex.mysqlTextBoard.dto.Article;
import com.ex.mysqlTextBoard.service.ArticleService;

public class ArticleController {
	private ArticleService articleService;
	
	public ArticleController() {
		articleService = new ArticleService();
	}
	
	public void doCommand(String cmd) {
		if(cmd.startsWith("article list")) {
			showList(cmd);
		}else if(cmd.startsWith("article detail")) {
			showDetail(cmd);	
		}
	}

	public void showList(String cmd) {
		System.out.println("==게시물 리스트==");
		
		List<Article> articles = articleService.getArticles();
			articleService = new ArticleService();
			
		System.out.println("번호 / 작성 / 수정 / 작성자 / 제목");
		
		for (Article article : articles) {
			System.out.printf("%d / %s / %s / %s / %s\n", article.id, article.regDate, article.updateDate, article.memberId, article.title);
		}
			
		System.out.println(articles);
	}

	private void showDetail(String cmd) {
		System.out.println("==게시물 상세페이지==");
		
		int inputedId = Integer.parseInt(cmd.split(" ")[2]);
		
		Article article = articleService.getArticle(inputedId);
		
		if(article == null) {
			System.out.println("존재하지 않는 게시물 입니다.");
			return;
		}
		
		System.out.printf("번호 : %d\n", article.id);
		System.out.printf("작성날짜 : %s\n", article.regDate);
		System.out.printf("수정날짜 : %s\n", article.updateDate);
		System.out.printf("작성자 : %s\n", article.memberId);
		System.out.printf("제목 : %s\n", article.title);
		System.out.printf("내용 : %s\n", article.body);
	}

}
