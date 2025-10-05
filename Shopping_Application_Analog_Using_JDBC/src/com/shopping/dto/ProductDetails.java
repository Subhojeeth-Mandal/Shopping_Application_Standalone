package com.shopping.dto;

import java.io.Serializable;
import java.sql.Date;

public class ProductDetails implements Serializable
{
	private int productID;
	private String productName;
	private String productBrand;
	private double productPrice;
	private Date productManfDate;
	private Date productExpDate;
	private int productQuantity;
	private String productCategory;
	private double productDiscount;
	
	public ProductDetails() {}

	public ProductDetails(int productID, String productName, String productBrand, double productPrice,
			Date productManfDate, Date productExpDate, int productQuantity, String productCategory,
			double productDiscount) 
	{
		this.productID = productID;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
		this.productManfDate = productManfDate;
		this.productExpDate = productExpDate;
		this.productQuantity = productQuantity;
		this.productCategory = productCategory;
		this.productDiscount = productDiscount;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductManfDate() {
		return productManfDate;
	}

	public void setProductManfDate(Date productManfDate) {
		this.productManfDate = productManfDate;
	}

	public Date getProductExpDate() {
		return productExpDate;
	}

	public void setProductExpDate(Date productExpDate) {
		this.productExpDate = productExpDate;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}
	
	public void display()
	{
		System.out.println("Product ID: "+getProductID());
		System.out.println("Product Name: "+getProductName());
		System.out.println("Product Brand: "+getProductBrand());
		System.out.println("Product Category: "+getProductCategory());
		System.out.println("Product Price: "+getProductPrice());
		System.out.println("Product Discount: "+getProductDiscount()+"%");
		System.out.println("Manufacture Date: "+getProductManfDate());
		System.out.println("Expiry Date: "+getProductExpDate());
		System.out.println("Product Quantity: "+getProductQuantity());
		System.out.println("---------------------------------");
	}
	
	@Override
	public String toString()
	{
		return " Product ID: "+getProductID()+"\n Product Name: "+getProductName()
		      +" \n Product Brand: "+getProductBrand()+" \n Product Price: "+getProductPrice()
		      +" \n Manufacture Date: "+getProductManfDate()+" \n Expiry Date: "+getProductExpDate()
		      +" \n Product Quantity: "+getProductQuantity()+" \n Product Category: "+getProductCategory()
		      +" \n Product Discount: "+getProductDiscount();
	}
}
