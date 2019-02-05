function loginform()
	{
	var Id = document.getElementById("Id").value;
    var email = document.getElementById("Email").value;
	var pass = document.getElementById("Password").value;
	$.ajax({
		url: 'http://localhost:50052/api/AuthenticateUser/'+ Id,
        type: 'GET',
        dataType: 'json',
        success: function(res)
            {
            if(pass == res.password){
                window.location.href = "homepage.html";
			     }  
			else {
				window.location.href = "index.html";	
			 }
            }
        });
	}
    