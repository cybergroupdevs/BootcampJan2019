
  src="http://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"

        

				
		function getEmployees(){
					var datatosend ={
									"emp_name": "Taran",
									"age": 25,
									"gender": "male",
									"DesignationId": 3				
									}
					$.ajax({
						url: "http://localhost:52041/api/Employees",
						data: datatosend,
						type: 'post',
						dataType: 'json', 
						success: function(res)	{
												console.log(res);
												alert();
												}   
						
							})
					
								};




  function getEmployee(){
        var id = document.getElementById("userid").value
        $.ajax({
            url: 'http://localhost:58794/api/Employees/'+id,
            type: 'GET',
            dataType: 'json',
            success: function(res){
                var pass = document.getElementById("password").value;
                if(pass == res.Password){
                    location.href = "list.html";
                }
                else{
                    document.getElementById("error").innerHTML = "WRONG ID OR PASSWORD";
                }
            }
        });
    }
    