package com.kh.db.oracle.sample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {

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
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = conn.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			
			// result.next() : result 객체에서 다음 행(row)로 이동
			// 다음 행이 있으면 true, 없으면 false
			while (result.next()) {
				int accountID = result.getInt("account_id");	// KHBANK에 있는 BANK 테이블 결과 집합에서 account_id를 가져옴
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
