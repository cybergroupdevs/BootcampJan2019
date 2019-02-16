package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.*;
@CrossOrigin(origins = "*")
@Controller
public class EmployeeRegistrationController {

	  @RequestMapping(method = RequestMethod.POST, value="/api/Employees")
	
	  @ResponseBody
	  public EmployeeRegistrationReply registerEmployee(@RequestBody Employee Employee) {
	  System.out.println("In registerEmployee");
	        EmployeeRegistrationReply stdregreply = new EmployeeRegistrationReply(); 
	        stdregreply.setName(Employee.getName());
	        stdregreply.setAge(Employee.getAge());
	        stdregreply.setDesignationID(Employee.getDesignationID());
	        stdregreply.setGender(Employee.getGender());
	        stdregreply.setEmail(Employee.getEmail());
	        stdregreply.setPhone(Employee.getPhone());
	        int ID = EmployeeRegistration.getInstance().add(Employee);
	        //We are setting the below value just to reply a message back to the caller
	     
	        stdregreply.setId(ID);
	        stdregreply.setRegistrationStatus("Successful");
	        return stdregreply;
	}


}
