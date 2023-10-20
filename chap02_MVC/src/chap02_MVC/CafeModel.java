package chap02_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "KHCAFE";
	String password = "KHCAFE";
	
	public void insertCafe(String name, String address, String phoneNumber, String operatingHours) {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "INSERT INTO CAFES (C_NAME, C_ADDRESS, C_PHONE_NUMBER, C_OPERATING_HOURS)" + "VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phoneNumber);
			ps.setString(4, operatingHours);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCafe(String operatingHours, int cafeId) {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "UPDATE CAFES SET C_OPERATING_HOURS = ? WHERE C_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, operatingHours);
			ps.setInt(2, cafeId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMenu(String description, int menuId, int cafeId) {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "UPDATE MENU SET M_DESCRIPTION = ? WHERE M_ID = ? AND C_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, description);
			ps.setInt(2, menuId);
			ps.setInt(3, cafeId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCafe(int cafeId) {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "DELETE FROM CAFES WHERE C_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cafeId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMenu(int menuId) {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "DELETE FROM MENU WHERE M_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, menuId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void findCafe(int cafeId) {
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "SELECT * FROM CAFES WHERE CAFE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cafeId);
			ResultSet result = ps.executeQuery();
			
			result.next();
			String cafeName = result.getString("NAME");
			String cafeAddress = result.getString("ADDRESS");
			String cafePhoneNumber = result.getString("PHONE_NUMBER");
			String cafeOperatingHours = result.getString("OPERATING_HOURS");
			System.out.println("NAME : " + cafeName);
			System.out.println("ADDRESS : " + cafeAddress);
			System.out.println("PHONE_NUMBER : " + cafePhoneNumber);
			System.out.println("OPERATING_HOURS : " + cafeOperatingHours);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
