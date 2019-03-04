
package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.beans.EmployeeRegistration;


@Controller
public class EmployeeDeleteController {
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/employee/{regdNum}")
	@ResponseBody
	public String deleteEmployeeRecord(@PathVariable("regdNum") String regdNum) {
		System.out.println("In deleteStudentRecord");   
	    return EmployeeRegistration.getInstance().deleteEmployee(regdNum);
	}
}