package model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	private static final String URL = "jdbc:sqlserver://eow035yl2w.database.windows.net:1433;database=travel";
	private static final String USERNAME = "webtraveldb";
	private static final String PASSWORD = "@sapassw0rd";
	private static Connection conn = null;
	
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(){
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	}
}
