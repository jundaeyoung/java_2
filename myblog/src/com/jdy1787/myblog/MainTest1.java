package com.jdy1787.myblog;

import com.jdy1787.myblog.controller.BlogController;
import com.jdy1787.myblog.dto.BlogDTO;
import com.jdy1787.myblog.utils.DBHelper;

public class MainTest1 {

	public static void main(String[] args) {
		
		// 코드 테스트
		//DBHelper dbHelper = DBHelper.getInstance();
		//dbHelper.getConnection();
		//System.out.println("main에서 주소값 찍음 : "+dbHelper);
		
		// 코드 테스트
		BlogController blogController = new BlogController();
//		BlogDTO dto = blogController.requestBoardContentById(8);
//		System.out.println(dto);
		
		int result = blogController.requestDeleteBoardById(14, 1);
		System.out.println(result);
	}

}
