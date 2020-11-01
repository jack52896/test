package com.student.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.student.factory.MsgBox;
import com.student.factory.Util;
import com.student.model.Admin;

public class AdminSql extends BaseSql{
	public Admin adminLogin(Admin admin) {
		String sql = "select * from admin where name=? and password=?";
		Admin adminRst = null; 
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1,admin.getUserName());
			prst.setString(2,admin.getPassWord());
			ResultSet executequery = prst.executeQuery();
			if(executequery.next()) {
				adminRst = new Admin();
				adminRst.setId(executequery.getInt(1));
				adminRst.setUserName(executequery.getString(2));
				adminRst.setPassWord(executequery.getString(3));
				adminRst.setCreateDate(executequery.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminRst;
	
	}
	public String Edit(Admin adminTemp , String PassWord) {
		String sql = "select * from admin where name  = ? and passWord = ?";
		int id = 0;
		PreparedStatement prst ;
		try {
			
			prst = con.prepareStatement(sql);
			prst.setString(1, adminTemp.getUserName());
			prst.setString(2,adminTemp.getPassWord());
			ResultSet rs = prst.executeQuery();
			if(!rs.next()) {
				String retString = "旧密码错误,请确认密码是否正确";
				return retString;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Message = "密码修改失败";
        String sqlString="update admin set passWord=? where name=?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(2, adminTemp.getUserName());
			prst.setString(1,PassWord);
			int rs = prst.executeUpdate();
			//影响的行数超过0列
			if(rs > 0) {
				Message = "密码修改成功";
				return Message;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Message;
	}
}
