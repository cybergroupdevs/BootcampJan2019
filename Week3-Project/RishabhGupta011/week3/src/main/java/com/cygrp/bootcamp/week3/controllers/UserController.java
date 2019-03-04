package com.cygrp.bootcamp.week3.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cygrp.bootcamp.week3.daoimpl.ProjectDaoImpl;
import com.cygrp.bootcamp.week3.daoimpl.UserDaoImpl;
import com.cygrp.bootcamp.week3.models.Project;
import com.cygrp.bootcamp.week3.models.User;
import com.cygrp.bootcamp.week3.responses.LoginResponse;
import com.cygrp.bootcamp.week3.responses.Response;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@RequestMapping(method = RequestMethod.GET, value="/v1/users")
	public List<User> getUsers(){
		
		List<User> usersList = new ArrayList<User>();
		return usersList;
		
	}

	@RequestMapping(method = RequestMethod.POST, value="/v1/login")
	public ResponseEntity<LoginResponse> login(@RequestBody User user){
		
		User u;
		UserDaoImpl userDaoImpl =  new UserDaoImpl();
		u = userDaoImpl.getUser(user.getUsername(), user.getPassword());
		
		if(u == null)
			return new ResponseEntity<LoginResponse>(new LoginResponse(0,"Invalid Login Credentials",0,""),HttpStatus.OK);
		else
			return new ResponseEntity<LoginResponse>(new LoginResponse(1,"Login Successfull",u.getId(),u.getUsername()),HttpStatus.OK);

		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/v1/signup")
	public ResponseEntity<Response> signup(@RequestBody User user){
		String username = user.getUsername();
		String password = user.getPassword();
		
		UserDaoImpl userDaoImpl =  new UserDaoImpl();
		int status = 0;
		String message = "";
		if(username.equals(""))
		{
			status = 0;
			message = "Username cannot be empty";
		}
		else if(!userDaoImpl.isUnqiue(username))
		{
			status = 0;
			message = "Username Should be Unique";
		}
		else if(password.length()<8 || password.length()>13)
		{
			status = 0;
			message = "Password length must be between 8 and 13";
		}
		else
		{
			userDaoImpl.createUser(new User(username,password));
			status = 1;
			message =  "User Registration Successfully"; 
		}

		return new ResponseEntity<Response>(new Response(status,message),HttpStatus.OK);

		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/v1/users/{id}")
	public ResponseEntity<Response>  deleteUser(@PathVariable("id") int id){
		
		UserDaoImpl userDaoImpl =  new UserDaoImpl();
		userDaoImpl.deleteUser(id);
		return new ResponseEntity<Response>(new Response(1,"User deleted successfully"),HttpStatus.OK);
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/v1/users/{id}/projects")
	public List<Project> getProjectsForUser(@PathVariable("id") int id){
		
		ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();
		return projectDaoImpl.getProjectsForUser(id);
		
	}

	
	@RequestMapping(method = RequestMethod.POST, value="/v1/users/{id}/projects")
	public ResponseEntity<Response>  getProjectsForUser(@PathVariable("id") int id,@RequestBody Project project){
		project.setUserId(id);
		
		ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();
		
		if(project.getName() == "")	
		return new ResponseEntity<Response>(new Response(0,"Project name cannot be empty"),HttpStatus.OK);
		else
			{ projectDaoImpl.createProject(project);
			return new ResponseEntity<Response>(new Response(1,"Project created successfully"),HttpStatus.OK);
			}
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/v1/users/{id}/projects/{pid}")
	public ResponseEntity<Response>  getProjectsForUser(@PathVariable("id") int id,@PathVariable("pid") int pid){
		
		ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();
		projectDaoImpl.deleteProject(pid, id);
		return new ResponseEntity<Response>(new Response(1,"Project deleted successfully"),HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/v1/users/{id}/projects")
	public ResponseEntity<Response>  updateProject(@PathVariable("id") int id,@RequestBody Project project){
		
		ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();
		project.setUserId(id);
		
		if(project.getName() == "")	
		return new ResponseEntity<Response>(new Response(0,"Project name cannot be empty"),HttpStatus.OK);
		else
			{ projectDaoImpl.updateProject(project);
			return new ResponseEntity<Response>(new Response(1,"Project updated successfully"),HttpStatus.OK);
			}
		
	}	
	
			
}
