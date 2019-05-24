package com.coursecube.jdbc.util;

import java.sql.*;
import java.util.*;

import com.mysql.cj.jdbc.JdbcConnection;
public class Lab13 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		con=JDBCUtil.getConnection();
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter value for Student id : ");
//		int sid = sc.nextInt();	sc.nextLine();
//		System.out.println("Enter value for Student name : ");
//		String sn = sc.nextLine();
//		System.out.println("Enter value for marks1 : ");
//		int m1 = sc.nextInt();
//		System.out.println("Enter value for marks2 : ");
//		int m2 = sc.nextInt();
//		System.out.println("Enter value for marks3 : ");
//		int m3 = sc.nextInt();
		String sql1="insert into students(student_name,marks1,marks2,marks3) values('Prakash',95,74,92)";
		String sql2="insert into students(student_name,marks1,marks2,marks3) values('Priyanka',98,94,97)";
		String sql3="insert into students(student_name,marks1,marks2,marks3) values('Sita',72,65,92)";
		String sql4="insert into students(student_name,marks1,marks2,marks3) values('Sushmita',95,99,84)";
		String sql5="update students set student_name='Abhinav' where student_id=98";
		String sql6="delete from students where student_id=100";
		try {
		st=con.createStatement();
		st.addBatch(sql1);
		st.addBatch(sql2);
		st.addBatch(sql3);
		st.addBatch(sql4);
		st.addBatch(sql5);
		st.addBatch(sql6);
		int x[]=st.executeBatch();
//		for(int i = 0;i<x.length;i++) {
//			System.out.println(x[i]);
//		}
		for(int y:x)
			System.out.println(y);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResouces(st, con);
		}
		}
}
