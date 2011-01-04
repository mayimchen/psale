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
				a.setPid(rs.getString("pid"));
				a.setInname(rs.getString("inname"));
				a.setInnum(rs.getInt("innum"));
				a.setInprice(rs.getDouble("inprice"));
				a.setInuserid(rs.getString("inuserid"));
				a.setIndate(rs.getString("indate").substring(0,19));
				a.setProductsdetail(rs.getString("productsdetail"));
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
	public Addwuliao getwuliaobyid(String pid) {
		// TODO Auto-generated method stub
		Addwuliao aw=null;
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from addwuliao where pid=?");
			pm.setString(1,pid);
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					aw=new Addwuliao();
					aw.setPid(rs.getString("pid"));
					aw.setInname(rs.getString("inname"));
					aw.setInnum(rs.getInt("innum"));
					aw.setInprice(rs.getDouble("inprice"));
					aw.setInuserid(rs.getString("inuserid"));
					aw.setIndate(rs.getString("indate").substring(0,19));
					aw.setProductsdetail(rs.getString("productsdetail"));
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
	/*
	 * 查看所有入库单
	 * **/

	public List<Addwuliao> findalladdbf() {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		List<Addwuliao> list=new ArrayList<Addwuliao>();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from addwuliaobeifen");
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Addwuliao a=new Addwuliao();
					a.setPid(rs.getString("pid"));
					a.setInname(rs.getString("inname"));
					a.setInnum(rs.getInt("innum"));
					a.setInprice(rs.getDouble("inprice"));
					a.setInuserid(rs.getString("inuserid"));
					a.setIndate(rs.getString("indate").substring(0,19));
					a.setProductsdetail(rs.getString("productsdetail"));
					list.add(a);
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
		return list;
	}
	
	
}
