package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Student;
import com.example.demo.StudentRegistration;
@Controller
public class StudentUpdateController {
	@RequestMapping(method = RequestMethod.PUT, value="/update/student")
	@ResponseBody
	public String updateStudentRecord(@RequestBody Student stdn) {
		System.out.println("In updateStudentRecord");   
		return StudentRegistration.getInstance().upDateStudent(stdn);
	}
}