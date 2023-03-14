package com.jdy.blog.service;

import com.jdy.blog.dao.UserDao;
import com.jdy.blog.dto.UserDto;

public class UserService {

    private	UserDao userDao;
    
    public UserService() {
    	userDao = new UserDao();
	}
	public UserDto select(int userId) {
		return userDao.select(userId);
	}
}
