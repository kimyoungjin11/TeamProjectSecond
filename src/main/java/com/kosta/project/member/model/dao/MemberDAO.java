package com.kosta.project.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kosta.project.member.vo.Member;
import com.kosta.project.util.DBUtil;

public class MemberDAO {
	static final String SQL_SELECT_BYID = "select * from tbl_user where user_id=?";
	
	Connection conn;
	Statement st;
	PreparedStatement pst; //바인딩변수를 지원한다.
	ResultSet rs;
	int result;
	
	public Member selectOneMember(String userId) {
		Member emp = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BYID);
			pst.setString(1, userId);//sql첫번쨰 ?에 를 넣는다
			rs=pst.executeQuery();
			while(rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return emp;
		}
	
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
