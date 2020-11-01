package com.student.model;

public class ClassMessage {
			private int id;
			private String name;
			private String Info;
			private String createDate;
			public int getId() {
				return id;
			}
			public String getCreateDate() {
				return createDate;
			}
			public void setCreateDate(String createDate) {
				this.createDate = createDate;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return this.name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getInfo() {
				return this.Info;
			}
			public void setInfo(String info) {
				this.Info = info;
			}
			@Override
			public String toString() {
				return this.name;
			}
}
