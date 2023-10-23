package com.kh.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bank {
	public static void main(String[] args) {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "KHBANK";
	String pw = "KHBANK";
	
	try {
		Connection conn = DriverManager.getConnection(url, user, pw);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
}
