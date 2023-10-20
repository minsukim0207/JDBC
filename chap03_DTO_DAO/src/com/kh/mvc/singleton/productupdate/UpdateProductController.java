package com.kh.mvc.singleton.productupdate;

import java.sql.Connection;
import java.util.List;

public class UpdateProductController {

	private UpdateProductModel model;
	private UpdateProductView view;
	
	public UpdateProductController(Connection conn, UpdateProductView view) {
		this.model = new UpdateProductModel(conn);
		this.view = view;
	}
	
	public void displayAllProducts() {
		List<UpdateProductDTO> products = model.getAllProducts();
		view.displayAllProducts(products);
	}
	
	public void updateProduct() {
		
	}
}
