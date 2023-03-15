package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class MainTest5 {
	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int statusCode = conn.getResponseCode();
			
			if(statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String line = null;
				StringBuffer sb = new StringBuffer();
				while( ( line = reader.readLine())!=null) {
					sb.append(line);
				}
				
				String result = sb.toString();
				
				Gson gson = new Gson();
				
				Type listType = new TypeToken<List<User>>() {}.getType();
				
				ArrayList<User> userList = gson.fromJson(result, listType);
				for (User user : userList) {
					System.out.println(user.toString());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
//		JsonObject jsonObject = new JsonObject();
//		jsonObject.addProperty("id", 1);
//		jsonObject.addProperty("name", "Leanne Graham");
//		jsonObject.addProperty("username", "Bret");
//		jsonObject.addProperty("email", "Sincere@april.biz");
//		
//		JsonObject jsonObject2 =new JsonObject();
//		
//		jsonObject.add("address",jsonObject2 );
//		jsonObject2.addProperty("street", "Kulas Light");
//		jsonObject2.addProperty("suite", "Apt. 556");
//		jsonObject2.addProperty("city", "Gwenborough");
//		jsonObject2.addProperty("zipcode", "92998-3874");
//		
//		JsonObject jsonObject3 =new JsonObject();
//		
//		jsonObject2.add("geo", jsonObject3);
//		jsonObject3.addProperty("lat", "-37.3159");
//		jsonObject3.addProperty("lng", "81.1496");
//		
//		JsonObject jsonObject4 =new JsonObject();
//
//		jsonObject.addProperty("phone", "1-770-736-8031 x56442");
//		jsonObject.addProperty("website", "hildegard.org");
//		jsonObject.add("company", jsonObject4);
//		jsonObject4.addProperty("name", "Romaguera-Crona");
//		jsonObject4.addProperty("catchPhrase", "Multi-layered client-serverneural-net");
//		jsonObject4.addProperty("bs", "harness real-time e-markets");
//		
	}
}
