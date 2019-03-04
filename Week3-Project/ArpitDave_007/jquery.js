$.ajax({
 type: 'GET',
 url: 'http://localhost:51510/api/EmployeeDetails',
 success: function(data)
 {
   extresults = data;
   console.log(extresults);
 }
});

$.ajax({
   type: 'POST',
   url: 'http://localhost:51510/api/EmployeeDetails',
   data: {
     "EmployeeID": "INT002",
     "Name": "Taarak Dhinigra",
     "Phone": null,
     "DOB": "1996-09-21T00:00:00",
     "Designation": "Intern",
     "Password": null,
     "EmailID": "taarak.dhingra@cygrp.com"
   },
   success: function(data) {
   alert("post is good");
   }
});
