package com.student.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.student.model.Admin;
import com.student.model.Stu;
import com.student.model.Teacher;
import com.student.model.UserType;

public class TimeSql extends BaseSql {
		public boolean register(UserType userType , Object userObject) {
			String SqlString = "insert into register values(?,?,?) ";
			PreparedStatement prst;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				prst = con.prepareStatement(SqlString);
				if("管理员".equals(userType.getName())) {
					Admin admin = (Admin) userObject;
					prst.setString(1, admin.getUserName());
					prst.setString(2, userType.getName());
					prst.setString(3, sdf.format(new Date()));
					int rs = prst.executeUpdate();
					if(rs > 0 ) {
						return true;
					}
				}
				if("学生".equals(userType.getName())) {
					Stu stu = (Stu) userObject;
					prst.setString(1, stu.getUserName());
					prst.setString(2, userType.getName());
					prst.setString(3, sdf.format(new Date()));
					int rst = prst.executeUpdate();
					if(rst > 0) {
						return true;
					}
				}
				if("教师".equals(userType.getName())) {
					Teacher tea = (Teacher)userObject; 
					prst.setString(1, tea.getUserName());
					prst.setString(2, userType.getName());
					prst.setString(3, sdf.format(new Date()));
					int rstd = prst.executeUpdate();
					if(rstd > 0) 
						return true;
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
}
