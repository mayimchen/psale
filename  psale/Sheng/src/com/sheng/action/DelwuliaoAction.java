package com.sheng.action;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.CheckuserexistDAO;
import com.sheng.dao.CheckuserexistDaoImpl;
import com.sheng.dao.DelwuliaoDAO;
import com.sheng.dao.DelwuliaoDaoImpl;
import com.sheng.po.Outwuliao;


public class DelwuliaoAction extends ActionSupport {

	/**
	 * 出库action，出库单子
	 */
	CheckuserexistDAO cdao = new CheckuserexistDaoImpl();
	DelwuliaoDAO ddao = new DelwuliaoDaoImpl();
	private static final long serialVersionUID = 1L;
	private String outname;
	private String outnum;
	private String outprice;
	private String outuserid;
	private String outdate;
	private int a;// 库存量

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getOutuserid() {
		return outuserid;
	}

	public void setOutuserid(String outuserid) {
		this.outuserid = outuserid;
	}

	public String getOutname() {
		return outname;
	}

	public void setOutname(String outname) {
		this.outname = outname;
	}

	public String getOutnum() {
		return outnum;
	}

	public void setOutnum(String outnum) {
		this.outnum = outnum;
	}

	public String getOutprice() {
		return outprice;
	}

	public void setOutprice(String outprice) {
		this.outprice = outprice;
	}

	public String getOutdate() {
		return outdate;
	}

	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// 数据库表还未加，等待加号就ok了，主要往数据表里添加条记录
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		outdate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
				.format(new Date());
		Outwuliao ow = new Outwuliao();
		ow.setOutdate(outdate);
		ow.setOutname(outname);
		ow.setOutnum(outnum);
		ow.setOutprice(outprice);
		ow.setOutuserid(outuserid);
		String forward = "";
		boolean s = outname.length() != 0 && outnum.length() != 0
				&& outprice.length() != 0 && outuserid.length() != 0
				&& outdate.length() != 0;
		if (s && checkname() && checknum()) {
			// 先往出库单里写一条记录
			if (ddao.savedel(ow)) {
				forward = "success";
			} else {
				forward = "input";
			}
			// 再从入库单里更新一下数据
			int i = a - Integer.parseInt(outnum);
			if (i == 0) {
				if (ddao.delwuliao(outname)) {
					forward = "success";
				} else {
					forward = "input";
				}
			} else {
				String num = String.valueOf(i);
				if (ddao.updatenum(num, outname)) {
					forward = "success";
				} else {
					forward = "input";
				}
			}
		} else {
			forward = "input";
		}
		return forward;
	}

	/*
	 * 检查是否存在这样的产品名 *
	 */
	public boolean checkname() {
		boolean flag = false;
		if (ddao.checkwuliaonameexist(outname)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	/*
	 * 检查已存在的产品名的数量和输入的数量值之间是否符合逻辑 *
	 */
	public boolean checknum() {
		boolean flag = false;
		boolean g = checkname();
		boolean h = checkuserid();
		if (g && h) {
			a = ddao.getnum(outname);// 数据库里的库存量
			if (a < Integer.parseInt(outnum)) {
				flag = false;
			} else {
				flag = true;
			}
		}
		return flag;
	}

	/*
	 * 检查userid是否存在,存在标志为true,不存在标志为false; *
	 */
	public boolean checkuserid() {
		boolean flag = false;
		if (cdao.checkuseridexist(getOutuserid())) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
}
