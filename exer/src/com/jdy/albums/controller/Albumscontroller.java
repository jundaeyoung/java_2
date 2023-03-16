package com.jdy.albums.controller;

import com.jdy.albums.dto.AlbumsDTO;
import com.jdy.albums.service.AlbumsService;

public class Albumscontroller {
	
	private AlbumsService albumsService;
	
	public Albumscontroller() {
		albumsService = new AlbumsService();
	}
	
	public AlbumsDTO requstUserId(int userId) {
		AlbumsDTO responseDTO = albumsService.selectByUserId(userId);
		return responseDTO;
	}
	
	
	public int requestInsertUserId(int userId , int id, String title) {
		int responseRow = albumsService.insertUserId(userId,id,title);
		return responseRow;
	}
	

}
