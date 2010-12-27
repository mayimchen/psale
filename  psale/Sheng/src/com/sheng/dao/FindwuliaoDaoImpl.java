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
				a.setId(rs.getInt(1));
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

	/*
	 * 查找指定的物料是否存在并保存起来
	 * **/
	public Addwuliao getwuliaobyid(int id) {
		// TODO Auto-generated method stub
		Addwuliao aw=null;
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from addwuliao where id=?");
			pm.setInt(1,id);
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					aw=new Addwuliao();
					aw.setId(rs.getInt(1));
					aw.setInname(rs.getString(2));
					aw.setInnum(rs.getString(3));
					aw.setInprice(rs.getString(4));
					aw.setInuserid(rs.getString(5));
					aw.setIndate(rs.getString(6).substring(0,19));
				}
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
		return aw;
	}

}
