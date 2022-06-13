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
	
	static final String ReplyGet= "select * from reply";
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;

  
  
	//선녀 - 상품 전체 목록
	public ArrayList<Reply> getReplyList(int board_ID){

		ArrayList<Reply> replyList = new ArrayList<Reply>();
		Connection connection = null;
		pst = null;
		rs = null;
		try {
			connection = DBUtil.getConnection();
			pst.setInt(1, board_ID);
			pst = connection.prepareStatement(ReplyGet);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int replyId = rs.getInt("reply_ID");
				Date replyDate = rs.getDate("reply_DATE");
				int productId = rs.getInt("product_ID");
				String userId = rs.getString("user_ID");
				
				Reply reply = new Reply();
				reply.setUser_ID(rs.getString(userId));
				reply.setProduct_ID(productId);
				reply.setReply_DATE(replyDate);
				reply.setReply_ID(replyId);
				replyList.add(reply);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(conn != null) conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return replyList;
	}
}
