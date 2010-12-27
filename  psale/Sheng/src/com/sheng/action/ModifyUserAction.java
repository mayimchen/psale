package com.sheng.action;

import java.net.URLDecoder;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.InsertUserDAO;
import com.sheng.dao.InsertUserDaoImpl;
import com.sheng.po.User;

public class ModifyUserAction extends ActionSupport {
	/**
	 * 修改用户信息
	 */
	private static final long serialVersionUID = 1L;
	InsertUserDAO indao=new InsertUserDaoImpl();
	private User u;
	private int flag;
	private String userid;
	private String username;
	private String passwd;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		u=new User();
		u.setUserid(userid);
		username=URLDecoder.decode(URLDecoder.decode(username,"UTF-8"), "UTF-8");
		u.setUsername(username);
		u.setPasswd(passwd);
		//System.out.println(userid+"\n"+username+"\n"+passwd);
		flag=indao.updateuser(u);
		return SUCCESS;
	}
	
}
