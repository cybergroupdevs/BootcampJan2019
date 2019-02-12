function getEmployee(){
        $.ajax({
            url: 'http://localhost:50191/api/Logins/',
            type: 'GET',
            dataType: 'json',
            success: function(res){
                console.log(res);
                $.each(res, function (i, item) {  
                    var rows = "<tr>" +  
                        "<td>" + item.ID + "</td>" +  
                        "<td>" + item.EmployeeID + "</td>" + 
                        "<td><button id='" + item.ID +"' onclick='showLogin(this.id);'>View</button></td>" + 
                        "<td><button id='" + item.ID +"' onclick='updateLogin(this.id);'>Update</button></td>" + 
                        "<td><button id='" + item.ID +"' onclick='deleteLogin(this.id);'>Delete</button></td>" +
                        "</tr>";  
                    $('#employee').append(rows);  
            });   
        }
    });
}
function deleteLogin(id){
    var del_id = Number(id);
    console.log(del_id);
    $.ajax({
        type: "DELETE",
        url: "http://localhost:50191/api/Logins/"+del_id,
        contentType:"application/json",
        success: function(){   
             window.location = "loginList.html";
        },
        failure:function(){
            alert("Unable to delete..!");
        }
    });
}
function updateEmployee(id){
    window.location="update.html?id="+id;
}