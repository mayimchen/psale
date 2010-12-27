package com.sheng.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.FindwuliaoDAO;
import com.sheng.dao.FindwuliaoDaoImpl;
import com.sheng.po.Addwuliao;

public class EditproductAction extends ActionSupport {
	/**
	 * 修改产品信息的action
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int flag;
	private String inname;
	private String innum;
	private String inprice;
	private String inuserid;
	private String indate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getInname() {
		return inname;
	}

	public void setInname(String inname) {
		this.inname = inname;
	}

	public String getInnum() {
		return innum;
	}

	public void setInnum(String innum) {
		this.innum = innum;
	}

	public String getInprice() {
		return inprice;
	}

	public void setInprice(String inprice) {
		this.inprice = inprice;
	}

	public String getInuserid() {
		return inuserid;
	}

	public void setInuserid(String inuserid) {
		this.inuserid = inuserid;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		FindwuliaoDAO fdao = new FindwuliaoDaoImpl();
		Addwuliao aw = new Addwuliao();
		aw = fdao.getwuliaobyid(flag);
		id = aw.getId();
		inname = aw.getInname();
		innum = aw.getInnum();
		inprice = aw.getInprice();
		inuserid = aw.getInuserid();
		indate = aw.getIndate();
		//System.out.println("id:"+id+"\n"+"inname:"+inname+"\n"+"innum:"+innum+"\n"+"inprice:"+inprice+"\n"+"inuserid:"+inuserid+"\n"+"indate:"+indate);
		return SUCCESS;
	}
}
