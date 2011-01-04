package com.sheng.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sheng.dao.CheckuserexistDAO;
import com.sheng.dao.CheckuserexistDaoImpl;
import com.sheng.dao.InsertwuliaoDAO;
import com.sheng.dao.InsertwuliaoDaoImpl;
import com.sheng.po.Addwuliao;

public class AddwuliaoAction extends ActionSupport {
	/**
	 * 添加物料action
	 */
	private static final long serialVersionUID = 1L;
	Addwuliao aw=new Addwuliao();
	Logger logger=Logger.getLogger(AddwuliaoAction.class);
	private String pid;
	private String inname;
	private int innum;
	private double inprice;
	private String inuserid;
	private String indate;
	private String detail;
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	/*
	 * 添加物料
	 * **/
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String forward="";
		indate=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
		InsertwuliaoDAO dao=new InsertwuliaoDaoImpl();
		aw.setPid(pid);
		aw.setProductsdetail(detail);
		aw.setInname(inname);
		aw.setInnum(innum);
		aw.setInuserid(inuserid);
		aw.setInprice(inprice);
		aw.setIndate(indate);		
			if(inname.length()!=0&&inuserid.length()!=0&&indate.length()!=0){
				if(checkuseid()){
					if(dao.addwuliao(aw)){
						forward="success";
logger.info(ActionContext.getContext().getSession().get("username")+"在"+new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())+"添加了物料"+pid);
					}	
					else{
						forward="input";
					}
				}
				else{
					forward="input";
				}
			}
			else{
				forward="input";
			}
		return forward;
	}
/*
 * 检查指定的用户ID是否存在
 * **/
public boolean checkuseid() throws ClassNotFoundException{
		boolean flag = false;
		CheckuserexistDAO cedao=new CheckuserexistDaoImpl();
		if(cedao.checkuseridexist(getInuserid())){
			flag = true;//-----------存在就返回true
		}else{
			flag =false;
		}
		return flag;
	}
}
