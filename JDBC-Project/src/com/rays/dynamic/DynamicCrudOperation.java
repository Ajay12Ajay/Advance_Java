package com.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicCrudOperation {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		MarksheetBean bean = new MarksheetBean();

		// bean.setId(6);
		// bean.setRoll_no(107);
		// bean.setName("riya");
		// bean.setPhysics(98);
		// bean.setChemistry(99);
		// bean.setMaths(97);

		// insert(bean);

		// update(bean);

		// delete(bean);

		read(null, 2, 3);

	}

	public static void insert(MarksheetBean bean) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values (?,?,?,?,?,?)");
		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRoll_no());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println("Data inserted : " + 1);

	}

	public static void update(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update marksheet set name = ? where id = ? ");

		pstmt.setString(1, bean.getName());
		pstmt.setInt(2, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Data updated : " + i);

	}

	public static void delete(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ? ");
		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Data deleted : " + i);

	}

	public static void read(MarksheetBean bean, int pageNo, int pageSize) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1 ");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id  = " + bean.getId());
			}

			if (bean.getRoll_no() > 0) {
				sql.append("and roll_no = " + bean.getRoll_no());
			}
			if (bean.getName() != null) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getPhysics() > 0) {
				sql.append(" and physics = " + bean.getPhysics());
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

		System.out.println(" sql => " + sql);

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
