package com.kh.oracledb.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSample {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHBANK";
		String password = "KHBANK";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, userName, password);
			String updateQuery = "UPDATE BANK SET BALANCE = ? WHERE ACCOUNT_NUMBER = ?";
			PreparedStatement updatePS = conn.prepareStatement(updateQuery);
			updatePS.setDouble(1, 2000.00);
			updatePS.setString(2, "12345678");
			updatePS.executeUpdate();
			int rowsUpdate = updatePS.executeUpdate();
			System.out.println(rowsUpdate + " 업데이트");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
