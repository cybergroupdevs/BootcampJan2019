function getEmployee(){
        $.ajax({
            url: 'http://localhost:61286/api/EMPLOYEEs/',
            type: 'GET',
            dataType: 'json',
            success: function(res){
                console.log(res);
                $.each(res, function (i, item) {  
                    var rows = "<tr>" +  
                        "<td>" + item.FirstName + "</td>" +  
                        "<td>" + item.LastName + "</td>" +  
                        
                        "<td>" + item.ContactNo + "</td>" +  
                       
                        "<td><button id='" + item.EmployeementId +"' onclick='updateEmployee(this.EmployeementId);'>Update</button></td>" + 
                        "<td><button id='" + item.EmployeementId +"' onclick='deleteEmployee(this.EmployeementId);'>Delete</button></td>" +
                        "</tr>";  
                    $('#EMPLOYEE').append(rows);  
            });   
        }
    });
}
function deleteEmployee(EmployeementId){
    var del_id = Number(EmployeementId);
    console.log(del_id);
    $.ajax({
        type: "DELETE",
        url: "http://localhost:50191/api/Employees/"+del_id,
        contentType:"application/json",
        success: function(){   
             window.location = "List.html";
        },
        failure:function(){
            alert("Unable to delete..!");
        }
    });
}
function updateEmployee(id){
    window.location="update.html?id="+EmployeementId;
}