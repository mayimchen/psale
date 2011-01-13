package com.sheng.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.FindwuliaoDAO;

import com.sheng.po.Addwuliao;
import com.sheng.util.DaoconfigReader;

public class GetreportAction extends ActionSupport {

	/**
	 * 生成报表所需的action
	 */
	private static final long serialVersionUID = 1L;
	
	FindwuliaoDAO findwuliao=null;
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
		try{
			findwuliao=(FindwuliaoDAO) Class.forName(DaoconfigReader.getInstance().getDp().getFindwuliaodao()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		String forward="";
		wuliaolist=new ArrayList<Addwuliao>();
		wuliaolist=findwuliao.findalladd();
		if(wuliaolist!=null){
			forward="success";
		}else{
			forward="input";
		}
		return forward;
	}
}
