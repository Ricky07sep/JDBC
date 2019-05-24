package com.coursecube.jdbc.util;

import java.sql.*;

public class Lab2 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:8080/coursecube", "root", "Abhinav.1");
		String sql="select student_id,student_name,student_email,student_phone,address from student;";
		st=con.createStatement();
		rs=st.executeQuery(sql);
		while(rs.next()) {
			int sid=rs.getInt(1);
			String sn=rs.getString(2);
			String em=rs.getString(3);
			long ph=rs.getLong(4);
			String add=rs.getString(5);
			System.out.println(sid+"\t"+sn+"\t"+em+"\t"+ph+"\t"+add);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
				if(con!=null)
					con.close();
				if(st!=null)
					st.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
