package com.ex.mysqlTextBoard;

import java.util.Scanner;

import com.ex.mysqlTextBoard.controller.ArticleController;
import com.ex.mysqlTextBoard.controller.MemberController;
import com.ex.mysqlutil.mysqlutil.MysqlUtil;

public class App {
	public void run() {
		Scanner sc = Container.scanner;
		
		ArticleController articleController = new ArticleController();
		MemberController memberController = new MemberController();

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine();
			
			//DB
			MysqlUtil.setDBInfo("192.168.200.102", "gokuma", "gokuma123", "textBoard");
			
			boolean needToExit = false;
			
			if(cmd.startsWith("article")) {
				articleController.doCommand(cmd);
				
			}else if(cmd.startsWith("member")) {
				memberController.doCommand(cmd);
				
			}else if(cmd.equals("system exit")) {
				System.out.println("==시스템 종료==");
				needToExit = true;
			}
			
			MysqlUtil.closeConnection();
			
			if( needToExit) {
				break;
			}
		}
	}
}