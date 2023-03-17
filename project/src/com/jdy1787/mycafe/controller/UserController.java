package com.jdy1787.mycafe.controller;

import com.jdy1787.mycafe.dto.UserDTO;
import com.jdy1787.mycafe.service.UserService;

public class UserController {

	private UserService userService;

	public UserController() {
		userService = new UserService();
	}

	public UserDTO requstUserLogin(String user_id, String password) {
		UserDTO responseDTO = userService.loginByUserIdAndPassword(user_id, password);
		return responseDTO;
	}

	public int requestJoin(String name, String user_id, String password, String email, String address,
			String tel) {
		int responseRow = userService.insertUserInfo(name, user_id, password, email, address, tel);
		return responseRow;
	}

	public String requestUserSelect(String user_id) {
		UserDTO responseDTO = userService.selectUserName(user_id);
		return responseDTO.getUser_id();

	}

}
