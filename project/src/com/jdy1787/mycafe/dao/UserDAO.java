package com.jdy1787.mycafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdy1787.mycafe.dto.UserDTO;
import com.jdy1787.mycafe.utils.DBHelper;

public class UserDAO implements IUserDAO{

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		conn = DBHelper.getInstance().getConnection();
	}
	
	@Override
	public UserDTO login(String user_id, String password) {
		UserDTO userDTO = null;
		userDTO = new UserDTO();
		
		String query = " SELECT * FROM user "
				+ " WHERE user_id = ? "
				+ " AND password = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userDTO.setId(rs.getInt("id"));
				userDTO.setName(rs.getString("name"));
				userDTO.setUser_id(rs.getString("user_id"));
				userDTO.setEmail(rs.getString("email"));
				userDTO.setAddress(rs.getString("address"));
				userDTO.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			System.out.println("login 에러");
			e.printStackTrace();
		}
		return userDTO;
		
	}
	

	@Override
	public void buy() {
		
	}

	@Override
	public int join(String name, String user_id, String password, String email, String address, String tel) {
		int resultRow = 0;
		String sql = " INSERT INTO "
				+ " user(name,user_id,password,email,address,tel) "
				+ " VALUES "
				+ "	( ? , ? , ? , ? , ? , ? ) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, user_id);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			pstmt.setString(6, tel);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("join실행 에러");
			e.printStackTrace();
		}
		return resultRow;
		
	}

	@Override
	public UserDTO select(String user_id) {
		UserDTO userDTO = null;
		userDTO = new UserDTO();
		
		String query = " SELECT * FROM user "
				+ " WHERE user_id = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userDTO.setUser_id(rs.getString("user_id"));
			}
		} catch (SQLException e) {
			System.out.println("SELECT 에러");
			e.printStackTrace();
		}
		return userDTO;
	}

}
