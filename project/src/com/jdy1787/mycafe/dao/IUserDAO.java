package com.jdy1787.mycafe.dao;

import com.jdy1787.mycafe.dto.UserDTO;

public interface IUserDAO {

	
	UserDTO select(String user_id);
	
	UserDTO login(String user_id,String password);
	
	void buy();
	
	int join(String name, String user_id, String password, String email, String address, String tel);
	
}
