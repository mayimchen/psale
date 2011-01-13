package com.sheng.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.FindwuliaoDAO;

import com.sheng.po.Addwuliao;
import com.sheng.util.DaoconfigReader;

public class LookwuliaobfAction extends ActionSupport {
	/**
	 * 查看所有入库单
	 */
	private static final long serialVersionUID = 1L;
	FindwuliaoDAO fdao=null;
	private List<Addwuliao> mylist;
	private List<Integer> ls;
	private int pageSize=10;
	private int pageNo=1;
	private int sumpage;
	public int getSumpage() {
		return sumpage;
	}
	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}
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
			fdao=(FindwuliaoDAO)Class.forName(DaoconfigReader.getInstance().getDp().getFindwuliaodao()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		String forward="";
		mylist=new ArrayList<Addwuliao>();
		ls=new ArrayList<Integer>();
		ls=fdao.gettotalpage(pageSize);
		if(ls.get(1)>0){
			sumpage=ls.get(0)+1;
		}
		if(ls.get(1)==0){
			sumpage=ls.get(0);
		}
		if(pageNo>ls.get(0)&&ls.get(1)>0){
			pageNo=ls.get(0)+1;
		}
		if(pageNo>ls.get(0)&&ls.get(1)==0){
			pageNo=ls.get(0);
		}
		if(pageNo<=0){
			pageNo=1;
		}
		mylist=fdao.findaddbfbypage(pageNo, pageSize);
		if(mylist!=null&&mylist.size()!=0){
			forward="success";
		}else{
			forward="input";
		}
		return forward;
	}
	
}
