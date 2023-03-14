package com.jdy1787.mycafe.dao;

import com.jdy1787.mycafe.dto.CafeDTO;

public interface ICafeDAO {

	CafeDTO select(String name);
	
	int delete(String name);
	
	int insert(String name);
}
