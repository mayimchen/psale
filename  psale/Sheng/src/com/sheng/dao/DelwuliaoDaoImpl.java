package com.sheng.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sheng.po.Outwuliao;
import com.sheng.util.Jdbcutil;
public class DelwuliaoDaoImpl implements DelwuliaoDAO {

	public boolean checkwuliaonameexist(String name) {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		boolean flag=false;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from addwuliao where inname=?");
			pm.setString(1,name);
			rs=pm.executeQuery();
			if(rs!=null){
				if(rs!=null){
					flag=true;
				}else{
					flag=false;
				}
			}else{
				flag=false;
			}
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}finally{
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}
		return flag;
	}
	/*
	 * 查看指定名称的库存量
	 * **/
	public int getnum(String name) {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		int a=0;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select innum from addwuliao where inname=?");
			pm.setString(1, name);
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					a=Integer.parseInt(rs.getString("innum"));
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
		return a;
	}
	/*
	 * 保存出库资料
	 * **/
	public boolean savedel(Outwuliao ow) {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		boolean flag=false;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("insert into delwuliao(outname,outnum," +
																"outprice," +
																"outuserid,outdate)" +
																"values(?,?,?,?,?)");
			pm.setString(1, ow.getOutname());
			pm.setString(2, ow.getOutnum());
			pm.setString(3, ow.getOutprice());
			pm.setString(4, ow.getOutuserid());
			pm.setString(5, ow.getOutdate());
			flag=pm.execute();
			jdbc.close(pm);
			jdbc.close(conn);
		}catch(Exception e){
			e.printStackTrace();
			jdbc.close(pm);
			jdbc.close(conn);
		}finally{
			jdbc.close(pm);
			jdbc.close(conn);
		}
		return flag;
	}
	/*
	 * 更新入库数量
	 * **/
	public boolean updatenum(String num,String name) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("update addwuliao set innum=? where inname=?");
			pm.setString(1, num);
			pm.setString(2, name);
			int a=pm.executeUpdate();
			if(a==0){
				flag=false;
			}else{
				flag=true;
			}
			jdbc.close(pm);
			jdbc.close(conn);
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
			jdbc.close(pm);
			jdbc.close(conn);
		}finally{
			jdbc.close(pm);
			jdbc.close(conn);
		}
		return flag;
	}
	/*
	 * 当出库完之后，如果库存量为0，那么就删除库存里物料的名字
	 * **/
	public boolean delwuliao(String name) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("delete from addwuliao where inname=?");
			pm.setString(1, name);
			int x=pm.executeUpdate();
			if(x==0){
				flag=false;
			}else{
				flag=true;
			}
			jdbc.close(pm);
			jdbc.close(conn);
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
			jdbc.close(pm);
			jdbc.close(conn);
		}finally{
			jdbc.close(pm);
			jdbc.close(conn);
		}
		return flag;
	}
	/*
	 * 查看所有出库单
	 * **/
	public List<Outwuliao> findallout() {
		// TODO Auto-generated method stub
		List<Outwuliao> ls=new ArrayList<Outwuliao>();
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from delwuliao");
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Outwuliao ow=new Outwuliao();
					ow.setOutname(rs.getString("outname"));
					ow.setOutnum(rs.getString("outnum"));
					ow.setOutprice(rs.getString("outprice"));
					ow.setOutuserid(rs.getString("outuserid"));
					ow.setOutdate(rs.getString("outdate").substring(0, 19));
					ls.add(ow);
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
		return ls;
	}
	
}
