package com.jdy1787.mycafe;

import com.jdy1787.mycafe.controller.CafeController;
import com.jdy1787.mycafe.dto.CafeDTO;

public class MainTest1 {

	public static void main(String[] args) {
		CafeController cafeController = new CafeController();
		
//		CafeDTO dto = cafeController.requstUserId("티모");
//		System.out.println(dto);
		
		
//		int result = cafeController.requestDeleteUserName("티모");
//		System.out.println(result);
		
		int result = cafeController.requestInsertUserName("아리");
		System.out.println(result);
		
	} 
}
