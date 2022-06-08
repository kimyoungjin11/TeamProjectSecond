package com.kosta.project.product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.kosta.project.member.vo.Member;
import com.kosta.project.util.DBUtil;

public class ProductDAO {
static final String SQL_SELECT_BYID = "SELECT * FROM TBL_PRODUCT";
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
 
	public ProductDAO() {
		 
	}
	
	public ArrayList<Product> selectAllProduct(){
		ArrayList<Product> productList = new ArrayList<Product>();
		Connection connection = null;
		pst = null;
		rs = null;
		try {
			connection = DBUtil.getConnection();
			String query = SQL_SELECT_BYID;
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int productId = rs.getInt("product_Id");
				String productTitle = rs.getString("Title");
				String productContext = rs.getString("Context");
				int wishCount = rs.getInt("wish_Count");
				int price = rs.getInt("price");
				Date reg_date = rs.getDate("reg_date");
				String productStatus = rs.getString("product_Status");
				int joinNumber = rs.getInt("join_Number");
				String userId = rs.getString("user_Id");
				int category = rs.getInt("category_id");
				
				Product product = new Product();
				product.setproductId(productId);
				product.setproductTitle(productTitle);
				product.setproductContext(productContext);
				product.setWishCount(wishCount);
				product.setPrice(price);
				product.setReg_date(reg_date);
				product.setproductStatus(productStatus);
				product.setJoinNumber(joinNumber);
				product.setUserId(userId);
				product.setCategory(category);
				System.out.println(product.toString());
				productList.add(product);
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
		return productList;
	}




}
