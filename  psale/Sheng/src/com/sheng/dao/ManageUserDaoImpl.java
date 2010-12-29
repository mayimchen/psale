package com.sheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sheng.po.User;
import com.sheng.util.Jdbcutil;

public class ManageUserDaoImpl implements ManageUserDAO {

	public List<User> getalluser() {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		List<User> ls=new ArrayList<User>();
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from user");
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					User u=new User();
					u.setUserid(rs.getString("userid"));
					u.setUsername(rs.getString("username"));
					u.setPasswd(rs.getString("passwd"));
					u.setManagement(rs.getInt("management"));
					u.setExiststate(rs.getInt("existstate"));
					ls.add(u);
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
