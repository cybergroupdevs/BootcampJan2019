package com.example.beans;

import java.util.ArrayList;

import java.util.List;



public class StudentRegistration {
	private List<student> studentRecords;



    private static StudentRegistration stdregd = null;



    private StudentRegistration(){

    studentRecords = new ArrayList<student>();

    }



    public static StudentRegistration getInstance() {



        if(stdregd == null) {

              stdregd = new StudentRegistration();

              return stdregd;

            }

            else {

                return stdregd;

            }

    }



    public void add(student std) {

    studentRecords.add(std);

    }



public String upDateStudent(student std) {



for(int i=0; i<studentRecords.size(); i++)

        {

            student stdn = studentRecords.get(i);

            if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {

              studentRecords.set(i, std);//update the new record

              return "Update successful";

            }

        }



return "Update un-successful";

}



public String deleteStudent(String registrationNumber) {



for(int i=0; i<studentRecords.size(); i++)

        {

            student stdn = studentRecords.get(i);

            if(stdn.getRegistrationNumber().equals(registrationNumber)){

              studentRecords.remove(i);//update the new record

              return "Delete successful";

            }

        }



return "Delete un-successful";

}



    public List<student> getStudentRecords() {

    return studentRecords;

    }

}
