package model.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceConnection {
	private static Connection conn = null;
	private static DataSource ds;
	
	static{
		Context context;
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/xxx");
		}catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {	
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;		
	}
	
	public static void closeConnection(){
		if (conn!= null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	}
	
}
