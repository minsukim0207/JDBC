package chap02_MVC;

import java.util.Scanner;

public class CafeView {
	public CafeModel model;

	public CafeView(CafeModel model) {
		this.model = model;
	}

	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보 입력");
		System.out.print("상호명 : ");
		String view_name = sc.nextLine();
		System.out.print("카페 주소 : ");
		String view_address = sc.nextLine();
		System.out.print("카페 번호 : ");
		String view_phoneNumber = sc.nextLine();
		System.out.print("카페 영업 시간 : ");
		String view_operatingHours = sc.nextLine();
		
		// CafeModel의 insertCafe 메서드를 가져와야 함
		model.insertCafe(view_name, view_address, view_phoneNumber, view_operatingHours);
		System.out.println("카페 추가 완료");
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명 입력");
		System.out.print("수정할 메뉴 설명 : ");
		String description = sc.nextLine();
		System.out.print("메뉴 ID : ");
		int menuId = sc.nextInt();
		System.out.print("카페 ID : ");
		int cafeId = sc.nextInt();
		
		model.updateMenu(description, menuId, cafeId);
		System.out.println("메뉴 업데이트 완료");
	}
	
	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 운영 시간 변경");
		System.out.print("변경된 운영 시간 : ");
		String operatingHours = sc.nextLine();
		System.out.println("변경할 카페 ID : ");
		int cafeId = sc.nextInt();
		
		model.updateCafe(operatingHours, cafeId);
		System.out.println("운영 시간 업데이트 완료");
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 삭제");
		System.out.print("삭제할 카페 ID : ");
		int cafeId = sc.nextInt();
		
		model.deleteCafe(cafeId);
		System.out.println("카페 삭제 완료");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 삭제");
		System.out.print("삭제할 메뉴 ID : ");
		int menuId = sc.nextInt();
		
		model.deleteMenu(menuId);
		System.out.println("메뉴 삭제 완료");
	}
	
	public void findCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 검색");
		System.out.print("검색할 카페 ID : ");
		int cafeId = sc.nextInt();
		
		model.findCafe(cafeId);
		System.out.println("카페 검색 완료");
	}
}
