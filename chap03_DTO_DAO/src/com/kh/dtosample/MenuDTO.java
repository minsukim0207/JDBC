package com.kh.dtosample;

public class MenuDTO {

	private int menuId;
	private int cafeId;
	private String menuName;
	private double price;
	private String description;
	
	public MenuDTO() {
				
	}
	
	public MenuDTO(int menuId, int cafeId, String menuName, double price, String description) {
		this.menuId = menuId;
		this.cafeId = cafeId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
	}
	
	public int getMenuId() {
		return menuId;
	}
	
	public int getCafeId() {
		return cafeId;
	}
	
	public String getMenuName() {
		return menuName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}
	
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
