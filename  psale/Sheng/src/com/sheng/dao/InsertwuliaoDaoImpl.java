package com.sheng.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sheng.po.Addwuliao;
import com.sheng.util.Jdbcutil;
/*
 * ÃÌº”ŒÔ¡œ
 * **/
public class InsertwuliaoDaoImpl implements InsertwuliaoDAO {
	public boolean addwuliao(Addwuliao aw) {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		PreparedStatement pm2=null;
		boolean flag=false;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("insert addwuliao(pid,inname,innum,inprice,inuserid,indate,productsdetail)values(?,?,?,?,?,?,?)");
			pm2=conn.prepareStatement("insert addwuliaobeifen(pid,inname,innum,inprice,inuserid,indate,productsdetail)values(?,?,?,?,?,?,?)");
			pm.setString(1,aw.getPid());
			pm.setString(2, aw.getInname());
			pm.setInt(3, aw.getInnum());
			pm.setDouble(4, aw.getInprice());
			pm.setString(5, aw.getInuserid());
			pm.setString(6, aw.getIndate());
			pm.setString(7,aw.getProductsdetail());
			
			pm2.setString(1,aw.getPid());
			pm2.setString(2, aw.getInname());
			pm2.setInt(3, aw.getInnum());
			pm2.setDouble(4, aw.getInprice());
			pm2.setString(5, aw.getInuserid());
			pm2.setString(6, aw.getIndate());
			pm2.setString(7,aw.getProductsdetail());
			pm.execute();
			pm2.execute();
			flag=true;
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

	public int updatewuliao(Addwuliao aw) {
		// TODO Auto-generated method stub
		int flag=0;
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("update addwuliao set inname=?,innum=?,inprice=?,productsdetail=?where pid=?");
			pm.setString(1,aw.getInname());
			pm.setInt(2,aw.getInnum());
			pm.setDouble(3,aw.getInprice());
			pm.setString(4,aw.getProductsdetail());
			pm.setString(5,aw.getPid());
			flag=pm.executeUpdate();
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

	public int findpid(String id) {
		// TODO Auto-generated method stub
		int i=1;
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from addwuliao where pid=?");
			pm.setString(1,id);
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					i=0;
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
		return i;
	}
	
}
