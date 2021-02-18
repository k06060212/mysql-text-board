package com.ex.mysqlTextBoard;

import java.util.Scanner;

import com.ex.mysqlTextBoard.controller.ArticleController;

public class App {

	public void run() {
		Scanner sc = Container.scanner;
		
		ArticleController articleController = new ArticleController();
		
		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine();
			
			if(cmd.startsWith("article")) {
				articleController.doCommand(cmd);
				
			}else if(cmd.equals("system exit")) {
				System.out.println("==시스템 종료==");
				break;
			}
		}
		
	}

}
