package com.kh.db.oracle.sample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {

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
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = conn.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			
			// result.next() : result ��ü���� ���� ��(row)�� �̵�
			// ���� ���� ������ true, ������ false
			while (result.next()) {
				int accountID = result.getInt("account_id");	// KHBANK�� �ִ� BANK ���̺� ��� ���տ��� account_id�� ������
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				int accountNumber = result.getInt("account_number");
				String branchName = result.getString("branch_name");
				Date lastTransactionDate = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + accountID);
				System.out.println("ACCOUNT_NUMBER : " + accountNumber);
				System.out.println("ACCOUNT_NAME : " + accountName);
				System.out.println("BALANCE : " + balance);
				System.out.println("BRANCH_NAME : " + branchName);
				System.out.println("LAST_TRANSACTION_DATE : " + lastTransactionDate);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
