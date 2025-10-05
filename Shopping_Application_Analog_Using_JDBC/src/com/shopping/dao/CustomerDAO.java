package com.shopping.dao;

import java.sql.*;
import java.util.ArrayList;

import com.shopping.dto.CustomerDetails;
import com.shopping.util.JDBCConnection;

public class CustomerDAO 
{
	private static final String insert="insert into customer_details(Customer_Name, Customer_EmailID,"
			+ " Customer_Mobile_No, Customer_Address, Customer_Gender,Customer_Password) values (?,?,?,?,?,?)";
	private static final String select_all_customers="select * from customer_details";
	private static final String customerLogin="select * from customer_details where (Customer_EmailID=? or Customer_Mobile_No=?) and Customer_Password=?";
	public boolean insertCustomerDetails(CustomerDetails customerDetails)
	{
		try {
			Connection connection=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setString(1, customerDetails.getCustomerName());
			preparedStatement.setString(2, customerDetails.getCustomerEmailID());
			preparedStatement.setLong(3, customerDetails.getCustomerMobileNo());
			preparedStatement.setString(4, customerDetails.getCustomerAddress());
			preparedStatement.setString(5, customerDetails.getCustomerGender());
			preparedStatement.setString(6, customerDetails.getCustomerPassword());
			int result=preparedStatement.executeUpdate();
			if(result>0)
				return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<CustomerDetails> selectAllCustomerDetails()
	{
		try {
			Connection connection=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(select_all_customers);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			ArrayList<CustomerDetails> listOfCustomers= new ArrayList<CustomerDetails>();
			while(resultSet.next())
			{
				CustomerDetails customerDetails= new CustomerDetails();
				customerDetails.setCustomerEmailID(resultSet.getString("Customer_EmailID"));
				customerDetails.setCustomerMobileNo(resultSet.getLong("Customer_Mobile_No"));
				customerDetails.setCustomerPassword(resultSet.getString("Customer_Password"));
				listOfCustomers.add(customerDetails);
			}
			return listOfCustomers;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public CustomerDetails selectCustomerDetailsByUsingEmailOrMobileNOAndPassword(String emailIdOrMobileNo, String password)
	{
		try {
			Connection connection=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(customerLogin);
			preparedStatement.setString(1, emailIdOrMobileNo);
			preparedStatement.setString(2, emailIdOrMobileNo);
			preparedStatement.setString(3, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				CustomerDetails customer= new CustomerDetails();
				customer.setCustomerID(resultSet.getInt("Customer_ID"));
				customer.setCustomerEmailID(resultSet.getString("Customer_EmailID"));
				customer.setCustomerMobileNo(resultSet.getLong("Customer_Mobile_No"));
				customer.setCustomerGender(resultSet.getString("Customer_Gender"));
				customer.setCustomerPassword(resultSet.getString("Customer_Password"));
				customer.setCustomerName(resultSet.getString("Customer_Name"));
				customer.setCustomerAddress(resultSet.getString("Customer_Address"));
				return customer;
//				if(resultSet.getString("Customer_Gender").equalsIgnoreCase("Male"))
//					System.out.println("Login Successfull.....\nHello Mr."+resultSet.getString("Customer_Name")+".... Welcome 😊😊");
//				else
//					System.out.println("Login Successfull.....\nHello Miss."+resultSet.getString("Customer_Name")+".... Welcome 😊😊");
			}
			else
				return null;
//				System.err.println("Invalid UserID And Password...");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
