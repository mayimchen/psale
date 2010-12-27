package com.sheng.action;

import java.net.URLDecoder;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.InsertwuliaoDAO;
import com.sheng.dao.InsertwuliaoDaoImpl;
import com.sheng.po.Addwuliao;

public class ModifyProductAction extends ActionSupport {
	/**
	 * 更新产品资料的action
	 */
	private static final long serialVersionUID = 1L;
	InsertwuliaoDAO indao=new InsertwuliaoDaoImpl();
	private int id;
	private int flag;
	private String inname;
	private String innum;
	private String inprice;
	private String inuserid;
	private String indate;
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		Addwuliao aw=new Addwuliao();
		aw.setId(id);
		aw.setIndate(indate);
		aw.setInname(URLDecoder.decode(URLDecoder.decode(inname, "UTF-8"), "UTF-8"));
		aw.setInnum(innum);
		aw.setInprice(inprice);
		aw.setInuserid(inuserid);
		//System.out.println(URLDecoder.decode(URLDecoder.decode(inname, "UTF-8"), "UTF-8"));
		//System.out.println("id:"+id+"\n"+"indate:"+indate+"\n"+"inname:"+inname+"\n"+"innum:"+innum+"\n"+inprice+"\n"+"inuserid:"+inuserid);
		flag=indao.updatewuliao(aw);
		return SUCCESS;
	}
}
