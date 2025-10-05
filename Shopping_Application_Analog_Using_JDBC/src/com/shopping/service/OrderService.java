package com.shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.shopping.dao.OrderDAO;
import com.shopping.dto.OrderDetails;

public class OrderService 
{
	Scanner scanner=new Scanner(System.in);
	OrderDAO orderDAO=new OrderDAO();
	
	public void orderProcessDetails(int cID,int pID, int quantity, String address)
	{
		OrderDetails orderDetails=new OrderDetails();
		System.out.println("Select Address to Deliver the Product..");
		System.out.println("1. "+address);
		System.out.println("2. Change Address");
		String newAddress="";
		switch (scanner.nextInt()) {
		case 1:
			newAddress=address;
			break;
		case 2:
			System.out.println("Please Enter Your Address For Product Delivery....");
			newAddress=scanner.next();
			break;
		default:
			System.out.println("Please Enter Valid options");
			break;
		}
		orderDetails.setCustomerID(cID);
		orderDetails.setProductID(pID);
		orderDetails.setProductQuantity(quantity);
		orderDetails.setOrderAddress(newAddress);
		orderDetails.setOrderDate(LocalDate.now());
		if(orderDAO.addOrderDetails(orderDetails))
			System.out.println("Thankyou...\nYour Order Will be Delivered to "+newAddress+" Very Soon");

			
	}
}
