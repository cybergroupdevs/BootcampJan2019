package com.example.demo.controllers;
import com.example.demo.EmployeeRegistration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
@CrossOrigin(origins = "*")
@Controller
public class EmployeeDeleteController {
	@RequestMapping(method = RequestMethod.DELETE, value="/api/Employees/{regdNum}")
	
	@ResponseBody
	public String deleteEmployeeRecord(@PathVariable("regdNum") int regdNum) {
	System.out.println("In deleteEmployeeRecord");   
	    return EmployeeRegistration.getInstance().deleteEmployee(regdNum);
	}

	
}
