package com.shopping.dao;

import java.sql.*;

import com.shopping.dto.OrderDetails;
import com.shopping.util.JDBCConnection;

public class OrderDAO 
{
	private static final String insert="insert into order_details(Customer_ID, Product_ID, Product_Quantity"
			+ ", Order_Address, Order_Date) values(?,?,?,?,?)";
	
	public boolean addOrderDetails(OrderDetails orderDetails)
	{
		try {
			Connection connection=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setInt(1, orderDetails.getCustomerID());
			preparedStatement.setInt(2, orderDetails.getProductID());
			preparedStatement.setInt(3, orderDetails.getProductQuantity());
			preparedStatement.setString(4, orderDetails.getOrderAddress());
			preparedStatement.setDate(5, Date.valueOf(orderDetails.getOrderDate()));
			int result=preparedStatement.executeUpdate();
			if(result>0)
				return true;
			return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
