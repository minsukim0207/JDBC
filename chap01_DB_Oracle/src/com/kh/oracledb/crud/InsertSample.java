package com.kh.oracledb.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertSample {

	public static void main(String[] args) {
		insertOne();
	}
	
	static void insertOne() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	
		String user = "KHBANK";
		String password = "KHBANK";
		
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)" + "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement insertState = conn.prepareStatement(insertQuery);
			
			insertState.setInt(1, 23);
			insertState.setString(2, "39671027");
			insertState.setString(3, "TH");
			insertState.setDouble(4, 2000.00);
			insertState.setString(5, "동쪽지점");
			insertState.setDate(6, Date.valueOf("2023-10-18"));
			int rowsInsert = insertState.executeUpdate();	// 업데이트된 열의 개수 반환
			
			if (rowsInsert == 0) {
				System.out.println("업데이트 된 데이터가 없습니다.");
			} else {
				System.out.println(rowsInsert + "개의 열이 업데이트되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
