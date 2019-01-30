function showdetail(){
	
				$.ajax	({
				url: "http://localhost:50052/api/EmployeeDetail",
				type: 'GET',
				dataType: 'json', 
				success: function(EmpDetail){ 
											}
						});
				$.ajax	({
				url: "http://localhost:50052/api/EducationDetail",
				type: 'GET',
				dataType: 'json', 
				success: function(EduDetail){
				
											}
						});
document.getElementById("Employee Id").value=;
document.getElementById("First Name").value= ;
document.getElementById("Last Name").value=;
document.getElementById("Father Name").value=;
document.getElementById("Email").value=;
document.getElementById("Phone Number").value=;
document.getElementById("Graduation Degree").value=;
document.getElementById("Graduation Percentage").value=;
document.getElementById("12 Board").value=;
document.getElementById("12 Percentage").value=;
document.getElementById("10 Board").value=;
document.getElementById("10 Percentage").value=;
document.getElementById("Country").value=;
document.getElementById("Dob").value=;
document.getElementById("Gender").value=;
document.getElementById("Designation").value=;
document.getElementById("Address").value=;

				
		
};
