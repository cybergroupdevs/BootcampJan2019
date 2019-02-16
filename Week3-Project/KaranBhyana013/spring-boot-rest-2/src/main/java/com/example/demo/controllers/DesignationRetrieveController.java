package com.example.demo.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Designation;
import com.example.demo.DesignationRegistration;

@CrossOrigin(origins = "*")
@Controller
public class DesignationRetrieveController {
	 @RequestMapping(method = RequestMethod.GET, value="/api/Designations")
	 
	  @ResponseBody
	  public List<Designation> getAllDesignations() {
	  return DesignationRegistration.getInstance().getDesignationRecords();
	  }
}
