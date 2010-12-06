package com.sheng.action;

import java.sql.Connection;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.util.Jdbcutil;

public class CheckoutnameAction extends ActionSupport {

	/**
	 * 出库时，检查产品名是否存在的action
	 */
	private static final long serialVersionUID = 1L;
	private String outname;
	private int message;
	public String getOutname() {
		return outname;
	}
	public void setOutname(String outname) {
		this.outname = outname;
	}
	public int getMessage() {
		return message;
	}
	public void setMessage(int message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=jdbc.getConnection();
		ResultSet rs=conn.createStatement().executeQuery("select * from addwuliao where inname='"+outname+"'");
		if(rs!=null){
			if(rs.next()){
				message=0;
				jdbc.close(rs);
				jdbc.close(conn);
			}else{
				message=1;
				jdbc.close(rs);
				jdbc.close(conn);
			}
		}
		return SUCCESS;
	}
	
	
}
