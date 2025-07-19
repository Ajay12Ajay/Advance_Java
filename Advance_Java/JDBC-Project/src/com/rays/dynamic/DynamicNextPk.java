package com.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicNextPk {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int nextpk = nextPk();
		System.out.println(nextpk);

	}

	public static Integer nextPk() throws ClassNotFoundException, SQLException {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from marksheet");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = (rs.getInt(1));

		}

		return pk + 1;

	}

}
