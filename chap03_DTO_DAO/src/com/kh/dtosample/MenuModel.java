package com.kh.dtosample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class MenuModel {

	private Connection connection;
	
	public MenuModel(Connection connection) {
		this.connection = connection;
	}
	
	public List<MenuDTO> getMenus() {
		List<MenuDTO> menus = new ArrayList<>();
		String query = "SELECT * FROM MENU";
		try {
			PreparedStatement st = connection.prepareCall(query);
			ResultSet result = st.executeQuery();
			
			while (result.next()) {
				MenuDTO menu = new MenuDTO();
				menu.setMenuId(result.getInt("MENU_ID"));
				menu.setCafeId(result.getInt("CAFE_ID"));
				menu.setMenuName(result.getString("MENU_NAME"));
				menu.setPrice(result.getDouble("PRICE"));
				menu.setDescription(result.getString("DESCRIPTION"));
				menus.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
		
	}
}
