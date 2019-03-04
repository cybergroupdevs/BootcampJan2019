function setEmployee(){
    regData = { 
            "Logins": [],
            "Name": $('#name').val(), 
            "Email": $('#mail').val(), 
            "PhoneNumber": $('#mail').val(), 
            "FathersName": $('#fname').val(),  
            "MothersName": $('#mname').val(), 
            "DOB": $('#user_dob').val(), 
            "Gender": $('#gender').val(), 
            "BloodGroup": $('#blood').val(),    
            "Qualification": $('#qualif').val(), 
            "Nationality": $('#nationality').val(), 
            "AadharNumber": $('#aadhar').val(), 
            "PanNumber": $('#pan').val(), 
            "Bio": $('#bio').val(), 
            "JobRole": $('#job').val() 
           };
    $.ajax({
           type : "POST",
           url : "http://localhost:8084/api/Employee/",
           dataType : "json",
           data : regData,
           success : function (msg) {
               if (msg) {
                   alert("Somebody" + name + " was added in list !");
                   location.reload(true);
               } 
               else {
                   alert("Cannot add to list !");
               }
           }
    });
}