package com.kh.oracledb.crud.prac;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class InsertExam {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KHCAFE";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			String insertSQL = "INSERT INTO CAFES (C_NAME, C_ADDRESS, C_PHONE_NUMBER, C_OPERATING_HOURS)" + "VALUES (?, ?, ?, ?)";
			String insertBook = "INSERT INTO BOOK (BOOK_ID, TITLE, AUTHOR, PUBLICATION_YEAR, ISBN, GENRE, DESCRIPTION, PRICE, PUBLICATION_DATE, CREATED_DATE, UPDATED_DATE, IS_AVAILABLE)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(insertBook);
			
			//insertCafes(ps, "dk", "ewoieh", "327203", "월-금");
			insertBook(ps, 16, "타이틀", "작가", 2023, "29853028932", "장르", "오브젝트", 49.99, Date.valueOf("2022-10-18"), Date.valueOf("2023-10-18"), Date.valueOf("2023-10-18"), "Y");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void insertCafes(PreparedStatement ps, String c_name, String c_address, String c_phone_number, String c_operating_hours) throws SQLException {
		ps.setString(1, c_name);
		ps.setString(2, c_address);
		ps.setString(3, c_phone_number);
		ps.setString(4, c_operating_hours);
		ps.executeUpdate();
	}
	
	static void insertBook(PreparedStatement ps, int book_id, String title, String author, int publication_year, String isbn, String genre, String description, double price, Date publication_date,  Date created_date, Date updated_date, String is_available) throws SQLException {
		ps.setInt(1, book_id);
		ps.setString(2, title);
		ps.setString(3, author);
		ps.setInt(4, publication_year);
		ps.setString(5, isbn);
		ps.setString(6, genre);
		ps.setString(7, description);
		ps.setDouble(8, price);
		ps.setDate(9, publication_date);
		ps.setDate(10, created_date);
		ps.setDate(11, updated_date);
		ps.setString(12, is_available);
		ps.executeUpdate();
	}
}
