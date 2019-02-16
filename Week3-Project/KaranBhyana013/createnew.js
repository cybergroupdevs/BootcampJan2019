        var arr=[];
function createnew(){
    
      var name= document.getElementById("name").value;
    var email = document.getElementById("email").value ;
     var age = document.getElementById("age").value ;
     var gender = document.getElementById("gender").value ;
    //var Gender = e.options[e.selectedIndex].value
     var phone = document.getElementById("Phone").value ;
    var designationID = document.getElementById("Designation").value ;
    //console.log(Name , Email, Gender, Phone, DesignationID, Age );
    if(age<18)
        {
            alert("Please enter valid age");
        }
    else{
   // || Email|| Age  || Gender || Phone|| DesignationID 
    if(name !="" && email !="" && age!=""  && gender!="" && phone!="" ){
    var myOBJ = JSON.stringify({
        name,
        email,
        age,
        gender,
        phone,
        designationID     
    });
        console.log(myOBJ);
   $.ajax({
        type:'POST',
        url : 'http://localhost:62622/api/Employees',
        dataType:"TEXT",
        contentType: "application/json; charset=utf-8",
        data:myOBJ,
        success:function(res){
        alert("Entry has been created");
        window.location.href="home.html"
    }
    })
     }
    else
        {
        alert("Please enter all the values")
        }
    }
}
function ConfirmDelete()
    {
      var x = confirm("Are you sure you want to delete?");
      if (x)
          
          return deleteitem();
      else
        return false;
    }
        

function cancel() {
alert("No New Entry added");
  window.location.href='home.html';
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

});