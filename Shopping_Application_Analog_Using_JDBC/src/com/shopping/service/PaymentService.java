package com.shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.shopping.dao.PaymentDAO;
import com.shopping.dto.PaymentDetails;

public class PaymentService 
{
	Scanner scanner=new Scanner(System.in);
	PaymentDAO paymentDAO=new PaymentDAO();
	public void paymentProcessDetails(int cID,double amount, int productID, int quantity, String address)
	{
		PaymentDetails paymentDetails=new PaymentDetails();
		System.out.println("Enter \n1.UPI Payment \n2.Cash On Delivery \n3.Debit Card \n4.Net Banking \n5.EMI");
		switch (scanner.nextInt()) {
		case 1:
			paymentDetails.setPaymentType("UPI");
			paymentDetails.setPaymentStatus("Payment Successful");
			break;
		case 2:
			paymentDetails.setPaymentType("Cash on Delivery");
			paymentDetails.setPaymentStatus("under Processing");
			break;
		case 3:
			paymentDetails.setPaymentType("Debit Card");
			paymentDetails.setPaymentStatus("Payment Successful");
			break;
		case 4:
			paymentDetails.setPaymentType("Net Banking");
			paymentDetails.setPaymentStatus("Payment Successful");
			break;
		case 5:
			paymentDetails.setPaymentType("EMI");
			paymentDetails.setPaymentStatus("Under Processing");
			break;
		default:
			break;
		}
		System.out.println("Enter the Amount");
		double userAmount=scanner.nextDouble();
		if(userAmount==amount)
		{
			paymentDetails.setCustomerID(cID);
			paymentDetails.setPaymentDate(LocalDate.now());
			paymentDetails.setProductID(productID);
			paymentDetails.setTotalAmount(amount);
			if(paymentDAO.addPaymentDetails(paymentDetails))
			{
				System.out.println("Payment Sucessfull..");
				System.out.println("----------------------");
				System.out.println("Payment Receipt");
				paymentDetails.display();
				System.out.println("Order Placed Successfully...");
				OrderService orderService=new OrderService();
				orderService.orderProcessDetails(cID, productID, quantity, address);
			}
			else
				System.out.println("Payment Failed...");
		}
		else
			System.err.println("Please Enter the Amount to be Paid");
	}
}
