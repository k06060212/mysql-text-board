package com.ex.mysqlTextBoard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex.mysqlTextBoard.dto.Article;

public class ArticleDAO {

	public List<Article> getArticles() {
		Connection con = null;
		List<Article> articles = new ArrayList<>();

		try {


			String dbmsJdbcUrl = "jdbc:mysql://192.168.200.102:3306/textBoard?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull&connectTimeout=60000&socketTimeout=60000";
			String dbmsLoginId = "gokuma";
			String dbmsLoginPw = "gokuma123";

			// MySQL 드라이버 등록
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			// 연결 생성
			// finally는 무조건 실행됨
			try {
				con = DriverManager.getConnection(dbmsJdbcUrl, dbmsLoginId, dbmsLoginPw);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} finally {

			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return articles;
	}

	private List<Article> getFakeArticles() {
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
