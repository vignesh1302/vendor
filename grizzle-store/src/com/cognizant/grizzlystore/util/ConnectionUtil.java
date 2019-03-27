package com.cognizant.grizzlystore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


	public class ConnectionUtil 
	{
		public static Connection getConnection() throws ClassNotFoundException, SQLException 
		{
			
			Connection connObj=null;
			Class.forName("com.mysql.jdbc.Driver");
			connObj=DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlystore", "root", "root");
			return connObj;
		}
	}
