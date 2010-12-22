package com.sheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sheng.po.User;
import com.sheng.util.Jdbcutil;

public class GetuinfoDaoImpl implements GetuinfoDAO {

	public User getuser(String s) {
		// TODO Auto-generated method stub
		User u=new User();
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from user where userid=?");
			pm.setString(1, s);
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					u.setUserid(rs.getString("userid"));
					u.setPasswd(rs.getString("passwd"));
					u.setUsername(rs.getString("username"));
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
		return u;
	}

}
