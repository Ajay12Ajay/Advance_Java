package com.rays.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// establish connections
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into marksheet values (7,107,'pqr',97,87,88)");
		System.out.println("Data inserted: " + i);

		// int i = stmt.executeUpdate("update marksheet set name= 'madhu' where id =4");
		// System.out.println("Data updated" + i);

		// int i = stmt.executeUpdate("delete from marksheet where id = 7");
		// System.out.println("Data deleted" + i);

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
