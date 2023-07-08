package com.example.StockCharting.Entity;

public class SigninRequest
{
	private String username;
	private String password;
	public SigninRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public SigninRequest() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
