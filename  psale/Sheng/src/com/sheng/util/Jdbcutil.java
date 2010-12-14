package com.sheng.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * the class is a util class
 * 
 * **/
public class Jdbcutil {
	
	public  Connection getConnection() throws ClassNotFoundException{
		Connection conn = null;
		Jdbcpro jdbcpro=ConnfigReader.getInstance().getJdbcpro();
		try {
			Class.forName(jdbcpro.getDrivername());
			System.out.println("the driver had load.....");
			conn=DriverManager.getConnection(jdbcpro.getUrl(), jdbcpro.getUsername(),jdbcpro.getPasswd());
			//System.out.println("the conn had been created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("we can't open connection!");
		}
		return conn;
	}
	/*
	 * author zqiangzhang
	 * the method will close the connection
	 * date:2010.11.02
	 * **/
	public void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("we can't close connection");
			}
		}
	}
	/*
	 * the method will close the resultset
	 * **/
	public void close(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("we can't close the resultset");
			}
		}
	}
	/*
	 * the method will close the statement
	 * **/
	public void close(Statement st){
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("we can't close the statement");
			}
		}
	}
		
	}

