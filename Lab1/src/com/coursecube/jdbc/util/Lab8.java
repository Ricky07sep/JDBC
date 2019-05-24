package com.coursecube.jdbc.util;

import java.sql.*;
import java.util.Scanner;

public class Lab8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = JDBCUtil.getConnection();
		System.out.println("Enter value for sid : ");
		int sid = sc.nextInt();
		String sql = "select * from student where student_id=?";
		try {
		ps=con.prepareStatement(sql);
		ps.setInt(1, sid);
		rs = ps.executeQuery();
		if(rs.next()) {
			int id=rs.getInt(1);
			String nm = rs.getString(2);
			String em = rs.getString(3);
			int ph = rs.getInt(4);
			String add = rs.getString(5);
			System.out.println(id+"\t"+nm+"\t"+em+"\t"+ph+"\t"+add);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResouces(rs, ps, con);
		}
	}
}
