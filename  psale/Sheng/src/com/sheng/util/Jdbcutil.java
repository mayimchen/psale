package com.sheng.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			System.out.println("------the driver had load------");
			conn=DriverManager.getConnection(jdbcpro.getUrl(), jdbcpro.getUsername(),jdbcpro.getPasswd());
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
				System.out.println("------conn had closed------"+"\n"+"\n");
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
				System.out.println("rs had closed");
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
				System.out.println("st had closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("we can't close the statement");
			}
		}
	}
	/*
	 * the method will close the preparestatement
	 * **/
	public void close(PreparedStatement pm){
		if(pm!=null){
			try {
				pm.close();
				System.out.println("pm had closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("we can't close the PreparedStatement");
			}
		}
	}
	}

