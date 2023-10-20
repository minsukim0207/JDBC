package com.kh.mvc.singleton.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
	
	private static Connection connection;
	private static ProductModel productModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "KHCAFE";
	private static String PW = "KHCAFE";
	
	// 기본 생성자로부터 외부에서 인스턴스를 직접 생성하는 것을 방지
	private ProductModel() {
		
	}
	
	public static ProductModel getInstance() throws SQLException {
		if (productModel == null) {
			productModel = new ProductModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
		}
		return productModel;
	}
	
	public boolean insertProduct(ProductDTO product) {
		String sql = "INSERT INTO PRODUCTS (P_ID, P_NAME, P_CATEGORY, P_PRICE, P_STOSCK_QUANTITY)"
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, product.getpId());
			ps.setString(2, product.getpName());
			ps.setString(3, product.getpCategory());
			ps.setDouble(4, product.getpPrice());
			ps.setInt(5, product.getpStockQuantity());
			
			int rowsAffected = ps.executeUpdate();
			
			return rowsAffected > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
