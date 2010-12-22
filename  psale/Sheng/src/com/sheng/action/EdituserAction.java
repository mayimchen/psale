package com.sheng.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.GetuinfoDAO;
import com.sheng.dao.GetuinfoDaoImpl;
import com.sheng.po.User;

public class EdituserAction extends ActionSupport {
	/**
	 * 修改用户信息时显示用户信息的action
	 */
	private static final long serialVersionUID = 1L;
	GetuinfoDAO udao=new GetuinfoDaoImpl();
	private String userid;
	private String username;
	private String passwd;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User u=new User();
		u=udao.getuser(id);
		userid=u.getUserid();
		username=u.getUsername();
		passwd=u.getPasswd();
		return SUCCESS;
	}
	
}
