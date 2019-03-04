package com.example.demo2.controllers;
import java.util.List;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;



import com.example.demo2.beans.Employee;

import com.example.demo2.beans.EmployeeRegistration;



@Controller

public class EmployeeRetrieveController {
	
	@RequestMapping(method = RequestMethod.GET, value="/Employee/allEmployee")



	  @ResponseBody

	  public List<Employee> getAllEmployees() {

	  return null;

	  }

}
