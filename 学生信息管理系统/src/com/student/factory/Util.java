package com.student.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.student.model.Admin;
/*
 *�������ݿ⣬�������ݿ����
 * */
public class Util {
		//���ݿ����ӵ�ַ/
		String durURL1 = "jdbc:sqlserver://localhost:1433;DatabaseName=mytest";
		//JDBC����
		  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//�û���
		  String username = "sa";
		//����
		  String userPassword = "123456789";
		  /*
		   * ��ȡ���ݿ�����
		   * */
		  	public  Connection getCon() {
			  Connection con = null;
			  try {
				  Class.forName(driverName);
				 con =  DriverManager.getConnection(durURL1, username, userPassword);
				 System.out.println("���ݿ����ӳɹ�");
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
