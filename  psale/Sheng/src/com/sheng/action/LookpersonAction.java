package com.sheng.action;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.LookpersonDAO;
import com.sheng.dao.LookpersonDaoImpl;
import com.sheng.po.Outwuliao;

public class LookpersonAction extends ActionSupport {
	/**
	 *查看用户指定日期销售汇总的业务action
	 */
	private static final long serialVersionUID = 1L;
	LookpersonDAO lp=new LookpersonDaoImpl();
	private String userid;
	private Timestamp startdate;
	private Timestamp enddate;
	private List<Outwuliao> ls;
	public List<Outwuliao> getLs() {
		return ls;
	}
	public void setLs(List<Outwuliao> ls) {
		this.ls = ls;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public Timestamp getStartdate() {
		return startdate;
	}
	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}
	public Timestamp getEnddate() {
		return enddate;
	}
	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String forward="";
		ls=new ArrayList<Outwuliao>();
		ls=lp.getpersonout(userid, startdate, enddate);
			if(ls!=null){
				forward="success";
			}
			else{
				forward="nomessage";
			}
		return forward;
	}
}
