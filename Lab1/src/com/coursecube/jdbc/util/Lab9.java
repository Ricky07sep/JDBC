package com.coursecube.jdbc.util;

import java.sql.*;
public class Lab9 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		con = JDBCUtil.getConnection();
		String sql = null;
//		sql = "select * from student";
//		sql = "insert into student (student_name,student_email,student_phone,address) values('Sai', 'sai@gmail.com', 65656565 , 'Patna')";
		sql = "update student set student_email='mamta@gmail.com',student_phone=95959595,address='Darbhanga' where student_id=103";
		try {
		st = con.createStatement();
		boolean b = st.execute(sql);
		System.out.println("b : "+b);
		if(b) {
			rs = st.getResultSet();
			System.out.println("RS : "+rs);
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
			int x = st.getUpdateCount();
			System.out.println("Result : "+x);
		}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResouces(rs, st, con);
		}
	}
}
