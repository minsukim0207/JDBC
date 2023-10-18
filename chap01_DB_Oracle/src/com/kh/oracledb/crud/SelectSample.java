package com.kh.oracledb.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectSample {

	public static void main(String[] args) {
		//selectAll();
		selectOne();
		//selectKhcafeMenu();
		//selectKhcafeCafes();
		//selectKhbank();
	}
	
	static void selectAll() {
		// 1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
				String driver = "oracle.jdbc.driver.OracleDriver";
				
				// 2. 오라클 내 컴퓨터 연결 : 데이터베이스 연결 정보
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
				String user = "KHBANK";
				String password = "KHBANK";
				
				Connection conn = null;
				try {
					//  연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
					conn = DriverManager.getConnection(url, user, password);
					System.out.println("데이터베이스 연결 성공");
					System.out.println();
					
					// SELECT 쿼리
					String selectQuery = "SELECT account_id, account_number FROM BANK";
					PreparedStatement selectState = conn.prepareStatement(selectQuery);
					
					ResultSet result = selectState.executeQuery();
					
					// result.next() : result 객체에서 다음 행(row)로 이동
					// 다음 행이 있으면 true, 없으면 false
					while (result.next()) {
						int accountID = result.getInt("account_id");	// KHBANK에 있는 BANK 테이블 결과 집합에서 account_id를 가져옴
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
	
	static void selectOne() {

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
			// 원하는 조건의 account_id 설정
			int targetAID = 1;
			
			// 조건 설정
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
				System.out.println("조건에 해당하는 데이터가 없습니다.");
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void selectKhbank() {
		//String driver = "oracle.jdbc.driver.OracleDriver";
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
}	