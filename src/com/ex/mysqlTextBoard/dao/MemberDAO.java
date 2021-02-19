package com.ex.mysqlTextBoard.dao;

import com.ex.mysqlutil.mysqlutil.MysqlUtil;
import com.ex.mysqlutil.mysqlutil.SecSql;

public class MemberDAO {

	public int add(String loginId, String loginPw, String name) {
		SecSql sql = new SecSql();

		sql.append("INSERT INTO `member`");
		sql.append(" SET regDate = NOW()");
		sql.append(", updateDate = NOW()");
		sql.append(", loginId = ?", loginId);
		sql.append(", loginPw = ?", loginPw);
		sql.append(", name = ?", name);		
		
		return MysqlUtil.insert(sql);
	}

}
