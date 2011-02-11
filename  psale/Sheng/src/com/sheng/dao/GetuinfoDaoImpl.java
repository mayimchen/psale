package com.sheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sheng.datasource.Pool;
import com.sheng.po.User;


public class GetuinfoDaoImpl implements GetuinfoDAO {

	public User getuser(String s) {
		// TODO Auto-generated method stub
		User u=new User();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=Pool.getConnection();
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
			Pool.close(rs);
			Pool.close(pm);
			Pool.close(conn);
		}catch(Exception e){
			e.printStackTrace();
			Pool.close(rs);
			Pool.close(pm);
			Pool.close(conn);
		}finally{
			Pool.close(rs);
			Pool.close(pm);
			Pool.close(conn);
		}
		return u;
	}

}
