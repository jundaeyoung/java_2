package com.jdy1787.myblog.service;

import com.jdy1787.myblog.dao.BlogDAO;
import com.jdy1787.myblog.dto.BlogDTO;

public class BlogService {

	private BlogDAO blogDAO;

	public BlogService() {
		blogDAO = new BlogDAO();
	}

	// 하나의 게시글 찾는 로직 만들기
	public BlogDTO selectByBoardId(int id) {

		BlogDTO resultDTO = blogDAO.select(id);

		return resultDTO;
	}

	public int deleteBoardById(int boardId, int userId) {

		int resultRow = 0;
		// 검증 userId 값과
		// board 테이블에 있는 작성자의 userId 값이 같은지 확인
		BlogDTO blogDTO = selectByBoardId(boardId);
		if (blogDTO != null) {
			int blogWriterId = blogDTO.getUserId();
			if (blogWriterId == userId) {
				// 삭제 요청 처리
				resultRow = blogDAO.delect(boardId);
			}
		} else {
			System.out.println("해당 정보가 없습니다.");
		}
		return resultRow;
	}
}
