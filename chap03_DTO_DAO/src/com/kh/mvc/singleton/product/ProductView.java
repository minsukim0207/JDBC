package com.kh.mvc.singleton.product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	
	public void addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("새 제품 정보 입력");
		
		System.out.println("제품 ID : ");
		int productId = sc.nextInt();
		System.out.println("제품 이름 : ");
		String productName = sc.nextLine();
		System.out.println("카테고리 : ");
		String category = sc.nextLine();
		System.out.println("가격 : ");
		double price = sc.nextDouble();
		System.out.println("재고 수량 : ");
		int stockQuantity = sc.nextInt();
		
		ProductDTO newProduct = new ProductDTO(productId, productName, category, price, stockQuantity);
		ProductModel productModel;
		boolean success = false;
		
		try {
			productModel = ProductModel.getInstance();
			success = productModel.insertProduct(newProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (success) {
			System.out.println("제품 추가 성공");
		} else {
			System.out.println("제품 추가 실패");
		}
		
		sc.close();
	}
}
