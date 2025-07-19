package com.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicRead {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MarksheetBean bean = new MarksheetBean();

		read(bean, 3, 2);

	}

	public static void read(MarksheetBean bean, int pageNo, int pageSize) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1 ");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append("and id = " + bean.getId());
			}
			if (bean.getRoll_no() > 0) {
				sql.append(" and roll_no = " + bean.getRoll_no());
			}
			if (bean.getName() != null) {
				sql.append("and name like ' " + bean.getName() + "'%");
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

		System.out.println("sql => " + sql);

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
