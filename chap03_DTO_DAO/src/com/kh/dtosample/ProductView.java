package com.kh.dtosample;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	
	public void displayProducts(List<ProductDTO> products) {
		for (ProductDTO product : products) {
			System.out.println("Product ID : " + product.getpId());
			System.out.println("Product Name : " + product.getpName());
			System.out.println("Product Category : " + product.getpCategory());
			System.out.println("Product Price : " + product.getpPrice());
			System.out.println("Product Stock Quantity : " + product.getpStockQuantity());
		}
	}
}
