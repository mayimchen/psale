package com.sheng.action;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	private String inname;
	private String innum;
	private String inprice;
	private String inuserid;
	private String indate;
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
		Addwuliao aw=new Addwuliao();
		indate=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		InsertwuliaoDAO dao=new InsertwuliaoDaoImpl();
		aw.setInname(inname);
		aw.setInnum(innum);
		aw.setInuserid(inuserid);
		aw.setInprice(inprice);
		aw.setIndate(indate);		
			if(inname.length()!=0&&innum.length()!=0&&inprice.length()!=0&&inuserid.length()!=0&&indate.length()!=0){
				if(checkuseid()){
					if(dao.addwuliao(aw)){
						forward="success";
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
