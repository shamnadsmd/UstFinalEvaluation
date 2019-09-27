package com.ust.beans;

public class Ust_Login {
	
//	Declaring needed variables
	
	private String userid;
	private String username;
	private String password;
	public Ust_Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ust_Login(String userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	@Override
	public String toString() {
		return "Ust_Login [userid=" + userid + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	

}
