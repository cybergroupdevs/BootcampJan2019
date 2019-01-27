<script
  src="http://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous">
</script>

<script>
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
				
				var datafor_AuthenticateUser =	{
												"Id": employeeid,
												"Email": Email,
												"Password": pass,
												"repassword": repass,
												"Terms": terms,	 
												}
												$.ajax	({
												url: "http://localhost:61096/api/AuthenticateUser",
												data: datafor_AuthenticateUser,
												type: 'post',
												dataType: 'json', 
												success: function(res)	{
													
																		}  
														})
														
				var datafor_EmployeeDetails =	{
												"Id": employeeid,
												"firstname":firstname,
												"lastname":lastname,
												"Email":Email,
												"country":Country,
												"DOB":dob, 
												}
												$.ajax({
												url: "http://localhost:61096/api/EmployeeDetails",
												data: datafor_EmployeeDetails,
												type: 'post',
												dataType: 'json', 
												success: function(res)	{

																		}
														})
					
									};
</script>
    