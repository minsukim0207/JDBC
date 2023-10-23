package com.kh.vodao.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection connection;
	
	public UserDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean createUser(UserVO user) {
		String sql = "INSERT INTO USERINFO (USER_ID, USERNAME, EMAIL, REG_DATE)"
				+ "VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, user.getUserId());
			st.setString(2, user.getUserName());
			st.setString(3, user.getEmail());
			st.setDate(4, new Date(user.getRegDate().getTime()));
			int rows = st.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<UserVO> getAllUsers() throws SQLException {
		List<UserVO> users = new ArrayList<>();
		String sql = "SELECT * FROM USERINFO";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				UserVO user = new UserVO();
				user.setUserId(rs.getInt("USER_ID"));
				user.setUserName(rs.getString("USERNAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setRegDate(rs.getDate("REG_DATE"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
