package com.sheng.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.ManageUserDAO;

import com.sheng.po.User;
import com.sheng.util.DaoconfigReader;

public class ManageUserAction extends ActionSupport {

	/**
	 * 查看所有系统用户
	 */
	private static final long serialVersionUID = 1L;
	ManageUserDAO mdao=null;
	private int pageSize=10;
	private int pageNo=1;
	private int sumpage;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getSumpage() {
		return sumpage;
	}
	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}
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
		try{
			mdao=(ManageUserDAO) Class.forName(DaoconfigReader.getInstance().getDp().getManageuserdao()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		String forward="";
		List<Integer> totalpage=new ArrayList<Integer>();
		totalpage=mdao.gettotalpage(pageSize);
		if(totalpage.get(1)>0){
			sumpage=totalpage.get(0)+1;
		}
		if(totalpage.get(1)==0){
			sumpage=totalpage.get(0);
		}
		if(pageNo>totalpage.get(0)&&totalpage.get(1)>0){
			pageNo=totalpage.get(0)+1;
		}
		if(pageNo>totalpage.get(0)&&totalpage.get(1)==0){
			pageNo=totalpage.get(0);
		}
		if(pageNo<=0){
			pageNo=1;
		}
		ls=new ArrayList<User>();
		ls=mdao.getalluserbypage(pageNo, pageSize);
		if(ls!=null){
			forward="success";
		}else{
			forward="input";
		}
		return forward;
	}
}
