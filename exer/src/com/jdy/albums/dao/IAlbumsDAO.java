package com.jdy.albums.dao;

import com.jdy.albums.dto.AlbumsDTO;

public interface IAlbumsDAO {

	AlbumsDTO select(int userId);
	
	int insert(int userId, int id, String title);
	
}
