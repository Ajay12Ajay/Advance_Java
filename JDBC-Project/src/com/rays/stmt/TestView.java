package com.rays.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestView {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// establish connections
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from marksheet");

		while (rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}

	}

}
