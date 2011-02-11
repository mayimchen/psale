package com.sheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sheng.datasource.Pool;
import com.sheng.po.User;


public class InsertUserDaoImpl implements InsertUserDAO {

	public void saveuser(User u) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pm = null;
		try {
			conn = Pool.getConnection();
			conn.setAutoCommit(false);
			pm = conn
					.prepareStatement("insert into user(userid,username,passwd,existstate,management)values(?,?,?,?,?)");
			pm.setString(1, u.getUserid());
			pm.setString(2, u.getUsername());
			pm.setString(3, u.getPasswd());
			pm.setInt(4, u.getExiststate());
			pm.setInt(5, u.getManagement());
			pm.execute();// 此处考虑换个方法来实现。此处的方法具有不负责任的感觉
			conn.commit();
			Pool.close(pm);
			Pool.close(conn);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception ep) {
				ep.printStackTrace();
			}
			Pool.close(pm);
			Pool.close(conn);
		} finally {
			Pool.close(pm);
			Pool.close(conn);
		}
	}

	public int updateuser(User u) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection conn = null;
		PreparedStatement pm = null;
		try {
			conn = Pool.getConnection();
			conn.setAutoCommit(false);
			pm = conn
					.prepareStatement("update user set username=?,passwd=?,existstate=?,management=? where userid=?");
			pm.setString(1, u.getUsername());
			pm.setString(2, u.getPasswd());
			pm.setInt(3, u.getExiststate());
			pm.setInt(4, u.getManagement());
			pm.setString(5, u.getUserid());
			i = pm.executeUpdate();
			conn.commit();
			Pool.close(pm);
			Pool.close(conn);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			Pool.close(pm);
			Pool.close(conn);
		} finally {
			Pool.close(pm);
			Pool.close(conn);
		}
		return i;
	}

}
