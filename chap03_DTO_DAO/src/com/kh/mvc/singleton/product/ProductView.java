package com.kh.mvc.singleton.product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	
	public void addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ��ǰ ���� �Է�");
		
		System.out.println("��ǰ ID : ");
		int productId = sc.nextInt();
		System.out.println("��ǰ �̸� : ");
		String productName = sc.nextLine();
		System.out.println("ī�װ� : ");
		String category = sc.nextLine();
		System.out.println("���� : ");
		double price = sc.nextDouble();
		System.out.println("��� ���� : ");
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
			System.out.println("��ǰ �߰� ����");
		} else {
			System.out.println("��ǰ �߰� ����");
		}
		
		sc.close();
	}
}
