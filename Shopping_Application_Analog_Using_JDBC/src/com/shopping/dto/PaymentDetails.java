package com.shopping.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PaymentDetails implements Serializable
{
	private int paymentID;
	private int customerID;
	private int productID;
	private String paymentType;
	private String paymentStatus;
	private double totalAmount;
	private LocalDate paymentDate;
	
	public PaymentDetails() {}

	public PaymentDetails(int paymentID, int customerID, int productID, String paymentType, String paymentStatus,
			int totalAmount, LocalDate paymentDate) 
	{
		this.paymentID = paymentID;
		this.customerID = customerID;
		this.productID = productID;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.totalAmount = totalAmount;
		this.paymentDate = paymentDate;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
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

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public void display()
	{
		System.out.println("Payment ID: "+getPaymentID());
		System.out.println("Customer ID: "+getCustomerID());
		System.out.println("Product ID: "+getProductID());
		System.out.println("Payment Type: "+getPaymentType());
		System.out.println("Payment Status: "+getPaymentStatus());
		System.out.println("Total Amount: "+getTotalAmount());
		System.out.println("Payment Date: "+getPaymentDate());
	}
	
	@Override
	public String toString()
	{
		return " Payment ID: "+getPaymentID()+"\n Customer ID: "+getCustomerID()
		      +" \n Product ID: "+getProductID()+" \n Payment Type: "+getPaymentType()
		      +" \n Payment Status: "+getPaymentStatus()+" \n Total Amount: "+getTotalAmount()
		      +" \n Payment Date: "+getPaymentDate();
	}
}
