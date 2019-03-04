package model;

public class login {

	private int id;
	private String name;
	private String userName;
	private String password;
	
	
	public login(int id,String name, String userName, String password) {
		this.setId(id);
		this.setName(name);
		this.setUserName(userName);
		this.setPassword(password);		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}