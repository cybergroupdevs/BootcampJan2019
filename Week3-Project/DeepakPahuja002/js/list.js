$(document).ready(function(){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:64061/api/Employees',
        success: function(data) {
        var table = document.getElementById("UserListTable");
        $.ajax({
            type: 'GET',
            url: 'http://localhost:64061/api/SignUps',
            success: function(SignUpData) {
                for(i=0; i<data.length;i++){
                    $('#UserListTable').append(
                        '<tr><td id = "SerialNo">' + (i+1) +
                        '</td><td id = "EmployeeId"><a href="required_user.html?id=' + data[i].EmployeeId + '">' + data[i].EmployeeId + '</a>' + 
                        '</td><td id = "Name">' + data[i].Name + 
                        '</td><td id = "Designation">' + data[i].Designation + 
                        '</td><td id = "EmailId">' + SignUpData[i].EmailId + 
                        '</td><td id = "PhoneNo">' + data[i].PhoneNo + 
                        '</td></tr>'
                    );
                }
            }
        });    
        }
    });
});