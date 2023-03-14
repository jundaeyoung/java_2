package com.jdy.blog.controller;

import com.jdy.blog.dto.UserDto;
import com.jdy.blog.service.UserService;

public class UserController {

	private UserService userService;

	public UserController() {
		userService = new UserService();

	}

	public UserDto select(int userId) {
		return userService.select(userId);
	}
}
