package com.jdy.albums.dto;

public class AlbumsDTO {

	private int userId;
	private int id;
	private String title;

	public AlbumsDTO() {

	}

	public AlbumsDTO(int userId, int id, String title) {
		this.userId = userId;
		this.id = id;
		this.title = title;
	}

	@Override
	public String toString() {
		return "AlbumsDTO [userId=" + userId + ", id=" + id + ", title=" + title + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
