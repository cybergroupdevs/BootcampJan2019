package com.example.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.example.beans.student;
import com.example.beans.StudentRegistration;

@Controller
public class StudentRetrieveController {
	
	 @RequestMapping(method = RequestMethod.GET, value="/student/allstudent")
	  @ResponseBody
	  public List<student> getAllStudents() {

	  return StudentRegistration.getInstance().getStudentRecords();

	  }

}
