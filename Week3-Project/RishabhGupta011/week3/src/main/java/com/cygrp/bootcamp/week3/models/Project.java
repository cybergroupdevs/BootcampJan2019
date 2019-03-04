package com.cygrp.bootcamp.week3.models;

public class Project {

	private int id;
	private String name;
	private int userId;
	
	
	
	public Project(int id, String name, int userId) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
	}
	
	
	public Project(String name) {
		super();
		this.name = name;
	}


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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
