package com.shopping.dao;

import java.sql.*;

import com.shopping.util.JDBCConnection;

public class AdminDAO 
{
	private static final String select_Admin_Details="select * from admin where Admin_EmailID=? and Admin_Password=?";
	
	public boolean selectAdminDetails(String emailID, String password)
	{
		try {
			Connection connect=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connect.prepareStatement(select_Admin_Details);
			preparedStatement.setString(1, emailID);
			preparedStatement.setString(2, password);
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
				return true;
			return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
