package com.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// insert1();
		// insert2();
		// insert3("ajay", 9);
		MarksheetBean bean = new MarksheetBean();
		bean.setId(2);
		bean.setRoll_no(1009);
		bean.setName("gunj");
		bean.setPhysics(99);
		bean.setChemistry(99);
		bean.setMaths(99);

		insert4(bean);
	}

	public static void insert1() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Update marksheet set name = 'ajay' where id=9");
		int i = pstmt.executeUpdate();
		System.out.println("Data updated: " + i);
	}

	public static void insert2() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update marksheet set name= ? where id = ?");

		pstmt.setString(1, "gunjan");
		pstmt.setInt(2, 9);

		int i = pstmt.executeUpdate();
		System.out.println("Data updated: " + i);

	}

	public static void insert3(String name, int id) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update marksheet set name = ? where id= ?");
		pstmt.setString(1, name);
		pstmt.setInt(2, id);

		int i = pstmt.executeUpdate();
		System.out.println("Data updated" + i);

	}

	public static void insert4(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update marksheet set name = ? where id= ?");
		pstmt.setString(1, bean.getName());
		pstmt.setInt(2, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Data updated: " + i);

	}

}
