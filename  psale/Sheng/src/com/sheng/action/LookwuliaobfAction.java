package com.sheng.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.FindwuliaoDAO;
import com.sheng.dao.FindwuliaoDaoImpl;
import com.sheng.po.Addwuliao;

public class LookwuliaobfAction extends ActionSupport {

	/**
	 * 查看所有入库单
	 */
	private static final long serialVersionUID = 1L;
	FindwuliaoDAO fdao=new FindwuliaoDaoImpl();
	private List<Addwuliao> mylist;
	public List<Addwuliao> getMylist() {
		return mylist;
	}
	public void setMylist(List<Addwuliao> mylist) {
		this.mylist = mylist;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String forward="";
		mylist=new ArrayList<Addwuliao>();
		mylist=fdao.findalladdbf();
		if(mylist!=null&&mylist.size()!=0){
			forward="success";
		}else{
			forward="input";
		}
		return forward;
	}
	
}
