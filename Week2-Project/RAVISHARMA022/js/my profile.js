function showdetail(){
				//var Id=;
				$.ajax	({
				url: "http://localhost:50052/api/EmployeeDetail/"+Id,
				type: 'GET',
				dataType: 'json', 
				success: function(EmpDetail){ 
					document.getElementById("Employee Id").value=EmpDetail.Id;
					document.getElementById("First Name").value=EmpDetail.firstname;
					document.getElementById("Last Name").value=EmpDetail.lastname;
					document.getElementById("Father Name").value=EmpDetail.fathername;
					document.getElementById("Email").value=EmpDetail.Email;
					document.getElementById("Phone Number").value=EmpDetail.Phone;
					document.getElementById("Country").value=EmpDetail.country;
					document.getElementById("Dob").value=EmpDetail.dob;
					document.getElementById("Gender").value=EmpDetail.gender;
					document.getElementById("Designation").value=EmpDetail.designation;
					document.getElementById("Address").value=EmpDetail.address;
											}
						});
				$.ajax	({
				url: "http://localhost:50052/api/EducationDetail/"+Id,
				type: 'GET',
				dataType: 'json', 
				success: function(EduDetail){
					document.getElementById("Graduation Degree").value=EduDetail.GraduationDegree;
					document.getElementById("Graduation Percentage").value=EduDetail.GraduationMarks;
					document.getElementById("12 Board").value=EduDetail.TwelfthBoard;
					document.getElementById("12 Percentage").value=EduDetail.TwelfthMarks;
					document.getElementById("10 Board").value=EduDetail.TenthBoard;
					document.getElementById("10 Percentage").value=EduDetail.TenthMarks;
											}
						});
};
