function signupform(){
	var firstname = document.getElementById("First Name").value;
	var fname=firstname.valueOf();
	var lastname = document.getElementById("Last Name").value;
	var lname=lastname.valueOf();
	var Email = document.getElementById("Email").value;
	var mail=Email.valueOf();
	var pass = document.getElementById("Password").value;
	var pass1=pass.valueOf();
	var repass = document.getElementById("Repassword").value;
	var pass2=repass.valueOf();
	var country = document.getElementById("Country").value;
	var region=country.valueOf();
	var employeeid = document.getElementById("Employee Id").value;
	var empid=employeeid.valueOf();
	var dob = document.getElementById("dob").value;
	var terms = document.getElementById("licence").value;
	var licence=terms.valueOf();
if(pass1 == pass2 && licence == 1 ){
	var datafor_EmployeeDetail ={
								"Id": empid,
								"firstname":fname,
								"lastname":lname,
								"fathername": "Not Specified",
								"Email":mail,
								"Phone": "Not Specified",
								"country": region,
								"dob":dob, 
								"gender": "NA",
								"designation": "Intern",
								"address": "Needs to be updated",
								"AuthenticateUser": {
								"Id": empid,
								"Email": mail,
								"password": pass1,
								"Terms": licence,
								},
								"EducationDetail":{
								"GraduationDegree": "Not Specified",
								"GraduationMarks": 0,
								"Id": empid,
								"TenthBoard": "Not Specified",
								"Tenthmarks": 0,
								"Twelfthboard": "Not Specified",
								"Twelfthmarks": 0,	
										},
								};
						$.ajax	({
							url: "http://localhost:50052/api/EmployeeDetail",
							data: datafor_EmployeeDetail,
							type: 'post',
							dataType: 'json', 
							success: function(res){ 
													alert("You've been signed up successfully, Please Login to continue");
													window.location="index.html";
												}
								});
		}else{alert("Password doesn't match");
			window.location.href = "Signup.html";}
};



	