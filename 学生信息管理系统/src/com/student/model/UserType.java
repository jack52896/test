package com.student.model;

public enum UserType{
	ADMIN("管理员",0),TEACHER("教师",1),STUDENT("学生",2);
	private String name;
	private int index;
	private UserType(String name,int index) {
		this.name = name;
		this.index = index;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return this.index;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
