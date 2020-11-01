package com.student.sql;

import java.sql.Connection;
import java.sql.SQLException;

import com.student.factory.Util;

/*
 * 创建数据库对象
*/
public class BaseSql {
		Connection con= new Util().getCon();
		public void closeSql() {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
