package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.bean.StudentBean;
import in.co.rays.util.JDBCDataSource;

public class MarksheetModel {

	public static Integer getNextPk() throws Exception {
		int pk = 0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_marksheet");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = (rs.getInt(1));
		}
		return pk + 1;

	}

	public void add(MarksheetBean bean) throws Exception {

		
		 StudentModel studentModel = new StudentModel(); StudentBean studentBean =
		 studentModel.findByPk(bean.getStudentId());
		 bean.setName(studentBean.getFirstName() +" "+ studentBean.getLastName());
		
		MarksheetBean beanExists = findByRollNo(bean.getRollNo());

		if (beanExists != null) {
			throw new Exception("Roll No already exist");

		}

		int pk = getNextPk();

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_marksheet values(?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getRollNo());

			pstmt.setLong(3, bean.getStudentId());
			pstmt.setString(4, bean.getName());

			pstmt.setInt(5, bean.getPhysics());
			pstmt.setInt(6, bean.getChemistry());
			pstmt.setInt(7, bean.getMaths());
			pstmt.setString(8, bean.getCreatedBy());
			pstmt.setString(9, bean.getModifiedBy());
			pstmt.setTimestamp(10, bean.getCreatedDatetime());
			pstmt.setTimestamp(11, bean.getModifiedDatetime());

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

	public void update(MarksheetBean bean) throws Exception {

		
		  StudentModel studentModel = new StudentModel(); StudentBean studentBean =
		  studentModel.findByPk(bean.getStudentId());
		  bean.setName(studentBean.getFirstName() +" "+ studentBean.getLastName());
		 
		MarksheetBean beanExists = findByRollNo(bean.getRollNo());
		if (beanExists != null && bean.getId() == beanExists.getId()) {

			throw new Exception("Roll No id already exists");

		}

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_marksheet set roll_no = ?, student_id = ?, name = ?, physics = ?, chemistry = ?, maths = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ? ");

			pstmt.setString(1, bean.getRollNo());
			pstmt.setLong(2, bean.getStudentId());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getPhysics());
			pstmt.setInt(5, bean.getChemistry());
			pstmt.setLong(6, bean.getMaths());
			pstmt.setString(7, bean.getCreatedBy());
			pstmt.setString(8, bean.getModifiedBy());
			pstmt.setTimestamp(9, bean.getCreatedDatetime());
			pstmt.setTimestamp(10, bean.getModifiedDatetime());
			pstmt.setLong(11, bean.getId());

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
		PreparedStatement pstmt = conn.prepareStatement("delete from st_marksheet where id = ?");
		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();
		System.out.println("Data Deleted : " + i);

	}

	public MarksheetBean findByPk(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where id = ?");
		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();
		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setStudentId(rs.getLong(3));
			bean.setName(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			bean.setCreatedBy(rs.getString(8));
			bean.setModifiedBy(rs.getString(9));
			bean.setCreatedDatetime(rs.getTimestamp(10));
			bean.setModifiedDatetime(rs.getTimestamp(11));
		}

		return bean;

	}

	public MarksheetBean findByRollNo(String rollNo) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where roll_no = ?");
		pstmt.setString(1, rollNo);

		ResultSet rs = pstmt.executeQuery();
		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setStudentId(rs.getLong(3));
			bean.setName(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			bean.setCreatedBy(rs.getString(8));
			bean.setModifiedBy(rs.getString(9));
			bean.setCreatedDatetime(rs.getTimestamp(10));
			bean.setModifiedDatetime(rs.getTimestamp(11));
		}

		return bean;

	}

	public List search(MarksheetBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_marksheet where 1=1 ");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id =" + bean.getId());
			}
			if (bean.getRollNo() != null) {
				sql.append(" and roll_no like '" + bean.getRollNo() + "%'");
			}
			if (bean.getStudentId() > 0) {
				sql.append(" and student_id =" + bean.getStudentId());
			}
			if (bean.getName() != null) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getPhysics() > 0) {
				sql.append(" and physics =" + bean.getPhysics());
			}
			if (bean.getChemistry() > 0) {
				sql.append(" and chemistry =" + bean.getChemistry());
			}
			if (bean.getMaths() > 0) {
				sql.append(" and maths =" + bean.getMaths());
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
			bean = new MarksheetBean();
			bean.setId(rs.getLong(1));
			bean.setRollNo(rs.getString(2));
			bean.setStudentId(rs.getLong(3));
			bean.setName(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			bean.setCreatedBy(rs.getString(8));
			bean.setModifiedBy(rs.getString(9));
			bean.setCreatedDatetime(rs.getTimestamp(10));
			bean.setModifiedDatetime(rs.getTimestamp(11));

			list.add(bean);
		}

		return list;

	}

}
