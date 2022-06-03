package com.kosta.project.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

	public static Connection getConnection() {
		Context initContext;
		Connection conn = null;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");//JNDIÎ∞©Ïãù
			conn = ds.getConnection();//Tomcat?ù¥ connection pooling?óê ?ó∞Í≤∞Ìïú connection?ó¥Í∏?
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
//	public static Connection getConnection() {
//		Connection conn = null;
//		String url="jdbc:oracle:thin:@localhost:1521:XE";
//		String userid="hr" , password= "hr";
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection(url, userid, password);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
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
