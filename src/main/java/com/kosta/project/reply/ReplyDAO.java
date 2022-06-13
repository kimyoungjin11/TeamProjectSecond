package com.kosta.project.reply;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kosta.project.product.Product;
import com.kosta.project.util.DBUtil;

public class ReplyDAO {
	
	static final String ReplyGet = "SELECT * FROM TBL_REPLY WHERE PRODUCT_ID = ?";

	static final String ReplyWrite = "INSERT INTO"
			+ "TBL_REPLY VALUES (sysdate, ?, '?', '?')";

	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;

	public ArrayList<Reply> getReplyList(int board_ID) {

		ArrayList<Reply> replyList = new ArrayList<Reply>();
		Connection connection = null;
		pst = null;
		rs = null;
		try {
			connection = DBUtil.getConnection();
			pst = connection.prepareStatement(ReplyGet);
			pst.setInt(1, board_ID);
			rs = pst.executeQuery();

			while (rs.next()) {
				int replyId = rs.getInt("reply_ID");
				Date replyDate = rs.getDate("reply_DATE");
				int productId = rs.getInt("product_ID");
				String userId = rs.getString("user_ID");
				String content = rs.getString("reply_CONTENT");

				Reply reply = new Reply();
				reply.setUser_ID(userId);
				reply.setProduct_ID(productId);
				reply.setReply_DATE(replyDate);
				reply.setReply_ID(replyId);
				reply.setReply_CONTENT(content);
				System.out.println(reply.toString());
				replyList.add(reply);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return replyList;
	}

	public Reply writeReply(int boardId) {
		static final String ReplyWrite = "INSERT INTO"
				+ "TBL_REPLY VALUES (sysdate, ?, '?', '?')";

		Reply reply = null;
		Connection connection = null;
		pst = null;
		rs = null;
		try {
			connection = DBUtil.getConnection();
			pst = connection.prepareStatement(ReplyWrite);
			pst.setInt(1, boardId);
			pst.set
			rs = pst.executeQuery();
			
			int replyId = rs.getInt("reply_ID");
			Date replyDate = rs.getDate("reply_DATE");
			int productId = rs.getInt("product_ID");
			String userId = rs.getString("user_ID");
			String content = rs.getString("reply_CONTENT");

			reply = new Reply();
			reply.setUser_ID(userId);
			reply.setProduct_ID(productId);
			reply.setReply_DATE(replyDate);
			reply.setReply_ID(replyId);
			reply.setReply_CONTENT(content);
			System.out.println(reply.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return reply;
	}
}
