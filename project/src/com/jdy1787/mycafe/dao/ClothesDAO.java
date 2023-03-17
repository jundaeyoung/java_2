package com.jdy1787.mycafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdy1787.mycafe.dto.BuyDTO;
import com.jdy1787.mycafe.utils.DBHelper;

public class ClothesDAO implements IBuyDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ClothesDAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	public BuyDTO select(String name) {
		BuyDTO cafeDTO = null;
		cafeDTO = new BuyDTO();

		String query = " SELECT * FROM cafe " 
				+ " WHERE name = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cafeDTO.setId(rs.getInt("id"));
				cafeDTO.setName(rs.getString("name"));
				cafeDTO.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println("cafeDAO select 에러 발생");
			e.printStackTrace();
		}

		return cafeDTO;

	}

	@Override
	public int delete(String name) {
		int resultRow = 0;
		String sql = " DELETE FROM cafe "
				+ " WHERE name = ? ";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("cafeDAO delete실행 에러 발생");
			e.printStackTrace();
		}
		
		return resultRow;
	}

	@Override
	public int insert(String name) {
		int resultRow = 0;
		String sql = " INSERT INTO cafe(name) "
				+ " VALUES "
				+ "	( ? ) " ;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("cafeDAO insert실행 에러 발생");
			e.printStackTrace();
		}
		
		return resultRow;
	}

	@Override
	public int update(String name, String targetName) {
		int resultRow = 0;
		String sql = " UPDATE cafe "
				+ " SET name = ? "
				+ " WHERE name = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, targetName);
			pstmt.setString(2, name);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("cafeDAO update실행 에러 발생");
			e.printStackTrace();
		}
		
		return resultRow;
	}
	
}
