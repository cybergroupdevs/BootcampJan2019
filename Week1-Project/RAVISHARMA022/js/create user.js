function CreateUser(){	
	var employeeid = document.getElementById("Employee Id").value;
	var empid=employeeid.valueOf();
	var firstname = document.getElementById("First Name").value;
	var fname=firstname.valueOf();
	var lastname = document.getElementById("Last Name").value;
	var lname=lastname.valueOf();
	var fathername = document.getElementById("Father Name").value;
	var fathersname=fathername.valueOf();
	var email = document.getElementById("Email").value;
	var mail=email.valueOf();
	var phone = document.getElementById("Phone Number").value;
	var mobile=phone.valueOf();
	var graddegree = document.getElementById("Graduation Degree").value;
	var degree=graddegree.valueOf();
	var gradmarks = document.getElementById("Graduation Percentage").value;
	var twelfthboard = document.getElementById("Twelfth Board").value;
	var board12=twelfthboard.valueOf();
	var twelfthmarks = document.getElementById("Twelfth Percentage").value;
	var tenthboard = document.getElementById("Tenth Board").value;
	var board10=tenthboard.valueOf();
	var tenthmarks = document.getElementById("Tenth Percentage").value;
	var country = document.getElementById("Country").value;
	var region=country.valueOf();
	var dob = document.getElementById("dob").value;
	var gender = document.getElementById("Gender").value;
	var sex=gender.valueOf();
	var designation = document.getElementById("Designation").value;
	var profile=designation.valueOf();
	var address = document.getElementById("Address").value;
	var address1=address.valueOf();
	
			var datafor_EmployeeDetail={
								"EducationDetail": {
								"Id": empid,
								"TenthBoard": board10,
								"Tenthmarks": tenthmarks,
								"Twelfthboard": board12,
								"Twelfthmarks": twelfthmarks,
								"GraduationDegree": degree,
								"GraduationMarks": gradmarks,
									
								},
								"Id": empid,
								"firstname":fname,
								"lastname":lname,
								"fathername": fathersname,
								"Email":mail,
								"Phone": mobile,
								"country":region,
								"dob":dob, 
								"gender": sex,
								"designation": profile,
								"address": address1,
								};
						$.ajax({
							url: 'http://localhost:50052/api/EmployeeDetail',
							data: datafor_EmployeeDetail,
							type: 'POST',
							dataType: 'json', 
							success: function(response){ 
													alert("User has been successfully added");
													window.location="user list.html";
													}	
								});
};



	