package com.sheng.po;

public class User {
	private String userid;
	private String username;
	private String passwd;
	private int existstate;
	private int management;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getExiststate() {
		return existstate;
	}
	public void setExiststate(int existstate) {
		this.existstate = existstate;
	}
	public int getManagement() {
		return management;
	}
	public void setManagement(int management) {
		this.management = management;
	}
	
}
