package com.kh.mvc.singleton.productupdate;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProductView {

	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ʈ ��ǰ ���� �Է�");
		
		System.out.print("��ǰ �̸� : ");
		String productName = sc.nextLine();
		System.out.print("��ǰ ID : ");
		int productId = sc.nextInt();
		
		UpdateProductDTO updateProduct = new UpdateProductDTO(productName, productId);
		try {
			UpdateProductModel productModel = UpdateProductModel.getInstance();
			productModel.updateProduct(updateProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.close();
	}
}
