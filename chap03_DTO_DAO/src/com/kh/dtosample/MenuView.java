package com.kh.dtosample;

import java.util.List;

public class MenuView {
	
	public void displayMenus(List<MenuDTO> menus) {
		for (MenuDTO menu : menus) {
			System.out.println(menu.getMenuId());
			System.out.println(menu.getCafeId());
			System.out.println(menu.getMenuName());
			System.out.println(menu.getPrice());
			System.out.println(menu.getDescription());
		}
	}

}
