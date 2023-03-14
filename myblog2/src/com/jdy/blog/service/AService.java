package com.jdy.blog.service;

import com.jdy.blog.dao.ADao;




public class AService {
	ADao aDao;	
	public AService() {
		aDao=new ADao();
	}
	public String select(String msg) {
		// AS(null) --> AC(null)
		String result2= aDao.select(msg);
		
		return result2;
	}
}
