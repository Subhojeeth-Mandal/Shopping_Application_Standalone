package com.shopping.service;

import java.util.Scanner;

import com.shopping.dao.AdminDAO;

public class AdminService 
{
	Scanner scanner=new Scanner(System.in);
	AdminDAO admin=new AdminDAO();
	public void AdminLogin()
	{
		System.out.println("Enter the Admin EmailID");
		String adminID=scanner.next();
		System.out.println("Enter the Password");
		String password=scanner.next();
		if(admin.selectAdminDetails(adminID, password))
		{
			System.out.println("Admin Login SuccessFull.....");
			System.out.println("Welcome Sir/Madam....");
			ProductService product=new ProductService();
			boolean condn=true;
			while (condn) 
			{
				System.out.println();
				System.out.println("Please Select a Option\n1.Add Product \n2.Add product Based On Brand Name"
						+ "\n3.Modify Product Details \n4.Remove Product"
						+ "\n5.Display Products \n6.Logout");
				int option=scanner.nextInt();
				switch (option) {
				case 1:
					product.storeProductDetails();
					break;
				case 2:
					//enter first product details
					product.addProductsBasedOnBrand();
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					product.getProductDetails();
					break;
				case 6:
					System.out.println("You have Logged Out Successfully...");
					condn=false;
					break;
				default:
					System.out.println("Please Choose Valid Option!!!!");
					break;
				}
			}
		}
		else
			System.err.println("Admin Login Failed...");
	}
}
