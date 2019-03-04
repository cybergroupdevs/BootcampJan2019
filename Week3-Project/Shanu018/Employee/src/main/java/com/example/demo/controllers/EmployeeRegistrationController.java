package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.beans.Employee;
import com.example.demo.beans.EmployeeRegistration;
import com.example.demo.beans.EmployeeRegistrationReply;


@Controller

public class EmployeeRegistrationController {
	  @RequestMapping(method = RequestMethod.POST, value="/register/employee")
	  @ResponseBody
	  public EmployeeRegistrationReply registerEmployee(@RequestBody Employee employee) {
	  System.out.println("In registerEmployee");
	        EmployeeRegistrationReply stdregreply = new EmployeeRegistrationReply();           
	        EmployeeRegistration.getInstance().add(employee);
	        //We are setting the below value just to reply a message back to the caller
	        stdregreply.setName(employee.getName());
	        stdregreply.setDesignation(employee.getDesignation());
	        stdregreply.setEid(employee.getEid());

	        return stdregreply;
	}
	  

}
