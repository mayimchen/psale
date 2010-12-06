package com.sheng.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.util.Jdbcutil;

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
	//可以考虑下继续重构
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String forward="";
		indate=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=jdbc.getConnection();
		try{
			if(inname.length()!=0&&innum.length()!=0&&inprice.length()!=0&&inuserid.length()!=0&&indate.length()!=0){
				if(checkuseid()){
					conn.createStatement().execute("insert addwuliao(inname,innum,inprice,inuserid,indate)values('"+inname+"','"+innum+"','"+inprice+"','"+inuserid+"','"+indate+"')");
					forward="success";
					jdbc.close(conn);
				}
				else{
					forward="input";
					jdbc.close(conn);
				}
			}else{
				forward="input";
				jdbc.close(conn);
			}	
		}catch(Exception e){
			forward="input";
			e.printStackTrace();
			jdbc.close(conn);
		}	
		return forward;
	}
public boolean checkuseid() throws ClassNotFoundException{
		boolean flag = false;
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=jdbc.getConnection();
		try{
		ResultSet rs=conn.createStatement().executeQuery("select * from user where userid="+inuserid);
		if(rs!=null){
			if(rs.next()){
				flag=true;
				jdbc.close(conn);
			}
			else{
				flag=false;
				jdbc.close(conn);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
			jdbc.close(conn);
		}
		return flag;
	}

}
