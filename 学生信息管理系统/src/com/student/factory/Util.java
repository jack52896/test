package com.student.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.student.model.Admin;
/*
 *连接数据库，返回数据库对象
 * */
public class Util {
		//数据库连接地址/
		String durURL1 = "jdbc:sqlserver://localhost:1433;DatabaseName=mytest";
		//JDBC引用
		  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//用户名
		  String username = "sa";
		//密码
		  String userPassword = "123456789";
		  /*
		   * 获取数据库连接
		   * */
		  	public  Connection getCon() {
			  Connection con = null;
			  try {
				  Class.forName(driverName);
				 con =  DriverManager.getConnection(durURL1, username, userPassword);
				 System.out.println("数据库连接成功");
			  }catch(Exception e) {
				  e.printStackTrace();
			  }
			  return con;
		  }
		 	public void closeCon(Connection con)throws Exception {
		 		if(con != null) {
		 			con.close();
		 		}
		 	}
}
