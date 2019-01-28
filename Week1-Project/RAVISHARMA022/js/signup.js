function signupform(){
	
		var firstname = document.getElementById('First Name').value;
		var lastname = document.getElementById('Last Name').value;
		var Email = document.getElementById('Email').value;
		var pass = document.getElementById('Password').value;
		var repass = document.getElementById('Repassword').value;
		var country = document.getElementById('Country').value;
		var employeeid = document.getElementById('Employee Id').value;
		var dob = document.getElementById('DOB').value;
		var terms = document.getElementById('licence').value;
	
	var datafor_EmployeeDetails ={
								"Id": employeeid,
								"firstname":firstname,
								"lastname":lastname,
								"Email":Email,
								"country":Country,
								"DOB":dob, 
								}
								$.ajax	({
								url: "http://localhost:50052/api/EmployeeDetail",
								data: datafor_EmployeeDetails,
								type: 'post',
								dataType: 'json', 
								success: function(res)	{
													location.href = "homepage.html";
														}
										});
										
										
	var datafor_AuthenticateUser =	{
										"Id": employeeid,
										"Email": Email,
										"Password": pass,
										"repassword": repass,
										"Terms": terms,	 
										}
										$.ajax	({
										url: "http://localhost:50052/api/AuthenticateUser",
										data: datafor_AuthenticateUser,
										type: 'post',
										dataType: 'json', 
										success: function(res)	{
											 location.href = "homepage.html";
																}  
												});
												

			
						};