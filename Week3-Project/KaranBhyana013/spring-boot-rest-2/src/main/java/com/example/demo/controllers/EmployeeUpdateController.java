package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Employee;
import com.example.demo.EmployeeRegistration;
@CrossOrigin(origins = "*")
@Controller
public class EmployeeUpdateController {
	@RequestMapping(method = RequestMethod.PUT, value="/api/Employees/{regdNum}")
	@ResponseBody
	public String updateEmployeeRecord(@RequestBody Employee stdn , @PathVariable("regdNum") int regdNum) {
	System.out.println("In updateEmployeeRecord");   
	    return EmployeeRegistration.getInstance().upDateEmployee(regdNum , stdn);
	}

}
