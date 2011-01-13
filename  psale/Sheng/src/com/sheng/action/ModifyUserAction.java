package com.sheng.action;

import java.net.URLDecoder;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.InsertUserDAO;
import com.sheng.po.User;
import com.sheng.util.DaoconfigReader;

public class ModifyUserAction extends ActionSupport {
	/**
	 * 修改用户信息
	 */
	private static final long serialVersionUID = 1L;
	InsertUserDAO indao=null;
	Logger logger=Logger.getLogger(ModifyUserAction.class);
	private User u;
	private int flag;
	private String userid;
	private String username;
	private String passwd;
	private int management;
	private int existstate;
	public int getManagement() {
		return management;
	}
	public void setManagement(int management) {
		this.management = management;
	}
	public int getExiststate() {
		return existstate;
	}
	public void setExiststate(int existstate) {
		this.existstate = existstate;
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
		try{
			indao=(InsertUserDAO) Class.forName(DaoconfigReader.getInstance().getDp().getInsertuserdao()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		u=new User();
PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
		u.setUserid(userid);
		username=URLDecoder.decode(URLDecoder.decode(username,"UTF-8"), "UTF-8");
		u.setUsername(username);
		u.setPasswd(passwd);
		u.setExiststate(existstate);
		u.setManagement(management);
		flag=indao.updateuser(u);
		if(flag==0){
			//更新失败
			logger.info(ActionContext.getContext().getSession().get("username")+"未能更新用户"+userid);
		}else{
			logger.info(ActionContext.getContext().getSession().get("username")+"成功更新用户"+userid);
		}
		return SUCCESS;
	}
	
}
