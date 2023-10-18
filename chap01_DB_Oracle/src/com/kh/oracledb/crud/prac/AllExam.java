package com.kh.oracledb.crud.prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AllExam {
	
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String userName = "KHCAFE";
	static String password = "KHCAFE";

	public static void main(String[] args) {
		// 모든 카페 목록 가져오기
		//selectAll();
		// 특정 카페의 메뉴 가져오기
		//selectOne();
		// 새로운 카페 추가하기
		//insertCafe();
		// 특정 카페의 메뉴 가격 변경
		//updateMenuPrice();
		// 특정 카페의 정보 변경
		//updateCafe();
		// 특정 카페의 정보 삭제하기
		//deleteCafe();
		// 특정 카페의 메뉴 수 가져오기
		countMenu();
	}

	static void selectAll() {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String selectAll = "SELECT * FROM CAFES";
			PreparedStatement selectAllState = conn.prepareStatement(selectAll);
			ResultSet result = selectAllState.executeQuery();
			
			while (result.next()) {
				int c_id = result.getInt("C_ID");
				String c_name = result.getString("C_NAME");
				String c_address = result.getString("C_ADDRESS");
				String c_phone_number = result.getString("C_PHONE_NUMBER");
				String c_operating_hours = result.getString("C_OPERATING_HOURS");
				
				System.out.println("C_ID : " + c_id + "C_NAME : " + c_name + "C_ADDRESS : " + c_address + "C_PHONE_NUMBER : " + c_phone_number + "C_OPERATING_HOURS" + c_operating_hours);
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void selectOne() {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String selectOne = "SELECT C_NAME, M.M_NAME FROM CAFES C, MENU M WHERE C.C_ID = M.C_ID AND C_NAME = '카페 서울'";
			PreparedStatement selectOneState = conn.prepareStatement(selectOne);
			ResultSet result = selectOneState.executeQuery();
			
			result.next();
			String c_name = result.getString("C_NAME");
			String m_name = result.getString("M_NAME");
			
			System.out.println("C_NAME : " + c_name + "M_NAME : " + m_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void insertCafe() {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String insertCafe = "INSERT INTO CAFES (C_ID, C_NAME, C_ADDRESS, C_PHONE_NUMBER, C_OPERATING_HOURS)" + "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement insertState = conn.prepareStatement(insertCafe);
			
			insertState.setInt(1, 21);
			insertState.setString(2, "노다지");
			insertState.setString(3, "서울시 관악구");
			insertState.setString(4, "193413043109");
			insertState.setString(5, "장사안함");
			insertState.executeUpdate();
			System.out.println("업데이트");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static void updateMenuPrice() {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String updateMenuPrice = "UPDATE MENU SET M_PRICE = ? WHERE M_ID = ?";
			PreparedStatement updateState = conn.prepareStatement(updateMenuPrice);
			
			updateState.setDouble(1, 9.99);
			updateState.setInt(2, 1);
			updateState.executeUpdate();
			System.out.println("업데이트");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static void updateCafe() {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String updateCafe = "UPDATE CAFES SET C_OPERATING_HOURS = '장사안함' WHERE C_ID = ?";
			PreparedStatement updateState = conn.prepareStatement(updateCafe);
			
			updateState.setInt(1, 1);
			updateState.executeUpdate();
			System.out.println("업데이트");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void deleteCafe() {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String deleteCafe = "DELETE FROM CAFES WHERE C_ID = ?";
			PreparedStatement deleteState = conn.prepareStatement(deleteCafe);
			
			deleteState.setInt(1, 21);
			deleteState.executeUpdate();
			System.out.println("삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static void countMenu() {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String countMenu = "SELECT C.C_ID, COUNT(M.M_ID) AS COUNT_MENU FROM CAFES C, MENU M WHERE C.C_ID = M.C_ID AND C.C_ID = 1 GROUP BY C.C_ID";
			PreparedStatement countState = conn.prepareStatement(countMenu);
			ResultSet result = countState.executeQuery();
			
			//countState.setInt(1, 1);
			result.next();
			int c_id = result.getInt("C_ID");
			int count = result.getInt("COUNT_MENU");
			System.out.println("C_ID : " + c_id + "COUNT(M.M_ID)" + count);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

