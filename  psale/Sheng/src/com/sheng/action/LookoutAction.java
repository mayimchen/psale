package com.sheng.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sheng.po.Outwuliao;
import com.sheng.util.Jdbcutil;

public class LookoutAction extends ActionSupport {

	/**
	 * 查看所有的销售单子
	 */
	private static final long serialVersionUID = 1L;
	private List<Outwuliao> ls;
	public List<Outwuliao> getLs() {
		return ls;
	}
	public void setLs(List<Outwuliao> ls) {
		this.ls = ls;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ls=new ArrayList<Outwuliao>();
		String forward="";
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=jdbc.getConnection();
		try{
			ResultSet rs=conn.createStatement().executeQuery("select * from delwuliao");
			if(rs!=null){
				while(rs.next()){
					Outwuliao ow=new Outwuliao();
					ow.setOutname(rs.getString("outname"));
					ow.setOutnum(rs.getString("outnum"));
					ow.setOutprice(rs.getString("outprice"));
					ow.setOutuserid(rs.getString("outuserid"));
					ow.setOutdate(rs.getString("outdate").substring(0, 19));
					ls.add(ow);
					forward="success";
				}
			}
			forward="success";
		}catch(Exception e){
			forward="input";
			e.printStackTrace();
		}
		return forward;
	}
	
}
