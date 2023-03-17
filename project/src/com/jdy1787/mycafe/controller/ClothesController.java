package com.jdy1787.mycafe.controller;

import com.jdy1787.mycafe.dto.BuyDTO;
import com.jdy1787.mycafe.service.BuyService;

public class ClothesController {

	private BuyService cafeService;

	public ClothesController() {
		cafeService = new BuyService();
	}

	public BuyDTO requstUserId(String name) {
		BuyDTO responseDTO = cafeService.selectByUserName(name);
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
	
	public int requestUpdateUserName(String name,String targetName) {
		int responseRow = cafeService.updateUserName(name,targetName);
		return responseRow;
	}
}
