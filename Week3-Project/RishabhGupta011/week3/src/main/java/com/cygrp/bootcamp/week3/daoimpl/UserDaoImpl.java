package com.cygrp.bootcamp.week3.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Value;

import com.cygrp.bootcamp.week3.dao.UserDao;
import com.cygrp.bootcamp.week3.models.User;

public class UserDaoImpl implements UserDao {
	
//	@Value("${jdbc.url}")
	private String dbURL = "jdbc:sqlserver://DESKTOP-JRVOJ7H;databaseName=JDB";
//	@Value("${jdbc.user}")
	private String user ="sa";
//	@Value("${jdbc.password}")
	private String password = "password";
	
	
	@Override
	public User getUser(String username, String password) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.dbURL,this.user,this.password);
			if(conn != null) {
				
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE UserName = ? AND Password = ?");
				stmt.setString(1,username);
				stmt.setString(2, password);				
				ResultSet rs = stmt.executeQuery();
				if(rs.next())
				{
					return new User(rs.getInt(1),rs.getString(2),rs.getString(3));
				}
				else
					return null;
				
		}
			} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally {
	
			try {
				if(conn !=null && !conn.isClosed())
				{
					conn.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public void createUser(User user) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.dbURL,this.user,this.password);
			if(conn != null) {
				
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users VALUES(?,?)");
				stmt.setString(1,user.getUsername());
				stmt.setString(2,user.getPassword());				
				stmt.executeUpdate();
				
		}
			} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally {
	
			try {
				if(conn !=null && !conn.isClosed())
				{
					conn.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteUser(int userId) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.dbURL,this.user,this.password);
			if(conn != null) {
				
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM Users WHERE Id = ?");
				stmt.setInt(1,userId);				
				stmt.executeUpdate();		
				
		}
			} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally {
	
			try {
				if(conn !=null && !conn.isClosed())
				{
					conn.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public boolean isUnqiue(String username) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.dbURL,this.user,this.password);
			if(conn != null) {
				
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE UserName = ? ");
				stmt.setString(1,username);			
				ResultSet rs = stmt.executeQuery();
				return !rs.next();
				
		}
			} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally {
	
			try {
				if(conn !=null && !conn.isClosed())
				{
					conn.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return false;
	}

	
}
