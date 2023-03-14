package com.jdy.blog.dto;

public class UserDto {

	private int id;
	private String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + "]";
	}

	public UserDto(int id, String userName) {
		this.id = id;
		this.userName = userName;
	}

}
