package com.shopping.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class OrderDetails implements Serializable
{
	private int orderID;
	private int customerID;
	private int productID;
	private int productQuantity;
	private String orderAddress;
	private LocalDate orderDate;
	
	public OrderDetails() {}

	public OrderDetails(int orderID, int customerID, int productID, int productQuantity, String orderAddress,
			LocalDate orderDate) 
	{
		this.orderID = orderID;
		this.customerID = customerID;
		this.productID = productID;
		this.productQuantity = productQuantity;
		this.orderAddress = orderAddress;
		this.orderDate = orderDate;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	public void display()
	{
		System.out.println("Order ID: "+getOrderID());
		System.out.println("Customer ID: "+getCustomerID());
		System.out.println("Product ID: "+getProductID());
		System.out.println("Product Quantity: "+getProductQuantity());
		System.out.println("Order Address: "+getOrderAddress());
		System.out.println("Order Date: "+getOrderDate());
	}
	
	@Override
	public String toString()
	{
		return " Order ID: "+getOrderID()+"\n Customer ID: "+getCustomerID()
		      +" \n Product ID: "+getProductID()+" \n Product Quantity: "+getProductQuantity()
		      +" \n Order Address: "+getOrderAddress()+" \n Order Date: "+getOrderDate();
	}
}
