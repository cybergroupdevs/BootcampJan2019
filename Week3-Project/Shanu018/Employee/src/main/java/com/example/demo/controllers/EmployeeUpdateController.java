package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.beans.Employee;
import com.example.demo.beans.EmployeeRegistration;
@Controller
public class EmployeeUpdateController {
	@RequestMapping(method = RequestMethod.PUT, value="/update/employee")
	@ResponseBody
	public String updateStudentRecord(@RequestBody Employee emp) {
		System.out.println("In updateemployeeRecord");   
		return EmployeeRegistration.getInstance().upDateEmployee(emp);
	}
}