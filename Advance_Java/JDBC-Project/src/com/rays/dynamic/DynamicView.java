package com.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicView {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// read1();
		// read2();
		 read3(0, 0, "ri", 0, 0, 0);

		MarksheetBean bean = new MarksheetBean();
		bean.setId(5);
		bean.setRoll_no(106);
		// bean.setName("");
		// bean.setPhysics();
		// bean.setChemistry();
		// bean.setMaths();

		// read4(bean);
		// read5(bean);
		//read6(bean, 1, 2);
	}

	public static void read1() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));

		}

	}

	public static void read2() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		// String sql = "select * from marksheet where id = 1";
		// String sql = "select * from marksheet where roll_no = 101";
		// String sql = "select * from marksheet where name = 'abc'";
		String sql = "select * from marksheet where physics = 78";
		// String sql = "select * from marksheet where chemistry = 88";
		// String sql = "select * from marksheet where maths = 89";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));

		}

	}

	public static void read3(int id, int roll_no, String name, int physics, int chemistry, int maths)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		String sql = "select * from marksheet ";

		if (id > 0) {
			sql = sql + "where id = " + id;

		}
		if (roll_no > 0) {
			sql = sql + "where id = " + roll_no;
		}
		if (name != null) {
			sql = sql + "where name  like  '" + name + "%'";
		}
		if (physics > 0) {
			sql = sql + "where physics = " + physics;
		}

		if (chemistry > 0) {
			sql = sql + "where chemistry = " + chemistry;
		}
		if (maths > 0) {
			sql = sql + "where maths = " + maths;
		}

		System.out.println(sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));

		}

	}

	public static void read4(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1 ");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append("and id = " + bean.getId());

			}
			if (bean.getRoll_no() > 0) {
				sql.append(" with roll_no = " + bean.getRoll_no());
			}
			if (bean.getName() != null) {
				sql.append("and name = '" + bean.getName() + "'");
			}
			if (bean.getPhysics() > 0) {
				sql.append("and physics = " + bean.getPhysics());
			}

			if (bean.getChemistry() > 0) {
				sql.append("and chemistry = " + bean.getChemistry());
			}
			if (bean.getMaths() > 0) {
				sql.append("and maths = " + bean.getMaths());
			}
		}

		System.out.println("sql = >" + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));

		}

	}

	public static void read5(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1 ");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getRoll_no() > 0) {
				sql.append(" and roll_no = " + bean.getRoll_no());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append("and name = '" + bean.getName() + "'");
			}
			if (bean.getPhysics() > 0) {
				sql.append("and physics = " + bean.getPhysics());
			}
			if (bean.getChemistry() > 0) {
				sql.append(" and chemistry = " + bean.getChemistry());
			}
			if (bean.getMaths() > 0) {
				sql.append(" and maths = " + bean.getMaths());
			}

		}

		System.out.println("sql = >" + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));

		}

	}

	public static void read6(MarksheetBean bean, int pageNo, int pageSize) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1 "); // here 1=1 is sql injection

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getRoll_no() > 0) {
				sql.append(" and roll_no = " + bean.getRoll_no());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append("and name = '" + bean.getName() + "'");
			}
			if (bean.getPhysics() > 0) {
				sql.append("and physics = " + bean.getPhysics());
			}
			if (bean.getChemistry() > 0) {
				sql.append(" and chemistry = " + bean.getChemistry());
			}
			if (bean.getMaths() > 0) {
				sql.append(" and maths = " + bean.getMaths());
			}

		}

		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);

		}

		System.out.println("sql = >" + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

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
