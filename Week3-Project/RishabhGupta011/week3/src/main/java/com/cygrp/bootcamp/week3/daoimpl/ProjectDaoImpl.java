package com.cygrp.bootcamp.week3.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.cygrp.bootcamp.week3.dao.ProjectDao;
import com.cygrp.bootcamp.week3.models.Project;

public class ProjectDaoImpl implements ProjectDao {
	
	
//	@Value("${jdbc.url}")
	private String dbURL = "jdbc:sqlserver://DESKTOP-JRVOJ7H;databaseName=JDB";
//	@Value("${jdbc.user}")
	private String user ="sa";
//	@Value("${jdbc.password}")
	private String password = "password";
	
	@Override
	public List<Project> getProjectsForUser(int userid) {
		
		List<Project> projectsList = new ArrayList<Project>(); 
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.dbURL,this.user,this.password);
			if(conn != null) {
				
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Projects WHERE UserId = ?");
				stmt.setInt(1,userid);				
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					projectsList.add(new Project(rs.getInt(1),rs.getString(2),rs.getInt(3)));
				}
				
				return projectsList;
				
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
		
		return projectsList;
	}

	@Override
	public void createProject(Project project) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.dbURL,this.user,this.password);
			if(conn != null) {
				
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO Projects VALUES(?,?)");
				stmt.setString(1,project.getName());				
				stmt.setInt(2,project.getUserId());
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
	public void updateProject(Project project) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.dbURL,this.user,this.password);
			if(conn != null) {
				
				PreparedStatement stmt = conn.prepareStatement("UPDATE Projects SET Name = ? WHERE Id = ? and UserId = ?");
				stmt.setString(1,project.getName());				
				stmt.setInt(2,project.getId());
				stmt.setInt(3, project.getUserId());
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
	public void deleteProject(int id,int userid) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.dbURL,this.user,this.password);
			if(conn != null) {
				
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM Projects WHERE Id = ? AND UserId = ?");
				stmt.setInt(1,id);	
				stmt.setInt(2, userid);
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
	

}
