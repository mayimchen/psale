package com.sheng.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.sheng.action.LoginAction;


/*
 * the class is a util class
 * 
 * **/
public class Jdbcutil {
	Logger logger=Logger.getLogger(Jdbcutil.class);
	public  Connection getConnection() throws ClassNotFoundException{
		Connection conn = null;
		Jdbcpro jdbcpro=ConnfigReader.getInstance().getJdbcpro();
		PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
		try {
			Class.forName(jdbcpro.getDrivername());
			logger.debug("驱动加载完成");
			//System.out.println("------the driver had load------");
			conn=DriverManager.getConnection(jdbcpro.getUrl(), jdbcpro.getUsername(),jdbcpro.getPasswd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug("无法打开连接");
			//System.out.println("we can't open connection!");
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
				logger.debug("连接已关闭");
				//System.out.println("------conn had closed------"+"\n"+"\n");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.debug("无法关闭连接");
				//System.out.println("we can't close connection");
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
				logger.debug("rs已关闭");
				//System.out.println("rs had closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.debug("rs无法关闭");
				//System.out.println("we can't close the resultset");
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
				logger.debug("st已关闭");
				//System.out.println("st had closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.debug("st无法关闭");
				//System.out.println("we can't close the statement");
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
				logger.debug("pm已关闭");
				//System.out.println("pm had closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.debug("pm无法关闭");
				//System.out.println("we can't close the PreparedStatement");
			}
		}
	}
	}

