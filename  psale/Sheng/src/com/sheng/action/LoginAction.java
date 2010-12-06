package com.sheng.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sheng.util.Jdbcutil;

public class LoginAction extends ActionSupport {

	/**
	 * µÇÂ½action
	 */
	private static final long serialVersionUID = 1L;
	private String userid;
	private String passwd;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String forward="";
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=jdbc.getConnection();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from user where userid='"+userid+"'and passwd='"+passwd+"'");
		if(rs!=null){
			if(rs.next()){
				//ServletContext.getServletContext.
				ActionContext.getContext().getSession().put("username", userid);
				forward="success";
			}else{
				forward="input";
			}
		}
		return forward;
	}
	
}
