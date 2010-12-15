package com.sheng.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.CheckuserexistDAO;
import com.sheng.dao.CheckuserexistDaoImpl;

public class CheckuserAction extends ActionSupport {

	/**
	 * ºÏ≤Èid «∑Ò¥Ê‘⁄
	 */
	private static final long serialVersionUID = 1L;
	private String userid;
	private int  showmessage;
	public int getShowmessage() {
		return showmessage;
	}
	public void setShowmessage(int showmessage) {
		this.showmessage = showmessage;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CheckuserexistDAO dao=new CheckuserexistDaoImpl();
		if(dao.checkuseridexist(userid)){
			showmessage=1;
		}
		else{
			showmessage=0;
		}
		return SUCCESS;
	}	
}
