package com.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicsDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// insert1();
		// insert2();
		insert3(7);

	}

	public static void insert1() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from  marksheet where id = 9");
		int i = pstmt.executeUpdate();
		System.out.println("Data deleted :" + i);

	}

	public static void insert2() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");

		pstmt.setInt(1, 8);

		int i = pstmt.executeUpdate();
		System.out.println("Data updated: " + i);

	}

	public static void insert3(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");
		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();
		System.out.println("Data updated: " + i);

	}
}
