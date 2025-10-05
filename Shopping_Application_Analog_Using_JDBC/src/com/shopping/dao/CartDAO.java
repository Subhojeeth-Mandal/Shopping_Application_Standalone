package com.shopping.dao;

import java.sql.*;
import java.util.ArrayList;

import com.shopping.dto.CartDetails;
import com.shopping.util.JDBCConnection;

public class CartDAO 
{
	private static final String insert_cart_details=" insert into cart_details(Product_ID, Customer_ID, Product_Quantity) values(?,?,?)";
	private static final String select_all_cart_Details_using_customerID="select * from cart_details where Customer_ID=?";
	
	public boolean insertCartDetails(CartDetails cartDetails)
	{
		try {
			Connection connect=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connect.prepareStatement(insert_cart_details);
			preparedStatement.setInt(1, cartDetails.getProductID());
			preparedStatement.setInt(2, cartDetails.getCustomerID());
			preparedStatement.setInt(3, cartDetails.getProductQuantity());
			int result=preparedStatement.executeUpdate();
			if(result>0)
				return true;
			return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<CartDetails> selectCartUsingCustomerID(int customerID)
	{
		try {
			Connection connect=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connect.prepareStatement(select_all_cart_Details_using_customerID);
			preparedStatement.setInt(1, customerID);
			ResultSet result=preparedStatement.executeQuery();
			ArrayList<CartDetails> listOfCartItems=new ArrayList<CartDetails>();
			if(result.isBeforeFirst())
			{
				while(result.next())
				{
					CartDetails cartDetails=new CartDetails();
					cartDetails.setCustomerID(result.getInt("Customer_ID"));
					cartDetails.setProductID(result.getInt("Product_ID"));
					cartDetails.setProductQuantity(result.getInt("Product_Quantity"));
					listOfCartItems.add(cartDetails);
				}
				return listOfCartItems;
			}
			return null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
