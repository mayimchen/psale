package com.sheng.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.CheckuserexistDAO;
import com.sheng.dao.CheckuserexistDaoImpl;

public class LoginAction extends ActionSupport {

	/**
	 * µÇÂ½action
	 */
	private static final long serialVersionUID = 1L;
	CheckuserexistDAO dao=new CheckuserexistDaoImpl();
	private String userid;
	private String passwd;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String forward="";
		if(dao.getuser(userid, passwd)){
			ActionContext.getContext().getSession().put("username", userid);
			forward="success";
		}
		else{
			forward="input";
		}
		return forward;
	}
}
