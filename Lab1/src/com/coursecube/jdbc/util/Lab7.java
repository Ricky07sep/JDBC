package com.coursecube.jdbc.util;

import java.sql.*;
import java.util.*;

public class Lab7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		con = JDBCUtil.getConnection();
		System.out.println("Enter value for sid : ");
		int sid =sc.nextInt();
		sc.nextLine();
		System.out.println("Enter value for sname : ");
		String sname = sc.nextLine();
		System.out.println("Enter value for email : ");
		String em = sc.nextLine();
		System.out.println("Enter value for phone : ");
		int ph = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter value for address : ");
		String add = sc.nextLine();
		String sql = "insert into student (student_id,student_name,student_email,student_phone,address) values(?,?,?,?,?)";
		try {
		ps=con.prepareStatement(sql);
		ps.setInt(1, sid);
		ps.setString(2, sname);
		ps.setString(3, em);
		ps.setInt(4, ph);
		ps.setString(5, add);
		int x = ps.executeUpdate();
		if(x==1) {
			System.out.println("Query executed successfully");
		}else {
			System.out.println("Query not executed");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResouces(ps, con);
		}
	}

}
