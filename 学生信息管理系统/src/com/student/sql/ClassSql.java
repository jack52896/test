package com.student.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.factory.StringUtil;
import com.student.model.ClassMessage;

public class ClassSql extends BaseSql {
	public boolean AddClass(ClassMessage cls) {
		String sqlString = "insert into ClassMessage values (?,?,?,?) ";
		try {
			PreparedStatement prst = con.prepareStatement(sqlString);
			prst.setInt(1, cls.getId());
			prst.setString(2, cls.getName());
			prst.setString(3, cls.getInfo());
			prst.setString(4, cls.getCreateDate());
			int upDateRs = prst.executeUpdate();
			if( upDateRs > 0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean upDate(ClassMessage clm) {
		String sqlString = "update ClassMessage set name = ?,info= ? where id = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sqlString);
			prst.setString(1, clm.getName());
			prst.setString(2, clm.getInfo());
			prst.setInt(3, clm.getId());
			if(prst.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(ClassMessage clm) {
		String sqlString  = "delete  from ClassMessage where id = ? ";
		try {
			PreparedStatement prst = con.prepareStatement(sqlString);
			prst.setInt(1, clm.getId());
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
	public List<ClassMessage> getClassList(ClassMessage classmessage){
		List<ClassMessage> reList = new ArrayList<ClassMessage>();
		String sqlString = "select * from ClassMessage";
		//ÅÐ¶ÏclassmessageÖÐÊÇ·ñÎªnull
		if(!StringUtil.isEmpty(classmessage.getName())) {
			sqlString += " where name like '%"+classmessage.getName()+"%'";
		}
		try {
			PreparedStatement prst = con.prepareStatement(sqlString);
			ResultSet rs = prst.executeQuery();
			while(rs.next()) {
				ClassMessage cm = new ClassMessage();
				cm.setId(rs.getInt(1));
				cm.setName(rs.getString(2));
				cm.setInfo(rs.getString(3));
				cm.setCreateDate(rs.getString(4));
				reList.add(cm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reList;
	}
}
