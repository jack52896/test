package com.student.model;

public enum UserType{
	ADMIN("����Ա",0),TEACHER("��ʦ",1),STUDENT("ѧ��",2);
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
