package com.sheng.action;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

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
	private static Logger logger=Logger.getLogger(LoginAction.class);
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
			String time=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
			PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
			logger.info(userid+"ÔÚ"+time+"µÇÂ½");
			forward="success";
		}
		else{
			forward="input";
		}
		return forward;
	}
}
