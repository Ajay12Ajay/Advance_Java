package com.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("update marksheet set name ='aniket' where id=7 ");
		int i = pstmt.executeUpdate();
		System.out.println("Data updated: " + i);
	}

}
