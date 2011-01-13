package com.sheng.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.DelwuliaoDAO;

import com.sheng.po.Outwuliao;
import com.sheng.util.DaoconfigReader;

public class LookoutAction extends ActionSupport {

	/**
	 * 查看所有的销售单子
	 */
	private static final long serialVersionUID = 1L;
	DelwuliaoDAO ddao=null;
	private List<Outwuliao> ls;
	private List<Double> dls;
	private double summaori=0.0;//总毛利
	private double sumsale=0.0;//总销售额
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
	public double getSummaori() {
		return summaori;
	}
	public void setSummaori(double summaori) {
		this.summaori = summaori;
	}
	public double getSumsale() {
		return sumsale;
	}
	public void setSumsale(double sumsale) {
		this.sumsale = sumsale;
	}
	public List<Outwuliao> getLs() {
		return ls;
	}
	public void setLs(List<Outwuliao> ls) {
		this.ls = ls;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			ddao=(DelwuliaoDAO) Class.forName(DaoconfigReader.getInstance().getDp().getDelwuliaodao()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		ls=new ArrayList<Outwuliao>();
		dls=new ArrayList<Double>();
		dls=ddao.getsumsm();
		sumsale=dls.get(0);
		summaori=dls.get(1);
		List<Integer> totalpage=new ArrayList<Integer>();
		totalpage=ddao.gettotalpage(pageSize);
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
		ls=ddao.findalloutbypage(pageSize, pageNo);
		String forward="";
			if(ls!=null&&ls.size()!=0){
					forward="success";
				}
			else{
				forward="input";
			}
		return forward;
	}
}
