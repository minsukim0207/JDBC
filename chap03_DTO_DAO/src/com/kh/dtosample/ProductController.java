package com.kh.dtosample;

import java.sql.Connection;
import java.util.List;

public class ProductController {

	private ProductModel model;
	private ProductView view;
	
	public ProductController(Connection conn, ProductView view) {
		this.model = new ProductModel(conn);
		this.view = view;
	}
	
	public void displayAllProducts() {
		List<ProductDTO> products = model.getAllProducts();
		view.displayProducts(products);
	}
}
