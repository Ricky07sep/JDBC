package com.coursecube.jdbc.util;

import java.sql.*;

public class Lab3 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
		con=JDBCUtil.getConnection();
		String sql="insert into student (student_name,student_email,student_phone,address) values('Abhi','abhi@gmail.com',90402099,'Ranchi')";
		st=con.createStatement();
		int x=st.executeUpdate(sql);
		if(x==1)
			System.out.println("Record inserted");
		else
			System.out.println("Recorted is not inserted");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResouces(st, con);
		}
	}
}
