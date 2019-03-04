package com.cygrp.bootcamp.week3.dao;

import com.cygrp.bootcamp.week3.models.User;

public interface UserDao {

	public User getUser(String username , String password);
	public void createUser(User user);
	public void deleteUser(int userId);
	public boolean isUnqiue(String username);
	
}
