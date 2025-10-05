package com.shopping.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.shopping.dao.CustomerDAO;
import com.shopping.dao.ProductDAO;
import com.shopping.dto.CartDetails;
import com.shopping.dto.CustomerDetails;
import com.shopping.dto.ProductDetails;
import com.shopping.exception.CustomerDataInvalidException;

public class CustomerService 
{
	Scanner scanner=new Scanner(System.in);
	CustomerDetails customerDetails;
	CartService cartservice= new CartService();
	CustomerDAO customerDAO=new CustomerDAO();
	ProductDAO productDAO=new ProductDAO();
	public void customerRegistration()
	{
		
		ArrayList<CustomerDetails> listOfCustomers=customerDAO.selectAllCustomerDetails();
		System.out.println("Enter Customer Name");
		String cName=scanner.next();
		System.out.println("Enter Customer EmailID");
		while(true)
		{
			String cEmailID=scanner.next();
			String emailID=cEmailID;
			try {
				if(!cEmailID.contains("@gmail.com"))
					throw new CustomerDataInvalidException("Invalid EmailID!!!");
				long emailCount=listOfCustomers.stream().filter((customer)->customer.getCustomerEmailID().equals(emailID)).count();
				if(emailCount>0)
					throw new CustomerDataInvalidException("EmailID Already Existed");
				else {
					customerDetails.setCustomerEmailID(cEmailID);
					break;
				}
			}
			catch(CustomerDataInvalidException e) {
				System.out.println(e.getMessage());
				System.out.println("Please Enter Valid EmailId...");
				cEmailID=scanner.next();
			}
		}
		System.out.println("Enter Customer Mobile Number");
		while(true)
		{
			long cMobileNo=scanner.nextLong();
			long mobileNumber=cMobileNo;
			try {
				if(!(cMobileNo>6000000000l && cMobileNo<=9999999999l))
					throw new CustomerDataInvalidException("Invalid Mobile Number....");
				long mobileCount=listOfCustomers.stream().filter((customer)->customer.getCustomerMobileNo()==mobileNumber).count();
				if(mobileCount>0)
					throw new CustomerDataInvalidException("Customer Mobile Number Already Existed");
				
				else {
					customerDetails.setCustomerMobileNo(cMobileNo);
					break;
				}
			}
			catch(CustomerDataInvalidException e) {
				System.out.println(e.getMessage());
				System.out.println("Please Enter Valid Mobile Number..");
				cMobileNo=scanner.nextLong();
			}
		}
		System.out.println("Enter the Customer Address");
		String cAddress=scanner.next();
		System.out.println("Enter the Customer Gender...");
		String cGender=scanner.next();
		while(true)
		{
			try {
				if(!(cGender.equalsIgnoreCase("Male")|| cGender.equalsIgnoreCase("Female")))
					throw new CustomerDataInvalidException("Invalid Gender");
				else {
					customerDetails.setCustomerGender(cGender);
					break;
				}
			}
			catch(CustomerDataInvalidException e) {
				System.out.println(e.getMessage());
				cGender=scanner.next();
			}
		}
		System.out.println("Enter the Password");
		while(true)
		{
			String cPassword=scanner.next();
			String password=cPassword;
			try {
				if(!((cPassword.charAt(0)>='A' || cPassword.charAt(0)<='Z') && (cPassword.contains("@") || cPassword.contains("!")|| cPassword.contains("*")) && (cPassword.length()>10)))
						throw new CustomerDataInvalidException("Invalid Password");
				Long passwordCount=listOfCustomers.stream().filter((customer)->customer.getCustomerPassword().equals(password)).count();
				if(passwordCount>0)
					throw new CustomerDataInvalidException("Password Already Exists");
				else {
					customerDetails.setCustomerPassword(cPassword);
					break;
				}
			}
			catch(CustomerDataInvalidException e) {
				System.out.println(e.getMessage());
				cPassword=scanner.next();
			}
		}
		customerDetails.setCustomerName(cName);
		customerDetails.setCustomerAddress(cAddress);
		if(customerDAO.insertCustomerDetails(customerDetails))
			System.out.println("Customer Registration Successfull....");
		else
			System.err.println("Customer Registration Failed...");
	}
	
