package com.coursecube.jdbc.util;

import java.sql.*;

public class JDBCCommon2 {
	static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
		public static Connection getConnection() {
			Connection con=null;
			try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:8080/coursecube", "root", "Abhinav.1");
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		public static void clearResouces(Statement st, Connection con) {
			try {
			if(st!=null)
				st.close();
			if(con!=null)
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		public static void clearResouces(ResultSet rs,Statement st, Connection con) {
			try {
			if(rs!=null)
					rs.close();
			if(st!=null)
				st.close();
			if(con!=null)
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
}