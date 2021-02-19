package com.ex.mysqlTextBoard.service;

import com.ex.mysqlTextBoard.dao.MemberDAO;

public class MemberService {
	
	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}

	public int join(String loginId, String loginPw, String name) {
		return memberDAO.add(loginId, loginPw, name);
	}

}
