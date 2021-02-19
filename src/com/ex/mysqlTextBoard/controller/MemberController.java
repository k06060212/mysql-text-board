package com.ex.mysqlTextBoard.controller;

import java.io.PrintStream;
import java.util.Scanner;

import com.ex.mysqlTextBoard.Container;
import com.ex.mysqlTextBoard.service.MemberService;

public class MemberController {

	private MemberService memberService ;
	
	public MemberController() {
		memberService = new MemberService();
	}

	public void doCommand(String cmd) {
		if (cmd.startsWith("member join")) {
			doJoin(cmd);
		}
//			else if (cmd.startsWith("article detail")) {
//				showDetail(cmd); // 보여주는 것은 show로
//			} else if (cmd.startsWith("article modify")) {
//				doModify(cmd); // 보여주는 것은 show로
//			} else if (cmd.startsWith("article delete")) {
//				doDelete(cmd); // 처리하는 것은 do로 하는 것이 관례
//			} else if (cmd.startsWith("article write")) {
//				doWrite(cmd);
	}

	private void doJoin(String cmd) {
		System.out.println("==회원가입==");

		Scanner sc = Container.scanner;

		System.out.printf("로그인아이디 : ");
		String loginId = sc.nextLine().trim();
		
		if (loginId.length() == 0) {
			System.out.println("로그인 아이디를 입력해주세요.");
			return;
		}

		System.out.printf("로그인비밀번호 :");
		String loginPw = sc.nextLine().trim();

		if (loginPw.length() == 0) {
			System.out.println("로그인 비밀번호를 입력해주세요.");
			return;
		}
		
		System.out.printf("로그인비밀번호확인 :");
		String loginPwConfirm = sc.nextLine().trim();

		if (loginPw.length() == 0) {
			System.out.println("로그인 비밀번호 확인을 입력해주세요.");
			return;
		}
		
		if (loginPw.equals(loginPwConfirm) == false) {
			System.out.println("로그인 비밀번호가 일치하지 않습니다.");
			return;
		}
		
		System.out.printf("이름 :");
		String name = sc.nextLine().trim();

		if (loginPw.length() == 0) {
			System.out.println("이름을 입력해주세요.");
			return;
		}
		
		int memberId = 1; // 임시 1
		int boardId = 1; // 임시 1

		int id = memberService.join(loginId, loginPw, name);

		System.out.printf("%d번 회원이 생성되었습니다.\n", id);

		
	}

}

