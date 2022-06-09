package com.kosta.project.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.kosta.project.member.vo.Member;
import com.kosta.project.util.DBUtil;

public class MypageDAO {
static final String SQL_SELECT_BYID = "select * from tbl_user where user_id=?";
	
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
	private Member makeEmp(ResultSet rs) throws SQLException {
		 Member emp = new Member();
		 emp.setUserId(rs.getString("user_Id"));
		 emp.setUserPassword(rs.getString("user_pw"));
		 emp.setPhone(rs.getString("Phone"));
		 return emp;
}
	//회원정보 수정 (마이페이지)
		public int memberupdate(Member dto) {
			int cnt = 0;
					
			String sql = "update tbl_user set user_pw=?, phone=? where user_id=?";
			
			conn = DBUtil.getConnection();
			
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, dto.getUserPassword());
				pst.setString(2, dto.getPhone());
				pst.setString(3, dto.getUserId());
				
				cnt = pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("memberUpdate() Exception");
			} finally {
				DBUtil.dbClose(rs, pst, conn);
			}
			
			return cnt;
		}
		
		//회원정보 삭제 (마이페이지)
		public int memberDelete(Member dto) {
			
			conn = DBUtil.getConnection();
			String sql = "DELETE FROM tbl_user WHERE user_id = ?";
			int succ = 0;
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, dto.getUserId());
				
				succ = pst.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("memberDelete() Exception");
			} finally {
				DBUtil.dbClose(rs, pst, conn);
			}
			return succ;
		}
		public int memberDelete(String id, String pw) {
			// TODO Auto-generated method stub
			return 0;
		}

		
	}
