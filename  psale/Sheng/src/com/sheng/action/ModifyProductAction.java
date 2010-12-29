package com.sheng.action;

import java.net.URLDecoder;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.opensymphony.xwork2.ActionContext;
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
	Logger logger=Logger.getLogger(ModifyProductAction.class);
	private String pid;
	private int flag;
	private String inname;
	private int innum;
	private double inprice;
	private String inuserid;
	private String indate;
	private String detail;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
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
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Addwuliao aw=new Addwuliao();
PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
		aw.setPid(pid);
		aw.setIndate(indate);
		aw.setInname(URLDecoder.decode(URLDecoder.decode(inname, "UTF-8"), "UTF-8"));
		aw.setInnum(innum);
		aw.setInprice(inprice);
		aw.setInuserid(inuserid);
		aw.setProductsdetail(URLDecoder.decode(URLDecoder.decode(detail, "UTF-8"), "UTF-8"));
		flag=indao.updatewuliao(aw);
		if(flag==0){
			//未能成功更新
			logger.info(ActionContext.getContext().getSession().get("username")+"未能更新产品"+pid);
		}else{
			logger.info(ActionContext.getContext().getSession().get("username")+"成功更新产品"+pid);
		}
		return SUCCESS;
	}
}
