package com.sheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sheng.util.Jdbcutil;

public class DaoImpl implements DAO {

	public boolean getuser(String userid, String passwd){
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		boolean forward=false;
		try {
			Connection conn=jdbc.getConnection();
			PreparedStatement pm=conn.prepareStatement("select * from user where userid=?and passwd=?");
			pm.setString(1,userid);
			pm.setString(2,passwd);
			ResultSet rs=pm.executeQuery();
			if(rs!=null){
				if(rs.next()){
					forward=true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forward=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forward=false;
		}
		return forward;
	}


}
