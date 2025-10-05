package com.shopping.main;

import java.util.Scanner;

import com.shopping.service.AdminService;
import com.shopping.service.CustomerService;
import com.shopping.util.DisplayMessage;

public class Driver 
{
	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		CustomerService customerservice=new CustomerService();
		AdminService admin=new AdminService();
		String welcome="----------Welcome To A14 Shopping-------------";
		String thanks="Thank you Visit Again...😊😊😊";
		DisplayMessage.getMessage(welcome);
		System.out.println();
		boolean exit=true;
		while(exit)
		{
			System.out.println("Please Proceed With These Options \n1.Admin Login \n2.Customer Registration \n3.Customer Login \n4.Exit");
			switch (scan.nextInt()) 
			{
			case 1:
				System.out.println("Admin Login Page...");
				admin.AdminLogin();
				break;
			case 2:
				System.out.println("Customer Registration...");
				customerservice.customerRegistration();
				break;
			case 3:
				System.out.println("Customer Login Page...");
				customerservice.customerLogin();
				break;
			case 4:
				DisplayMessage.getMessage(thanks);
				exit=false;
				break;
			default:
				System.out.println("Choose a Valid Option...");
				break;
			}
			System.out.println("Do you want to Continue 😊😊😊 \nEnter Yes/No");
			if(scan.next().equalsIgnoreCase("no"))
			{
				exit=false;
				DisplayMessage.getMessage(thanks);
			}
			System.out.println();
		}
	}
}

