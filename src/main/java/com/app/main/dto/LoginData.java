package com.app.main.dto;

public class LoginData {
	
	private String email;
	private String pass;
	public LoginData() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "LoginData [email=" + email + ", pass=" + pass + "]";
	}
	public LoginData(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}
	
}
