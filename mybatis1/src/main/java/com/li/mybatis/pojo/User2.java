package com.li.mybatis.pojo;

import com.li.mybatis.utils.Test_DateExchange;

public class User2 {
	private String id ;
	private String username;
	private String birthday;
	private int sex;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int i) {
		this.sex = i;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User2() {
		super();
	}
	public User2(String id, String username, String birthday, int sex, String address) {
		super();
		this.id = id;
		this.username = username;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", sex=" + new Test_DateExchange().getSexFormat(sex) + ", address=" + address
				+ "]";
	}
	
}
