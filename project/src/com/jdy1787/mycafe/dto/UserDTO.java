package com.jdy1787.mycafe.dto;

public class UserDTO {

	private int id;
	private String name;
	private String user_id;
	private String password;
	private String email;
	private String address;
	private String tel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public UserDTO() {
	}
	public UserDTO(int id, String name, String user_id, String email, String address, String tel) {
		this.id = id;
		this.name = name;
		this.user_id = user_id;
		this.email = email;
		this.address = address;
		this.tel = tel;
	}
	
	public UserDTO(String user_id, String password) {
		this.user_id = user_id;
		this.password = password;
	}
	@Override
	public String toString() {
		return " id = " + id + "\n\n"
				+" name = " + name + "\n\n"
				+" user_id = " + user_id + "\n\n"
				+" email = " + email + "\n\n"
				+" address = " + address + "\n\n"
				+" tel = " + tel;
	}

	
	
	
	
}
