package com.jdy.albums;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jdy.albums.controller.Albumscontroller;
import com.jdy.albums.dto.AlbumsDTO;

import ch01.Albums;

public class MainTest1 {
	public static void main(String[] args) {

		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/albums");
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

				Type listType = new TypeToken<List<Albums>>() {
				}.getType();

				ArrayList<Albums> userList = gson.fromJson(str, listType);
				for (Albums albums : userList) {
					System.out.println(albums.toString());
				}

//				Albums albums = gson.fromJson(str, Albums.class);
//				System.out.println("userId :" + albums.getUserId());
//				System.out.println("id :" + albums.getId());
//				System.out.println("title :" + albums.getTitle());

				Albumscontroller albumscontroller = new Albumscontroller();
				// select
//				AlbumsDTO dto = albumscontroller.requstUserId(1);
//				System.out.println(dto);

				// insert
				for (Albums albums : userList) {
					int result = albumscontroller.requestInsertUserId(albums.getUserId(), albums.getId(),
							albums.getTitle());
					System.out.println(result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
