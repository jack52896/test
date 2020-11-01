package com.student.sql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import com.student.factory.MsgBox;
import com.student.factory.StringUtil;
import com.student.model.ClassMessage;
import com.student.model.Stu;
import com.student.model.StudentMessage;

public class StuSql extends BaseSql{
		public boolean delete(StudentMessage sm) {
			String SqlString  = "delete from StudentMessage where id = ?";
			try {
				PreparedStatement prst = con.prepareStatement(SqlString);
				prst.setInt(1, sm.getId());
				int rs = prst.executeUpdate();
				if(rs > 0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		public Stu StuLogin(Stu stu) {
			String sql = "select * from Stu where name = ? and passWord = ?";
			Stu stuRst = null;
			try {
				PreparedStatement prsc =con.prepareStatement(sql);
				prsc.setString(1, stu.getUserName());
				prsc.setString(2, stu.getPassWord());
				ResultSet rs = prsc.executeQuery();
				if(rs.next()) {
					stuRst = new Stu();
					stuRst.setId(rs.getInt(1));
					stuRst.setUserName(rs.getString(2));
					stuRst.setPassWord(rs.getString(3));
					stuRst.setCreateDate(rs.getString(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stuRst;
		}
		public boolean upDate(StudentMessage sm) {
			String SqlString = "update StudentMessage set className =?,sex=?,infoText=?,name=? where id = ?";
			try {
				PreparedStatement prst = con.prepareStatement(SqlString);
				prst.setString(1, sm.getClassName());
				prst.setString(2, sm.getSex());
				prst.setString(3, sm.getInfo());
				prst.setString(4, sm.getStudentName());
				prst.setInt(5, sm.getId());
				int  rs = prst.executeUpdate();
				if(rs > 0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		public String Edit(Stu stu , String PassWord) {
			String sql = "select * from stu where name = ? and passWord = ?";
			PreparedStatement prst;
			try {
				prst = con.prepareStatement(sql);
				prst.setString(1, stu.getUserName());
				prst.setString(2, stu.getPassWord());
				ResultSet rs = prst.executeQuery();
				if(!rs.next()) {
					String retString = "旧密码错误,请确认密码是否正确";
					return retString;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String retString = "密码修改失败";
			String sqlString = "update stu set passWord=? where name=? ";
			try{prst = con.prepareStatement(sqlString);
			prst.setString(1, PassWord);
			prst.setString(2, stu.getUserName());
			int rs = prst.executeUpdate();
			//影响的行数超过0行
			if(rs > 0) {
				retString  = "密码修改成功";
				return retString;
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return retString;
		}
		public Boolean AddStudent(StudentMessage studentmessage) {
			String SqlString = "insert into StudentMessage values (?,?,?,?,?,?)";
			PreparedStatement prst;
			try {
				prst = con.prepareStatement(SqlString);
				prst.setInt(1,studentmessage.getId());
				prst.setString(2, studentmessage.getStudentName());
				prst.setString(3, studentmessage.getClassName());
				prst.setString(4, studentmessage.getSex());
				prst.setString(5, studentmessage.getInfo());
				prst.setString(6, studentmessage.getTime());
				int  rs = prst.executeUpdate();
				//影响的行数>0
				if(rs > 0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		public List<StudentMessage> getStudentList(StudentMessage studentmessage){
			List<StudentMessage> reList = new ArrayList<StudentMessage>();
			StringBuffer SqlString = new StringBuffer("select * from StudentMessage ");
			if(!StringUtil.isEmpty(studentmessage.getStudentName())) {
				SqlString.append(" where name like '%"+studentmessage.getStudentName()+"%'");
				SqlString.append("and className like '%" + studentmessage.getClassName()+"%'");
			}
			
			try {
				PreparedStatement prst  = con.prepareStatement(SqlString.toString());
				ResultSet rs = prst.executeQuery();
				while(rs.next()) {
					StudentMessage sm = new StudentMessage();
					sm.setId(rs.getInt(1));
					sm.setStudentName(rs.getString(2));
					sm.setClassName(rs.getString(3));
					sm.setSex(rs.getString(4));
					sm.setInfo(rs.getString(5));
					sm.setTime(rs.getString(6));
					reList.add(sm);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return reList;
		}
}
