package com.deepakpahuja.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deepakpahuja.beans.Employee;
import com.deepakpahuja.beans.EmployeeRegistration;

@CrossOrigin
@Controller
public class EmployeeRetrieveController {
	 @RequestMapping(method = RequestMethod.GET, value="/student/allstudent")
	  @ResponseBody
	  public List<Employee> getAllStudents() {
			System.out.println("In retrieveStudentRecord");   
	  return EmployeeRegistration.getInstance().getStudentRecords();
	  }

}
