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
			insertState.setString(5, "��������");
			insertState.setDate(6, Date.valueOf("2023-10-18"));
			int rowsInsert = insertState.executeUpdate();	// ������Ʈ�� ���� ���� ��ȯ
			
			if (rowsInsert == 0) {
				System.out.println("������Ʈ �� �����Ͱ� �����ϴ�.");
			} else {
				System.out.println(rowsInsert + "���� ���� ������Ʈ�Ǿ����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
