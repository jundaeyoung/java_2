package com.jdy1787.mycafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdy1787.mycafe.dto.CafeDTO;
import com.jdy1787.mycafe.utils.DBHelper;

public class CafeDAO implements ICafeDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CafeDAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	public CafeDTO select(String name) {
		CafeDTO cafeDTO = null;
		cafeDTO = new CafeDTO();

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
}
