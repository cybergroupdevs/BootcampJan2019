function changepassword(){
	var Id = document.getElementById("Id").value;
    var Email = document.getElementById("Email").value;
	var dob = document.getElementById("dob").value;
	var pass = document.getElementById("Password").value;
	var repass = document.getElementById("Repassword").value;
	if(pass==repass){
		$.ajax({
			url: 'http://localhost:50052/api/EmployeeDetail/'+Id,
			type: 'GET',
			dataType: 'json',
			success: function(res){
				if(Id == res.Id && Email == res.Email && dob == res.dob){
					var datato_resetpassword {"Id": Id,
										"Email": res.Email,
										"password": pass,
										"Terms": true}
						$.ajax({url: 'http://localhost:50052/api/AuthenticateUser/',
								type: 'POST',
								data: datato_resetpassword,
								dataType: 'json',
								success: function(response)
													{
													alert("Your Password Has been changed Please Login to access your profile")
													window.location.href = "index.html";
													}
								});
					 }else {alert("Details Do not match our databases");
					window.location.href = "reset password.html";}
				}
			});
		}else{alert("Both Password Should Match");window.location.href = "reset password.html";}
	}
    