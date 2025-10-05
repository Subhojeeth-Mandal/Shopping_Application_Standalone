package com.shopping.service;

import java.util.ArrayList;

import com.shopping.dao.CartDAO;
import com.shopping.dao.ProductDAO;
import com.shopping.dto.CartDetails;
import com.shopping.dto.ProductDetails;

public class CartService 
{
	CartDAO cartDAO=new CartDAO();
	ProductDAO productDAO=new ProductDAO();
	public void addCartDetails(CartDetails cartDetails)
	{
		if(cartDAO.insertCartDetails(cartDetails))
			System.out.println("Product Added to Cart...");
		else
			System.out.println("Failed to Add Product to Cart");
	}
	
	public void displayCartItems(int customerID)
	{
		ArrayList<CartDetails> cartDetails=cartDAO.selectCartUsingCustomerID(customerID);
		if(cartDetails!=null)
		{
			System.out.println("------------------------------");
			for(CartDetails cart: cartDetails)
			{
				int productID=cart.getProductID();
				ProductDetails product=productDAO.getProductByProductID(productID);
				System.out.println("Product ID: "+product.getProductID());
				System.out.println("Product Name: "+product.getProductName());
				System.out.println("Product Brand: "+product.getProductBrand());
				System.out.println("Product Category: "+product.getProductCategory());
				System.out.println("Product Price: "+product.getProductPrice());
				System.out.println("Product Discount: "+product.getProductDiscount()+"%");
				System.out.println("Manufacture Date: "+product.getProductManfDate());
				System.out.println("Expiry Date: "+product.getProductExpDate());
				System.out.println("No Of Products Added: "+cart.getProductQuantity());
				System.out.println("------------------------------");
			}
		}
		else
			System.out.println("Sorry... Your Cart is Empty..!!!!");
		System.out.println();
	}
}
