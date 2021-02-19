package com.ex.mysqlTextBoard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.mysqlTextBoard.dto.Article;
import com.ex.mysqlutil.mysqlutil.MysqlUtil;
import com.ex.mysqlutil.mysqlutil.SecSql;

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

			String sql = "SELECT * FROM article ORDER BY id DESC";

			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
//				System.out.println(rs.getObject("id"));
//				int id = (int)(long)rs.getObject("id");
					int id = rs.getInt("id");
					String regDate = rs.getString("regDate");
					String updateDate = rs.getString("updateDate");
					String title = rs.getString("title");
					String body = rs.getString("body");
					int memberId = rs.getInt("memberId");
					int boardId = rs.getInt("boardId");

					Article article = new Article(id, regDate, updateDate, title, body, memberId, boardId);

//				System.out.println(id);
//				System.out.println(article);
					articles.add(article);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
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

//	private List<Article> getFakeArticles() {
//		List<Article> articles = new ArrayList<>();
//		
//		Article article;
//		
//		// 첫번째 가짜 게시물 만들기
////		article = new Article();
////		article.id = 1;
////		article.regDate = "2021-02-18 18:22:22";
////		article.updateDate = "2021-02-18 18:22:22";
////		article.title = "제목1";
////		article.body = "내용1";
////		article.memberId = 1;
////		article.boardId = 1;
//		article = new Article(1, "2021-02-18 18:22:22", "2021-02-18 18:22:22","제목1", "내용1",1,1);
//		articles.add(article);
//
//		// 두번째 가짜 게시물 만들기
////		article = new Article();
////		article.id = 2;
////		article.regDate = "2021-02-18 18:22:23";
////		article.updateDate = "2021-02-18 18:22:23";
////		article.title = "제목1";
////		article.body = "내용1";
////		article.memberId = 1;
////		article.boardId = 1;
//
//		article = new Article(2,"2021-02-18 18:22:23", "2021-02-18 18:22:23","제목2", "내용2",1,1);		
//		articles.add(article);
//		return articles;
//	}

	public Article getArticle(int id) {
		Article article = null;
		Connection con = null;

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

			String sql = "SELECT * FROM article WHERE id = ?";

			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
//				System.out.println(rs.getObject("id"));
//				int id = (int)(long)rs.getObject("id");
					int articleId = rs.getInt("id");
					String regDate = rs.getString("regDate");
					String updateDate = rs.getString("updateDate");
					String title = rs.getString("title");
					String body = rs.getString("body");
					int memberId = rs.getInt("memberId");
					int boardId = rs.getInt("boardId");

					article = new Article(id, regDate, updateDate, title, body, memberId, boardId);
				}

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

		return article;
	}

	public int delete(int id) {
		int affectedRows = 0;
		Connection con = null;

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

			String sql = "DELETE FROM article WHERE id = ?";

			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				affectedRows = pstmt.executeUpdate();


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
		
		return affectedRows;
	}

	public int save(int boardId, int memberId, String title, String body) {
		int id = 0;
		Connection con = null;

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

			String sql = "INSERT INTO article";
			sql += " SET regDate = NOW()";
			sql += ", updateDate = NOW()";
			sql += ", boardId = ?";
			sql += ", memberId = ?";
			sql += ", title = ?";
			sql += ", body = ?";

			try {
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, boardId);
				pstmt.setInt(2, memberId);
				pstmt.setString(3, title);
				pstmt.setString(4, body);
				pstmt.executeUpdate();

				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);
				
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
		
		return id;
	}

	public int modify(int id, String title, String body) {
		SecSql sql = new SecSql();
		
		sql.append("UPDATE article");
		sql.append(" SET updateDate = NOW()");
		sql.append(", title = ?", title);
		sql.append(", body = ?", body);
		sql.append("Where id = ?", id);
		
		return MysqlUtil.update(sql);
	}

}
