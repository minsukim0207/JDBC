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
			System.out.println("1. 카페 정보 추가");
			System.out.println("2. 메뉴 설명 추가");
			System.out.println("3. 카페 정보 변경");
			System.out.println("4. 카페 삭제");
			System.out.println("5. 메뉴 삭제");
			System.out.println("6. 카페 찾기");
			System.out.println("7. 종료");
			System.out.print("원하는 메뉴 선택 : ");
		
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
					System.out.println("프로그램 종료");
					isTrue = false;
					break;
				default :
					System.out.println("잘못된 입력");
			}
			System.out.println();
		}
	}
}
