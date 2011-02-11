package com.sheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sheng.datasource.Pool;
import com.sheng.po.User;


public class ManageUserDaoImpl implements ManageUserDAO {

	public List<User> getalluser() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		List<User> ls=new ArrayList<User>();
		try{
			conn=Pool.getConnection();
			pm=conn.prepareStatement("select * from user");
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					User u = setproperty(rs);
					ls.add(u);
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
		return ls;
	}

	/*
	 * �鿴�����û���������ҳ��ʾ
	 * **/
	public List<User> getalluserbypage(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		List<User> ls=new ArrayList<User>();
		try{
			conn=Pool.getConnection();
			pm=conn.prepareStatement("select * from user limit "+(pageNo*pageSize-pageSize)+","+pageSize+"");
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					User u = setproperty(rs);
					ls.add(u);
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
		return ls;
	}

	private User setproperty(ResultSet rs) throws SQLException {
		User u=new User();
		u.setUserid(rs.getString("userid"));
		u.setUsername(rs.getString("username"));
		u.setPasswd(rs.getString("passwd"));
		u.setManagement(rs.getInt("management"));
		u.setExiststate(rs.getInt("existstate"));
		return u;
	}

	/*
	 * �鿴��ҳ��
	 * **/
	public List<Integer> gettotalpage(int pageSize) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<Integer>();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=Pool.getConnection();
			pm=conn.prepareStatement("select count(*) from user");
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					list.add(rs.getInt(1)/pageSize);
					list.add(rs.getInt(1)%pageSize);
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
		return list;
	}
	
	
}
