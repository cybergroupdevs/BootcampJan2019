package model;


public class Employee {
	
	private int id;
	private String name;
	private String userName;
	private String gender;
	private String designation;
	private String empNo;
	private int contact;
	private String add;
	private String dep;
	
	public Employee(int id, String name, String userName, String gender,
			String designation, String empNo, int contact, String add, String dep ) {

		this.setId(id);
		this.setName(name);
		this.setUserName(userName);
		this.setGender(gender);
		this.setDesignation(designation);
		this.setEmpNo(empNo);
		this.setContact(contact);
		this.setAdd(add);
		this.setDep(dep);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}

}
