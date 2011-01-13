package com.sheng.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.FindwuliaoDAO;
import com.sheng.po.Addwuliao;
import com.sheng.util.DaoconfigReader;

public class EditproductAction extends ActionSupport {
	/**
	 * 修改产品信息的action
	 */
	private static final long serialVersionUID = 1L;
	FindwuliaoDAO fdao = null;
	private String id;
	private String flag;
	private String inname;
	private int innum;
	private double inprice;
	private String inuserid;
	private String indate;
	private String detail;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getInname() {
		return inname;
	}

	public void setInname(String inname) {
		this.inname = inname;
	}

	public int getInnum() {
		return innum;
	}

	public void setInnum(int innum) {
		this.innum = innum;
	}

	public double getInprice() {
		return inprice;
	}

	public void setInprice(double inprice) {
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			fdao=(FindwuliaoDAO) Class.forName(DaoconfigReader.getInstance().getDp().getFindwuliaodao()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		Addwuliao aw = new Addwuliao();
		aw = fdao.getwuliaobyid(flag);
		id = aw.getPid();
		inname = aw.getInname();
		innum = aw.getInnum();
		inprice = aw.getInprice();
		inuserid = aw.getInuserid();
		indate = aw.getIndate();
		detail=aw.getProductsdetail();
		return SUCCESS;
	}
}
