package com.jdy.blog;

import com.jdy.blog.controller.AController;
import com.jdy.blog.controller.UserController;
import com.jdy.blog.dto.UserDto;

public class MainTest1 {
	public static void main(String[] args) {

		// main -> AC -> AS -> AD
		// 결과 받아보기
		AController ac = new AController();
		String acResult = ac.select("혼자함");
		System.out.println(acResult);
		
		
		UserController userController = new UserController();
		UserDto responDto = userController.select(1);
		System.out.println(responDto);
	}
}
