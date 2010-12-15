package com.sheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sheng.util.Jdbcutil;

public class CheckuserexistDaoImpl implements CheckuserexistDAO {
	//检查用户是否存在
	public boolean getuser(String userid, String passwd){
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		boolean forward=false;
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try {
			 conn=jdbc.getConnection();
			 pm=conn.prepareStatement("select * from user where userid=?and passwd=?");
			pm.setString(1,userid);
			pm.setString(2,passwd);
			 rs=pm.executeQuery();
			if(rs!=null){
				if(rs.next()){
					forward=true;					
				}
			}
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forward=false;
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forward=false;
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}finally{
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}
		return forward;
	}
//检查用户ID是否存在
	public boolean checkuseridexist(String userid) {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		boolean forward=false;
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from user where userid=?");
			pm.setString(1, userid);
			rs=pm.executeQuery();
			if(rs!=null){
				if(rs.next()){
					forward=true;
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
			forward=false;
		}finally{
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}
		return forward;
	}
}
