package com.kh.dtosample;

import java.util.List;

public class CafeView {

	public void displayCafes(List<CafeDTO> cafes) {
		for (CafeDTO cafe : cafes) {
			System.out.println("Cafe Id : " + cafe.getCafeId());
			System.out.println("Cafe Name : " + cafe.getCafeName());
			System.out.println("Cafe Address : " + cafe.getAddress());
			System.out.println("Cafe Phone Number : " + cafe.getPhoneNumber());
			System.out.println("Cafe Operatin Hours : " + cafe.getOperatingHours());
		}
	}
}
