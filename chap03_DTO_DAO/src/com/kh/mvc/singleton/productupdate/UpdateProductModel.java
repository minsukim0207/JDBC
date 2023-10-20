package com.kh.mvc.singleton.productupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.dtosample.ProductDTO;

public class UpdateProductModel {
	
	private static Connection connection;
	private static UpdateProductModel productModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "KHCAFE";
	private static String PW = "KHCAFE";
	
	private UpdateProductModel() {
		
	}
	
	public static UpdateProductModel getInstance() throws SQLException {
		if (productModel == null) {
			productModel = new UpdateProductModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
		}
		return productModel;
	}
	
	public void updateProduct(UpdateProductDTO product) {
		String query = "UPDATE PRODUCTS SET P_NAME = ? WHERE P_ID = ?";
		try {
			PreparedStatement st = connection.prepareStatement(query);
			st.setString(1, product.getpName());
			st.setInt(2, product.getpId());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
