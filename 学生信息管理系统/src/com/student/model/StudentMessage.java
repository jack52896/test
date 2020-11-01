package com.student.model;

public class StudentMessage {
		private int id;
		private String StudentName;
		private String ClassName;
		private String sex;
		private String Info;
		private String time;
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getInfo() {
			return Info;
		}
		public void setInfo(String info) {
			Info = info;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getStudentName() {
			return StudentName;
		}
		public void setStudentName(String studentName) {
			StudentName = studentName;
		}
		public String getClassName() {
			return ClassName;
		}
		public void setClassName(String className) {
			ClassName = className;
		}	
		@Override
		public String toString () {
			return this.ClassName;
		}
}
