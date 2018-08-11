package com.bibek.ems.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static DatabaseConnection conn=new DatabaseConnection();
	
	private DatabaseConnection() {}
	
	public static Connection getInstance() throws SQLException {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/coreemsproject","root","macro32m");
		return conn;
	}
	
	

}
