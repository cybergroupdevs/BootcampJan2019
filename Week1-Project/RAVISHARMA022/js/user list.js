<script
  src="http://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous">
</script>
        
<script>
				
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
</script>
    