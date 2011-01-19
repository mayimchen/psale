package com.sheng.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.CheckuserexistDAO;
import com.sheng.util.DaoconfigReader;


public class LoginAction extends ActionSupport {
	/**
	 * 登陆action
	 */
	private static final long serialVersionUID = 1L;
	CheckuserexistDAO dao=null;
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
		List<Integer> ls=new ArrayList<Integer>();
		int i=0;//用户权限
		int j=0;//员工状态
		try{
			dao=(CheckuserexistDAO) Class.forName(DaoconfigReader.getInstance().getDp().getCheckuserexistdao()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		String forward="";
		ls=dao.getmanageexiststate(userid);
		i=ls.get(0);
		j=ls.get(1);
		Map<String,Object> session=ActionContext.getContext().getSession();
		if(dao.getuser(userid, passwd)){
			session.put("username", userid);
			session.put("management",i);
			session.put("existstate",j);
			String time=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
			PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
			logger.info(userid+"在"+time+"登陆");
			forward="success";
		}
		else{
			forward="input";
		}
		return forward;
	}
}
