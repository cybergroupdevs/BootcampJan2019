package com.example.demo.EmployeeDetail;
import javax.persistence.Entity;

@Entity
public class EducationDetail {
	private String Id;
	private String Tenthboard;
	private float Tenthmarks;
	private String Twelfthboard;
	private float Twelfthmarks;
	private String Graduationdegree;
	private float Graduationmarks;
	
	//constructor for create Api
	public EducationDetail(String Id,
			String Tenthboard,float Tenthmarks, 
			String Twelfthboard,float Twelfthmarks,
			String Graguationdegree,float Graduationmarks)
	{	
		this.setId(Id);
		this.setTenthboard(Tenthboard);
		this.setTenthmarks(Tenthmarks);
		this.setTwelfthboard(Twelfthboard);
		this.setTwelfthmarks(Twelfthmarks);
		this.setGraduationdegree(Graguationdegree);
		this.setGraduationmarks(Graduationmarks);
	}
	
	//constructor for update Api
	public EducationDetail(String Tenthboard,float Tenthmarks, 
			String Twelfthboard,float Twelfthmarks,
			String Graguationdegree,float Graduationmarks)
	{	
		this.setTenthboard(Tenthboard);
		this.setTenthmarks(Tenthmarks);
		this.setTwelfthboard(Twelfthboard);
		this.setTwelfthmarks(Twelfthmarks);
		this.setGraduationdegree(Graguationdegree);
		this.setGraduationmarks(Graduationmarks);
	}
	
	//getters and setter
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTenthboard() {
		return Tenthboard;
	}
	public void setTenthboard(String tenthboard) {
		Tenthboard = tenthboard;
	}
	public float getTenthmarks() {
		return Tenthmarks;
	}
	public void setTenthmarks(float tenthmarks) {
		Tenthmarks = tenthmarks;
	}
	public String getTwelfthboard() {
		return Twelfthboard;
	}
	public void setTwelfthboard(String twelfthboard) {
		Twelfthboard = twelfthboard;
	}
	public float getTwelfthmarks() {
		return Twelfthmarks;
	}
	public void setTwelfthmarks(float twelfthmarks) {
		Twelfthmarks = twelfthmarks;
	}
	public String getGraduationdegree() {
		return Graduationdegree;
	}
	public void setGraduationdegree(String graduationdegree) {
		Graduationdegree = graduationdegree;
	}
	public float getGraduationmarks() {
		return Graduationmarks;
	}
	public void setGraduationmarks(float graduationmarks) {
		Graduationmarks = graduationmarks;
	}

	
	
	
	
	
	
}
