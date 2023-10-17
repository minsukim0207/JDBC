package com.kh.db.oracle.sample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		//selectBank();
		//selectKhcafeMenu();
		//selectKhcafeCafes();
		//selectIf();
		selectKhbank();
	}
	
	static void selectBank() {
		// 1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
				String driver = "oracle.jdbc.driver.OracleDriver";
				
				// 2. ����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ���� ����
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
				String user = "KHBANK";
				String password = "KHBANK";
				
				Connection conn = null;
				try {
					//  ������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
					conn = DriverManager.getConnection(url, user, password);
					System.out.println("�����ͺ��̽� ���� ����");
					System.out.println();
					
					// SELECT ����
					String selectQuery = "SELECT account_id, account_number FROM BANK";
					PreparedStatement selectState = conn.prepareStatement(selectQuery);
					
					ResultSet result = selectState.executeQuery();
					
					// result.next() : result ��ü���� ���� ��(row)�� �̵�
					// ���� ���� ������ true, ������ false
					while (result.next()) {
						int accountID = result.getInt("account_id");	// KHBANK�� �ִ� BANK ���̺� ��� ���տ��� account_id�� ������
						String accountName = result.getString("account_name");
						//double balance = result.getDouble("balance");
						int accountNumber = result.getInt("account_number");
						//String branchName = result.getString("branch_name");
						//Date lastTransactionDate = result.getDate("last_transaction_date");
						System.out.println("ACCOUNT_ID : " + accountID);
						System.out.println("ACCOUNT_NUMBER : " + accountNumber);
						System.out.println("ACCOUNT_NAME : " + accountName);
						//System.out.println("BALANCE : " + balance);
						//System.out.println("BRANCH_NAME : " + branchName);
						//System.out.println("LAST_TRANSACTION_DATE : " + lastTransactionDate);
						System.out.println();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

	static void selectKhcafeMenu() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KHCAFE";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			String selecQuery = "SELECT * FROM MENU";
			PreparedStatement selectState = conn.prepareStatement(selecQuery);
			ResultSet result = selectState.executeQuery();
			
			while (result.next()) {
				int mID = result.getInt("M_ID");
				String mName = result.getString("M_NAME");
				int mPrice = result.getInt("M_PRICE");
				int cID = result.getInt("C_ID");
				String mDescription = result.getString("M_DESCRIPTION");
				
				System.out.println("M_ID : " + mID + "M_NAME : " + mName + "M_PRICE : " + mPrice + "C_ID : " + cID + "M_DESCRIPTION : " + mDescription);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void selectKhcafeCafes() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KHCAFE";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			String selectQuery = "SELECT C_ID FROM CAFES";
			PreparedStatement selectState = conn.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();

			while (result.next()) {
				int cID = result.getInt("C_ID");
				System.out.println("C_ID : " + cID);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void selectIf() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KHBANK";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			String selectQuery = "SELECT * FROM BANK WHERE account_number in (?, ?)";
			PreparedStatement selectState = conn.prepareStatement(selectQuery);
			
			/*
			// ���ϴ� ������ account_id ����
			int targetAID = 1;
			
			// ���� ����
			selectState.setInt(1, targetAID);
			*/
			
			String[] targetAN = {"12345678", "5555666777"};
			selectState.setString(1,  targetAN[0]);
			selectState.setString(2, targetAN[1]);
			
			ResultSet result = selectState.executeQuery();
			
			while (result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("ACCOUNT_NUMBER");
				String c = result.getString("ACCOUNT_NAME");
				int d = result.getInt("BALANCE");
				String e = result.getString("BRANCH_NAME");
				Date f = result.getDate("LAST_TRANSACTION_DATE");
				System.out.println("ACCOUNT_ID : " + a);
				System.out.println("ACCOUNT_NUMBER: " + b);
				System.out.println("ACCOUNT_NAME : " + c);
				System.out.println("BALANCE : " + d);
				System.out.println("BRANCH_NAME : " + e);
				System.out.println("LAST_TRANSACTION_DATE : " + f);
				System.out.println();
			} /*else {
				System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�.");
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void selectKhbank() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KHBANK";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = conn.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			
			result.next();
			String account_number = result.getString("account_number");
			System.out.println(account_number);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void pp() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "khbank";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			String selectQuery = "select * from bank";
			PreparedStatement selectState = conn.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
