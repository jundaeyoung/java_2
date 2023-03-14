package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 1. connection 객체를 얻는 연습
// 주소,계정 비번 등
public class DBHelper {
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_DATABASE_NAME = "myblog";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "bloguser";
	private static final String DB_PASSWORD = "1q2w3e4r5t";

	private Connection conn;

	// 싱글톤 패턴
	// 1.기본생성자 만들기 (private로 설정)
	// 2.자기 자신을 선언해주기
	// 3. 외부 어디서든지 접근 가능한 static 메소드를 만들어준다.

	// 1
	private DBHelper() {

	}

	// 2
	private static DBHelper dbHelper;

	// 3
	public static DBHelper getInstance() {
		if (dbHelper == null) {
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}

	public Connection getConnection() {
		if (conn == null) {
			// 한번도 생성하지 않았다면
			String urlFormat = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DB_DATABASE_NAME, DB_CHARSET);

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">>DB 연결 완료<<");
			} catch (Exception e) {
				System.out.println(">> DBHelper 에서 오류가 발생했어. <<");
				e.printStackTrace();
			}
		}
		// DB안에서 주소 찍어보기 (todo 추후 삭제 예정)
		// System.out.println("DB안에서 주소 찍어보기"+this);
		return conn;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}
}
