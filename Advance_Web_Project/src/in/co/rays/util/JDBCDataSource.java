package in.co.rays.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCDataSource {

	private static JDBCDataSource jds = null;
	private static ComboPooledDataSource cpds = null;
	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");

	private JDBCDataSource() {
		try {
//			cpds = new ComboPooledDataSource();
//			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
//			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/project_1 ");
//			cpds.setUser("root");
//			cpds.setPassword("root");
//			cpds.setInitialPoolSize(5);
//			cpds.setAcquireIncrement(5);
//			cpds.setMaxPoolSize(30);
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass(rb.getString("driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("username"));
			cpds.setPassword(rb.getString("password"));
			cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialpoolsize")));
			cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireincrement")));
			cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxpoolsize")));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static JDBCDataSource getInstance() {
		if (jds == null) {
			jds = new JDBCDataSource();
		}

		return jds;

	}

	public static Connection getConnection() throws Exception {

		return getInstance().cpds.getConnection();
	}

	public static void closeConnection(Connection c, PreparedStatement pstmt) throws Exception {
		if (c != null) {
			c.close();
		}

		if (pstmt != null) {
			pstmt.close();
		}

	}

	public static void closeConnection(Connection c, PreparedStatement pstmt, ResultSet rs) throws Exception {
		if (rs != null) {
			rs.close();
		}

	}

}
