package com.kh.oracledb.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteSample {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHBANK";
		String password = "KHBANK";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, userName, password);
			String deleteQuery = "DELETE FROM BANK WHERE ACCOUNT_ID = ?";
			PreparedStatement updatePS = conn.prepareStatement(deleteQuery);
			updatePS.setDouble(1, 23);
			updatePS.executeUpdate();
			System.out.println(" ªË¡¶");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
