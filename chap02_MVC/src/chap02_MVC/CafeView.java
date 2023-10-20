package chap02_MVC;

import java.util.Scanner;

public class CafeView {
	public CafeModel model;

	public CafeView(CafeModel model) {
		this.model = model;
	}

	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ���� �Է�");
		System.out.print("��ȣ�� : ");
		String view_name = sc.nextLine();
		System.out.print("ī�� �ּ� : ");
		String view_address = sc.nextLine();
		System.out.print("ī�� ��ȣ : ");
		String view_phoneNumber = sc.nextLine();
		System.out.print("ī�� ���� �ð� : ");
		String view_operatingHours = sc.nextLine();
		
		// CafeModel�� insertCafe �޼��带 �����;� ��
		model.insertCafe(view_name, view_address, view_phoneNumber, view_operatingHours);
		System.out.println("ī�� �߰� �Ϸ�");
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ���� �Է�");
		System.out.print("������ �޴� ���� : ");
		String description = sc.nextLine();
		System.out.print("�޴� ID : ");
		int menuId = sc.nextInt();
		System.out.print("ī�� ID : ");
		int cafeId = sc.nextInt();
		
		model.updateMenu(description, menuId, cafeId);
		System.out.println("�޴� ������Ʈ �Ϸ�");
	}
	
	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� � �ð� ����");
		System.out.print("����� � �ð� : ");
		String operatingHours = sc.nextLine();
		System.out.println("������ ī�� ID : ");
		int cafeId = sc.nextInt();
		
		model.updateCafe(operatingHours, cafeId);
		System.out.println("� �ð� ������Ʈ �Ϸ�");
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ����");
		System.out.print("������ ī�� ID : ");
		int cafeId = sc.nextInt();
		
		model.deleteCafe(cafeId);
		System.out.println("ī�� ���� �Ϸ�");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ����");
		System.out.print("������ �޴� ID : ");
		int menuId = sc.nextInt();
		
		model.deleteMenu(menuId);
		System.out.println("�޴� ���� �Ϸ�");
	}
	
	public void findCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� �˻�");
		System.out.print("�˻��� ī�� ID : ");
		int cafeId = sc.nextInt();
		
		model.findCafe(cafeId);
		System.out.println("ī�� �˻� �Ϸ�");
	}
}
