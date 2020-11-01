package com.student.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.student.model.Teacher;
import com.student.model.TeacherMessage;

public class TeacherSql extends BaseSql{
		public Teacher teacherLogin(Teacher teacher) { 
			String sql = "select * from teacher where name = ? and passWord = ?";
			Teacher teacherRst = null;
			try {
				PreparedStatement prsc = con.prepareStatement(sql);
				prsc.setString(1, teacher.getUserName());
				prsc.setString(2, teacher.getPassWord());
				ResultSet  rs = prsc.executeQuery();
				if(rs.next()) {
					teacherRst = new Teacher();
					teacherRst.setId(rs.getInt(1));
					teacherRst.setUserName(rs.getString(2));
					teacherRst.setPassWord(rs.getString(3));
					teacherRst.setCreateDate(rs.getString(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return teacherRst;
		}
		public String Edit(Teacher teacher,String passWord) {
			String sql = "select * from teacher where name = ? and passWord = ?";
			PreparedStatement prst;
			try {
				prst = con.prepareStatement(sql);
				prst.setString(1, teacher.getUserName());
				prst.setString(2, teacher.getPassWord());
				ResultSet rs  = prst.executeQuery();
				if(!rs.next()) {
					String retString  = "¾ÉÃÜÂë´íÎó,ÇëÈ·ÈÏÃÜÂëÊÇ·ñÕýÈ·";
					return retString;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String retString = "ÃÜÂëÐÞ¸ÄÊ§°Ü";
			String sqlString = "update teacher set passWord=? where name=? ";
			try {
				prst = con.prepareStatement(sqlString);
				prst.setString(1, passWord);
				prst.setString(2, teacher.getUserName());
				int rs = prst.executeUpdate();
				if(rs > 0 ) {
					retString= "ÃÜÂëÐÞ¸Ä³É¹¦";
					return retString;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return retString;
		}
		@SuppressWarnings("null")
		public boolean addTeacher(TeacherMessage tm) {
			String sqlString = "insert into TeacherMessage values(?,?,?,?,?)";
			PreparedStatement prst = null;
			try {
				prst = con.prepareStatement(sqlString);
				prst.setInt(1, tm.getId());
				prst.setString(2, tm.getName());
				prst.setString(3, tm.getForm());
				prst.setString(4, tm.getAge());
				prst.setString(5, tm.getArea());
				int rs = prst.executeUpdate();
				if( rs>0) {
					return true;
					}else {
						return false;
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		public List<TeacherMessage> getTeacherList(TeacherMessage teachermessage){
			List<TeacherMessage> reList = new ArrayList<TeacherMessage>();
			String sqlString = "select * from TeacherMessage";
			PreparedStatement prst;
			try {
				prst = con.prepareStatement(sqlString);
				ResultSet rs = prst.executeQuery();
				while(rs.next()) {
					TeacherMessage tm = new TeacherMessage();
					tm.setId(rs.getInt(1));
					tm.setName(rs.getString(2));
					tm.setForm(rs.getString(3));
					tm.setAge(rs.getString(4));
					tm.setArea(rs.getString(5));
					reList.add(tm);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return reList;
		}
}
