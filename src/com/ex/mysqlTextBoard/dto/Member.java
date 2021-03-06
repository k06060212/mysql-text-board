package com.ex.mysqlTextBoard.dto;

public class Member {
	public int id;
	public String regDate;
	public String updateDate;
	public String loginId;
	public String loginPw;
	public String name;

//	public Member(int id, String regDate, String updateDate, String loginId, String loginPw, String name) {
//		this.id = id;
//		this.regDate = regDate;
//		this.updateDate = updateDate;
//		this.loginId = loginId;
//		this.loginPw = loginPw;
//		this.name = name;
//	}

	public Member(java.util.Map<String, Object> map) {
		this.id = (int) map.get("id");
		this.regDate = (String) map.get("regDate");
		this.updateDate = (String) map.get("updateDate");
		this.loginId = (String) map.get("loginId");
		this.loginPw = (String) map.get("loginPw");
		this.name = (String) map.get("name");
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", regDate=" + regDate + ", updateDate=" + updateDate + ", loginId=" + loginId
				+ ", loginPw=" + loginPw + ", name=" + name + "]";
	}

}
