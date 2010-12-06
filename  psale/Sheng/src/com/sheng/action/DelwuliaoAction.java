package com.sheng.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.util.Jdbcutil;

public class DelwuliaoAction extends ActionSupport {

	/**
	 * 出库action，出库单子
	 */
	private static final long serialVersionUID = 1L;
	private String outname;
	private String outnum;
	private String outprice;
	private String outuserid;
	private String outdate;
	private int a;//库存量
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
//数据库表还未加，等待加号就ok了，主要往数据表里添加条记录
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		outdate=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		String forward="";
		boolean s=outname.length()!=0&&outnum.length()!=0&&outprice.length()!=0&&outuserid.length()!=0&&outdate.length()!=0;
		if(s&&checkname()&&checknum()){
			Jdbcutil jdbc=new Jdbcutil();
			Connection conn=jdbc.getConnection();
			try{
				//先往出库单里写一条记录
				conn.createStatement().execute("insert into delwuliao(outname,outnum,outprice,outuserid,outdate)values('"+outname+"','"+outnum+"','"+outprice+"','"+outuserid+"','"+outdate+"')");
				//再从入库单里更新一下数据
				int i=a-Integer.parseInt(outnum);
				if(i==0){
					conn.createStatement().executeUpdate("delete from addwuliao where inname='"+outname+"'");
				}
				else{
					conn.createStatement().executeUpdate("update addwuliao set innum='"+i+"' where inname='"+outname+"'");
					System.out.println("update addwuliao set innum='"+i+"' where inname='"+outname+"'");
				}
				forward="success";
				jdbc.close(conn);
			}catch(Exception e){
				forward="input";
				jdbc.close(conn);
				e.printStackTrace();
			}
		}
		else{
			forward="input";
		}
		return forward;
	}
	/*
	 * 检查是否存在这样的产品名
	 * **/
	public boolean checkname(){
		boolean flag = false;
		Jdbcutil jdbc1=new Jdbcutil();
		ResultSet rs1=null;
		try {
			 rs1=jdbc1.getConnection().createStatement().executeQuery("select * from addwuliao where inname='"+outname+"'");
			if(rs1!=null){
				if(rs1.next()){
					flag=true;
				}
				else{
					flag=false;
				}
			}
		} catch (SQLException e){
			flag=false;
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			flag=false;
			e.printStackTrace();
		}
		System.out.println(flag);
		return flag;	
	}
	/*
	 * 检查已存在的产品名的数量和输入的数量值之间是否符合逻辑
	 * **/
	public boolean checknum(){
		boolean flag=false;
		boolean g=checkname();
		boolean h=checkuserid();
		Jdbcutil jdbc2=new Jdbcutil();
		ResultSet rs2=null;
		if(g&&h){
			try {
				rs2=jdbc2.getConnection().createStatement().executeQuery("select innum from addwuliao where inname='"+outname+"'");
				if(rs2!=null){
					while(rs2.next()){
						 a=Integer.parseInt(rs2.getString("innum"));//数据库里的库存量
						if(a<Integer.parseInt(outnum)){
							flag=false;
						}else{
							flag=true;
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				flag=false;
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				flag=false;
				e.printStackTrace();
			}
		}
		return flag;
	}
	/*
	 * 检查userid是否存在
	 * **/
	public boolean checkuserid(){
		boolean flag=false;
		Jdbcutil jdbc=new Jdbcutil();
		try {
			Connection conn=jdbc.getConnection();
			ResultSet rs=conn.createStatement().executeQuery("select * from user where userid='"+outuserid+"'");
			if(rs!=null){
				if(rs.next()){
					flag=true;
				}
				else{
					flag=false;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			flag=false;
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
}
