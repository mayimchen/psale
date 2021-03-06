package com.sheng.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.FindwuliaoDAO;
import com.sheng.po.Addwuliao;
import com.sheng.util.DaoconfigReader;

public class GetrukubfreportAction extends ActionSupport {

	/**
	 * 导出所有入库单为pdf
	 */
	private static final long serialVersionUID = 1L;
	FindwuliaoDAO fdao=null;
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
		try{
			fdao=(FindwuliaoDAO) Class.forName(DaoconfigReader.getInstance().getDp().getFindwuliaodao()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
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
