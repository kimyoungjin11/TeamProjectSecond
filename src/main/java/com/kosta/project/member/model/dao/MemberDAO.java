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
	static final String SQL_INSERT_MEMBER = "insert into tbl_user values(?,?,?,?,?,?,?)";
	
	Connection conn;
	Statement st;
	PreparedStatement pst; 
	ResultSet rs;
	int result;
	
	public Member selectOneMember(String userId) {
		Member emp = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BYID);
			pst.setString(1, userId);
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
	
	public int insertMember(Member member) {
		int result =0;
		
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_INSERT_MEMBER);
			pst.setString(1, member.getUserId());
			pst.setString(2, member.getUserName());
			pst.setString(3, member.getUserPassword());
			pst.setString(4, member.getNickName());
			pst.setDate(5, member.getSignDate());
			pst.setString(6, member.getPhone());
			pst.setString(7, member.getUserRole());
			
			result = pst.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, pst, conn);
		}

		return result;
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
