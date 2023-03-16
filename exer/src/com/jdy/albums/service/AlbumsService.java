package com.jdy.albums.service;

import com.jdy.albums.dao.AlbumsDAO;
import com.jdy.albums.dto.AlbumsDTO;

public class AlbumsService {

	private AlbumsDAO albumsDAO;

	public AlbumsService() {
		albumsDAO = new AlbumsDAO();

	}

	public AlbumsDTO selectByUserId(int userId) {
		AlbumsDTO resultDTO = albumsDAO.select(userId);
		return resultDTO;
	}

	public int insertUserId(int userId, int id, String title) {
		int resultRow = 0;

		AlbumsDTO albumsDTO = selectByUserId(userId);
		if (albumsDTO != null) {
			int albumsWriterUserId = albumsDTO.getUserId();
			int albumsWriterId = albumsDTO.getId();
			String albumsWriterTitle = albumsDTO.getTitle();
			if (userId == albumsWriterUserId && id == albumsWriterId && title.equals(albumsWriterTitle) ) {
				System.out.println("해당 아이디가 존재합니다.");
			} else {
				resultRow = albumsDAO.insert(userId, id, title);
			}
		}
		return resultRow;
	}

}
