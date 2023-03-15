package com.jdy1787.mycafe;

import com.jdy1787.mycafe.controller.CafeController;
import com.jdy1787.mycafe.dto.CafeDTO;

public class MainTest1 {

	public static void main(String[] args) {
		CafeController cafeController = new CafeController();
		// select
//		CafeDTO dto = cafeController.requstUserId("티모");
//		System.out.println(dto);
//		
		// delete
//		int result = cafeController.requestDeleteUserName("티모");
//		System.out.println(result);
		
		// insert
//		int result = cafeController.requestInsertUserName("티모");
//		System.out.println(result);
		
		
		// update
		int result = cafeController.requestUpdateUserName("티모","르블랑");
		System.out.println(result);

		
	} 
}
