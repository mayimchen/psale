package com.sheng.action;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.po.Outwuliao;
import com.sheng.util.Jdbcutil;

public class LookpersonAction extends ActionSupport {
	/**
	 *查看用户指定日期销售汇总的业务action
	 */
	private static final long serialVersionUID = 1L;
	private String userid;
	private Timestamp startdate;
	private Timestamp enddate;
	private List<Outwuliao> ls;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public Timestamp getStartdate() {
		return startdate;
	}
	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}
	public Timestamp getEnddate() {
		return enddate;
	}
	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String forward="";
		ls=new ArrayList<Outwuliao>();
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=jdbc.getConnection();
		ResultSet rs=null;
		try{
			rs=conn.createStatement().executeQuery("select * from delwuliao where outuserid='"+userid+"' and outdate between '"+startdate+"' and '"+enddate+"'");
			if(rs!=null){
				while(rs.next()){
					Outwuliao ow=new Outwuliao();
					ow.setOutname(rs.getString("outname"));
					ow.setOutnum(rs.getString("outnum"));
					ow.setOutprice(rs.getString("outprice"));
					ow.setOutuserid(rs.getString("outuserid"));
					ow.setOutdate(rs.getString("outdate").substring(0,19));
					ls.add(ow);
					forward="success";
				}
			}
			else{
				forward="nomessage";
			}
		}catch(Exception e){
			forward="input";
			e.printStackTrace();
		}
		return forward;
	}
}
