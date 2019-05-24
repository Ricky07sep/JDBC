package com.coursecube.jdbc.util;

import java.sql.*;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con=null;
		CallableStatement cs = null;

	 	con=JDBCUtil.getConnection();
		System.out.println("Enter a numer : ");
		int a=sc.nextInt();
		System.out.println("Enter a smaller number : ");
		int b = sc.nextInt();
		String sql="call p1(?,?,?,?)";
		try {
			cs=con.prepareCall(sql);
			cs.setInt(1, a);
			cs.setInt(2, b);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.execute();
			int sum=cs.getInt(3);
			int diff=cs.getInt(4);
			System.out.println("Sum of given number is : "+sum);
			System.out.println("Difference of given number is : "+diff);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(RuntimeException re) {
			re.printStackTrace();
		}
		finally {
			JDBCUtil.closeResouces(cs, con);
		}
	}
}
