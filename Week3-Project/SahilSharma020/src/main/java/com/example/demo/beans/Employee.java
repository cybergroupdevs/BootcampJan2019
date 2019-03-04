package com.example.demo.beans;

public class Employee {
	
int id;
String Name;
int Age;
String Gender;
int designationId;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	this.Gender = gender;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	this.Name = name;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	this.Age = age;
}
public int getDesignationId() {
	return designationId;
}
public void setDesignationId(int designationId) {
	this.designationId = designationId;
}

}
