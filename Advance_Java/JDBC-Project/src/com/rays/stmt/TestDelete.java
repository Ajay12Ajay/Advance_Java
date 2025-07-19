package com.rays.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// establish connections
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("delete from marksheet where id = 7");
		System.out.println("Data deleted" + i);

	}

}
