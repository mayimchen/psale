package com.sheng.action;


import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.FindwuliaoDAO;
import com.sheng.dao.FindwuliaoDaoImpl;
import com.sheng.po.Addwuliao;


public class LookkucunAction extends ActionSupport {

	/**
	 * 查看所有库存
	 */
	private static final long serialVersionUID = 1L;
	FindwuliaoDAO findwuliao=new FindwuliaoDaoImpl();
	private List<Addwuliao> wuliaolist;

	public List<Addwuliao> getWuliaolist() {
		return wuliaolist;
	}

	public void setWuliaolist(List<Addwuliao> wuliaolist) {
		this.wuliaolist = wuliaolist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String forward="";
		wuliaolist=new ArrayList<Addwuliao>();
		wuliaolist=findwuliao.findalladd();
		if(wuliaolist!=null&&wuliaolist.size()!=0){
			forward="success";
		}else{
			forward="input";
		}
		return forward;
	}
}
