package com.kh.dtosample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {

	private Connection connection;
	
	public ProductModel(Connection connection) {
		this.connection = connection;
	}
	
	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> products = new ArrayList<>();
		String query = "SElECT * FROM PRODUCTS";
		try {
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();
			
			while (result.next()) {
				ProductDTO product = new ProductDTO();
				product.setpId(result.getInt("P_ID"));
				product.setpName(result.getString("P_NAME"));
				product.setpCategory(result.getString("P_CATEGORY"));
				product.setpPrice(result.getDouble("P_PRICE"));
				product.setpQuantity(result.getInt("P_STOCK_QUANTITY"));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
}
