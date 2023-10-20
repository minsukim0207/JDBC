package chap02_MVC;

import java.util.Scanner;

public class CafeController {
	public CafeModel model;
	public CafeView view;
	
	public CafeController(CafeModel model, CafeView view) {
		this.model = model;
		this.view = view;
	}
	
	public void run() {
		
		boolean isTrue = true;
		while (isTrue) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. ī�� ���� �߰�");
			System.out.println("2. �޴� ���� �߰�");
			System.out.println("3. ī�� ���� ����");
			System.out.println("4. ī�� ����");
			System.out.println("5. �޴� ����");
			System.out.println("6. ī�� ã��");
			System.out.println("7. ����");
			System.out.print("���ϴ� �޴� ���� : ");
		
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					view.addCafeName();
					break;
				case 2:
					view.updateMenu();
					break;
				case 3:
					view.updateCafe();
					break;
				case 4:
					view.deleteCafe();
					break;
				case 5:
					view.deleteMenu();
					break;
				case 6:
					view.findCafe();
					break;
				case 7:
					System.out.println("���α׷� ����");
					isTrue = false;
					break;
				default :
					System.out.println("�߸��� �Է�");
			}
			System.out.println();
		}
	}
}
