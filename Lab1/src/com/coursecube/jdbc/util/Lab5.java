package com.coursecube.jdbc.util;

import java.sql.*;
import java.util.Formatter;
import java.util.Scanner;

public class Lab5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		Connection con = null;
		Statement st = null;
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
		
		String sql = String.format("insert into student values (%d,'%s','%s',%d,'%s')",sid,sname,em,ph,add);
		
//		String sql = "insert into student (student_id,student_name,student_email,student_phone,address) values("+sid+",'"+sname+"','"+em+"',"+ph+",'"+add+"')";
		
//		String sql="delete from student where student_id>105";
		
//		Formatter fmt = new Formatter();
//		String sql=fmt.format("insert into student (student_id,student_name,student_email,student_phone,address) values(%d,'%s','%s',%d,'%s')",sid,sname,em,ph,add).toString();
		
		System.out.println(sql);
		
		try {
			st = con.createStatement();
			int x = st.executeUpdate(sql);
			if(x==1) 
				System.out.println("Query executed sucessfully");
			else
				System.out.println("Query is not executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResouces(st, con);
		}
	}

}