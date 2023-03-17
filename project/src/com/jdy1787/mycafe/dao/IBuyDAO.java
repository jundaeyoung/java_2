package com.jdy1787.mycafe.dao;

import com.jdy1787.mycafe.dto.BuyDTO;

public interface IBuyDAO {

	BuyDTO select(String name);
	
	int delete(String name);
	
	int insert(String name);
	
	int update(String name, String targetName);
}
