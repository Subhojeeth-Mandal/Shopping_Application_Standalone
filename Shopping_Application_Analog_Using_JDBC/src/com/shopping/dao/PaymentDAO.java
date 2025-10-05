package com.shopping.dao;

import java.sql.*;

import com.shopping.dto.PaymentDetails;
import com.shopping.util.JDBCConnection;

public class PaymentDAO 
{
	private static final String insert="insert into payment_details(Customer_ID, Product_ID, Payment_Type,"
			+ " Payment_Status, Total_Amount, Payment_Date) values(?,?,?,?,?,?)";
	
	public boolean addPaymentDetails(PaymentDetails paymentDetails)
	{
		try {
			Connection connect=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connect.prepareStatement(insert);
			preparedStatement.setInt(1, paymentDetails.getCustomerID());
			preparedStatement.setInt(2, paymentDetails.getProductID());
			preparedStatement.setString(3, paymentDetails.getPaymentType());
			preparedStatement.setString(4, paymentDetails.getPaymentStatus());
			preparedStatement.setDouble(5, paymentDetails.getTotalAmount());
			preparedStatement.setDate(6, Date.valueOf(paymentDetails.getPaymentDate()));
			int result=preparedStatement.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
