package com.sheng.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.util.Jdbcutil;

public class AdduserAction extends ActionSupport {

	/**
	 * 添加新用戶的action
	 */
	private static final long serialVersionUID = 1L;
	private String userid;//用戶ID
	private String username;//用戶名
	private String passwd;//用戶密碼
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		Jdbcutil jdbcutil=new Jdbcutil();
		Connection conn=jdbcutil.getConnection();
		String forward;
		try{
			if(userid.length()!=0&&username.length()!=0&&passwd.length()>=6&&checkuserid()){
				conn.createStatement().execute("insert into user(userid,username,passwd)values('"+userid+"','"+username+"','"+passwd+"')");
				forward="success";
			}
			else{
				forward="input";
				}
			jdbcutil.close(conn);
		}catch(Exception e){
			e.printStackTrace();
			jdbcutil.close(conn);
			forward="input";
		}	
		return forward;
	}
	
	/*
	 * 检查userid是否存在
	 * **/
	public boolean checkuserid(){
		boolean flag=false;
		Jdbcutil jdbc=new Jdbcutil();
		try {
			Connection conn=jdbc.getConnection();
			ResultSet rs=conn.createStatement().executeQuery("select * from user where userid='"+userid+"'");
			if(rs!=null){
				if(rs.next()){
					flag=false;
				}
				else{
					flag=true;
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
