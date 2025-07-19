package com.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// insert1();
		// insert2();
		// insert3(8, 108, "aniket", 87, 67, 88);

		MarksheetBean bean = new MarksheetBean();
		bean.setId(9);
		bean.setRoll_no(9);
		bean.setName("gunjan");
		bean.setPhysics(88);
		bean.setChemistry(77);
		bean.setMaths(66);

		insert4(bean);

	}

	public static void insert1() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(7,107,'malay',87,98,68)");
		int i = pstmt.executeUpdate();
		System.out.println("Data inserted :" + i);
	}

	public static void insert2() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		pstmt.setInt(1, 7);
		pstmt.setInt(2, 107);
		pstmt.setString(3, "Malay");
		pstmt.setInt(4, 98);
		pstmt.setInt(5, 67);
		pstmt.setInt(6, 75);

		int i = pstmt.executeUpdate();
		System.out.println("Data Inserted: " + i);

	}

	public static void insert3(int id, int roll_no, String name, int physics, int chemistry, int maths)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		pstmt.setInt(1, id);
		pstmt.setInt(2, roll_no);
		pstmt.setString(3, name);
		pstmt.setInt(4, physics);
		pstmt.setInt(5, chemistry);
		pstmt.setInt(6, maths);

		int i = pstmt.executeUpdate();
		System.out.println("Data inserted: " + i);

	}

	public static void insert4(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRoll_no());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();
		System.out.println("Data inserted: " + i);

	}

}
