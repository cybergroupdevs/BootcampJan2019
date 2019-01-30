function signupform(){
	var firstname = document.getElementById("First Name").value;
	var lastname = document.getElementById("Last Name").value;
	var Email = document.getElementById("Email").value;
	var pass = document.getElementById("Password").value;
	var repass = document.getElementById("Repassword").value;
	var country = document.getElementById("Country").value;
	var employeeid = document.getElementById("Employee Id").value;
	var dob = document.getElementById("DOB").value;
	var terms = document.getElementById("licence").value;
if(pass == repass && terms == 1 ){
	var datafor_EmployeeDetail ={
								"Id": employeeid,
								"firstname":firstname,
								"lastname":lastname,
								"fathername": "Not Specified",
								"Email":Email,
								"Phone": "Not Specified",
								"country":Country,
								"dob":dob, 
								"gender": "Not Specified",
								"designation": "Not Specified",
								"address":"Not Specified",
								};
	var datafor_AuthenticateUser={
								"Id": employeeid,
								"Email": Email,
								"password": pass,
								"Terms": terms,
								};
				$.ajax	({
					url: "http://localhost:50052/api/EmployeeDetail",
					data: datafor_EmployeeDetail,
					type: 'post',
					dataType: 'json', 
					success: function(res)	{ 
										$.ajax({
											url: "http://localhost:50052/api/AuthenticateUser",
											data: datafor_AuthenticateUser,
											type: 'post',
											dataType: 'json', 
											success: function(response){window.location.href = "index.html";}  
												});	
											}
						});
		}else{alert("Password doesn't match");
			window.location.href = "Signup.html";}
};



	