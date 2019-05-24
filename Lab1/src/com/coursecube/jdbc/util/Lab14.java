package com.coursecube.jdbc.util;

import java.sql.*;
import java.util.*;
public class Lab14 {
	static char ch;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement ps=null;
		con=JDBCUtil.getConnection();
		String sql="insert into students(student_name,marks1,marks2,marks3) values(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);		
		do {
			System.out.println("Enter value for Student name : ");
			String sn = sc.nextLine();
			System.out.println("Enter value for marks1 : ");
			int m1 = sc.nextInt();	sc.nextLine();
			System.out.println("Enter value for marks2 : ");
			int m2 = sc.nextInt();	sc.nextLine();
			System.out.println("Enter value for marks3 : ");
			int m3 = sc.nextInt();	sc.nextLine();
			ps.setString(1, sn);
			ps.setInt(2, m1);
			ps.setInt(3, m2);
			ps.setInt(4, m3);
			ps.addBatch();
			System.out.println("Do you want to add more (y/n) : ");
			ch=sc.nextLine().charAt(0);
		}while(ch == 'Y' || ch == 'y');
		int res[]=ps.executeBatch();
		for(int i=0;i<res.length;i++) {
			System.out.println("Res : "+res[i]);
		}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResouces(ps, con);
		}
	}

}
