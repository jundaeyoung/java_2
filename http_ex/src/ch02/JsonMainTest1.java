package ch02;

import com.google.gson.JsonObject;

public class JsonMainTest1 {
	public static void main(String[] args) {

		// 출발
		// JSON 형식에 문자열을 만드는 방법
		// 1. 직접 형식을 지켜서 만들어주면 된다. ( 불편함 )
		String myJson = "{\r\n" 
					+ "	\"name\" : \"티모\"\r\n" 
					+ "}";
		// 그래서 개발자들이 만들어둔 JsonObject를 사용한다.
		JsonObject jsonObject1 = new JsonObject();
		// { } 여기 까지 만들어진것이다.
		jsonObject1.addProperty("name", "티모");
		System.out.println(jsonObject1);

	}
}
