package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class MainTest1 {
	public static void main(String[] args) {

		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/albums/1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
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
				
				Gson gson = new Gson();
				
				Albums albums = gson.fromJson(str, Albums.class);
				
				System.out.println("userId :" + albums.getUserId());
				System.out.println("id :" + albums.getId());
				System.out.println("title :" + albums.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
