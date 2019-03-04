function signupform(){	
	var employeeid = document.getElementById("EmployeeId").value;
	var empid=employeeid.valueOf();
	var firstname = document.getElementById("FirstName").value;
	var fname=firstname.valueOf();
	var lastname = document.getElementById("LastName").value;
	var lname=lastname.valueOf();
	var email = document.getElementById("Email").value;
	var mail=email.valueOf();
	var password = document.getElementById("Password").value;
	var pass=password.valueOf();
	var repassword = document.getElementById("Repassword").value;
	var repass=repassword.valueOf();
	var phone = "NA";
	var graddegree = "NA";
	var gradmarks = 0;
	var twelfthboard = "NA";
	var twelfthmarks = 0;
	var tenthboard = "NA";
	var tenthmarks = 0;
	var country = document.getElementById("Country").value;
	var region=country.valueOf();
	var dob = document.getElementById("dob").value;
	var fathername = "NA";
	var gender = "NA";
	var designation = "NA";
	var address = "NA";
	var terms = document.getElementById("licence").value;
	var licence=parseInt(terms);
	if(pass == repass && licence == 1 ){
			var datafor_EmployeeDetail={
								"Id": empid,
								"firstname":fname,
								"lastname":lname,
								"fathername": fathername,
								"Email":mail,
								"Phone": phone,
								"country":region,
								"dob":dob, 
								"gender": gender,
								"designation": designation,
								"address": address,
								"EducationDetail": {
								"Id": empid,
								"TenthBoard": tenthboard,
								"Tenthmarks": tenthmarks,
								"Twelfthboard": twelfthboard,
								"Twelfthmarks": twelfthmarks,
								"GraduationDegree": graddegree,
								"GraduationMarks": gradmarks,
								},
								"AuthenticateUser":{
								"Id": empid,
								"Email": mail,
<<<<<<< HEAD
								"password": pass,
								"Terms": licence,
								},
								};
						$.ajax({
							url: 'http://localhost:50052/api/EmployeeDetail/',
=======
								"password": pass1,
								"Terms": licence
								},
								"EducationDetail":{
								"Id": empid,
								"TenthBoard": "Not Specified",
								"Tenthmarks": 0,
								"Twelfthboard": "Not Specified",
								"Twelfthmarks": 0,
								"GraduationDegree": "Not Specified",
								"GraduationMarks": 0
										}
								};
								console.log(datafor_EmployeeDetail);
						$.ajax	({
							url: "http://localhost:50052/api/EmployeeDetail",
>>>>>>> 6311e2c658160f6f0d2c89871782016ec937c5d3
							data: datafor_EmployeeDetail,
							type: 'POST',
							dataType: 'json', 
							success: function(response){ 
													alert("SignUp Successful, Please Login To Continue");
													window.location="user list.html";
													}	
								});
			}else{alert("Password doesn't match");
			window.location.href = "Signup.html";}
};



	