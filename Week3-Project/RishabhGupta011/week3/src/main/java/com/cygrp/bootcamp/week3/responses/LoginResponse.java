package com.cygrp.bootcamp.week3.responses;

public class LoginResponse extends Response {
	
	int userid;
	String username;
	
	public LoginResponse(int status, String message, int userid , String username) {
		super(status,message);
		this.userid = userid;
		this.username = username;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
