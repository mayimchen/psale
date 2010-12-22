package com.sheng.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.ManageUserDAO;
import com.sheng.dao.ManageUserDaoImpl;
import com.sheng.po.User;

public class ManageUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ManageUserDAO mdao=new ManageUserDaoImpl();
	private List<User> ls;
	public List<User> getLs() {
		return ls;
	}
	public void setLs(List<User> ls) {
		this.ls = ls;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String forward="";
		ls=new ArrayList<User>();
		ls=mdao.getalluser();
		if(ls!=null){
			forward="success";
		}else{
			forward="input";
		}
		return forward;
	}
}
