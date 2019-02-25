function deleteEmployee(id){
    var element = Number(id);
    $.ajax({
        type: "DELETE",
        url: "http://localhost:50191/api/Employees/"+element,
        contentType:"application/json",
        success: function(){   
             window.location = "list.html";
        }
        error:function(){
            alert("Unable to delete due to referencing!!!");
        }
    });
}