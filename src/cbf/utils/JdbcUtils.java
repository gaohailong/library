package cbf.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {

	private JdbcUtils() {
	}

	private static String url;
	private static String user;
	private static String password;

	// 静态代码块读配置文件 注册驱动
	static {
		try {
			Properties props = new Properties();
			InputStream in = JdbcUtils.class.getClassLoader()
					.getResourceAsStream("jdbc.properties");
			props.load(in);

			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");

			// 注册驱动
			String driverClass = props.getProperty("driverClass");
			Class.forName(driverClass);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	// 静态方法获得连接
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	// 静态方法释放资源
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