	public void customerLogin()
	{
		System.out.println("Enter Customer EmailID or Mobile Number");
		String emailOrMobileNO=scanner.next();
		System.out.println("Enter Your Password");
		String password=scanner.next();
	    customerDetails=customerDAO.selectCustomerDetailsByUsingEmailOrMobileNOAndPassword(emailOrMobileNO, password);
		if(customerDetails!=null)
		{
			if(customerDetails.getCustomerGender().equalsIgnoreCase("Male"))
				System.out.println("Login Successfull.....\nHello Mr."+customerDetails.getCustomerName()+".... Welcome 😊😊");
			else
				System.out.println("Login Successfull.....\nHello Miss."+customerDetails.getCustomerName()+".... Welcome 😊😊");
			customerOperations();
		}
		else
			System.err.println("Invalid UserID And Password...");
	}
	public void customerOperations()
	{
		boolean logout=true;
		while (logout) {
			System.out.println("Please Enter Your Choice \n1.Display All Product Details \n2.Display Cart Details "
					+ " \n3.Display Order Details \n4.Log Out");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:
				ArrayList<ProductDetails> productDetails=productDAO.displayAllProducts();
				System.out.println();
				int i=1;
				for(ProductDetails products: productDetails)
				{
					System.out.println("Serial No: "+ i++);
					System.out.println("Product Name: "+products.getProductName());
					System.out.println("Product Brand: "+products.getProductBrand());
					System.out.println("Product Category: "+products.getProductCategory());
					System.out.println("Product Price: "+products.getProductPrice());
					System.out.println("Product Discount: "+products.getProductDiscount()+"%");
					System.out.println("Manufacture Date: "+products.getProductManfDate());
					System.out.println("Expiry Date: "+products.getProductExpDate());
					System.out.println("---------------------------------");
					System.out.println();
				}
				System.out.println("Select Serial Number To Add To Cart Or To Buy...");
				ProductDetails products=productDetails.get(scanner.nextInt()-1);
				System.out.println("---------------------------------");
				System.out.println("Product Name: "+products.getProductName());
				System.out.println("Product Brand: "+products.getProductBrand());
				System.out.println("Product Category: "+products.getProductCategory());
				System.out.println("Product Price: "+products.getProductPrice());
				System.out.println("Product Discount: "+products.getProductDiscount()+"%");
				System.out.println("Manufacture Date: "+products.getProductManfDate());
				System.out.println("Expiry Date: "+products.getProductExpDate());
				System.out.println("---------------------------------");
				
//				boolean condition=true;
//				while(condition)
//				{
//					System.out.println("Select Serial No To Add To Cart Or To Buy...");
//					ProductDetails products=productDetails.get(scanner.nextInt()-1);
//					System.out.println("Product Name: "+products.getProductName());
//					System.out.println("Product Brand: "+products.getProductBrand());
//					System.out.println("Product Category: "+products.getProductCategory());
//					System.out.println("Product Price: "+products.getProductPrice());
//					System.out.println("Product Discount: "+products.getProductDiscount()+"%");
//					System.out.println("Manufacture Date: "+products.getProductManfDate());
//					System.out.println("Expiry Date: "+products.getProductExpDate());
//					System.out.println("---------------------------------");
//					System.out.println("Do you want to Continue Adding Products To Cart \nEnter Yes/No");
//					if(scanner.next().equalsIgnoreCase("no"))
//					{
//						condition=false;
//					}
//				}
//				ProductDetails products=new ProductDetails();
				PaymentService paymentService=new PaymentService();
				System.out.println("Enter \n1.Add to Cart \n2.To Buy Product ");
				switch(scanner.nextInt()) {
				case 1:
					System.out.println("Add Product to the Cart");
					System.out.println("Enter the Product Quantity");
					int quantity=scanner.nextInt();
					CartDetails cartDetails=new CartDetails();
					cartDetails.setCustomerID(customerDetails.getCustomerID());
					cartDetails.setProductID(products.getProductID());
					cartDetails.setProductQuantity(quantity);
					cartservice.addCartDetails(cartDetails);
					break;
				case 2:
					System.out.println("TO BUY");
					System.out.println("Enter the Product Quantity");
					int purchaseQuantity=scanner.nextInt();
					double totalAmount=products.getProductPrice()*purchaseQuantity;
					double discountedPrice=totalAmount*(products.getProductDiscount()/100);
					double actualAmount=totalAmount-discountedPrice;
					System.out.println("Product Name: "+products.getProductName());
					System.out.println("Product Brand: "+products.getProductBrand());
					System.out.println("Product Category: "+products.getProductCategory());
					System.out.println("Product Quantity: "+purchaseQuantity);
					System.out.println("Total Product's Price: "+totalAmount);
					System.out.println("Discounted Price: "+discountedPrice);
					System.out.println("Total Amount To Pay: "+actualAmount);
					paymentService.paymentProcessDetails(customerDetails.getCustomerID(),actualAmount,products.getProductID(),purchaseQuantity, customerDetails.getCustomerAddress());
					break;
				default:
					System.out.println("Please Enter a Valid Option...");
					break;
				}
				break;
			case 2:
//				CartDetails cartDetails=new CartDetails();
//				cartDetails.setCustomerID(customerDetails.getCustomerID());
//				cartDetails.setProductID(products.getProductID());
				cartservice.displayCartItems(customerDetails.getCustomerID());
				break;
			case 3:
				break;
			case 4:
				logout=false;
				System.out.println("You Have been Logged Out Successfully....");
				break;
			default:
				System.out.println("Please Enter a Valid Option...");
				break;
			}
		}
	}
}
