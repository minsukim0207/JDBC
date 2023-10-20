package com.kh.dtosample;

import java.sql.Connection;
import java.util.List;

public class CafeController {

	private CafeModel model;
	private CafeView view;
	
	public CafeController(Connection conn, CafeView view) {
		this.model = new CafeModel(conn);
		this.view = view;
	}
	
	public void displayAllCafes() {
		List<CafeDTO> cafes = model.getCafes();
		view.displayCafes(cafes);
	}
}
