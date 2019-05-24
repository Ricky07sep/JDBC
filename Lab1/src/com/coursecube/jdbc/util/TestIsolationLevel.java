package com.coursecube.jdbc.util;

import java.sql.Connection;

import org.apache.log4j.Logger;

public class TestIsolationLevel {
	private static Logger logger=Logger.getLogger("");
	public static void main(String[] args) {
		
		//Logger log=Logger.getLogger("TestIsolationLevel");
		Connection mySQLConnection=JDBCUtil.getConnection();
		
		try {
			mySQLConnection.setAutoCommit(false);
			String sql="insert into student \r\n" + 
					"(student_name,student_email,student_phone,address)\r\n" + 
					"values ('Abhinav','abhi07sep@gmail.com',98989898,'Bangalore')";
			for(int i=0;i<30;i++) {
			mySQLConnection.prepareStatement(sql).executeUpdate();
			logger.info("jhghjgjhghjghjg");
			//log.info("Executing TestIsolationLevel ");
			Thread.currentThread().sleep(1000);
			}
			mySQLConnection.commit();
		}catch(Exception e) {
			logger.error("gfghjhhjhj");
		//log.severe("Error");
			e.printStackTrace();
		}
	}

}
