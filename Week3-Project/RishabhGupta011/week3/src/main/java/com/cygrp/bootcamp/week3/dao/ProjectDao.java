package com.cygrp.bootcamp.week3.dao;

import java.util.List;

import com.cygrp.bootcamp.week3.models.Project;

public interface ProjectDao {

	public List<Project> getProjectsForUser(int userid);
	public void createProject(Project project);
	public void updateProject(Project project);
	public void deleteProject(int id , int userid);
	
}
