package com.shopping.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.shopping.dao.ProductDAO;
import com.shopping.dto.ProductDetails;

public class ProductService 
{
	Scanner scanner = new Scanner(System.in);
	ProductDAO productDAO=new ProductDAO();
	
	public void storeProductDetails()
	{
		ProductDetails product=new ProductDetails();
		System.out.println("Enter the Product Name");
		String pName=scanner.next();
		System.out.println("Enter Product Category");
		String pCat=scanner.next();
		System.out.println("Enter Product Brand");
		String pBrand=scanner.next();
		System.out.println("Enter the Price");
		double price=scanner.nextDouble();
		System.out.println("Enter the Manufacturing date");
		String pMFGDate=scanner.next();
		System.out.println("Enter the Expiry Date");
		String pEXpDate=scanner.next();
		System.out.println("Enter the Quantity");
		int quantity=scanner.nextInt();
		System.out.println("Enter the Discount Value");
		double discount=scanner.nextDouble();
		product.setProductName(pName);
		product.setProductCategory(pCat);
		product.setProductBrand(pBrand);
		product.setProductPrice(price);
		product.setProductManfDate(Date.valueOf(pMFGDate));
		product.setProductExpDate(Date.valueOf(pEXpDate));
		product.setProductQuantity(quantity);
		product.setProductDiscount(discount);
		if(productDAO.addProduct(product))
			System.out.println("Product Succesfully Added....");
		else
			System.err.println("Failed to Add the Product");
	}
	
	public void getProductDetails()
	{
		ArrayList<ProductDetails> products=productDAO.displayAllProducts();
		System.out.println();
		for(ProductDetails product: products)
		{
			product.display();
			System.out.println();
		}
	}
	
	public void addProductsBasedOnBrand()
	{
		ArrayList<ProductDetails> listOfProducts=new ArrayList<ProductDetails>();
		System.out.println("Enter Brand Name");
		String pBrand=scanner.next();
		System.out.println("Enter the Number Of Products Under "+pBrand +" Brand");
		int count=scanner.nextInt();
		if(count>10)
		{
			System.out.println("Number of Products Should be Only upto 10");
			while(count>10)
			{
				System.out.println("Please Re-Enter No Of Products");
				count=scanner.nextInt();
			}
		}
		String arr[]= {"First","Second","Third","Fourth","Fifth","Sixth","Seventh","Eighth","Ninth","Tenth"};
		for(int i=0;i<count;i++)
		{
			System.out.println("-----Enter "+arr[i]+" Product Details-----");
			ProductDetails product=new ProductDetails();
			System.out.println("Enter the Product Name");
			String pName=scanner.next();
			System.out.println("Enter Product Category");
			String pCat=scanner.next();
			System.out.println("Enter the Price");
			double price=scanner.nextDouble();
			System.out.println("Enter the Manufacturing date");
			String pMFGDate=scanner.next();
			System.out.println("Enter the Expiry Date");
			String pEXpDate=scanner.next();
			System.out.println("Enter the Quantity");
			int quantity=scanner.nextInt();
			System.out.println("Enter the Discount Value");
			double discount=scanner.nextDouble();
			product.setProductName(pName);
			product.setProductCategory(pCat);
			product.setProductBrand(pBrand);
			product.setProductPrice(price);
			product.setProductManfDate(Date.valueOf(pMFGDate));
			product.setProductExpDate(Date.valueOf(pEXpDate));
			product.setProductQuantity(quantity);
			product.setProductDiscount(discount);
			listOfProducts.add(product);
		}
		if(productDAO.insertMultipleProducts(listOfProducts))
			System.out.println("Multiple Products Added Successfully.....");
		else
			System.err.println("Failed To Add the Products../ Server Error 500");
	}
}
