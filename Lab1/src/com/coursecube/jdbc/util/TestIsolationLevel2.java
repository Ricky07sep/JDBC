package com.coursecube.jdbc.util;

import java.sql.Connection;

public class TestIsolationLevel2 {
	
	public static void main(String[] args) {
		
		Connection mySQLConnection=JDBCCommon2.getConnection();
		try {
			String sql="insert into student \r\n" + 
					"(student_name,student_email,student_phone,address)\r\n" + 
					"values ('Abhinav','abhi07sep@gmail.com',98989898,'Bangalore')";
			//for(int i=0;i<30;i++) {
			mySQLConnection.prepareStatement(sql).executeUpdate();
			System.out.println(" Executing ...........");
			//}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
