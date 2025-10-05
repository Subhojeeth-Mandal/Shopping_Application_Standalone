package com.shopping.dto;

import java.io.Serializable;

public class CartDetails implements Serializable
{
	private int cartID;
	private int productID;
	private int customerID;
	private int productQuantity;
	
	public CartDetails() {}

	public CartDetails(int cartID, int productID, int customerID, int productQuantity) 
	{
		this.cartID = cartID;
		this.productID = productID;
		this.customerID = customerID;
		this.productQuantity = productQuantity;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	public void display()
	{
		System.out.println("Cart ID: "+getCartID());
		System.out.println("Product ID: "+getProductID());
		System.out.println("Customer ID: "+getCustomerID());
		System.out.println("Product Quantity: "+getProductQuantity());
	}
	
	@Override
	public String toString()
	{
		return " Cart ID: "+getCartID()+"\n Product ID: "+getProductID()
		      +" \n Customer ID: "+getCustomerID()+" \n Product Quantity: "+getProductQuantity();
	}
}
