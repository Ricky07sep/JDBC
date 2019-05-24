package com.coursecube.jdbc.util;

import java.sql.*;
import java.util.Formatter;
import java.util.Scanner;
public class Lab6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value ");
		String s_id = sc.nextLine();
		int sid = Integer.parseInt(s_id);
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		con = JDBCUtil.getConnection();
//		String sql = "select * from student where student_id="+sid+"";
//		String sql = String.format("select * from student where student_id=%d", +sid);
		Formatter fmt = new Formatter();
		String sql = fmt.format("select * from student where student_id=%d", +sid).toString();
		
		System.out.println(sql);
		try {
			st=con.createStatement();
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
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
			JDBCUtil.closeResouces(rs, st, con);
		}
	}
}