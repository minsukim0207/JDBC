package com.kh.dtosample;

public class ProductDTO {

	private int pId;
	private String pName;
	private String pCategory;
	private double pPrice;
	private int pStockQuantity;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(int pId, String pName, String pCategory, double pPrice, int pStockQuantity) {
		this.pId = pId;
		this.pName = pName;
		this.pCategory = pCategory;
		this.pPrice = pPrice;
		this.pStockQuantity = pStockQuantity;
	}
	
	public int getpId() {
		return pId;
	}
	
	public String getpName() {
		return pName;
	}
	
	public String getpCategory() {
		return pCategory;
	}
	
	public double getpPrice() {
		return pPrice;
	}
	
	public int getpStockQuantity() {
		return pStockQuantity;
	}
	
	public void setpId(int pId) {
		this.pId = pId;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	
	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}
	
	public void setpQuantity(int pStockQuantity) {
		this.pStockQuantity = pStockQuantity;
	}
}
