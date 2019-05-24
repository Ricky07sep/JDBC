package com.coursecube.jdbc.util;

import java.sql.Connection;
import java.sql.Statement;

public class Student {
	public static void main(String[] args) {
		try {
		Connection connection=JDBCUtil.getConnection();
		String sql="insert into student (student_name,student_email,student_phone,address) values ('Abhinav','abhi07sep@gmail.com',98989898,'Bangalore')";
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
