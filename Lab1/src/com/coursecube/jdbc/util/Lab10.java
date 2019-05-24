package com.coursecube.jdbc.util;

import java.sql.*;
public class Lab10 {
	public static final String sql = "select * from student";
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = JDBCUtil.getConnection();
		String sql = null;
//		sql = "update student set student_name='kumkum',student_email='kumkum@gmail.com',student_phone=32323232,address='Daheri' where student_id=102";
		
//		sql = "insert into student (student_id,student_name,student_email,student_phone,address) values(107,'Sai', 'sai@gmail.com', 15151515 , 'Bangalore')";
		try {
		ps =con.prepareStatement(sql);
		boolean b1 = ps.execute();
		if(b1) {
			rs=ps.getResultSet();
			if(rs.next()) {
				do {
					int sid = rs.getInt(1);
					String nm = rs.getString(2);
					String em = rs.getString(3);
					int ph = rs.getInt(4);
					String add = rs.getString(5);
					System.out.println(sid+"\t"+nm+"\t"+em+"\t"+ph+"\t"+add);
				}while(rs.next());
			}
		}
		else {
			int x = ps.getUpdateCount();
			System.out.println("Result : "+x);
		}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResouces(rs, ps, con);
		}
	}
}
