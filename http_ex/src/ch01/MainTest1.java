package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class MainTest1 {
	public static void main(String[] args) {
		// Client --> Web Server --> dataBase에 접속해서
		// data 확인하고 Client로 다시 보냄
		// Client <-- Web Server <-- dataBase
		// 기본 자바 표준 기술인 http 클래스를 이용하여 http 통신을 통해서
		// 데이터를 요청하고 응답 받아보는 기술을 확인해 보자.

		// https://jsonplaceholder.typicode.com/todos
		// 프로토콜 :// 회사 주소 / todos

		// http 통신을 위해 필요한것
		// 1. URL 클래스
		// 2. HttpURLConnection 클래스
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/3");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // 다운캐스팅했음

			conn.setRequestMethod("GET");
			conn.connect(); // 실행

			int statusCode = conn.getResponseCode();
			System.out.println("statusCode : " + statusCode);

			// conn.getInputStream(); // 한 바이트씩 데이터를 읽어 들이는 녀석
			// new InputStreamReader(conn.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			// 문자 붙이기
			StringBuffer sb = new StringBuffer();
			String line = null;

			// reader.readLine() --> null 만나면 더이상 읽을 데이터가 없음
			// null이 아닐 때 까지 반복한다.
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

			String resultStr = sb.toString();
//			int resultindex = resultStr.indexOf("title");
//			int resultindexlast = resultStr.indexOf("completed");
//			String result = resultStr.substring(resultindex - 1, resultindexlast - 5);
			System.out.println(resultStr);

			// Gson 라이브러리 가지고 오고 설정하는 방법 알아두기(노션 참조)
			// Gson 대표적인 사용법 및 개념
			Gson gson = new Gson();

			Todo todo = new Todo();

			todo.setId(0);
			todo.setUserId(statusCode);
			todo.setTitle("");
			todo.setCompleted(false);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
