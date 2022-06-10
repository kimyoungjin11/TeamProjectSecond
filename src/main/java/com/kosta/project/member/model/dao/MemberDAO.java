package com.kosta.project.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kosta.project.member.vo.Member;
import com.kosta.project.util.DBUtil;

public class MemberDAO {
	static final String SQL_SELECT_BYID = "select * from tbl_user where user_id = ?";
	static final String SQL_INSERT_MEMBER = "insert into tbl_user values(?,?,?,?,sysdate,?,'user')";
	static final String SQL_SELECT_NICK = "select * from tbl_user where nickname='?'";
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;

	
	public Member selectByNick(String nickName) {
		Member member = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_NICK);
			pst.setString(1, nickName);
			rs = pst.executeQuery();
			while (rs.next()) {
				member = makeEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return member;

	};

	public Member selectOneMember(String userId) {
		Member member = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BYID);
			System.out.println("selectOneMember:" + userId);
			pst.setString(1, userId);
			rs = pst.executeQuery();
			while (rs.next()) {
				member = makeEmp(rs);
				System.out.println("멤버:" + member);
				System.out.println("깃허브테스트");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return member;
	}

	public int insertMember(Member member) {
		int result = 0;

		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_INSERT_MEMBER);
			pst.setString(1, member.getUserId());
			pst.setString(2, member.getUserName());
			pst.setString(3, member.getUserPassword());
			pst.setString(4, member.getNickName());
			pst.setString(5, member.getPhone());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}

		return result;
	}

	private Member makeEmp(ResultSet rs) throws SQLException {
		System.out.println("emp왔습니다..");
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
