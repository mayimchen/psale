package com.sheng.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.util.Jdbcutil;

public class CheckuserAction extends ActionSupport {

	/**
	 * ºÏ≤Èid «∑Ò¥Ê‘⁄
	 */
	private static final long serialVersionUID = 1L;
	private String userid;
	private int  showmessage;
	public int getShowmessage() {
		return showmessage;
	}
	public void setShowmessage(int showmessage) {
		this.showmessage = showmessage;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=jdbc.getConnection();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from user where userid="+userid);
		if(rs!=null){
			if(rs.next()){
				showmessage=1;
				jdbc.close(rs);
				jdbc.close(st);
				jdbc.close(conn);
			}
			else{
				showmessage=0;
				jdbc.close(rs);
				jdbc.close(st);
				jdbc.close(conn);
			}
		}
		return SUCCESS;
	}
	
}
