        var arr=[];
    
function ConfirmDelete()
    {
      var x = confirm("Are you sure you want to delete?");
      if (x)
          
          return deleteitem();
      else
        return false;
    }
        
function deleteitem(){ 
     var Id = localStorage.getItem("Id"); 
  var OBJ = {
       Id
  }
    $.ajax({
        type:'DELETE',
        url : 'http://localhost:62622/api/Employees/'+localStorage.getItem("Id"),
        dataType:"TEXT",
        data: OBJ,
        success:function(res){
        alert("Entry has been deleted");
        window.location.href="home.html"
    }
    })

}
function cancel() {
  alert("No changes have been saved.");
    window.location.href="home.html";
}
function savechanges(){
    var name= document.getElementById("name").value;
    var id = localStorage.getItem("Id"); 
    var email = document.getElementById("email").value ;
     var age = document.getElementById("age").value ;
     var gender = document.getElementById("gender").value ;
     var phone = document.getElementById("Phone").value ;
    var designationID = document.getElementById("Designation").value ;
    console.log(name, id, email);

    var myOBJ = JSON.stringify({
        id,
        name,
        email,
        age,
        gender,
        phone,
        designationID     
    });
    console.log(myOBJ);
   $.ajax({
        type:'PUT',
        url : 'http://localhost:62622/api/Employees/'+localStorage.getItem("Id"),
        dataType:"text",
        contentType: "application/json; charset=utf-8",
        data:myOBJ,
        success:function(res){
        alert("Entry has been updated");
        window.location.href="home.html"
    }
    })
    
            
        }
function checkform()
{
    var f = document.forms["theform"].elements;
    var cansubmit = true;

    for (var i = 0; i < f.length; i++) {
        if (f[i].value.length == 0) cansubmit = false;
    }

    if (cansubmit) {
        document.getElementById('submitbutton').disabled = false;
    }
    else {
        document.getElementById('submitbutton').disabled = 'disabled';
    }
}

    //document.getElementById("hey").disabled = true;
$(document).ready(function(){
    var arr=[];
    const Url = 'http://localhost:62622/api/Employees/'+localStorage.getItem("Id");
    const Url1 = 'http://localhost:62622/api/Designations/';
    //console.log(Url);
    $.get(Url1, function(data, status){
         async: false;
           // console.log(data.length);
            
        var select = document.getElementById('Designation');
        for (var i = 0; i<data.length; i++){
            var opt = document.createElement('option');
            opt.value = data[i].id;
            opt.innerHTML = data[i].name;
            select.appendChild(opt);
        }
      
        })
      
    $.get(Url, function(data, status){
         async: false;
            console.log(data[0]);
        document.getElementById("name").value= data[0].name;
        document.getElementById("email").value= data[0].email;
        document.getElementById("age").value= data[0].age;
        document.getElementById("Phone").value= data[0].phone;
        document.getElementById("gender").value= data[0].gender;
        console.log(data.gender , data.age, data.name);
        document.getElementById("Designation").value=  data[0].designationID;
        })
     
 document.getElementById("Id").value=localStorage.getItem("Id");

});