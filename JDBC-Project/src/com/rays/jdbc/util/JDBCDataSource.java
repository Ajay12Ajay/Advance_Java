package com.rays.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {

	private static JDBCDataSource jds = null;
	private static ComboPooledDataSource cpds = null;

	private JDBCDataSource() {
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/adv_java ");
			cpds.setUser("root");
			cpds.setPassword("root");
			cpds.setInitialPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setMaxPoolSize(30);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static JDBCDataSource getInstance() {
		if (jds == null) {
			jds = new JDBCDataSource();
		}

		return jds;

	}

	public static Connection getConnection() throws Exception {

		return getInstance().cpds.getConnection();
	}

	public static void closeConnection(Connection c, PreparedStatement pstmt) throws SQLException {
		if (c != null) {
			c.close();
		}

		if (pstmt != null) {
			pstmt.close();
		}

	}

	public static void closeConnection(Connection c, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}

	}

}
