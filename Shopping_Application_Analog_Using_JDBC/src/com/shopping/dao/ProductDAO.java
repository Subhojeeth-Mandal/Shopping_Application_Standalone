package com.shopping.dao;

import java.sql.*;
import java.util.ArrayList;

import com.shopping.dto.ProductDetails;
import com.shopping.util.JDBCConnection;

public class ProductDAO 
{
	private static final String insert_product_details="insert into product_details (Product_Name, Product_Brand, Product_Price, "
			+ "Product_Manf_Date, Product_Exp_Date, Product_Quantity, Product_Category, Product_Discount) values(?,?,?,?,?,?,?,?)";
	private static final String select_all_product_details="select * from product_details";
	private static final String select_product_by_productID="select * from product_details where Product_ID=?";
	public boolean addProduct(ProductDetails product)
	{
		try {
			Connection connect=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connect.prepareStatement(insert_product_details);
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setString(2, product.getProductBrand());
			preparedStatement.setDouble(3, product.getProductPrice());
			preparedStatement.setDate(4, product.getProductManfDate());
			preparedStatement.setDate(5, product.getProductExpDate());
			preparedStatement.setInt(6, product.getProductQuantity());
			preparedStatement.setString(7, product.getProductCategory());
			preparedStatement.setDouble(8, product.getProductDiscount());
			int result=preparedStatement.executeUpdate();
			if(result>0)
				return true;
			return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean insertMultipleProducts(ArrayList<ProductDetails> listOfProducts)
	{
		try {
			Connection connection=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert_product_details);
			for(ProductDetails product: listOfProducts)
			{
				preparedStatement.setString(1, product.getProductName());
				preparedStatement.setString(2, product.getProductBrand());
				preparedStatement.setDouble(3, product.getProductPrice());
				preparedStatement.setDate(4, product.getProductManfDate());
				preparedStatement.setDate(5, product.getProductExpDate());
				preparedStatement.setInt(6, product.getProductQuantity());
				preparedStatement.setString(7, product.getProductCategory());
				preparedStatement.setDouble(8, product.getProductDiscount());
				preparedStatement.addBatch();
			}
			int[] result=preparedStatement.executeBatch();
			if(result.length>0)
				return true;
			return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<ProductDetails> displayAllProducts()
	{
		try {
			Connection connection=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(select_all_product_details);
			ResultSet result=preparedStatement.executeQuery();
			ArrayList<ProductDetails> listOfProducts=new ArrayList<ProductDetails>();
			if(result.isBeforeFirst())
			{
				while(result.next())
				{
					ProductDetails products=new ProductDetails();
					products.setProductID(result.getInt("Product_ID"));
					products.setProductName(result.getString("Product_Name"));
					products.setProductBrand(result.getString("Product_Brand"));
					products.setProductPrice(result.getInt("Product_Price"));
					products.setProductManfDate(result.getDate("Product_Manf_Date"));
					products.setProductExpDate(result.getDate("Product_Exp_Date"));
					products.setProductQuantity(result.getInt("Product_Quantity"));
					products.setProductCategory(result.getString("Product_Category"));
					products.setProductDiscount(result.getDouble("Product_Discount"));
					listOfProducts.add(products);
				}
			}
			return listOfProducts;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ProductDetails getProductByProductID(int productID)
	{
		try {
			Connection connect=JDBCConnection.mySQLConnection();
			PreparedStatement preparedStatement=connect.prepareStatement(select_product_by_productID);
			preparedStatement.setInt(1, productID);
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
			{
				ProductDetails products=new ProductDetails();
				products.setProductID(result.getInt("Product_ID"));
				products.setProductName(result.getString("Product_Name"));
				products.setProductBrand(result.getString("Product_Brand"));
				products.setProductPrice(result.getInt("Product_Price"));
				products.setProductManfDate(result.getDate("Product_Manf_Date"));
				products.setProductExpDate(result.getDate("Product_Exp_Date"));
				products.setProductCategory(result.getString("Product_Category"));
				products.setProductDiscount(result.getDouble("Product_Discount"));
				return products;
			}
			return null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
