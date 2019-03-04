package com.deepakpahuja.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepakpahuja.beans.*;

@CrossOrigin
@RestController
public class EmployeeRegistrationController {
	
	  @RequestMapping(method = RequestMethod.POST, value="/register/student")
	  
	  @ResponseBody
	  public EmployeeRegistrationReply registerStudent(@RequestBody Employee employee) {
		    System.out.println("In registerEmployee");
		    System.out.println(employee.getName());
		    EmployeeRegistrationReply empregreply = new EmployeeRegistrationReply();           
	        EmployeeRegistration.getInstance().add(employee);
	        //We are setting the below value just to reply a message back to the caller
	        empregreply.setEmployeeId(employee.getEmployeeId());
	        empregreply.setName(employee.getName());
	        empregreply.setDesignation(employee.getDesignation());
	        empregreply.setPhoneNo(employee.getPhoneNo());
	        empregreply.setSignUpId(employee.getSignUpId());
	        empregreply.setRegistrationStatus("Successful");
		    System.out.println("below successful");
	        return empregreply;
	}
	
}
