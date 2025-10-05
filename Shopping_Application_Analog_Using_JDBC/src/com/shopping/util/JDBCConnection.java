package com.shopping.util;

import java.sql.*;

public class JDBCConnection 
{
	public static Connection mySQLConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce_database?user=root&password=root");
	}
}

