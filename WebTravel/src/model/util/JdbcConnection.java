package model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	private static final String URL = "jdbc:sqlserver://ypu6zibdg7.database.windows.net:1433;database=travel";
	private static final String USERNAME = "webtraveldb@ypu6zibdg7";
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
