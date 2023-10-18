package com.kh.oracledb.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertAll {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHCAFE";
		String password = "KHCAFE";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO PRODUCTS (P_ID, P_NAME, P_CATEGORY, P_PRICE, P_STOCK_QUANTITY)" + "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(insertSQL);
			
			// PRODUCTS 테이블에 데이터 삽입
			insertProducts(ps, 7, "노트북", "전자제품", 89.99, 10);
			insertProducts(ps, 8, "냉장고", "전자제품", 599.99, 5);
			insertProducts(ps, 9, "690SMC-R", "생활용품", 1499.99, 1);
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static void insertProducts(PreparedStatement ps, int p_id, String p_name, String p_category, double p_price, int p_stock_quantity) throws SQLException {
		ps.setInt(1, p_id);
		ps.setString(2, p_name);
		ps.setString(3, p_category);
		ps.setDouble(4, p_price);
		ps.setInt(5, p_stock_quantity);
		ps.executeUpdate();
		}

}
