package com.deepakpahuja.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.deepakpahuja.beans.EmployeeRegistration;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
public class EmployeeDeleteController {

	@RequestMapping(method = RequestMethod.DELETE, value="/delete/student/{regdNum}")
	
	@ResponseBody
	public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
	System.out.println("In deleteStudentRecord");   
	    return EmployeeRegistration.getInstance().deleteStudent(regdNum);
	}
}
