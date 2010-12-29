package com.sheng.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.DelwuliaoDAO;
import com.sheng.dao.DelwuliaoDaoImpl;
import com.sheng.po.Outwuliao;

public class LookoutAction extends ActionSupport {

	/**
	 * 查看所有的销售单子
	 */
	private static final long serialVersionUID = 1L;
	DelwuliaoDAO ddao=new DelwuliaoDaoImpl();
	private List<Outwuliao> ls;
	private double summaori=0.0;//总毛利
	private double sumsale=0.0;//总销售额
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
		ls=new ArrayList<Outwuliao>();
		ls=ddao.findallout();
		String forward="";
			if(ls!=null){
				for(int i=0;i<ls.size();i++){
					summaori+=ls.get(i).getMaori();
					sumsale+=ls.get(i).getOutprice();
				}
					forward="success";
				}
			else{
				forward="input";
			}
		return forward;
	}
}
