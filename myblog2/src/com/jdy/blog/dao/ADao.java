package com.jdy.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBHelper;

public class ADao {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn;

	public ADao() {
		conn = DBHelper.getInstance().getConnection();
	}

	public String select(String msg) {
		
		
		String copyMsg = "[[ >>"+msg+"<< ]]";
		
		try {
			pstmt = conn.prepareStatement(copyMsg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return copyMsg;
	}
}
