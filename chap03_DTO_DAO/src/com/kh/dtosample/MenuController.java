package com.kh.dtosample;

import java.sql.Connection;
import java.util.List;

public class MenuController {

	private MenuModel model;
	private MenuView view;
	
	public MenuController(Connection conn, MenuView view) {
		this.model = new MenuModel(conn);
		this.view = view;
	}
	
	public void displayAllMenus() {
		List<MenuDTO> menus = model.getMenus();
		view.displayMenus(menus);
	}
}
