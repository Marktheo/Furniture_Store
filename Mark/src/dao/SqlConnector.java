package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class SqlConnector {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String user = "root";
			String password = "function";
			String url = "jdbc:mysql://localhost:3306/markbase?verifyServerCertificate=false&useSSL=true";
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			System.out.println("Successfull Connection.");
			
			return connection;
			
		} catch (Exception e) {
			
			System.out.println("Unsuccessfull Connection.");
			
			System.out.println(e);
			
			return null;
		}
	}
}