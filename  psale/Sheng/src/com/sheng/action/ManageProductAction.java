package com.sheng.action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.FindwuliaoDAO;
import com.sheng.po.Addwuliao;
import com.sheng.util.DaoconfigReader;

public class ManageProductAction extends ActionSupport {
	
	/**
	 * 管理产品时显示所有产品的action
	 */
	private static final long serialVersionUID = 1L;
	FindwuliaoDAO fdao=null;
	private List<Addwuliao> ls;
	private int pageNo=1;
	private int pageSize=10;
	private int sumpage;
	public int getSumpage() {
		return sumpage;
	}
	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Addwuliao> getLs() {
		return ls;
	}

	public void setLs(List<Addwuliao> ls) {
		this.ls = ls;
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
		List<Integer> list=new ArrayList<Integer>();
		list=fdao.getaddpage(pageSize);
		ls=new ArrayList<Addwuliao>();
		if(list.get(1)>0){
			sumpage=list.get(0)+1;
		}
		if(list.get(1)==0){
			sumpage=list.get(0);
		}
		if(pageNo>list.get(0)&&list.get(1)>0){
			pageNo=list.get(0)+1;
		}
		if(pageNo>list.get(0)&&list.get(1)==0){
			pageNo=list.get(0);
		}
		if(pageNo<=0){
			pageNo=1;
		}
		ls=fdao.getaddbypage(pageNo, pageSize);
		if(ls!=null&&ls.size()!=0){
			forward="success";
		}else{
			forward="input";
		}
		return forward;
	}
}
