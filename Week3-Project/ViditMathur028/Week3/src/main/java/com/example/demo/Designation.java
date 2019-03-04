package com.example.demo;

public class Designation {
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
public Designation() {
	Id=0;
	Name=null ;
}
public Designation(int id, String name) {
	Id=id;
	Name=name;
}
}
