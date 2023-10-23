package com.kh.vodao.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		//um.addUser();
		//um.getAllUsers();
		um.selectScanner();
	}
	
	public boolean checkId(int userId) {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "KHCAFE";
		String dbPassword = "KHCAFE";
		
		String sql = "SELECT * FROM USERINFO WHERE USER_ID = ?";
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				int checkId = rs.getInt(1);
				return checkId > 0;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean checkEmail(String userEmail) {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "KHCAFE";
		String dbPassword = "KHCAFE";
		
		String sql = "SELECT COUNT(*) FROM USERINFO WHERE EMAIL = ?";
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userEmail);	
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void selectScanner() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "KHCAFE";
		String dbPassword = "KHCAFE";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
			Scanner sc = new Scanner(System.in);
			
			while (true) {
				System.out.print("User ID 입력(종료는 e 입력) : ");
				String input = sc.nextLine();
				
				if ("e".equalsIgnoreCase(input)) {
					System.out.println("종료");
					break;
				}
				
				System.out.print("Email 입력 : ");
				String userEmail = sc.nextLine();
				
				int userId = Integer.parseInt(input);
				String sql = "SELECT * FROM USERINFO WHERE USER_ID = ? AND EMAIL = ?";
				PreparedStatement st = conn.prepareStatement(sql);
				st.setInt(1, userId);
				st.setString(2, userEmail);
				ResultSet rs = st.executeQuery();
				
				if (rs.next()) {
					System.out.println("User ID : " + rs.getInt("USER_ID"));
					System.out.println("User Name : " + rs.getString("USERNAME"));
					System.out.println("Email : " + rs.getString("EMAIL"));
					System.out.println("Registration Date : " + rs.getDate("REG_DATE"));
					System.out.println();
				} else {
					boolean idTrue = checkId(userId);
					boolean emailTrue = checkEmail(userEmail);
					if (!idTrue && emailTrue) {
						System.out.println("일치하는 ID 확인 불가");
						System.out.println();
					} else if (idTrue && !emailTrue) {
						System.out.println("일치하는 Email 확인 불가");
						System.out.println();
					} else {
						System.out.println("유저 없음");
						System.out.println();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addUser() {
		// DB 연결 URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "KHCAFE";
		String dbPassword = "KHCAFE";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);	// Connection
			UserDAO userDAO = new UserDAO(connection);	// UserDao(Connection)
					
			Scanner sc = new Scanner(System.in);
			System.out.print("User ID : ");
			int userId = sc.nextInt();
			sc.nextLine();
			System.out.print("User Name : ");
			String userName = sc.nextLine();
			System.out.print("User Email : ");
			String email = sc.nextLine();
			Date regDate = new Date();	// 현재 날짜와 시간 사용
					
			// DB에 담기 위해 인스턴스 생성 후 정보 저장
			UserVO newUser = new UserVO();	// UserVO
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
					
			// 데이터가 정상적으로 들어갔는지 확인
			if (userDAO.createUser(newUser)) {
				System.out.println("유저 등록 성공");
			} else {
				System.out.println("유저 등록 실패");
			}
					
			// 연결 닫기
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getAllUsers() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "KHCAFE";
		String dbPassword = "KHCAFE";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
			UserDAO userDAO = new UserDAO(connection);
			List<UserVO> users = userDAO.getAllUsers();
			
			for (UserVO user : users) {
				System.out.println("User ID : " + user.getUserId());
				System.out.println("User Name : " + user.getUserName());
				System.out.println("User Email : " + user.getEmail());
				System.out.println("User Reg_DATE : " + user.getRegDate());
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
