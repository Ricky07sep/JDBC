package com.coursecube.jdbc.util;

import java.sql.*;

public class Lab1 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:8080/coursecube", "root", "Abhinav.1");
		String sql="insert into student (student_name,student_email,student_phone,address) values('Ricky','ricky@gmail.com',73680981,'Bhubaneswar')";
		st=con.createStatement();
		int x=st.executeUpdate(sql);
		if(x==1)
			System.out.println("Record inserted");
		else
			System.out.println("Recorted is not inserted");
		
		}catch(Exception e) {
			System.out.println();
			e.printStackTrace();
		}
		finally {
			try {
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
