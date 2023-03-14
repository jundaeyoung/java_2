package com.jdy1787.myblog.controller;

import com.jdy1787.myblog.dto.BlogDTO;
import com.jdy1787.myblog.service.BlogService;

public class BlogController {
	
	private BlogService blogservice;
	
	public BlogController() {
		blogservice = new BlogService();
	}
	
	//외부에서 오는 요청을 담당하는 녀석
	public BlogDTO requestBoardContentById(int id) {
		BlogDTO responseDTO = blogservice.selectByBoardId(id);
		return responseDTO;
	}
	
	// 하나의 게시글 삭제하기
	public int requestDeleteBoardById(int boardId, int userId) {
		int responseRow = blogservice.deleteBoardById(boardId, userId);
		return responseRow;
	}
}
