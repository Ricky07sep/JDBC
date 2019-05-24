package com.coursecube.jdbc.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Lab11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con=null;
		CallableStatement cs=null;
		con=JDBCUtil.getConnection();
		System.out.println("Enter value for student id : ");	//96,97,98,99
		int sid=sc.nextInt();
		String sql = "call p3(?)";
		try {
			cs=con.prepareCall(sql);
			cs.setInt(1, sid);
			cs.execute();
			System.out.println("Procedure executed successfully.");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResouces(cs, con);
		}
	}
}
