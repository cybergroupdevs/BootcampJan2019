function getEmployee(){
        $.ajax({
            url: 'http://localhost:50191/api/Employees/',
            type: 'GET',
            dataType: 'json',
            success: function(res){
                console.log(res);
                $.each(res, function (i, item) {  
                    var rows = "<tr>" +  
                        "<td>" + item.Name + "</td>" +  
                        "<td>" + item.Email + "</td>" +  
                        "<td>" + item.PhoneNumber + "</td>" +  
                        "<td>" + item.BloodGroup + "</td>" +  
                        "<td>" + item.DOB + "</td>" + 
                        "<td><button id='" + item.ID +"' onclick='showEmployee(this.id);'>View</button></td>" + 
                        "<td><button id='" + item.ID +"' onclick='updateEmployee(this.id);'>Update</button></td>" + 
                        "<td><button id='" + item.ID +"' onclick='deleteEmployee(this.id);'>Delete</button></td>" +
                        "</tr>";  
                    $('#employee').append(rows);  
            });   
        }
    });
}
function deleteEmployee(id){
    var del_id = Number(id);
    console.log(del_id);
    $.ajax({
        type: "DELETE",
        url: "http://localhost:50191/api/Employees/"+del_id,
        contentType:"application/json",
        success: function(){   
             window.location = "list.html";
        },
        failure:function(){
            alert("Unable to delete..!");
        }
    });
}
function updateEmployee(id){
    window.location="update.html?id="+id;
}