package com.sheng.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.po.Addwuliao;
import com.sheng.util.Jdbcutil;

public class LookkucunAction extends ActionSupport {

	/**
	 * 查看所有库存
	 */
	private static final long serialVersionUID = 1L;
	private List<Addwuliao> wuliaolist;

	public List<Addwuliao> getWuliaolist() {
		return wuliaolist;
	}

	public void setWuliaolist(List<Addwuliao> wuliaolist) {
		this.wuliaolist = wuliaolist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=jdbc.getConnection();
		ResultSet rs=null;
		String forward="";
		wuliaolist=new ArrayList<Addwuliao>();
		try{
			rs=conn.createStatement().executeQuery("select * from addwuliao");
			while(rs.next()){
				Addwuliao a=new Addwuliao();
				//用对象封装好信息后存入数组
				a.setInname(rs.getString(2));
				a.setInnum(rs.getString(3));
				a.setInprice(rs.getString(4));
				a.setInuserid(rs.getString(5));
				a.setIndate(rs.getString(6).substring(0,19));
				wuliaolist.add(a);
			}
			jdbc.close(rs);
			jdbc.close(conn);
			forward="success";
		}catch(Exception e){
			jdbc.close(rs);
			jdbc.close(conn);
			e.printStackTrace();
			forward="input";	
		}
		return forward;
	}
	

}
