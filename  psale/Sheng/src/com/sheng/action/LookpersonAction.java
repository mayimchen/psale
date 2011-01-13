package com.sheng.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.LookpersonDAO;

import com.sheng.po.Outwuliao;
import com.sheng.util.DaoconfigReader;

public class LookpersonAction extends ActionSupport {
	/**
	 *查看用户指定日期销售汇总的业务action
	 */
	private static final long serialVersionUID = 1L;
	LookpersonDAO lp =null;
	private String userid;
	private Timestamp startdate;
	private Timestamp enddate;
	private List<Outwuliao> ls;
	private double summaori = 0.0;
	private double sumsale = 0.0;
	private int pageNo = 1;
	private int pageSize = 10;
	private int sumpage;

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

	public int getSumpage() {
		return sumpage;
	}

	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
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
		String forward = "";
		try{
			lp=(LookpersonDAO) Class.forName(DaoconfigReader.getInstance().getDp().getLookpersondao()).newInstance();
		}catch(Exception e){
			forward="input";
			e.printStackTrace();
		}
		List<Double> dls = new ArrayList<Double>();
		List<Integer> lpage = new ArrayList<Integer>();
		ls = new ArrayList<Outwuliao>();
		lpage = lp.getsumpage(userid,startdate,enddate,pageSize);
		dls = lp.getsumms(userid,startdate,enddate);
		sumsale = dls.get(0);
		summaori = dls.get(1);
		if (lpage.get(1) > 0) {
			sumpage = lpage.get(0) + 1;
		}
		if (lpage.get(1) == 0) {
			sumpage = lpage.get(0);
		}
		if (pageNo > lpage.get(0) && lpage.get(1) > 0) {
			pageNo = lpage.get(0) + 1;
		}
		if (pageNo > lpage.get(0) && lpage.get(1) == 0) {
			pageNo = lpage.get(0);
		}
		if (pageNo <= 0) {
			pageNo = 1;
		}
		ls = lp.getpersonoutbypage(userid, startdate,enddate,pageSize,pageNo);
		if (ls != null&&ls.size()!=0) {
			forward = "success";
		} else {
			forward = "nomessage";
		}
		return forward;
	}
}
