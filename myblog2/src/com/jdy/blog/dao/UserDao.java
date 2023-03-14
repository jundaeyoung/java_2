package com.jdy.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdy.blog.dto.UserDto;

public class UserDao {

	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn;

	public UserDao() {

	}

	// 1.UserDTO를 만들어보세요.
	public UserDto select(int userId) {
		// UserDto 객체를 임의에 값을 넣어서 생성하고
		// 그 결과값을 main 함수에서 출력하시오.
		UserDto kimUser = new UserDto(1, "미스터킴");
		return kimUser;

		// DB에 있는 부분을 연동하고 싶다면
		// 거기에 맞는 기술들을 알아보고 분석해서 준비 하면 된다.

		// MySQL <--- 데이터관리(다중 접속 가능)
		// 드라이버..
		// Connnection 객체가 필요하다.
		// 주소,계정,비번,데이터베이스이름,포트번호,사용할 문자셋,현지시간
		// connection 이라는 객체안에 담겨져 있다.

		// connection 에서 연결처리 외 또 많이하는 작업은
		// SQL을 만들고 실행하는 일이다.
		// SQL 질이어를 만들기 위해선 Statement 객체가 필요하다.

		// connection 객체에서 Statment,prepareStatement를 생성할 수 있다.
		// connection.createStatement() OR
		// connection.prepareStatement 를 사용할 수 있다.
		// ? ? 에 값을 바인딩 하는 기능
		
		//prepareStatement 질의어를 생성하고 질의어를 실행시킬 수 있다.
		// select<-- executeQuery()사용하면 된다.
		// delete,update,insert<--executeUpdate()를 사용하면된다.
		// 쿼리를 실행하면 결과값은
		// executeQuery() --> ReseultSet을 반환한다.
		// executeUpdate() --> 적용받은 row 갯수를 반환한다.
		
	}
}
