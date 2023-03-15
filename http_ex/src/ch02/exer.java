package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class exer {
	public static void main(String[] args) {

		JsonArray jsonArray = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "홍길동");
		jsonObject.addProperty("age", 20);
		jsonObject.addProperty("address", "부산");

		JsonObject jsonObject1 = new JsonObject();
		jsonObject1.addProperty("name", "이순신");
		jsonObject1.addProperty("age", 33);
		jsonObject1.addProperty("address", "서울");

		JsonObject jsonObject2 = new JsonObject();
		jsonObject2.addProperty("name", "세종대왕");
		jsonObject2.addProperty("age", 59);
		jsonObject2.addProperty("address", "세종시");

		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);

		System.out.println(jsonArray);

		System.out.println("=================");

		JsonObject jsonObject4 = new JsonObject();
		JsonArray jsonArray2 = new JsonArray();
		jsonObject4.add("todoList", jsonArray2);

		JsonObject jsonObject5 = new JsonObject();
		jsonObject5.addProperty("id", 1);
		jsonObject5.addProperty("title", "청소");
		jsonObject5.addProperty("complete", false);

		JsonObject jsonObject6 = new JsonObject();
		jsonObject6.addProperty("id", 1);
		jsonObject6.addProperty("title", "영어공부");
		jsonObject6.addProperty("complete", true);

		jsonArray2.add(jsonObject5);
		jsonArray2.add(jsonObject6);

		jsonObject4.addProperty("server_name", "server_1");

		System.out.println(jsonObject4);

	}
}
