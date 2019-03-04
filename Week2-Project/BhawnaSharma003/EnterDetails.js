function onClick(){
    Info= {
        
        "EmploymentId": $('#EmploymentId').val(),
        "FirstName": $('#FirstName').val(), 
        "LastName": $('#LastName').val(), 
        "ContactNo": $('#ContactNumber').val(),
        "DateOfBirth": $('#DateOfBirth').val(),
        "DepartmentId": $('#DepartmentId').val(),
        "DepartmentName": $('#DepartmentName').val(),
        "Designation1": $('#Designation').val(),
        "Salary": $('#Salary').val(),
        "HireDate": $('#HireDate').val(),
        "PanCardNumber": $('#PanCardNumber').val(),
        "EmailID": $('#EmailID').val(),
        "GitHubUsername": $('#GitHubUsername').val(),
        "LinkedInProfile": $('#LinkedInProfile').val(),
        "ResidentialAddress": $('#ResidentialAddress').val()
        }
    
     $.ajax({
           type : "POST",
           url : "http://localhost:61286/api/EMPLOYEEs/", 
            
           dataType : "json",
           data : regData, debugger;
            error: function(e)
            {
              console.log(e);  
            },
           success : function (msg) {
               if (msg) {
                   alert("Successful Update");
                  
               } 
               else {
                   alert("Unsuccessful Update !");
               }
           }
        });
      
}