package ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import ch01.Todo;

public class MainTest {
	public static void main(String[] args) {

		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.connect();
			int statusCode = conn.getResponseCode();

			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = null;
				StringBuffer sb = new StringBuffer();
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				String str = sb.toString();
//				System.out.println(sb.toString());
//				System.out.println(str);
				Gson gson = new Gson();
				
				Type listType = new TypeToken<List<User>>(){}.getType();
				ArrayList<User> todoList = gson.fromJson(str, listType);
				for (User user : todoList) {
					System.out.println(user.toString());
				}
//				User user = gson.fromJson(str, User.class);

				
//				System.out.println(user.getAddress().city);
//				System.out.println(user.getAddress().getGeo().lat);
//				System.out.println(user.getAddress().getGeo().lng);
//				System.out.println(user.getCompany().name);
//				JsonObject jsonObject = new JsonObject();
//				jsonObject.addProperty("id", user.getId());
//				jsonObject.addProperty("name", user.getName());
//				jsonObject.addProperty("username", user.getUsername());
//				jsonObject.addProperty("email", user.getEmail());
//
//				JsonObject jsonObject2 = new JsonObject();
//
//				jsonObject.add("address", jsonObject2);
//				jsonObject2.addProperty("street", user.getAddress().getStreet());
//				jsonObject2.addProperty("suite", user.getAddress().getSuite());
//				jsonObject2.addProperty("city", user.getAddress().getCity());
//				jsonObject2.addProperty("zipcode", user.getAddress().getZipcode());
//
//				JsonObject jsonObject3 = new JsonObject();
//
//				jsonObject2.add("geo", jsonObject3);
//				jsonObject3.addProperty("lat", user.getAddress().getGeo().getLat());
//				jsonObject3.addProperty("lng", user.getAddress().getGeo().getLng());
//
//				JsonObject jsonObject4 = new JsonObject();
//
//				jsonObject.addProperty("phone", user.getPhone());
//				jsonObject.addProperty("website", user.getWebsite());
//				jsonObject.add("company", jsonObject4);
//				jsonObject4.addProperty("name", user.getCompany().getName());
//				jsonObject4.addProperty("catchPhrase", user.getCompany().getCatchPhrase());
//				jsonObject4.addProperty("bs", user.getCompany().getBs());

//				System.out.println(jsonObject);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
