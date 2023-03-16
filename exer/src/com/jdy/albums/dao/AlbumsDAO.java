package com.jdy.albums.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdy.albums.dto.AlbumsDTO;
import com.jdy.albums.utils.DBHelper;

public class AlbumsDAO implements IAlbumsDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public AlbumsDAO() {
		conn = DBHelper.getInstance().getConnection(); 
	}
	
	@Override
	public AlbumsDTO select(int userId) {
		AlbumsDTO albumsDTO = null;
		albumsDTO = new AlbumsDTO();

		String query = " SELECT * FROM albums " + " WHERE userId = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				albumsDTO.setUserId(rs.getInt("userId"));
				albumsDTO.setId(rs.getInt("id"));
				albumsDTO.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			System.out.println("select 에러 발생");
			e.printStackTrace();
		}
		return albumsDTO;
	}

	@Override
	public int insert(int userId, int id, String title) {
		int resultRow = 0;
		String sql = " INSERT INTO albums(userId, id, title) "
				+ " VALUES " 
				+ "	( ? , ? , ? ) " ;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, id);
			pstmt.setString(3, title);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert실행 에러 발생");
			e.printStackTrace();
		}
		return resultRow;
	}

}
