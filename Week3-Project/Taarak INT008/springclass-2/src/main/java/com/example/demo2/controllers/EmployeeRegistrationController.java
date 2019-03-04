package com.example.demo2.controllers;
import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;



import com.example.demo2.beans.*;



@Controller

public class EmployeeRegistrationController {
	 @RequestMapping(method = RequestMethod.POST, value="/register/Employee")
	 @ResponseBody

	  public EmployeeRegistrationReply registerEmployee(@RequestBody Employee Employee) {

	  System.out.println("In registerEmployee");

	        EmployeeRegistrationReply stdregreply = new EmployeeRegistrationReply();           

	        EmployeeRegistration.getInstance().add(Employee);

	        //We are setting the below value just to reply a message back to the caller

	        stdregreply.setName(Employee.getName());

	        stdregreply.setId(Employee.getId());

	        stdregreply.setPassword(Employee.getPassword());

	        stdregreply.setRegistrationStatus("Successful");



	        return stdregreply;

	}

	 @RequestMapping(method = RequestMethod.PUT, value="/register/Employee")
	 @ResponseBody

	  public EmployeeRegistrationReply updateEmployee(@RequestBody Employee Employee) {

	  System.out.println("In registerEmployee");

	        EmployeeRegistrationReply stdregreply = new EmployeeRegistrationReply();           

	        EmployeeRegistration.getInstance().updateEmployee(Employee);

	        //We are setting the below value just to reply a message back to the caller

	        stdregreply.setName(Employee.getName());

	        stdregreply.setId(Employee.getId());

	        stdregreply.setPassword(Employee.getPassword());

	        stdregreply.setRegistrationStatus("Successful");



	        return stdregreply;

	}

	 @RequestMapping(method = RequestMethod.DELETE, value="/register/Employee/{id}")
	 @ResponseBody

	  public EmployeeRegistrationReply deleteEmployee(@PathVariable("id") int id) {

	  System.out.println("In registerEmployee");

	        EmployeeRegistrationReply stdregreply = new EmployeeRegistrationReply();           

	        EmployeeRegistration.getInstance().deleteEmployee(id);

	        //We are setting the below value just to reply a message back to the caller

	        stdregreply.setRegistrationStatus("Successful");



	        return stdregreply;

	}


}
