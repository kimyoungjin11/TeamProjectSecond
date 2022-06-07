package com.kosta.project.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kosta.project.member.vo.Member;
import com.kosta.project.util.DBUtil;

public class ProductDAO {
static final String SQL_SELECT_BYID = "SELECT * FROM TBL_PRODUCT";
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	
	
	private Member makeEmp(ResultSet rs) throws SQLException {
		 Member emp = new Member();
		 emp.setUserId(rs.getString("user_Id"));
		 emp.setUserName(rs.getString("user_name"));
		 emp.setUserPassword(rs.getString("user_pw"));
		 emp.setNickName(rs.getString("nickname"));
		 emp.setSignDate(rs.getDate("sign_date"));
		 emp.setPhone(rs.getString("Phone"));
		 emp.setUserRole(rs.getString("user_role"));
		 
		 return emp;
	}
}
