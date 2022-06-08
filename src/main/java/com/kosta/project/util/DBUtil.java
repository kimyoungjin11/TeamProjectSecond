package com.kosta.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
//	public static Connection getConnection() {
//		Context initContext;
//		Connection conn = null;
//		try {
//			initContext = new InitialContext();
//			Context envContext  = (Context)initContext.lookup("java:/comp/env");
//			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");//JNDI방식
//			conn = ds.getConnection();//Tomcat?�� connection pooling?�� ?��결한 connection?���?
//			System.out.println(conn + "����");
//		} catch (NamingException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
	
	public static Connection getConnection() {
		Connection conn = null;
		String url="jdbc:oracle:thin:@db20220602160542_high?TNS_ADMIN=C:/Users/ijbms/Desktop/secondProject/Wallet_DB20220602160542/";
		String userid="admin" , password= "KostaKosta33";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, userid, password);
			System.out.println(conn+"");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void dbClose(ResultSet rs, Statement st , Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
