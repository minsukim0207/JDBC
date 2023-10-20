package com.kh.dtosample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		//cafes();
		//products();
		//menus();

	}
	
	public static void cafes() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHCAFE";
		String password = "KHCAFE";
		
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			CafeView view = new CafeView();
			CafeController controller = new CafeController(conn, view);
			controller.displayAllCafes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void products() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHCAFE";
		String password = "KHCAFE";
		
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			ProductView view = new ProductView();
			ProductController controller = new ProductController(conn, view);
			controller.displayAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void menus() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHCAFE";
		String password = "KHCAFE";
		
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			MenuView view = new MenuView();
			MenuController controller = new MenuController(conn, view);
			controller.displayAllMenus();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
