package com.sheng.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.DelwuliaoDAO;
import com.sheng.dao.DelwuliaoDaoImpl;
import com.sheng.po.Outwuliao;

public class GetdelreportAction extends ActionSupport {

	/**
	 * 导出所有出库单
	 */
	private static final long serialVersionUID = 1L;
	DelwuliaoDAO ddao=new DelwuliaoDaoImpl();
	private List<Outwuliao> ls;
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
					forward="success";
				}
			else{
				forward="input";
			}
		return forward;
	}
}
