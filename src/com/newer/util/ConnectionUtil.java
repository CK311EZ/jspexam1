package com.newer.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionUtil {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	
	static {
		try {
			Properties props=new Properties();
			
			InputStream is=ConnectionUtil.class.getClassLoader().getResourceAsStream("com/newer/util/mysql.properties");
			
			props.load(is);
			
			driver=props.getProperty("driver");
			url=props.getProperty("url");
			user=props.getProperty("user");
			password=props.getProperty("password");
			
			//加载并注册驱动类
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取连接对象的方法
	 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/*
	 * 关闭数据库对象的方法
	 */
	public static void closeAll(Connection conn,Statement st,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {
//		Connection conn=getConnection();
//		
//		try {
//			System.out.println(conn.isClosed());
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//	}

}
