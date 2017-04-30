package xzx.core.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DatabaseConn implements Serializable {
	private static String user = null;
	private static String password = null;
	private static String url = null;
	private Statement stmt = null;
	ResultSet rs = null;
	private Connection conn = null;
	String sql;

	public DatabaseConn() {
	}
    
	@Test
	public void OpenConn() throws Exception {
		try {
			url="jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8";
			user="root";
			password="root";
			Driver driver = new com.mysql.jdbc.Driver();
			//Driver driver2 = new com.oracle.jdbc.Driver();
			//1.注册驱动程序(可以注册多个驱动程序)
			DriverManager.registerDriver(driver);
			//2.连接到具体的数据库
		    conn = DriverManager.getConnection(url, user, password);
		    System.out.println(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQuery(String sql) {
		System.out.println(sql);
		stmt = null;
		rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			//System.out.println("-----"+rs);
		} catch (SQLException e) {
			System.err.println("查询数据:" + e.getMessage());
		}
		return rs;
	}

	public void executeUpdate(String sql) {
		System.out.println(sql);
		stmt = null;
		rs = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("更新数据:" + e.getMessage());
		}
	}

	public void closeStmt() {
		System.out.println(stmt);
		try {
			stmt.close();
		} catch (SQLException e) {
			System.err.println("释放对象:" + e.getMessage());
		}
	}

	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException ex) {
			System.err.println("释放对象:" + ex.getMessage());
		}
	}

	public static String toGBK(String str) {
		try {
			if (str == null)
				str = null;
			else
				str = new String(str.getBytes("ISO-8859-1"), "GBK");
		} catch (Exception e) {
			System.out.println(e);
		}
		return str;
	}
}
