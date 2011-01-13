package com.sheng.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.CheckuserexistDAO;

import com.sheng.util.DaoconfigReader;

public class CheckuserAction extends ActionSupport {

	/**
	 * ºÏ≤Èid «∑Ò¥Ê‘⁄
	 */
	private static final long serialVersionUID = 1L;
	CheckuserexistDAO dao=null;
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
		try{
		dao=(CheckuserexistDAO) Class.forName(DaoconfigReader.getInstance().getDp().getCheckuserexistdao()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(dao.checkuseridexist(userid)){
			showmessage=1;
		}
		else{
			showmessage=0;
		}
		return SUCCESS;
	}	
}
