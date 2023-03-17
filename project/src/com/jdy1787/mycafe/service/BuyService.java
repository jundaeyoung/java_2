package com.jdy1787.mycafe.service;

import com.jdy1787.mycafe.dao.BuyDAO;
import com.jdy1787.mycafe.dto.BuyDTO;

public class BuyService {

	private BuyDAO cafeDAO;

	public BuyService() {
		cafeDAO = new BuyDAO();
	}

	public BuyDTO selectByUserName(String name) {
		BuyDTO resultDTO = cafeDAO.select(name);
		return resultDTO;
	}

	public int deleteUserName(String name) {
		int resultRow = 0;

		BuyDTO cafeDTO = selectByUserName(name);
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
		
		BuyDTO cafeDTO = selectByUserName(name);
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
	
	public int updateUserName(String name, String targetName) {
		int resultRow = 0;
		
		BuyDTO cafeDTO = selectByUserName(name);
		if(cafeDTO != null) {
			String cafeWriterName = cafeDTO.getName();
			if(name.equals(cafeWriterName)) {
				resultRow = cafeDAO.update(name,targetName);
			}
		}else {
			System.out.println("해당 이름이 없습니다.");
		}
		return resultRow;
	}
}
