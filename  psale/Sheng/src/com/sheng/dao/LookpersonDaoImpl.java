package com.sheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.sheng.po.Outwuliao;
import com.sheng.util.Jdbcutil;

public class LookpersonDaoImpl implements LookpersonDAO {
       /*
        * 查看指定人员，指定日期内的销量
        * **/
	public List<Outwuliao> getpersonout(String userid,Timestamp startdate,Timestamp enddate) {
		// TODO Auto-generated method stub
		List<Outwuliao> ls=new ArrayList<Outwuliao>();
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from delwuliao where outuserid=? and outdate between ? and ?");
			pm.setString(1, userid);
			pm.setTimestamp(2, startdate);
			pm.setTimestamp(3, enddate);
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Outwuliao ow = setproperty(rs);
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
	
	/*
	 * 公共的函数
	 * **/
	private Outwuliao setproperty(ResultSet rs) throws SQLException {
		Outwuliao ow=new Outwuliao();
		ow.setMaori(rs.getDouble("maori"));
		ow.setPurchaser(rs.getString("purchaser"));
		ow.setOutname(rs.getString("outname"));
		ow.setOutnum(rs.getInt("outnum"));
		ow.setOutprice(rs.getDouble("outprice"));
		ow.setOutuserid(rs.getString("outuserid"));
		ow.setOutdate(rs.getString("outdate").substring(0, 19));
		ow.setPid(rs.getString("pid"));
		return ow;
	}
	/*
	 * 查看指定人员，指定日期，按页显示
	 * **/
	public List<Outwuliao> getpersonoutbypage(String userid,
			Timestamp startdate, Timestamp enddate, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		List<Outwuliao> ls=new ArrayList<Outwuliao>();
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from delwuliao where outuserid=? and outdate between ? and ? limit "+(pageSize*pageNo-pageSize)+","+pageSize+"");
			pm.setString(1, userid);
			pm.setTimestamp(2, startdate);
			pm.setTimestamp(3, enddate);
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Outwuliao ow = setproperty(rs);
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
	/*
	 * 查看指定人员，指定日期的销售额和总毛利
	 * **/
	public List<Double> getsumms(String userid, Timestamp startdate,
			Timestamp enddate) {
		// TODO Auto-generated method stub
		List<Double> ls=new ArrayList<Double>();
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select sum(outprice),sum(maori) from delwuliao where outuserid=? and outdate between ? and ?");
			pm.setString(1, userid);
			pm.setTimestamp(2, startdate);
			pm.setTimestamp(3, enddate);
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					ls.add(rs.getDouble(1));
					ls.add(rs.getDouble(2));
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
	/*
	 * 查看指定人员，指定日期，按页显示的总页数
	 * **/
	public List<Integer> getsumpage(String userid, Timestamp startdate,
			Timestamp enddate,int pageSize) {
		// TODO Auto-generated method stub
		List<Integer> ls=new ArrayList<Integer>();
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select count(*) from delwuliao where outuserid=? and outdate between ? and ?");
			pm.setString(1, userid);
			pm.setTimestamp(2, startdate);
			pm.setTimestamp(3, enddate);
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					ls.add(rs.getInt(1)/pageSize);
					ls.add(rs.getInt(1)%pageSize);
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
