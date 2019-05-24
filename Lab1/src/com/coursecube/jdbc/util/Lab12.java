package com.coursecube.jdbc.util;

import java.sql.*;
import java.util.*;
public class Lab12 {
	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cs=null;
		con=JDBCUtil.getConnection();
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter value for Student id : ");
		int sid=sc.nextInt();
		String sql="call updateStudentsData(?,?,?,?)";
		try {
			con.setAutoCommit(false);
			cs=con.prepareCall(sql);
			cs.setInt(1, sid);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.FLOAT);
			cs.registerOutParameter(4, Types.CHAR);
			cs.execute();
		con.commit();
			System.out.println("Procedure executed successfully.");
			int total=cs.getInt("total");
			float avrg=cs.getFloat(3);
			String grade=cs.getString(4);
			System.out.println("Total : "+total+"\tAverage : "+avrg+"\tGrade : "+grade);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResouces(cs, con);
		}
	}
}
