package com.deepakpahuja.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepakpahuja.beans.Employee;
import com.deepakpahuja.beans.EmployeeRegistration;

@CrossOrigin
@RestController
public class EmployeeUpdateController {
	@RequestMapping(method = RequestMethod.PUT, value="/update/student")
	@ResponseBody
	public String updateStudentRecord(@RequestBody Employee empn) {
	System.out.println("In updateStudentRecord");   
	    return EmployeeRegistration.getInstance().upDateStudent(empn);
	}
}
