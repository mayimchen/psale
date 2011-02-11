package com.sheng.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp.datasources.SharedPoolDataSource;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.sheng.util.ConnfigReader;
import com.sheng.util.Jdbcpro;

public class Pool {
	private static DataSource ds;
	static Logger logger = Logger.getLogger(Pool.class);
	static {
		Jdbcpro jdbc=ConnfigReader.getInstance().getJdbcpro();
		DriverAdapterCPDS cpds = new DriverAdapterCPDS();
		try {
			PropertyConfigurator.configure(Thread.currentThread()
					.getContextClassLoader().getResource("log4j.properties"));
			cpds.setDriver(jdbc.getDrivername());
			logger.info("�����������");
			cpds.setUrl(jdbc.getUrl());
			cpds.setUser(jdbc.getUsername());
			cpds.setPassword(jdbc.getPasswd());
			SharedPoolDataSource tds = new SharedPoolDataSource();
			tds.setConnectionPoolDataSource(cpds);
			tds.setMaxActive(jdbc.getMaxactive());
			tds.setMaxIdle(jdbc.getMaxidle());
			tds.setMaxWait(jdbc.getMaxwaite());
			ds = tds;
			//System.out.println(ds.getClass().getName());
		} catch (ClassNotFoundException e) {
			logger.info("�޷���������");
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	/*
	 * author zqiangzhang the method will close the connection date:2010.11.02 *
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				logger.info("�����ѹر�");
				// System.out.println("------conn had closed------"+"\n"+"\n");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.info("�޷��ر�����");
				// System.out.println("we can't close connection");
			}
		}
	}

	/*
	 * the method will close the resultset *
	 */
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				// logger.debug("rs�ѹر�");
				// System.out.println("rs had closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// logger.debug("rs�޷��ر�");
				// System.out.println("we can't close the resultset");
			}
		}
	}

	/*
	 * the method will close the statement *
	 */
	public void close(Statement st) {
		if (st != null) {
			try {
				st.close();
				// logger.debug("st�ѹر�");
				// System.out.println("st had closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// logger.debug("st�޷��ر�");
				// System.out.println("we can't close the statement");
			}
		}
	}

	/*
	 * the method will close the preparestatement *
	 */
	public static void close(PreparedStatement pm) {
		if (pm != null) {
			try {
				pm.close();
				// logger.debug("pm�ѹر�");
				// System.out.println("pm had closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// logger.debug("pm�޷��ر�");
				// System.out.println("we can't close the PreparedStatement");
			}
		}
	}
}
