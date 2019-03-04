function deleteEmployee(id){
    var element = Number(id);
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8084/api/Employee/"+element,
        contentType:"application/json",
        success: function(){   
             window.location = "list.html";
        }
        error:function(){
            alert("Unable to delete due to referencing!!!");
        }
    });
}