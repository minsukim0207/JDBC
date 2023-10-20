package com.kh.dtosample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CafeModel {

	private Connection connection;
	
	public CafeModel(Connection connection) {
		this.connection = connection;
	}
	
	public List<CafeDTO> getCafes() {
		List<CafeDTO> cafes = new ArrayList<>();
		String query = "SELECT * FROM CAFES";
		try {
			PreparedStatement st = connection.prepareCall(query);
			ResultSet result = st.executeQuery();
			
			while (result.next()) {
				CafeDTO cafe = new CafeDTO();
				cafe.setCafeId(result.getInt("cafe_id"));
				cafe.setCafeName(result.getString("name"));
				cafe.setAddress(result.getString("address"));
				cafe.setPhoneNumber(result.getString("phone_number"));
				cafe.setOperatingHours(result.getString("operating_hours"));
				cafes.add(cafe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cafes;
	}
}
