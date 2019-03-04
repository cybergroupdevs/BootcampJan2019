package com.arpitdave.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.arpitdave.beans.Employee;
import com.arpitdave.beans.EmployeeRegistration;

@Controller
public class EmployeeRetrieveController {
  @RequestMapping(method = RequestMethod.GET, value="/employee/allemployee")
  @ResponseBody
  public List<Employee> getAllStudents() {
  return EmployeeRegistration.getInstance().getEmployeeRecords();
  }
}