package com.jdy1787.mycafe.service;

import com.jdy1787.mycafe.dao.CafeDAO;
import com.jdy1787.mycafe.dto.CafeDTO;

public class CafeService {

	private CafeDAO cafeDAO;

	public CafeService() {
		cafeDAO = new CafeDAO();
	}

	public CafeDTO selectByUserName(String name) {
		CafeDTO resultDTO = cafeDAO.select(name);
		return resultDTO;
	}

	public int deleteUserName(String name) {
		int resultRow = 0;

		CafeDTO cafeDTO = selectByUserName(name);
		if (cafeDTO != null) {
			String cafeWriterName = cafeDTO.getName();
			if (name.equals(cafeWriterName)) {
				resultRow = cafeDAO.delete(name);
			}
		}else {
			System.out.println("해당 정보가 없습니다.");
		}
		return resultRow;
	}
	
	public int insertUserName(String name) {
		int resultRow = 0;
		
		CafeDTO cafeDTO = selectByUserName(name);
		if (cafeDTO != null) {
			String cafeWriterName = cafeDTO.getName();
		if(name.equals(cafeWriterName)) {
			System.out.println("해당 이름이 존재합니다.");
			}	else {
				resultRow = cafeDAO.insert(name);
		}
		}
		return resultRow;
	}
}
