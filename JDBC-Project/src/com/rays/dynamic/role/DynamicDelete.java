package com.rays.dynamic.role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicDelete {
	public static void main(String[] args) throws Exception {
		// delete1();
		//delete2();
		delete3(5);

	}

	public static void delete1() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from role where id = 4");
		int i = pstmt.executeUpdate();
		System.out.println("Data deleted :> " + i);

	}

	public static void delete2() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from role where id = ?");
		pstmt.setInt(1, 6);
		int i = pstmt.executeUpdate();
		System.out.println("Data deleted : " + i);

	}

	public static void delete3(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from role where id = ?");
		pstmt.setInt(1, id);
		int i = pstmt.executeUpdate();
		System.out.println("Data deleted : " + i);

	}

}
