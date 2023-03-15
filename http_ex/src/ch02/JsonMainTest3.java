package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ch01.Todo;

public class JsonMainTest3 {
	public static void main(String[] args) {
		
		JsonArray jsonArray = new JsonArray();
		// [ ] <-- 여기 까지 만들어진것이다.
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "스즈매");
		jsonObject.addProperty("age", 22);
		
		System.out.println(jsonArray);
		System.out.println("===============");
		System.out.println(jsonObject);
		
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		
		System.out.println("------------------");
		System.out.println(jsonArray);
		
		// JsonArray 에서 JsonObject 꺼내는 방법
		JsonObject targetObject = jsonArray.get(2).getAsJsonObject();
		System.out.println(targetObject);
		String strName = targetObject.get("name").getAsString();
		System.out.println(strName);
		
		
		System.out.println("=================");
		
		Todo todo1 = new Todo();
		
		JsonArray jsonArray2 = new JsonArray();
		JsonObject jsonObject2 = new JsonObject();
		jsonObject2.addProperty("userId", 1);
		jsonObject2.addProperty("id", 1);
		jsonObject2.addProperty("title", "delectus aut autem");
		jsonObject2.addProperty("completed", false);
		
		todo1.setUserId(1);
		todo1.setId(1);
		todo1.setTitle("delectus aut autem");
		todo1.setCompleted(false);
		
		Todo todo2 = new Todo();

		
		JsonObject jsonObject3 = new JsonObject();
		jsonObject3.addProperty("userId", 1);
		jsonObject3.addProperty("id", 2);
		jsonObject3.addProperty("title", "quis ut nam facilis et officia qui");
		jsonObject3.addProperty("completed", false);
		
		todo2.setUserId(1);
		todo2.setId(2);
		todo2.setTitle("quis ut nam facilis et officia qui");
		todo2.setCompleted(false);
		
		JsonObject jsonObject4 = new JsonObject();
		jsonObject4.addProperty("userId", 1);
		jsonObject4.addProperty("id", 3);
		jsonObject4.addProperty("title","fugiat veniam minus");
		jsonObject4.addProperty("completed", false);
		
		Todo todo3 = new Todo();

		todo3.setUserId(1);
		todo3.setId(3);
		todo3.setTitle("fugiat veniam minus");
		todo3.setCompleted(false);
		
		jsonArray2.add(jsonObject2);
		jsonArray2.add(jsonObject3);
		jsonArray2.add(jsonObject4);
		System.out.println(jsonArray2);
		System.out.println(todo1.getId());
		System.out.println(todo1.getUserId());
		System.out.println(todo1.getTitle());
		System.out.println(todo1.isCompleted());
		
		
		
		
		}
	
		
}
