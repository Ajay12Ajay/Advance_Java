package in.com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.com.rays.bean.CollegeBean;
import in.com.rays.bean.CourseBean;
import in.com.rays.bean.SubjectBean;
import in.com.rays.util.JDBCDataSource;

public class CourseModel {

	public static Integer getNextPk() throws Exception {
		int pk = 0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_course");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = (rs.getInt(1));
		}
		return pk + 1;

	}

	public void add(CourseBean bean) throws Exception {

		CourseBean beanExists = findByName(bean.getName());

		if (beanExists != null) {
			throw new Exception("Name already exist");

		}

		int pk = getNextPk();

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_course values(?,?,?,?,?,?,?,?)");

			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDuration());
			pstmt.setString(4, bean.getDescription());
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());

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

	public void update(CourseBean bean) throws Exception {

		CourseBean beanExists = findByName(bean.getName());
		if (beanExists != null && bean.getId() == beanExists.getId()) {

			throw new Exception("Name id already exists");

		}

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_course set name = ?, duration = ?, description = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ? ");

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getDuration());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getCreatedBy());
			pstmt.setString(5, bean.getModifiedBy());
			pstmt.setTimestamp(6, bean.getCreatedDatetime());
			pstmt.setTimestamp(7, bean.getModifiedDatetime());
			pstmt.setLong(8, bean.getId());

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
		PreparedStatement pstmt = conn.prepareStatement("delete from st_course where id = ?");
		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();
		System.out.println("Data Deleted : " + i);

	}

	public CourseBean findByPk(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_course where id = ?");
		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();
		CourseBean bean = null;

		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));
		}

		return bean;

	}

	public CourseBean findByName(String name) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_course where name = ?");
		pstmt.setString(1, name);

		ResultSet rs = pstmt.executeQuery();
		CourseBean bean = null;

		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));
		}

		return bean;

	}

	public List search(CourseBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_course where 1=1 ");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id =" + bean.getId());
			}
			if (bean.getName() != null) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getDuration() != null) {
				sql.append(" and duration like '" + bean.getDuration() + "%'");
			}
			if (bean.getDescription() != null) {
				sql.append(" and description like '" + bean.getDescription() + "%'");
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
			bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));

			list.add(bean);
		}

		return list;

	}

}
