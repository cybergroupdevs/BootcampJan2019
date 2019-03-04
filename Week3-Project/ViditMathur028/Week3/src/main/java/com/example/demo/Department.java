package com.example.demo;

public class Department {
int Id;
String Name;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public Department() {
	Id=0;
	Name=null ;
}
public Department(int id, String name) {
	Id=id;
	Name=name;
}

}
