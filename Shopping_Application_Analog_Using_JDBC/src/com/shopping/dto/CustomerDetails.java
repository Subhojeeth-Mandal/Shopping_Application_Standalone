package com.shopping.dto;

import java.io.Serializable;

public class CustomerDetails implements Serializable
{
	private int customerID;
	private String customerName;
	private String customerEmailID;
	private long customerMobileNo;
	private String customerAddress;
	private String customerGender;
	private String customerPassword;
	
	public CustomerDetails() {}

	public CustomerDetails(int customerID, String customerName, String customerEmailID, long customerMobileNo,
			String customerAddress, String customerGender) 
	{
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerEmailID = customerEmailID;
		this.customerMobileNo = customerMobileNo;
		this.customerAddress = customerAddress;
		this.customerGender = customerGender;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmailID() {
		return customerEmailID;
	}

	public void setCustomerEmailID(String customerEmailID) {
		this.customerEmailID = customerEmailID;
	}

	public long getCustomerMobileNo() {
		return customerMobileNo;
	}

	public void setCustomerMobileNo(long customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	
	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	public void display()
	{
		System.out.println("Customer ID: "+getCustomerID());
		System.out.println("Customer Name: "+getCustomerName());
		System.out.println("Gender: "+getCustomerGender());
		System.out.println("Email ID: "+getCustomerEmailID());
		System.out.println("Mobile NO: "+getCustomerMobileNo());
		System.out.println("Address: "+getCustomerAddress());
	}
	
	@Override
	public String toString()
	{
		return " Customer ID: "+getCustomerID()+"\n Customer Name: "+getCustomerName()
		      +" \n Email ID: "+getCustomerEmailID()+" \n Mobile NO: "+getCustomerMobileNo()
		      +" \n Address: "+getCustomerAddress()+" \n Gender: "+getCustomerGender();
	}
}
