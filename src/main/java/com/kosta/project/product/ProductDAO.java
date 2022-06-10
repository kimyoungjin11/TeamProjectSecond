package com.kosta.project.product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.kosta.project.member.vo.Member;
import com.kosta.project.product.vo.CategoryVO;
import com.kosta.project.util.DBUtil;

public class ProductDAO {
//static final String SQL_SELECT_ALL = "SELECT * FROM TBL_PRODUCT";
static final String SQL_INSERT_PRODUCT = "INSERT INTO tbl_product (USER_ID, CATEGORY_ID, PRODUCT_ID, TITLE, CONTENT,\r\n"
		+ "PRICE, REG_DATE, PRODUCT_STATUS, JOIN_NUMBER)\r\n"
		+ "VALUES (?, ?, PRODUCT_SEQ.nextval, ?, ?, ?, SYSDATE, '모집중', ?)";

static final String SQL_CATEGORY_NAME = "SELECT * FROM TBL_CATEGORY ORDER BY 1";
static final String SQL_MAX_Product_ID = "select max(PRODUCT_ID) from tbl_product";
static final String SQL_INSERT_PRODUCT_Images = "insert into tbl_product_images values(img_seq.nextval, ?, ?)";

static final String SQL_SELECT_PRODUCT = "SELECT * FROM TBL_PRODUCT tp WHERE tp.PRODUCT_ID = ?";

  
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;

  
  
	//선녀 - 상품 전체 목록
	public ArrayList<Product> selectAllProduct(String category_id, String keyword, String sort){

		ArrayList<Product> productList = new ArrayList<Product>();
		Connection connection = null;
		pst = null;
		rs = null;
		try {
			connection = DBUtil.getConnection();
			if(category_id.equals("전체")) category_id = "%";
			String query = "select * from tbl_product where CATEGORY_ID like '" 
			              + category_id + "' and content like '%" + keyword + "%' order by reg_date  " + sort;
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int productId = rs.getInt("product_Id");
				String productTitle = rs.getString("title");
				String productContent = rs.getString("content");
				int viewCount = rs.getInt("view_Count");
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
				product.setproductContent(productContent);
				product.setViewCount(viewCount);
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



	//솔 - INSERT PRODUCT
		
		public int productInsert (Product product) {
			int result = 0;
			
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(SQL_INSERT_PRODUCT);
				pst.setString(1, product.getUserId()); //현재 세션에서 user id 가져오기
				pst.setInt(2, product.getCategory());
				pst.setString(3, product.getproductTitle());
				pst.setString(4, product.getproductContent());
				pst.setInt(5, product.getPrice());
				pst.setInt(6, product.getJoinNumber());
		
				result = pst.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbClose(rs, pst, conn);
			}

			return result;
		}
	

	//솔 - SELECT ALL CATEGORY NAME
		public List<CategoryVO> selectCategoryName() {
			List<CategoryVO> clist = new ArrayList<>();
			conn = DBUtil.getConnection();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(SQL_CATEGORY_NAME);
				while (rs.next()) {
					CategoryVO category = new CategoryVO(rs.getInt(1), rs.getString(2));
					clist.add(category);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbClose(rs, st, conn);
			}
			return clist;
	}
				
		
	//솔 - GET MAX PRODUCT ID	
		
		public int maxProductNO() {
			int product_id = 0;
			String query = SQL_MAX_Product_ID;
			conn = DBUtil.getConnection();
			 
			try {
				pst = conn.prepareStatement(query);
				rs = pst.executeQuery();
				while(rs.next()) {
					product_id = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return product_id;
		}
		
		
	//솔 - INSERT PRODUCT IMAGES	
	
		public int insertProductImages(int pid , List<String> imageList) {
			System.out.println(imageList);
			int result = 0;
			String query = SQL_INSERT_PRODUCT_Images;
			
			try {
				
				conn = DBUtil.getConnection();
				conn.setAutoCommit(false); //리스트가 올라갈 때까지 자동커밋 막아놓기
				pst = conn.prepareStatement(query);
				for(String fname :imageList) {
					pst.setString(1, fname);
					pst.setInt(2, pid);
					
					pst.addBatch();
					pst.clearParameters();
				}
				
				pst.executeBatch();
				conn.commit();
				pst.clearBatch();
				
				System.out.println("성공");
				
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					conn.rollback();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			} finally {
				DBUtil.dbClose(rs, pst, conn);
			}
			return result;
		}
		
		
	//승민	
  
		public Product selectProductById(int product_id){
			Product viewProduct = new Product();
			Connection connection = null;
			pst = null;
			rs = null;
			try {
				connection = DBUtil.getConnection();
				String query = SQL_SELECT_PRODUCT;
				pst = connection.prepareStatement(query);
				pst.setInt(1, product_id);
				rs = pst.executeQuery();
				
				rs.next();
					int productId = rs.getInt("product_Id");
					String productTitle = rs.getString("title");
					String productContent = rs.getString("content");
					int viewCount = rs.getInt("view_Count");
					int wishCount = rs.getInt("wish_Count");
					int price = rs.getInt("price");
					Date reg_date = rs.getDate("reg_date");
					String productStatus = rs.getString("product_Status");
					int joinNumber = rs.getInt("join_Number");
					String userId = rs.getString("user_Id");
					int category = rs.getInt("category_id");
					
					viewProduct.setproductId(productId);
					viewProduct.setproductTitle(productTitle);
					viewProduct.setproductContent(productContent);
					viewProduct.setViewCount(viewCount);
					viewProduct.setWishCount(wishCount);
					viewProduct.setPrice(price);
					viewProduct.setReg_date(reg_date);
					viewProduct.setproductStatus(productStatus);
					viewProduct.setJoinNumber(joinNumber);
					viewProduct.setUserId(userId);
					viewProduct.setCategory(category);
					System.out.println(viewProduct.toString());
				
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
			return viewProduct;
		}
}