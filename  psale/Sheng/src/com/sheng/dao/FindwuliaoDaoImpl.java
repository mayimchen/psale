package com.sheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sheng.po.Addwuliao;
import com.sheng.util.Jdbcutil;

public class FindwuliaoDaoImpl implements FindwuliaoDAO {
	/*
	 * 查找所有的入库物料
	 * **/
	public List<Addwuliao> findalladd() {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		List<Addwuliao> list=new ArrayList<Addwuliao>();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from addwuliao");
			rs=pm.executeQuery();
			while(rs.next()){
				Addwuliao a=new Addwuliao();
				a.setInname(rs.getString(2));
				a.setInnum(rs.getString(3));
				a.setInprice(rs.getString(4));
				a.setInuserid(rs.getString(5));
				a.setIndate(rs.getString(6).substring(0,19));
				list.add(a);
			}
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}catch(Exception e){
			e.printStackTrace();
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}finally{
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}
		return list;
	}

}
