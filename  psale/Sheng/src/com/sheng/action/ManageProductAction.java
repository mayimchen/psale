package com.sheng.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.FindwuliaoDAO;
import com.sheng.dao.FindwuliaoDaoImpl;
import com.sheng.po.Addwuliao;

public class ManageProductAction extends ActionSupport {
	
	/**
	 * 管理产品时显示所有产品的action
	 */
	private static final long serialVersionUID = 1L;
	FindwuliaoDAO fdao=new  FindwuliaoDaoImpl();
	private List<Addwuliao> ls;

	public List<Addwuliao> getLs() {
		return ls;
	}

	public void setLs(List<Addwuliao> ls) {
		this.ls = ls;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String forward="";
		ls=new ArrayList<Addwuliao>();
		ls=fdao.findalladd();
		if(ls!=null){
			forward="success";
		}else{
			forward="input";
		}
		return forward;
	}
}
