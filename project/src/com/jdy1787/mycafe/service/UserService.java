package com.jdy1787.mycafe.service;

import com.jdy1787.mycafe.dao.UserDAO;
import com.jdy1787.mycafe.dto.UserDTO;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}

	public UserDTO loginByUserIdAndPassword(String user_id, String password) {
		UserDTO resultDTO = userDAO.login(user_id, password);
		return resultDTO;
	}

	public int insertUserInfo(String name, String user_id, String password, String email, String address, String tel) {
		int resultRow = 0;

		UserDTO userDTO = selectUserName(user_id);
		if (userDTO != null) {
			String userWriterId = userDTO.getUser_id();
			if (user_id.equals(userWriterId)) {
				System.out.println("해당 아이디가 존재합니다.");
			} else {
				resultRow = userDAO.join(name, user_id, password, email, address, tel);
			}
		}

		return resultRow;
	}

	public UserDTO selectUserName(String user_id) {
		UserDTO resultDTO = userDAO.select(user_id);
		return resultDTO;

	}

}
