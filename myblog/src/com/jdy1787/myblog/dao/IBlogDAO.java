package com.jdy1787.myblog.dao;

import com.jdy1787.myblog.dto.BlogDTO;

public interface IBlogDAO {

	void select(); // 전체 조회
	BlogDTO select(int id); // id 기반으로 조회
	int delect(int boardId); 
	
}
