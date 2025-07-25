package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {

	public static Integer getNextPk() throws Exception {
		int pk = 0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = (rs.getInt(1));
		}
		return pk + 1;

	}

	public void add(UserBean bean) throws Exception {

		UserBean beanExists = findByLoginId(bean.getLogin());

		if (beanExists != null) {
			throw new Exception("Login id already exist");

		}

		int pk = getNextPk();

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setLong(8, bean.getRoleId());
			pstmt.setString(9, bean.getGender());
			pstmt.setString(10, bean.getCreatedBy());
			pstmt.setString(11, bean.getModifiedBy());
			pstmt.setTimestamp(12, bean.getCreatedDatetime());
			pstmt.setTimestamp(13, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();
			System.out.println("Data Inserted : " + i);

			conn.commit();
		} catch (Exception e) {

			conn.rollback();
			System.out.println(e.getMessage());

		} finally {
			conn.close();

		}

	}

	public void update(UserBean bean) throws Exception {

		UserBean beanExists = findByLoginId(bean.getLogin());
		if (beanExists != null && bean.getId() == beanExists.getId()) {

			throw new Exception("Login Id id already exists");

		}

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_user set first_name = ?, last_name = ?, login = ?, password = ?, dob = ?, mobile_no = ?, role_id = ?, gender = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ? ");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setLong(7, bean.getRoleId());
			pstmt.setString(8, bean.getGender());
			pstmt.setString(9, bean.getCreatedBy());
			pstmt.setString(10, bean.getModifiedBy());
			pstmt.setTimestamp(11, bean.getCreatedDatetime());
			pstmt.setTimestamp(12, bean.getModifiedDatetime());
			pstmt.setLong(13, bean.getId());

			int i = pstmt.executeUpdate();
			System.out.println("Data Updated : " + i);

			conn.commit();
		} catch (Exception e) {

			conn.rollback();
			System.out.println(e.getMessage());

		} finally {
			conn.close();

		}

	}

	public void delete(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");
		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();
		System.out.println("Data Deleted : " + i);

	}

	public UserBean findByPk(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ?");
		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setMobileNo(rs.getString(7));
			bean.setRoleId(rs.getLong(8));
			bean.setGender(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));
		}

		return bean;

	}

	public UserBean findByLoginId(String loginId) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ?");
		pstmt.setString(1, loginId);

		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setMobileNo(rs.getString(7));
			bean.setRoleId(rs.getLong(8));
			bean.setGender(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));
		}

		return null;

	}

	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1 ");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id =" + bean.getId());
			}
			if (bean.getFirstName() != null) {
				sql.append(" and first_name like '" + bean.getFirstName() + "%'");
			}
			if (bean.getLastName() != null) {
				sql.append(" and last_name like '" + bean.getLastName() + "%'");
			}
			if (bean.getLogin() != null) {
				sql.append(" and login like '" + bean.getLogin() + "%'");
			}
			if (bean.getPassword() != null) {
				sql.append(" and password like '" + bean.getPassword() + "%'");
			}
			if (bean.getDob() != null) {
				sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
			}
			if (bean.getMobileNo() != null) {
				sql.append(" and mobile_no like '" + bean.getMobileNo() + "%'");
			}
			if (bean.getRoleId() > 0) {
				sql.append(" and role_id =" + bean.getRoleId());
			}
			if (bean.getGender() != null) {
				sql.append(" and gender like '" + bean.getGender() + "%'");
			}
			if (bean.getCreatedBy() != null) {
				sql.append(" and created_by like '" + bean.getCreatedBy() + "%'");
			}
			if (bean.getModifiedBy() != null) {
				sql.append(" and modified_by like '" + bean.getModifiedBy() + "%'");
			}
			if (bean.getCreatedDatetime() != null) {
				sql.append(" and created_datetime like '" + bean.getCreatedDatetime() + "%'");
			}
			if (bean.getModifiedDatetime() != null) {
				sql.append(" and modified_by like '" + bean.getModifiedDatetime() + "%'");
			}

		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setMobileNo(rs.getString(7));
			bean.setRoleId(rs.getLong(8));
			bean.setGender(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));

			list.add(bean);
		}

		return list;

	}

}
