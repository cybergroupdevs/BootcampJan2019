package com.example.demo.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Employee;
import com.example.demo.EmployeeRegistration;
@CrossOrigin(origins = "*")
@Controller
public class EmployeeRetrieveControllerIndividual {
	 @RequestMapping(method = RequestMethod.GET, value="/api/Employees/{regdNum}")
	
	  @ResponseBody
	  public List<Employee> getAllEmployees(@PathVariable("regdNum") int regdNum) {
		 System.out.println("In EmployeeRetrieveControllerIndividual");   
	  return EmployeeRegistration.getInstance().getEmployeeRecords(regdNum);
	  }
}
