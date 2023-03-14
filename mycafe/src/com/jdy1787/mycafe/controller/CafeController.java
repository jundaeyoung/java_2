package com.jdy1787.mycafe.controller;

import com.jdy1787.mycafe.dto.CafeDTO;
import com.jdy1787.mycafe.service.CafeService;

public class CafeController {

	private CafeService cafeService;

	public CafeController() {
		cafeService = new CafeService();
	}

	public CafeDTO requstUserId(String name) {
		CafeDTO responseDTO = cafeService.selectByUserName(name);
		return responseDTO;
	}

	public int requestDeleteUserName(String name) {
		int responseRow = cafeService.deleteUserName(name);
		return responseRow;
	}
	
	public int requestInsertUserName(String name) {
		int responseRow = cafeService.insertUserName(name);
		return responseRow;
	}
}
