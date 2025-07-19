package com.rays.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBCDataSource {
	public static void main(String[] args) throws Exception {

		testConnection();

	}

	public static void testConnection() throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1));

		}
		JDBCDataSource.getConnection().close();
	
	}

}
